package com.joaovanzuita.deliveryapi.DTO.input;

import javax.validation.constraints.NotNull;

public class ClientInputDTO {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
