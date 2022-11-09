package com.joaovanzuita.deliveryapi.controller;

import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import com.joaovanzuita.deliveryapi.domain.service.CreateDeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private CreateDeliveryService createDeliveryService;

    public DeliveryController(CreateDeliveryService createDeliveryService) {
        this.createDeliveryService = createDeliveryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery save(@RequestBody Delivery delivery){

        return createDeliveryService.save(delivery);
    }
}
