package com.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity

@Getter     // Lombok dependency will automatically add the Getter and Setters
@Setter
@ToString

public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fName;
    private String lName;
    private int age;
    private String city;
    private String gender;
    private long salary;

    // One Employee -> Many Vehicles
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;


}
