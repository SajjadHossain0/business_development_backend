package com.business_development_backend.business_development_backend.ContactDetails.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String phone;
    private String email;
    private String businesshour;

    private String facebooklink;
    private String linkedinlink;
    private String instagramlink;
    private String youtubelink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinesshour() {
        return businesshour;
    }

    public void setBusinesshour(String businesshour) {
        this.businesshour = businesshour;
    }

    public String getFacebooklink() {
        return facebooklink;
    }

    public void setFacebooklink(String facebooklink) {
        this.facebooklink = facebooklink;
    }

    public String getLinkedinlink() {
        return linkedinlink;
    }

    public void setLinkedinlink(String linkedinlink) {
        this.linkedinlink = linkedinlink;
    }

    public String getInstagramlink() {
        return instagramlink;
    }

    public void setInstagramlink(String instagramlink) {
        this.instagramlink = instagramlink;
    }

    public String getYoutubelink() {
        return youtubelink;
    }

    public void setYoutubelink(String youtubelink) {
        this.youtubelink = youtubelink;
    }
}
