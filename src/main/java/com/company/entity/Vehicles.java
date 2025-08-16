package com.company.entity;

import jakarta.persistence.*;

@Entity
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String vehicleType;
    private String registrationNumber;

    // Many Vehicles -> One Developer
    @ManyToOne
    @JoinColumn(name = "developer_id")  // foreign key in Vehicle table
    private Developer Developer;

    // Getters & Setters
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Developer getDeveloper() {
        return Developer;
    }

    public void setDeveloper(Developer Developer) {
        this.Developer = Developer;
    }
}

