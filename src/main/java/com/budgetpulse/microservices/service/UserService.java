package com.budgetpulse.microservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetpulse.microservices.model.Client;
import com.budgetpulse.microservices.model.User;
import com.budgetpulse.microservices.model.UserTenantMap;
import com.budgetpulse.microservices.repository.ClientRepository;
import com.budgetpulse.microservices.repository.UserRepository;
import com.budgetpulse.microservices.repository.UserTenantMapRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserTenantMapRepository userTenantMapRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User assignUserToClient(UUID userId, UUID clientId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + clientId));
        if (!userTenantMapRepository.existsByUserIdAndClientId(userId, clientId)) {
            UserTenantMap map = new UserTenantMap();
            map.setUser(user);
            map.setClient(client);
            userTenantMapRepository.save(map);
        }
        return user;
    }

    public List<User> getUsersByClientId(UUID clientId) {
        List<UserTenantMap> mappings = userTenantMapRepository.findByClientId(clientId);
        List<User> users = new ArrayList<>();
        for (UserTenantMap map : mappings) {
            users.add(map.getUser());
        }
        return users;
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
} 