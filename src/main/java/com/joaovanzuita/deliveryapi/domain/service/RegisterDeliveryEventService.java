package com.joaovanzuita.deliveryapi.domain.service;

import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import com.joaovanzuita.deliveryapi.domain.model.DeliveryEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterDeliveryEventService {

    private FindDeliveryService findDeliveryService;

    public RegisterDeliveryEventService(FindDeliveryService findDeliveryService) {
        this.findDeliveryService = findDeliveryService;
    }

    @Transactional
    public DeliveryEvent registerEvent(Long deliveryId, String description){

        Delivery delivery = findDeliveryService.find(deliveryId);

        return delivery.addEvent(description);
    }
}
