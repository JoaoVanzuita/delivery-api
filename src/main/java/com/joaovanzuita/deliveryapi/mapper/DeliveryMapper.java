package com.joaovanzuita.deliveryapi.mapper;

import com.joaovanzuita.deliveryapi.DTO.DeliveryDTO;
import com.joaovanzuita.deliveryapi.DTO.input.DeliveryInputDTO;
import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;

    public DeliveryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DeliveryDTO map(Delivery delivery){
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> mapList(List<Delivery> deliveries){

        return deliveries.stream().map(this::map)
                .collect(Collectors.toList());
    }

    public Delivery mapInput(DeliveryInputDTO deliveryInputDTO){

        return modelMapper.map(deliveryInputDTO, Delivery.class);
    }
}
