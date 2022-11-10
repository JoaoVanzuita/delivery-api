package com.joaovanzuita.deliveryapi.domain.service;

import com.joaovanzuita.deliveryapi.domain.exception.EntityNotFoundException;
import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import com.joaovanzuita.deliveryapi.domain.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class FindDeliveryService {

    private DeliveryRepository deliveryRepository;

    public FindDeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery find(Long id){

        return deliveryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("delivery not found"));
    }
}
