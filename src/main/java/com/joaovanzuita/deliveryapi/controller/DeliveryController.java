package com.joaovanzuita.deliveryapi.controller;

import com.joaovanzuita.deliveryapi.DTO.DeliveryDTO;
import com.joaovanzuita.deliveryapi.DTO.input.DeliveryInputDTO;
import com.joaovanzuita.deliveryapi.domain.repository.DeliveryRepository;
import com.joaovanzuita.deliveryapi.domain.service.CreateDeliveryService;
import com.joaovanzuita.deliveryapi.domain.service.FinishDeliveryService;
import com.joaovanzuita.deliveryapi.mapper.DeliveryMapper;
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
    private DeliveryMapper deliveryMapper;
    private FinishDeliveryService finishDeliveryService;

    public DeliveryController(CreateDeliveryService createDeliveryService, DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper, FinishDeliveryService finishDeliveryService) {
        this.createDeliveryService = createDeliveryService;
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
        this.finishDeliveryService = finishDeliveryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDTO save(@Valid @RequestBody DeliveryInputDTO deliveryInputDTO){

        return deliveryMapper.map(createDeliveryService
                .save(deliveryMapper.mapInput(deliveryInputDTO)));
    }

    @GetMapping
    public List<DeliveryDTO> findAll(){

        return deliveryMapper.mapList(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id) {

        return deliveryRepository.findById(id).map(delivery -> ResponseEntity.ok(deliveryMapper.map(delivery)))
                .orElse(ResponseEntity.notFound().build());
     }

    @PutMapping("/{id}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish (@PathVariable Long id){

        finishDeliveryService.finish(id);
    }
}