package com.business_development_backend.business_development_backend.SuccessStory.Controllers;
import com.business_development_backend.business_development_backend.SuccessStory.Entities.ClientSuccessStory;
import com.business_development_backend.business_development_backend.SuccessStory.Services.ClientSuccessStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/success-story")
@CrossOrigin
public class ClientSuccessStoryController {

    @Autowired
    private ClientSuccessStoryService clientSuccessStoryService;

    // Add a new success story
    @PostMapping("/add")
    public ResponseEntity<ClientSuccessStory> addSuccessStory(@RequestBody ClientSuccessStory successStory) {
        ClientSuccessStory savedSuccessStory = clientSuccessStoryService.saveSuccessStory(successStory);
        return ResponseEntity.ok(savedSuccessStory);
    }

    // Get all success stories
    @GetMapping("/get-all")
    public ResponseEntity<List<ClientSuccessStory>> getAllSuccessStories() {
        List<ClientSuccessStory> successStories = clientSuccessStoryService.getAllSuccessStories();
        return ResponseEntity.ok(successStories);
    }

    // Get a single success story by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClientSuccessStory> getSuccessStoryById(@PathVariable Long id) {
        return clientSuccessStoryService.getSuccessStoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a success story by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSuccessStory(@PathVariable Long id) {
        clientSuccessStoryService.deleteSuccessStory(id);
        return ResponseEntity.ok("Success story deleted successfully.");
    }
}