package com.amigoscode.spring_boot;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineerResponse> getAllSoftwareEngineers() {
        return softwareEngineerRepository
                .findAll()
                .stream()
                .map(SoftwareEngineerResponse::from)
                .toList();
    }

    public SoftwareEngineerResponse getSoftwareEngineerById(Long id) {
        SoftwareEngineer entity = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Engineer not found with id: " + id));
        
        return SoftwareEngineerResponse.from(entity);
    }

    public SoftwareEngineerResponse insertSoftwareEngineer(SoftwareEngineerRequest request) {
        SoftwareEngineer entity = new SoftwareEngineer();
        entity.setName(request.name());
        entity.setTechStack(request.techStack());

        softwareEngineerRepository.save(entity);

        return SoftwareEngineerResponse.from(entity);
    }

    public void deleteSoftwareEngineer(Long id) {
        boolean exists = softwareEngineerRepository.existsById(id);

        if (!exists) {
            throw new IllegalStateException(id + " not found");
        } 
        
        softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineerResponse updateSoftwareEngineer(Long id, SoftwareEngineerRequest request) {
        SoftwareEngineer entity = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Engineer not found with id: " + id));

        entity.setName(request.name());
        entity.setTechStack(request.techStack());

        softwareEngineerRepository.save(entity);

        return SoftwareEngineerResponse.from(entity);
    }

}
