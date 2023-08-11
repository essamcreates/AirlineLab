package com.example.Airline.services;

import com.example.Airline.models.Flight;
import com.example.Airline.models.FlightDTO;
import com.example.Airline.models.Passenger;
import com.example.Airline.repositories.FlightRepository;
import com.example.Airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

//        Add details of a new flight
    public Flight addFlight(FlightDTO flightDTO) {
        Flight flight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        return flightRepository.save(flight);
    }

//            Display all available flights
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

//           Display details of a specific flight
    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

//    Book a passenger on to a flight

    public Flight updateFlight(FlightDTO flightDTO, Long id){ // ADDED
        Flight flightToUpdate = flightRepository.findById(id).get();
        for (Long passengerId : flightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerId).get();
            flightToUpdate.addPassengers(passenger);
        }
        flightRepository.save(flightToUpdate);
        return flightToUpdate;
    }


    //    Cancel a flight
    public void cancelFlight(Long id){
        Flight flight = flightRepository.findById(id).get();
        flightRepository.delete(flight);
    }

}
