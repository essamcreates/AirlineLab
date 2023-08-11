package com.example.Airline.controllers;

import com.example.Airline.models.Passenger;
import com.example.Airline.models.PassengerDTO;
import com.example.Airline.repositories.PassengerRepository;
import com.example.Airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity(passengerService.displayAllPassengers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Passenger>> postPassenger(@RequestBody PassengerDTO passengerDTO){
        Passenger passenger = passengerService.addNewPassenger(passengerDTO);
        return new ResponseEntity(passenger, HttpStatus.OK);
    }


}
