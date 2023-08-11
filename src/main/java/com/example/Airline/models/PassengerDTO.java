package com.example.Airline.models;

public class PassengerDTO {

    private String name;
    private String phoneNumber;


    public PassengerDTO(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public PassengerDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
