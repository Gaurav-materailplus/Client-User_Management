package com.budgetpulse.microservices.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "app_user")    //sql syntax error fixing
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String email;
    private String fullName;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client; // For CLIENT_USER only

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager; // For CLIENT_USER only

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy; // Who created this user

    private boolean isActive = true;

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public User getManager() { return manager; }
    public void setManager(User manager) { this.manager = manager; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
