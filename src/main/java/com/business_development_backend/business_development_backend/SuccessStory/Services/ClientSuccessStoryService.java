package com.business_development_backend.business_development_backend.SuccessStory.Services;
import com.business_development_backend.business_development_backend.SuccessStory.Entities.ClientSuccessStory;
import com.business_development_backend.business_development_backend.SuccessStory.Repositories.ClientSuccessStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientSuccessStoryService {

    @Autowired
    private ClientSuccessStoryRepository clientSuccessStoryRepository;

    public ClientSuccessStory saveSuccessStory(ClientSuccessStory clientSuccessStory) {
        return clientSuccessStoryRepository.save(clientSuccessStory);
    }

    public List<ClientSuccessStory> getAllSuccessStories() {
        return clientSuccessStoryRepository.findAll();
    }

    public Optional<ClientSuccessStory> getSuccessStoryById(Long id) {
        return clientSuccessStoryRepository.findById(id);
    }

    public void deleteSuccessStory(Long id) {
        clientSuccessStoryRepository.deleteById(id);
    }
}