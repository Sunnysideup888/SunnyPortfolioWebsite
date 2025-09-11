package com.sunnyportfoliowebsite.backend.service;

import com.sunnyportfoliowebsite.backend.model.EmailRequest;
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

    @Value("${ses.from.email}")
    private String fromEmail;

    @Value("${ses.to.email}")
    private String toEmail;

    public void sendEmail(EmailRequest emailRequest) {
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

        try {
            System.out.println("This is the name " + name  + " This is the email " + email + " This is the message " + message);
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

            System.out.println("This is the SendEmailRequest " + request);
            sesClient.sendEmail(request);
        } catch (SesException err) {
            throw new RuntimeException("Error with sending email: " + err.getMessage());
        }
    }
}
