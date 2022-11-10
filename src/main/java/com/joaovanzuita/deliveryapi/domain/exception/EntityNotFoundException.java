package com.joaovanzuita.deliveryapi.domain.exception;

public class EntityNotFoundException extends DomainException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
