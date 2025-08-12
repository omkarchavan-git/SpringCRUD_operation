package com.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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


}
