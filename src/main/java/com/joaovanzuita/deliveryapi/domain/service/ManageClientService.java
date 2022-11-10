package com.joaovanzuita.deliveryapi.domain.service;

import com.joaovanzuita.deliveryapi.domain.exception.DomainException;
import com.joaovanzuita.deliveryapi.domain.model.Client;
import com.joaovanzuita.deliveryapi.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManageClientService {

    private ClientRepository clientRepository;

    public ManageClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client save(Client client){

        boolean emailAlreadyInUse = clientRepository.findByEmail(client.getEmail()).stream().anyMatch(hasClient -> !hasClient.equals(client));

        if(emailAlreadyInUse){
            throw new DomainException("Email already in use.");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id){

        clientRepository.deleteById(id);
    }

    @Transactional
    public Client find(Long id){

        return clientRepository.findById(id).orElseThrow(() -> new DomainException("Client not found"));
    }

}
