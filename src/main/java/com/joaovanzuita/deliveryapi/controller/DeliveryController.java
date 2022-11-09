package com.joaovanzuita.deliveryapi.controller;

import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import com.joaovanzuita.deliveryapi.domain.repository.DeliveryRepository;
import com.joaovanzuita.deliveryapi.domain.service.CreateDeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private CreateDeliveryService createDeliveryService;
    private DeliveryRepository deliveryRepository;

    public DeliveryController(CreateDeliveryService createDeliveryService, DeliveryRepository deliveryRepository) {
        this.createDeliveryService = createDeliveryService;
        this.deliveryRepository = deliveryRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery save(@Valid @RequestBody Delivery delivery){

        return createDeliveryService.save(delivery);
    }

    @GetMapping
    public List<Delivery> findAll(){

        return deliveryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> findById(@PathVariable Long id){

        return deliveryRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
