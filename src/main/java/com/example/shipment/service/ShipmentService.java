package com.example.shipment.service;

import com.example.shipment.dto.CreateShipmentRequest;
import com.example.shipment.model.Shipment;
import com.example.shipment.model.ShipmentStatus;
import com.example.shipment.repository.ShipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(CreateShipmentRequest request) {
        String shipmentId;
        do {
            shipmentId = "SHP-" + UUID.randomUUID()
                    .toString().substring(0, 8).toUpperCase();
        } while (shipmentRepository.existsByShipmentId(shipmentId));

        Shipment shipment = new Shipment(
                shipmentId,
                request.origin().trim(),
                request.destination().trim()
        );
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipment(String shipmentId) {
        return shipmentRepository.findByShipmentId(shipmentId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Shipment not found: " + shipmentId));
    }

    public Shipment updateStatus(String shipmentId, ShipmentStatus status) {
        Shipment shipment = getShipment(shipmentId);
        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }

    public void deleteShipment(String shipmentId) {
        Shipment shipment = getShipment(shipmentId);
        shipmentRepository.delete(shipment);
    }
}
