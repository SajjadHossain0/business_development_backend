package com.business_development_backend.business_development_backend.ClintThoughts.Controllers;

import com.business_development_backend.business_development_backend.ClintThoughts.Entities.Testimonial;
import com.business_development_backend.business_development_backend.ClintThoughts.Services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
@CrossOrigin
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    // Add a new testimonial
    @PostMapping("/add")
    public ResponseEntity<Testimonial> addTestimonial(@RequestParam("image") MultipartFile image,
                                                      @RequestParam("name") String name,
                                                      @RequestParam("thought") String thought) throws IOException {
        Testimonial testimonial = new Testimonial();
        testimonial.setName(name);
        testimonial.setThought(thought);
        testimonial.setImage(image.getBytes());

        Testimonial savedTestimonial = testimonialService.saveTestimonial(testimonial);
        return ResponseEntity.ok(savedTestimonial);
    }

    // Get all testimonials
    @GetMapping("/get-all")
    public ResponseEntity<List<Testimonial>> getAllTestimonials() {
        List<Testimonial> testimonials = testimonialService.getAllTestimonials();
        return ResponseEntity.ok(testimonials);
    }

    // Delete a testimonial
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTestimonial(@PathVariable Long id) {
        testimonialService.deleteTestimonial(id);
        return ResponseEntity.ok("Testimonial deleted successfully!");
    }
}
