package com.business_development_backend.business_development_backend.Advertisement.Controllers;


import com.business_development_backend.business_development_backend.Advertisement.Entities.Advertisement;
import com.business_development_backend.business_development_backend.Advertisement.Services.AdvertisementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
@CrossOrigin
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping("/save-ads")
    public ResponseEntity<Advertisement> addAdvertisement(@RequestParam("title") String title,
            @RequestParam("image") MultipartFile image) throws IOException {

        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(title);
        advertisement.setImage(image.getBytes());

        Advertisement savedAd = advertisementService.saveAdvertisement(advertisement);
        return ResponseEntity.ok(savedAd);
    }

    @GetMapping("/get-ads")
    public ResponseEntity<List<Advertisement>> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
        return ResponseEntity.ok(advertisements);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.noContent().build();
    }
}
