package com.example.shipment.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateShipmentRequest(
        @NotBlank(message = "Origin is required") String origin,
        @NotBlank(message = "Destination is required") String destination
) {}
