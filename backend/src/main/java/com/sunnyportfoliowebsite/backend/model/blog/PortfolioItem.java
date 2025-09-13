package com.sunnyportfoliowebsite.backend.model.blog;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "portfolio_items")
public class PortfolioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderAppears;

    @Column(nullable = false)
    private String title;

    @Column(name = "title_image_url")
    private String titleImageUrl;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @Column(name = "content_markdown", nullable = false, columnDefinition = "TEXT")
    private String contentMarkdown;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType type;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "portfolio_item_tags",
            joinColumns = @JoinColumn(name = "portfolio_item_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    // For full text search
    @Column(name = "content_tsv", insertable = false, updatable = false, columnDefinition = "tsvector")
    private String contentTsv;
}
