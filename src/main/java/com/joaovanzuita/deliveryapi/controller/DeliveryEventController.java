package com.joaovanzuita.deliveryapi.controller;

import com.joaovanzuita.deliveryapi.DTO.DeliveryEventDTO;
import com.joaovanzuita.deliveryapi.DTO.input.DeliveryEventInputDTO;
import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import com.joaovanzuita.deliveryapi.domain.model.DeliveryEvent;
import com.joaovanzuita.deliveryapi.domain.service.FindDeliveryService;
import com.joaovanzuita.deliveryapi.domain.service.RegisterDeliveryEventService;
import com.joaovanzuita.deliveryapi.mapper.DeliveryEventMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deliveries/{id}/events")
public class DeliveryEventController {

    private RegisterDeliveryEventService registerDeliveryEventService;
    private DeliveryEventMapper deliveryEventMapper;
    private FindDeliveryService findDeliveryService;

    public DeliveryEventController(RegisterDeliveryEventService registerDeliveryEventService, DeliveryEventMapper deliveryEventMapper, FindDeliveryService findDeliveryService) {
        this.registerDeliveryEventService = registerDeliveryEventService;
        this.deliveryEventMapper = deliveryEventMapper;
        this.findDeliveryService = findDeliveryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryEventDTO register(@PathVariable Long id, @Valid @RequestBody DeliveryEventInputDTO deliveryEventInputDTO){

        DeliveryEvent deliveryEvent = registerDeliveryEventService
                .registerEvent(id, deliveryEventInputDTO.getDescription());

        System.out.println(deliveryEvent.toString());

        return deliveryEventMapper.map(deliveryEvent);
    }

    @GetMapping
    public List<DeliveryEventDTO> find(@PathVariable Long id){

        Delivery delivery = findDeliveryService.find(id);

        return deliveryEventMapper.map(delivery.getDeliveryEvents());
    }
}
