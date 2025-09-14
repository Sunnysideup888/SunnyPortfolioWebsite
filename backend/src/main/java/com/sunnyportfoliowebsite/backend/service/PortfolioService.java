package com.sunnyportfoliowebsite.backend.service;

import com.sunnyportfoliowebsite.backend.model.blog.ItemType;
import com.sunnyportfoliowebsite.backend.model.blog.PortfolioItem;
import com.sunnyportfoliowebsite.backend.repository.PortfolioItemRepository;
import com.sunnyportfoliowebsite.backend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioItemRepository portfolioItemRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagService tagService;

    public List<PortfolioItem> searchItems(String query) {
        if (query == null || query.isBlank()) {
            return portfolioItemRepository.findAll();
        }

        String processedQuery = Arrays.stream(query.trim().split("\\s+"))
                .map(word -> word + ":*")
                .collect(Collectors.joining(" & "));

        return portfolioItemRepository.searchByQuery(processedQuery);
    }

    public List<PortfolioItem> findAndFilter(ItemType type, List<String> tagNames) {
        String typeString = (type != null) ? type.name() : null;
        List<String> tagsToFilter = (tagNames != null && !tagNames.isEmpty()) ? tagNames : null;
        long tagCount = (tagsToFilter != null) ? tagsToFilter.size() : 0;

        return portfolioItemRepository.filterItems(typeString, tagsToFilter, tagCount);

    }
}
