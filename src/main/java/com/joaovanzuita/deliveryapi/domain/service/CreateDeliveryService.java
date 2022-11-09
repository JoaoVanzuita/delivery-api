package com.joaovanzuita.deliveryapi.domain.service;

import com.joaovanzuita.deliveryapi.domain.model.Client;
import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import com.joaovanzuita.deliveryapi.domain.model.StatusDelivery;
import com.joaovanzuita.deliveryapi.domain.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.OffsetDateTime;

@Service
public class CreateDeliveryService {

    private DeliveryRepository deliveryRepository;
    private ManageClientService manageClientService;

    public CreateDeliveryService(DeliveryRepository deliveryRepository, ManageClientService manageClientService) {
        this.deliveryRepository = deliveryRepository;
        this.manageClientService = manageClientService;
    }

    @Transactional
    public Delivery save(Delivery delivery){

        Client client = manageClientService.find(delivery.getClient().getId());

        delivery.setClient(client);

        delivery.setStatusDelivery(StatusDelivery.PENDING);
        delivery.setRequestDate(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
