package com.sunnyportfoliowebsite.backend.service;

import com.sunnyportfoliowebsite.backend.model.blog.TagColor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TagService {
    private static final Map<String, String> PREDEFINED_TAG_COLOURS = Map.of(
            "Project", TagColor.RED.hexCode,
            "Blog", TagColor.BLUE.hexCode,
            "Random", TagColor.YELLOW.hexCode,
            "Computing", TagColor.RED.hexCode,
            "Mathematics", TagColor.BLUE.hexCode,
            "Geography", TagColor.YELLOW.hexCode
    );

    public String getColourOfTag(String tagName) {
        return PREDEFINED_TAG_COLOURS.getOrDefault(tagName, TagColor.DEFAULT.hexCode);
    }
}
