package com.joaovanzuita.deliveryapi.domain.service;

import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import com.joaovanzuita.deliveryapi.domain.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinishDeliveryService {

    private FindDeliveryService findDeliveryService;
    private DeliveryRepository deliveryRepository;

    public FinishDeliveryService(FindDeliveryService findDeliveryService, DeliveryRepository deliveryRepository) {
        this.findDeliveryService = findDeliveryService;
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public void finish(Long id){

        Delivery delivery = findDeliveryService.find(id);

        delivery.finish();

        deliveryRepository.save(delivery);
    }
}
