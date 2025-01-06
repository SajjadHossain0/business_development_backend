package com.business_development_backend.business_development_backend.SuccessStory.Repositories;

import com.business_development_backend.business_development_backend.SuccessStory.Entities.ClientSuccessStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSuccessStoryRepository extends JpaRepository<ClientSuccessStory, Long> {
}
