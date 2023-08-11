package com.example.Airline.controllers;

import com.example.Airline.models.Flight;
import com.example.Airline.models.FlightDTO;
import com.example.Airline.models.Passenger;
import com.example.Airline.repositories.FlightRepository;
import com.example.Airline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> postFlight(@RequestBody FlightDTO flightDTO){
        Flight savedFlight = flightService.addFlight(flightDTO);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {
        flightService.cancelFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Flight> updateFlight(@RequestBody FlightDTO flightDTO, @PathVariable Long id){
        Flight updatedFlight = flightService.updateFlight(flightDTO, id);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }




}
