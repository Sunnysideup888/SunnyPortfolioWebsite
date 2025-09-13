package com.sunnyportfoliowebsite.backend.controller;

import com.sunnyportfoliowebsite.backend.model.Photo;
import com.sunnyportfoliowebsite.backend.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping("/api/photos")
    public ResponseEntity<Page<Photo>> getPhotos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Photo> photos = photoService.getPhotos(pageable);

        return ResponseEntity.ok(photos);
    }
}
