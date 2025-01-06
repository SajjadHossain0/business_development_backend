package com.business_development_backend.business_development_backend.ManageMajorClints.Controllers;

import com.business_development_backend.business_development_backend.ManageMajorClints.Entities.MajorClint;
import com.business_development_backend.business_development_backend.ManageMajorClints.Services.MCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/major-client")
@CrossOrigin
public class MCController {

    @Autowired
    private MCService mcService;

    // Add a new client
    @PostMapping("/add")
    public ResponseEntity<MajorClint> addClient(
            @RequestParam("name") String name,
            @RequestParam("industryName") String industryName,
            @RequestParam("image") MultipartFile image) {
        try {
            MajorClint client = new MajorClint();
            client.setName(name);
            client.setIndustryName(industryName);
            client.setImage(image.getBytes());

            MajorClint savedClient = mcService.saveClient(client);
            return ResponseEntity.ok(savedClient);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Get all clients
    @GetMapping("/get-all")
    public ResponseEntity<List<MajorClint>> getAllClients() {
        List<MajorClint> clients = mcService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    // Get a single client by ID
    @GetMapping("/{id}")
    public ResponseEntity<MajorClint> getClientById(@PathVariable Long id) {
        return mcService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a client by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        mcService.deleteClient(id);
        return ResponseEntity.ok("Client deleted successfully.");
    }

}
