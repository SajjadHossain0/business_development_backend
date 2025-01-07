package com.business_development_backend.business_development_backend.Gallery.Controllers;


import com.business_development_backend.business_development_backend.Gallery.Entities.Gallery;
import com.business_development_backend.business_development_backend.Gallery.Services.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    // Add an image to the gallery
    @PostMapping("/add")
    public ResponseEntity<Gallery> addImage(@RequestBody Gallery gallery) {
        Gallery savedImage = galleryService.saveImage(gallery);
        return ResponseEntity.ok(savedImage);
    }

    // Get all images from the gallery
    @GetMapping("/get-all")
    public ResponseEntity<List<Gallery>> getAllImages() {
        List<Gallery> images = galleryService.getAllImages();
        return ResponseEntity.ok(images);
    }

    // Delete an image from the gallery
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        galleryService.deleteImage(id);
        return ResponseEntity.ok("Image deleted successfully!");
    }
}
