package com.amigoscode.spring_boot;

public record SoftwareEngineerResponse(Long id, String name, String techStack) {
    
    public static SoftwareEngineerResponse from(SoftwareEngineer entity) {
        return new SoftwareEngineerResponse(
                entity.getId(),
                entity.getName(),
                entity.getTechStack());
    }

}
