package com.business_development_backend.business_development_backend.Advertisement.Services;

import com.business_development_backend.business_development_backend.Advertisement.Entities.Advertisement;
import com.business_development_backend.business_development_backend.Advertisement.Repositories.AdvertisementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;

    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public Advertisement saveAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    public Optional<Advertisement> getAdvertisementById(Long id) {
        return advertisementRepository.findById(id);
    }

    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }
}