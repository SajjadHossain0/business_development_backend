package com.business_development_backend.business_development_backend.ClintThoughts.Entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] image; // URL of the client's image
    private String name;     // Name of the client
    private String thought;  // Client's testimonial/thought

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThought() {
        return thought;
    }

    public void setThought(String thought) {
        this.thought = thought;
    }
}
