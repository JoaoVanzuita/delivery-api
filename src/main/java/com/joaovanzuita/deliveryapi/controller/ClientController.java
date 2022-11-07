package com.joaovanzuita.deliveryapi.controller;

import com.joaovanzuita.deliveryapi.domain.model.Client;
import com.joaovanzuita.deliveryapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

//    @Autowired
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> list(){

        List<Client> clients = clientRepository.findAll();

        return clients;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){

        return clientRepository.findById(id)
                .map(client -> ResponseEntity.ok(client))
                .orElse(ResponseEntity.notFound().build());

//        Optional<Client> client = clientRepository.findById(id);
//
//        if(client.isPresent()){
//           return ResponseEntity.ok(client.get());
//        }
//
//        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@Valid @RequestBody Client client){

        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@Valid @RequestBody Client client, @PathVariable Long id){

        if(!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        client.setId(id);
        client = clientRepository.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        if (!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        clientRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
