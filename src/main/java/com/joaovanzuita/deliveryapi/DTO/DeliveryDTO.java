package com.joaovanzuita.deliveryapi.DTO;

import com.joaovanzuita.deliveryapi.domain.model.StatusDelivery;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class DeliveryDTO {

    private Long id;
    private String clientName;
    private AddresseeDTO addresseeDTO;
    private BigDecimal tax;
    private StatusDelivery statusDelivery;
    private OffsetDateTime requestDate;
    private OffsetDateTime completionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public AddresseeDTO getAddresseeDTO() {
        return addresseeDTO;
    }

    public void setAddresseeDTO(AddresseeDTO addresseeDTO) {
        this.addresseeDTO = addresseeDTO;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public StatusDelivery getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(StatusDelivery statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public OffsetDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(OffsetDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public OffsetDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(OffsetDateTime completionDate) {
        this.completionDate = completionDate;
    }
}
