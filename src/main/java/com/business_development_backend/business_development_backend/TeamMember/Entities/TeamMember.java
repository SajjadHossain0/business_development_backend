package com.business_development_backend.business_development_backend.TeamMember.Entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] image;
    private String name;
    private String position;
    @Lob
    private String bio;      // Bio/Description

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
