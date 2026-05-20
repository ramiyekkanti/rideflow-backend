package com.rideflow.rideflow_backend.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import com.rideflow.rideflow_backend.model.RideStatus;
import lombok.Data;

@Data
public class RideResponse {
    private UUID id;
    private String riderId;
    private String pickupLocation;
    private String dropoffLocation;
    private RideStatus status;
    private LocalDateTime createdAt;
}
