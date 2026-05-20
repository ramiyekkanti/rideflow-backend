package com.rideflow.rideflow_backend.dto;

import lombok.Data;

@Data
public class CreateRideRequest {
    private String riderId;
    private String pickupLocation;
    private String dropoffLocation;
}
