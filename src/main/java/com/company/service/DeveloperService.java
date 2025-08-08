package com.company.service;

import com.company.entity.Developer;

import java.util.List;

public interface DeveloperService {

   public String saveDeveloper(Developer developer);

   // method to get all developers
   public List<Developer>  getAllDevelopers();

   // Get Developer data by ID
   Developer getDeveloperById(int id);

   //Update developer By id
   Developer updateDeveloper (int id, Developer newData);

   //Delete developer Data By ID
   Developer delteDeveloper(int id);

}
