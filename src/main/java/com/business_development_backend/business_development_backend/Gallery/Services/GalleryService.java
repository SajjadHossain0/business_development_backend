package com.business_development_backend.business_development_backend.Gallery.Services;

import com.business_development_backend.business_development_backend.Gallery.Entities.Gallery;
import com.business_development_backend.business_development_backend.Gallery.Repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    public Gallery saveImage(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public List<Gallery> getAllImages() {
        return galleryRepository.findAll();
    }

    public void deleteImage(Long id) {
        galleryRepository.deleteById(id);
    }
}
