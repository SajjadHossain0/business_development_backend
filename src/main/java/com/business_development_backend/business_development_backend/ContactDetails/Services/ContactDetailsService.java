package com.business_development_backend.business_development_backend.ContactDetails.Services;

import com.business_development_backend.business_development_backend.ContactDetails.Entities.ContactDetails;
import com.business_development_backend.business_development_backend.ContactDetails.Repositories.ContactDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailsService {

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    public ContactDetails saveContact(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    public List<ContactDetails> getAllContacts() {
        return contactDetailsRepository.findAll();
    }

    public boolean deleteContactById(Long id) {
        if (contactDetailsRepository.existsById(id)) {
            contactDetailsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ContactDetails updateContactById(Long id, ContactDetails updatedContact) {
        Optional<ContactDetails> existingContact = contactDetailsRepository.findById(id);
        if (existingContact.isPresent()) {
            ContactDetails contact = existingContact.get();
            contact.setAddress(updatedContact.getAddress());
            contact.setPhone(updatedContact.getPhone());
            contact.setEmail(updatedContact.getEmail());
            contact.setBusinesshour(updatedContact.getBusinesshour());
            contact.setFacebooklink(updatedContact.getFacebooklink());
            contact.setYoutubelink(updatedContact.getYoutubelink());
            contact.setLinkedinlink(updatedContact.getLinkedinlink());
            contact.setInstagramlink(updatedContact.getInstagramlink());
            return contactDetailsRepository.save(contact);
        }
        return null;
    }


}
