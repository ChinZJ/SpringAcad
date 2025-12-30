package com.amigoscode.spring_boot;

// DTO for incoming requests (create / update).
public record SoftwareEngineerRequest(String name, String techStack) {}
