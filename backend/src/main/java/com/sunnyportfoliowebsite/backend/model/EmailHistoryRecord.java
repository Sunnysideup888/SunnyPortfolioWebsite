package com.sunnyportfoliowebsite.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "emails")
@NoArgsConstructor
public class EmailHistoryRecord {
    public EmailHistoryRecord(String name, String email, String message, EmailDirection direction) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.direction = direction;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(columnDefinition = "TEXT")
    private String message;

    @CreationTimestamp
    private LocalDateTime sentAt;

    @Enumerated(EnumType.STRING)
    private EmailDirection direction;
}
