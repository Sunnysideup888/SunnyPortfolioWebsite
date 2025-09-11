package com.sunnyportfoliowebsite.backend.controller;

import com.sunnyportfoliowebsite.backend.model.EmailRequest;
import com.sunnyportfoliowebsite.backend.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/api/sendEmail")
    public ResponseEntity<?> sendEmail(@Valid @RequestBody EmailRequest emailRequest) {
        System.out.println("THIS IS THE EMAIL REQUEST " + emailRequest);
        try {
            emailService.sendEmail(emailRequest);
            return ResponseEntity.ok(Map.of("message", "Email sent. Check your inbox for a copy as well."));
        } catch (Exception err) {
            System.out.println("There was an error " + err.getMessage());
            return ResponseEntity.status(500).body(Map.of("Message", "Something went wrong."));
        }
    }
}
