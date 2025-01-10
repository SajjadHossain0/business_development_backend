package com.business_development_backend.business_development_backend.Advertisement.Controllers;


import com.business_development_backend.business_development_backend.Advertisement.Entities.Advertisement;
import com.business_development_backend.business_development_backend.Advertisement.Services.AdvertisementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    // POST: Add Advertisement
    @PostMapping
    public ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAd = advertisementService.saveAdvertisement(advertisement);
        return ResponseEntity.ok(savedAd);
    }

    // GET: Fetch all advertisements
    @GetMapping
    public ResponseEntity<List<Advertisement>> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
        return ResponseEntity.ok(advertisements);
    }

    // DELETE: Delete advertisement by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.noContent().build();
    }
}
