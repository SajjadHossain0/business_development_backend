package com.business_development_backend.business_development_backend.ManageMajorClints.Services;

import com.business_development_backend.business_development_backend.ManageMajorClints.Entities.MajorClint;
import com.business_development_backend.business_development_backend.ManageMajorClints.Repositories.MCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MCService {

    @Autowired
    private MCRepository mcRepository;

    public MajorClint saveClient(MajorClint client) {
        return mcRepository.save(client);
    }

    public List<MajorClint> getAllClients() {
        return mcRepository.findAll();
    }

    public Optional<MajorClint> getClientById(Long id) {
        return mcRepository.findById(id);
    }

    public void deleteClient(Long id) {
        mcRepository.deleteById(id);
    }
}
