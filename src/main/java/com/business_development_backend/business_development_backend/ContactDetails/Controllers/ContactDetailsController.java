package com.business_development_backend.business_development_backend.ContactDetails.Controllers;

import com.business_development_backend.business_development_backend.ContactDetails.Entities.ContactDetails;
import com.business_development_backend.business_development_backend.ContactDetails.Services.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactDetailsController {

    @Autowired
    private ContactDetailsService contactDetailsService;

    @PostMapping("/save-contacts")
    public ResponseEntity<ContactDetails> setContactDetails(@RequestBody ContactDetails contactDetails) {
        ContactDetails savedContactDetails = contactDetailsService.saveContact(contactDetails);

        return ResponseEntity.ok(savedContactDetails);
    }

    @GetMapping("/get-contacts")
    public ResponseEntity<List<ContactDetails>> getContactDetails() {
        List<ContactDetails> contactDetails = contactDetailsService.getAllContacts();
        if (contactDetails != null) {
            return ResponseEntity.ok(contactDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
