package com.joaovanzuita.deliveryapi.domain.repository;

import com.joaovanzuita.deliveryapi.domain.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}