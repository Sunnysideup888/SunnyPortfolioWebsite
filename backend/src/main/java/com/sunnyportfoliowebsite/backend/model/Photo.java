package com.sunnyportfoliowebsite.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import software.amazon.awssdk.services.ses.endpoints.internal.Value;

@Data
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String s3Url;

    private String altText;

    private int displayOrder;
}
