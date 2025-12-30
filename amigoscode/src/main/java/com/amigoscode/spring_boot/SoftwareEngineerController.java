package com.amigoscode.spring_boot;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    
    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return List.of(
                new SoftwareEngineer(1L, "James", "js, node, react, tailwindcss"),
                new SoftwareEngineer(2L, "Jamila", "java, spring, springboot")

        );
    }

}
