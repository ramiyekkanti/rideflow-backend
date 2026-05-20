package com.rideflow.rideflow_backend.model;

import java.util.UUID;

public class RideNotFoundException extends RuntimeException{
    public RideNotFoundException(UUID riderId){
        super("Ride not found with id: " + riderId);
    }
}
