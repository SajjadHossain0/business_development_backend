package com.business_development_backend.business_development_backend.Advertisement.Repositories;


import com.business_development_backend.business_development_backend.Advertisement.Entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
