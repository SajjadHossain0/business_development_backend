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

    private String clientImageUrl; // URL of the client's image
    private String clientName;     // Name of the client
    private String clientThought;  // Client's testimonial/thought

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientImageUrl() {
        return clientImageUrl;
    }

    public void setClientImageUrl(String clientImageUrl) {
        this.clientImageUrl = clientImageUrl;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientThought() {
        return clientThought;
    }

    public void setClientThought(String clientThought) {
        this.clientThought = clientThought;
    }
}
