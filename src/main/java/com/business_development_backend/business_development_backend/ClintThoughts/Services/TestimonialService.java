package com.business_development_backend.business_development_backend.ClintThoughts.Services;
import com.business_development_backend.business_development_backend.ClintThoughts.Entities.Testimonial;
import com.business_development_backend.business_development_backend.ClintThoughts.Repositories.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    public Testimonial saveTestimonial(Testimonial testimonial) {
        return testimonialRepository.save(testimonial);
    }

    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }

    public void deleteTestimonial(Long id) {
        testimonialRepository.deleteById(id);
    }
}