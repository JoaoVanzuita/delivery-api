package com.joaovanzuita.deliveryapi.mapper;

import com.joaovanzuita.deliveryapi.DTO.DeliveryEventDTO;
import com.joaovanzuita.deliveryapi.domain.model.DeliveryEvent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeliveryEventMapper {

    private ModelMapper modelMapper;

    public DeliveryEventMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DeliveryEventDTO map(DeliveryEvent deliveryEvent){

        return modelMapper.map(deliveryEvent, DeliveryEventDTO.class);
    }

    public List<DeliveryEventDTO> map(List<DeliveryEvent> deliveryEvents){

        return deliveryEvents.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
