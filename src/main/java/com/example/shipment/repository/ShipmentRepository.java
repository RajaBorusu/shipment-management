package com.example.shipment.repository;

import com.example.shipment.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Optional<Shipment> findByShipmentId(String shipmentId);
    boolean existsByShipmentId(String shipmentId);
    void deleteByShipmentId(String shipmentId);
}
