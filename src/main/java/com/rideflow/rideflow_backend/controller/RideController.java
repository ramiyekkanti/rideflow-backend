package com.rideflow.rideflow_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rideflow.rideflow_backend.dto.CreateRideRequest;
import com.rideflow.rideflow_backend.dto.RideResponse;
import com.rideflow.rideflow_backend.service.RideService;

@RestController
@RequestMapping("/api")
public class RideController {
    private final RideService rideService;
    public RideController(RideService rideService){
        this.rideService = rideService;
    }

    @PostMapping("/rides")
    @ResponseStatus(HttpStatus.CREATED)
    public RideResponse createRide(@RequestBody CreateRideRequest request){
        return rideService.bookRide(request);
    }   

    @GetMapping("/rides/{riderId}")
    public List<RideResponse> getRideByRiderId(@PathVariable String riderId){
        return rideService.getRidesByRider(riderId);
    }

}
