package com.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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

    @Transient   // age column will not be stored in DB
    private int age;
    private String city;
    private String gender;
    private long salary;

    private LocalDate DOB;
    private LocalDateTime dateAndTime;

    // One Employee -> Many Vehicles
    @OneToMany(mappedBy = "Developer", cascade = CascadeType.ALL)
    private List<Vehicles> vehicles;


    // Getter for age - calculate dynamically
    public int getAge() {
        if (DOB == null) {
            return 0;
        }
        return Period.between(DOB, LocalDate.now()).getYears();
    }
}
