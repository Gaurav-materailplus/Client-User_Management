package com.budgetpulse.microservices.repository;

import com.budgetpulse.microservices.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    List<Client> findByManagerId(UUID managerId);
}
