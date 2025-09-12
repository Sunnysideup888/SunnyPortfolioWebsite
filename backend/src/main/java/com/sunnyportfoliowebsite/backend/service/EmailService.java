package com.sunnyportfoliowebsite.backend.service;

import com.sunnyportfoliowebsite.backend.model.EmailDirection;
import com.sunnyportfoliowebsite.backend.model.EmailHistoryRecord;
import com.sunnyportfoliowebsite.backend.model.EmailRequest;
import com.sunnyportfoliowebsite.backend.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
public class EmailService {
    @Autowired
    private SesClient sesClient;

    @Autowired
    private EmailRepository emailRepository;

    @Value("${ses.from.email}")
    private String fromEmail;

    @Value("${ses.to.email}")
    private String toEmail;

    public void sendEmails(EmailRequest emailRequest) {
        // Remove any HTML
        String name = HtmlUtils.htmlEscape(emailRequest.getName());
        String email = HtmlUtils.htmlEscape(emailRequest.getEmail());
        String message = HtmlUtils.htmlEscape(emailRequest.getMessage()).replaceAll("\n", "<br>");

        String subject = "New email from portfolio website from " + email;
        String htmlBody = String.format("""
                <b>Sent by:</b>
                <br />
                %s
                <br/>
                <b>With message:</b>
                <br />
                %s
                <br />
                <br />
                This email is automatically generated. Please do not respond.
                """, name, message.replaceAll("\n", "<br />"));

        EmailHistoryRecord emailHistoryRecord = new EmailHistoryRecord(name, email, message, EmailDirection.TO_ME);

        String formattedSourceToSender = String.format("%s <%s>", "Sunny Chen", fromEmail);
        String subjectToSender = "Thanks for your email - Sunny Chen";
        String htmlBodyToSender = String.format("""
                <b>Thank you for getting in touch. The following is a receipt of your message.</b>
                <br />
                <br />
                <b>Your Email Address:</b>
                <br />
                %s
                <br />
                <b>Your Name:</b>
                <br />
                %s
                <br />
                <b>Your Message</b>
                <br />
                %s
                <br />
                <br />
                
                <i>This email is automatically generated. Please do not respond.</i>
                <br />
                <i>If you are not the intended recipient, please delete this message.</i>
                """, email, name, message.replaceAll("\n", "<br />"));

        EmailHistoryRecord emailHistoryRecordToSender = new EmailHistoryRecord(name, email, message, EmailDirection.TO_SENDER);

        try {
            // This uses the builder pattern from COMP2511 haha - https://refactoring.guru/design-patterns/builder
            SendEmailRequest request = SendEmailRequest
                    .builder()
                    .source(fromEmail)
                    .destination(Destination.builder().toAddresses(toEmail).build())
                    .message(Message.builder()
                            .subject(Content.builder().data(subject).build())
                            .body(Body.builder().html(Content.builder().data(htmlBody).build()).build())
                            .build())
                    .build();

            SendEmailRequest requestToSender = SendEmailRequest
                    .builder()
                    .source(formattedSourceToSender)
                    .destination(Destination.builder().toAddresses(email).build())
                    .message(Message.builder()
                            .subject(Content.builder().data(subjectToSender).build())
                            .body(Body.builder().html(Content.builder().data(htmlBodyToSender).build()).build())
                            .build())
                    .build();

            sesClient.sendEmail(request);
            sesClient.sendEmail(requestToSender);
            emailRepository.save(emailHistoryRecord);
            emailRepository.save(emailHistoryRecordToSender);
        } catch (SesException err) {
            throw new RuntimeException("Error with sending email: " + err.getMessage());
        }
    }
}
