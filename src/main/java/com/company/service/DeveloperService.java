package com.company.service;

import com.company.entity.Developer;

import java.util.List;

public interface DeveloperService {

   public String saveDeveloper(Developer developer);

   // method to get all developers
   public List<Developer>  getAllDevelopers();

   Developer getDeveloperById(int id);

   //Update developer By id
   Developer updateDeveloper (int id, Developer newData);

}
