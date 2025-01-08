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
        // Check if contact details already exist
        List<ContactDetails> existingContactDetails = contactDetailsService.getAllContacts();

        if (existingContactDetails.isEmpty()) {
            // No contact info exists, create a new one
            ContactDetails savedContactDetails = contactDetailsService.saveContact(contactDetails);
            return ResponseEntity.ok(savedContactDetails);
        } else {
            // Contact info exists, update the existing entry
            ContactDetails updatedContactDetails = contactDetailsService.updateContactById(existingContactDetails.get(0).getId(), contactDetails);
            return ResponseEntity.ok(updatedContactDetails);
        }
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


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        boolean isDeleted = contactDetailsService.deleteContactById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ContactDetails> editContact(@PathVariable Long id, @RequestBody ContactDetails updatedContact) {
        ContactDetails editedContact = contactDetailsService.updateContactById(id, updatedContact);
        if (editedContact != null) {
            return ResponseEntity.ok(editedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
