package com.sunnyportfoliowebsite.backend.service;

import com.sunnyportfoliowebsite.backend.model.Photo;
import com.sunnyportfoliowebsite.backend.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public Page<Photo> getPhotos(Pageable pageable) {
        return photoRepository.findByOrderByDisplayOrderAsc(pageable);
    }
}
