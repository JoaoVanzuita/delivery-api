package com.joaovanzuita.deliveryapi.DTO.input;

import javax.validation.constraints.NotBlank;

public class DeliveryEventInputDTO {

    @NotBlank
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
