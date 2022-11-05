package com.joaovanzuita.deliveryapi.controller;


import com.joaovanzuita.deliveryapi.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> list(){

        Client client1 = new Client();

        client1.setEmail("email");
        client1.setName("name");
        client1.setPhone("phone");

        Client client2 = new Client();

        client2.setEmail("email");
        client2.setName("name");
        client2.setPhone("phone");

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        return clients;
    }
}
