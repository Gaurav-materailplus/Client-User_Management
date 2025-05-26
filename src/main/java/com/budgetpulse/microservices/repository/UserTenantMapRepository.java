package com.budgetpulse.microservices.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetpulse.microservices.model.UserTenantMap;

public interface UserTenantMapRepository extends JpaRepository<UserTenantMap, UUID> {
    List<UserTenantMap> findByClientId(UUID clientId);
    List<UserTenantMap> findByUserId(UUID userId);
    boolean existsByUserIdAndClientId(UUID userId, UUID clientId);
} 