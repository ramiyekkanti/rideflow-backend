package com.rideflow.rideflow_backend.dto;

import com.rideflow.rideflow_backend.model.RideStatus;
import lombok.Data;

@Data
public class UpdateRideStatusRequest {
    private RideStatus status;
}
