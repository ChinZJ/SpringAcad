package com.amigoscode.spring_boot;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SoftwareEngineer {
    @Id
    private Long id;
    private String name;
    private String techStack;

    // Allows for creation of object, then population using setters.
    public SoftwareEngineer() {}

    public SoftwareEngineer(Long id, String name, String techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(id, that.id) 
                && Objects.equals(name, that.name) 
                && Objects.equals(techStack, that.techStack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack);
    }
}
