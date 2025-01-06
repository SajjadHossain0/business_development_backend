package com.business_development_backend.business_development_backend.SuccessStory.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class ClientSuccessStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String successName;

    @Lob
    private String successText;

    private String successQuote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuccessName() {
        return successName;
    }

    public void setSuccessName(String successName) {
        this.successName = successName;
    }

    public String getSuccessText() {
        return successText;
    }

    public void setSuccessText(String successText) {
        this.successText = successText;
    }

    public String getSuccessQuote() {
        return successQuote;
    }

    public void setSuccessQuote(String successQuote) {
        this.successQuote = successQuote;
    }
}
