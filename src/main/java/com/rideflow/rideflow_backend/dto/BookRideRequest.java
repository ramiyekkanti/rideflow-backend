package com.rideflow.rideflow_backend.dto;

import lombok.Data;

@Data
public class BookRideRequest {
    private String riderId;
    private String pickup;
    private String dropoff;
}
