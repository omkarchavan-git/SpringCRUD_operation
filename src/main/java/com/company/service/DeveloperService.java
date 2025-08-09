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

   // Filter data by city
   List<Developer> getbyCity(String city);

}
