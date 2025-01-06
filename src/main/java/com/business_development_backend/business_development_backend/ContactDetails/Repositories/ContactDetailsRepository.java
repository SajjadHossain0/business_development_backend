package com.business_development_backend.business_development_backend.ContactDetails.Repositories;

import com.business_development_backend.business_development_backend.ContactDetails.Entities.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
}
