package com.rideflow.rideflow_backend.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rideflow.rideflow_backend.model.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, UUID>{
    List<Ride> findByRiderId(String riderId);
}
