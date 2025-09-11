package com.sunnyportfoliowebsite.backend.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmailRequest {
    @NotBlank(message = "Error on backend: Need a name")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Error on backend: You need an email")
    @Email(message = "Provide your email address")
    private String email;

    @NotBlank(message = "Error on backend: You need a message")
    @Size(max = 5000)
    private String message;
}
