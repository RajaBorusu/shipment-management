package com.example.shipment.controller;

import com.example.shipment.dto.CreateShipmentRequest;
import com.example.shipment.dto.UpdateStatusRequest;
import com.example.shipment.model.Shipment;
import com.example.shipment.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment createShipment(@Valid @RequestBody CreateShipmentRequest request) {
        return shipmentService.createShipment(request);
    }

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{shipmentId}")
    public Shipment getShipment(@PathVariable String shipmentId) {
        return shipmentService.getShipment(shipmentId);
    }

    @PatchMapping("/{shipmentId}/status")
    public Shipment updateStatus(
            @PathVariable String shipmentId,
            @Valid @RequestBody UpdateStatusRequest request) {
        return shipmentService.updateStatus(shipmentId, request.status());
    }

    @DeleteMapping("/{shipmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShipment(@PathVariable String shipmentId) {
        shipmentService.deleteShipment(shipmentId);
    }
}
