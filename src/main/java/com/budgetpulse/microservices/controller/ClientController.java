package com.budgetpulse.microservices.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetpulse.microservices.model.Client;
import com.budgetpulse.microservices.model.User;
import com.budgetpulse.microservices.service.ClientService;
import com.budgetpulse.microservices.service.UserService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable UUID id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/users")
    public ResponseEntity<User> assignUserToClient(@PathVariable UUID id, @RequestBody User user) {
        User assigned = userService.assignUserToClient(user.getId(), id);
        return ResponseEntity.ok(assigned);
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<List<User>> getUsersByClient(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUsersByClientId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable UUID id, @RequestBody Client clientDetails) {
        Optional<Client> optionalClient = clientService.getClientById(id);
        if (optionalClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Client client = optionalClient.get();
        client.setName(clientDetails.getName());
        client.setIndustry(clientDetails.getIndustry());
        client.setDescription(clientDetails.getDescription());
        // Add more fields as needed
        return ResponseEntity.ok(clientService.createClient(client));
    }
}


