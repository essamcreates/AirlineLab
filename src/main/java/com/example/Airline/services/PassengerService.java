package com.example.Airline.services;

import com.example.Airline.models.Passenger;
import com.example.Airline.models.PassengerDTO;
import com.example.Airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

//    Add new passenger
    public Passenger addNewPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger(
                passengerDTO.getName(),
                passengerDTO.getPhoneNumber()
        );
        return passengerRepository.save(passenger);
    }

//    Display details of all passengers
    public List<Passenger> displayAllPassengers(){
        return passengerRepository.findAll();
    }

//    Display details of a specific passenger
    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
    }


}
