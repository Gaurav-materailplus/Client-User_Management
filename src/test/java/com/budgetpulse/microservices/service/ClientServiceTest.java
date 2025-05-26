package com.budgetpulse.microservices.service;

import com.budgetpulse.microservices.model.Client;
import com.budgetpulse.microservices.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void shouldCreateClient() {
        Client c = new Client();
        c.setName("Test Client");
        c.setIndustry("Finance");

        Client saved = clientService.createClient(c);
        assertNotNull(saved.getId());
        assertEquals("Test Client", saved.getName());
    }

    @Test
    void shouldFetchAllClients() {
        List<Client> clients = clientService.getAllClients();
        assertNotNull(clients);
    }
}
