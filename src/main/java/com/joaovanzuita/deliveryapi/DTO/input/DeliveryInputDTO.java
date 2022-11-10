package com.joaovanzuita.deliveryapi.DTO.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class DeliveryInputDTO {

    @Valid
    @NotNull
    private ClientInputDTO client;

    @Valid
    @NotNull
    private AddresseeInputDTO addressee;

    @NotNull
    private BigDecimal tax;

    public ClientInputDTO getClient() {
        return client;
    }

    public void setClient(ClientInputDTO client) {
        this.client = client;
    }

    public AddresseeInputDTO getAddressee() {
        return addressee;
    }

    public void setAddressee(AddresseeInputDTO addressee) {
        this.addressee = addressee;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}
