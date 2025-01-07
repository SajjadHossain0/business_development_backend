package com.business_development_backend.business_development_backend.Gallery.Repositories;


import com.business_development_backend.business_development_backend.Gallery.Entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
