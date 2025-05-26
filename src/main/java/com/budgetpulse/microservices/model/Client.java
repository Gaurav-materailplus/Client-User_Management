package com.budgetpulse.microservices.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String industry;
    private String description;

    @ManyToOne                      // ONLY TEMPORARY REMOVAL OF MANAGER FOR TESTING WHENEVER WE WILL MAKE THE MANAGER WE WILL UNCOMMENT IT AGAIN
    @JoinColumn(name = "manager_id")
    private User manager;

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getManager() { return manager; }       //ONLY FOR TEMPORARILY I SHOULD NOT ADD MANAGERS FIRST
    public void setManager(User manager) { this.manager = manager; }
}
