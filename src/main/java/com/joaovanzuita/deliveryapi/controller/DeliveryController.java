package com.joaovanzuita.deliveryapi.controller;

import com.joaovanzuita.deliveryapi.DTO.AddresseeDTO;
import com.joaovanzuita.deliveryapi.DTO.DeliveryDTO;
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
    public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id){

        return deliveryRepository.findById(id).map(delivery -> {
                    DeliveryDTO deliveryDTO = new DeliveryDTO();
                    AddresseeDTO addresseeDTO = new AddresseeDTO();
                        addresseeDTO.setName(delivery.getAddressee().getName());
                        addresseeDTO.setPublicPlace(delivery.getAddressee().getPublicPlace());
                        addresseeDTO.setNumber(delivery.getAddressee().getNumber());
                        addresseeDTO.setComplement(delivery.getAddressee().getComplement());
                        addresseeDTO.setDistrict(delivery.getAddressee().getDistrict());

                    deliveryDTO.setAddresseeDTO(addresseeDTO);
                    deliveryDTO.setId(delivery.getId());
                    deliveryDTO.setClientName(delivery.getClient().getName());
                    deliveryDTO.setTax(delivery.getTax());
                    deliveryDTO.setStatusDelivery(delivery.getStatusDelivery());
                    deliveryDTO.setRequestDate(delivery.getRequestDate());
                    deliveryDTO.setCompletionDate(delivery.getCompletionDate());

                    return ResponseEntity.ok(deliveryDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
