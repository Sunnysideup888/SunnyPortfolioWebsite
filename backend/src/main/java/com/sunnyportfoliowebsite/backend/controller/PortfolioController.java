package com.sunnyportfoliowebsite.backend.controller;

import com.sunnyportfoliowebsite.backend.model.blog.ItemType;
import com.sunnyportfoliowebsite.backend.model.blog.PortfolioItem;
import com.sunnyportfoliowebsite.backend.model.blog.Tag;
import com.sunnyportfoliowebsite.backend.repository.PortfolioItemRepository;
import com.sunnyportfoliowebsite.backend.repository.TagRepository;
import com.sunnyportfoliowebsite.backend.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@RestController
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private PortfolioItemRepository portfolioItemRepository;
    @Autowired
    private CorsConfigurationSource corsConfigurationSource;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/api/search")
    public ResponseEntity<List<PortfolioItem>> searchItems(@RequestParam(required = false) String query) {
        List<PortfolioItem> items = portfolioService.searchItems(query);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/api/filter")
    public ResponseEntity<List<PortfolioItem>> filterItems(
            @RequestParam(required = false)ItemType type,
            @RequestParam(required = false) List<String> tags
    ) {
        List<PortfolioItem> items = portfolioService.findAndFilter(type, tags);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/api/slug/{slug}")
    public ResponseEntity<PortfolioItem> getItemBySlug(@PathVariable String slug) {
        return portfolioItemRepository
                .findBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/tags")
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags =  tagRepository.findAll();
        return ResponseEntity.ok(tags);
    }
}
