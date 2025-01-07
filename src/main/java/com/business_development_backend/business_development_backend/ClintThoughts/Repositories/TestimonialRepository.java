package com.business_development_backend.business_development_backend.ClintThoughts.Repositories;


import com.business_development_backend.business_development_backend.ClintThoughts.Entities.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
}
