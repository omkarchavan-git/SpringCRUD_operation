package com.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity

@Getter
@Setter
@ToString

public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String firstname;
    private String lastName;
    private int age;
    private String city;
    private String gender;
    private long salary;

    private String DOB;
    private String dateAndTime;

    // One Employee -> Many Vehicles
    @OneToMany(mappedBy = "Developer", cascade = CascadeType.ALL)
    private List<Vehicles> vehicles;
}
