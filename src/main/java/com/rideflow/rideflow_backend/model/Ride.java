package com.rideflow.rideflow_backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rides")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String riderId;

    @Column(nullable = false)
    private String pickup;

    @Column(nullable = false)
    private String dropoff;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    private Double fare;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.status = RideStatus.REQUESTED;
        this.createdAt = LocalDateTime.now();
    }
}
