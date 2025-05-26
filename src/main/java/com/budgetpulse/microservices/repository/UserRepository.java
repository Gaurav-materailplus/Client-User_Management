package com.budgetpulse.microservices.repository;

import com.budgetpulse.microservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByClientId(UUID clientId);
}
