package com.joaovanzuita.deliveryapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joaovanzuita.deliveryapi.domain.exception.DomainException;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    @NotNull
    @ManyToOne
    private Client client;

    @Valid
    @NotNull
    @Embedded
    private Addressee addressee;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<DeliveryEvent> deliveryEvents;

    @NotNull
    private BigDecimal tax;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusDelivery statusDelivery;

    @Column(name = "request_date")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime requestDate;

    @Column(name = "completion_date")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime completionDate;

    public Delivery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Addressee getAddressee() {
        return addressee;
    }

    public void setAddressee(Addressee addressee) {
        this.addressee = addressee;
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

    public List<DeliveryEvent> getDeliveryEvents() {
        return deliveryEvents;
    }

    public void setDeliveryEvents(List<DeliveryEvent> deliveryEvents) {
        this.deliveryEvents = deliveryEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public DeliveryEvent addEvent(String description) {
        DeliveryEvent deliveryEvent = new DeliveryEvent();

        deliveryEvent.setDescription(description);
        deliveryEvent.setDateTime(OffsetDateTime.now());
        deliveryEvent.setDelivery(this);

        this.getDeliveryEvents().add(deliveryEvent);

        return deliveryEvent;
    }

    public void finish(){

        if(!canBeFinished()){

            throw new DomainException("Delivery cannot be concluded");
        }

        this.setStatusDelivery(StatusDelivery.FINISHED);
        this.setCompletionDate(OffsetDateTime.now());
    }

    public boolean canBeFinished(){

        return this.statusDelivery.equals(StatusDelivery.PENDING);
    }
}
