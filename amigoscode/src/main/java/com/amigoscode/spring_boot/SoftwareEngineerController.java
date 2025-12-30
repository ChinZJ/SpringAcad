package com.amigoscode.spring_boot;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }
    
    @GetMapping
    public List<SoftwareEngineerResponse> getAllEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineerResponse getEngineerById(@PathVariable Long id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public SoftwareEngineerResponse addNewSoftwareEngineer(@RequestBody SoftwareEngineerRequest request) {
        return softwareEngineerService.insertSoftwareEngineer(request);
    }

    @DeleteMapping("{id}")
    public void deleteSoftwareEngineer(@PathVariable Long id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }

    @PutMapping("{id}")
    public SoftwareEngineerResponse updateSoftwareEngineer(
            @PathVariable Long id, @RequestBody SoftwareEngineerRequest request) {

        return softwareEngineerService.updateSoftwareEngineer(id, request);
    }
}
