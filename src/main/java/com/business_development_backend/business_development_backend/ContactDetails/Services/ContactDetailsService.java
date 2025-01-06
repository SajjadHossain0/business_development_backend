package com.business_development_backend.business_development_backend.ContactDetails.Services;

import com.business_development_backend.business_development_backend.ContactDetails.Entities.ContactDetails;
import com.business_development_backend.business_development_backend.ContactDetails.Repositories.ContactDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
