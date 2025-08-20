package com.company.service;

import com.company.entity.Developer;

import java.util.List;

public interface DeveloperService {

   // method to add single data into db
   public String saveDeveloper(Developer developer);

   // method to add multiple data at once into db
   public List<Developer> addAllDevelopers(List<Developer> developerList);

   // method to get all developers
   public List<Developer>  getAllDevelopers();

   // Get Developer data by ID
   Developer getDeveloperById(int id);

   //Update developer By id
   Developer updateDeveloper (int id, Developer newData);

   //Delete developer Data By ID
   Developer delteDeveloper(int id);

   // filter by one city
   List<Developer> getByCity(String city);


   // filter multiple cities at once
   List<Developer> filterByCity(List<String> city);

   //Filter by Gender
   List<Developer> filterByGender(String gender);

   //Filter by First Name
   List<Developer> filterByFirstName(String fName);

   //Filter by LAst Name
   List<Developer> filterByLastName(String lName);


   // get developer by city using JPSQL
   List<Developer> getByCityName(String city);
}
