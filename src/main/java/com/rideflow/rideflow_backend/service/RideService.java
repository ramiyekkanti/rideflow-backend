package com.rideflow.rideflow_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rideflow.rideflow_backend.dto.CreateRideRequest;
import com.rideflow.rideflow_backend.dto.RideResponse;
import com.rideflow.rideflow_backend.model.Ride;
import com.rideflow.rideflow_backend.model.RideStatus;
import com.rideflow.rideflow_backend.repository.RideRepository;

@Service
public class RideService {
    private RideRepository rideRepository;
    public RideService(RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    public RideResponse bookRide(CreateRideRequest request){
        Ride ride = new Ride();
        ride.setRiderId(request.getRiderId());
        ride.setPickupLocation(request.getPickupLocation());
        ride.setDropoffLocation(request.getDropoffLocation());
        ride.setStatus(RideStatus.REQUESTED);

        Ride savedRide = rideRepository.save(ride);
        return mapToResponse(savedRide);
    }

    public List<RideResponse> getRidesByRider(String riderId){
        List<RideResponse> responses = new ArrayList<>();
        List<Ride> rides = rideRepository.findByRiderId(riderId);
        for(Ride ride : rides){
            responses.add(mapToResponse(ride));
        }
        return responses;
    }

    private RideResponse mapToResponse(Ride savedRide){
        RideResponse response = new RideResponse();
        response.setId(savedRide.getId());
        response.setRiderId(savedRide.getRiderId());
        response.setPickupLocation(savedRide.getPickupLocation());
        response.setDropoffLocation(savedRide.getDropoffLocation());
        response.setStatus(savedRide.getStatus());
        response.setCreatedAt(savedRide.getCreatedAt());
        return response;
    }
}
