package com.company.controller;

import com.company.entity.Developer;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/developer")

public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

//    @PostMapping("/addData")
//    public ResponseEntity<String> addDeveloper(@RequestBody Developer developer) {
//
//        System.err.println(developer);
//        developerService.saveDeveloper(developer);
//        return new ResponseEntity<>("Developer Data Saved", HttpStatus.CREATED);
//    }

    // added with vehicle mapping
    @PostMapping("/addData")
    public ResponseEntity<String> addDeveloper(@RequestBody Developer developer) {

        // Ensure the bidirectional mapping is set
        if (developer.getVehicles() != null) {
            developer.getVehicles().forEach(vehicle -> vehicle.setDeveloper(developer));
        }

        System.err.println(developer);
        developerService.saveDeveloper(developer);

        return new ResponseEntity<>("Developer Data Saved", HttpStatus.CREATED);
    }


    // Add Multiple data at once
    @PostMapping("/addMultipleDevelopers")
    public ResponseEntity<List<Developer>> addAllDevelopers(@RequestBody List<Developer> developerList) {
        List<Developer> developerList1 = developerService.addAllDevelopers(developerList);
        return new ResponseEntity<>(developerList1, HttpStatus.CREATED);
    }

    // Get all developers data
    @GetMapping("/getAllDeveloper")
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        List<Developer> developerList = developerService.getAllDevelopers();
        return new ResponseEntity<>(developerList, HttpStatus.OK);
    }

    // Get data by Id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable("id") int id) {
        Developer developer = developerService.getDeveloperById(id);

        if (developer != null) {
            return ResponseEntity.ok(developer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update By ID
    @PutMapping("/updateDeveloper/{id}")
    public ResponseEntity<Developer> updateDeveloperByID(@PathVariable("id") int id, @RequestBody Developer developer) {
        Developer dev = developerService.updateDeveloper(id, developer);
        return new ResponseEntity<>(dev, HttpStatus.OK);
    }

    // Delete developer data by ID
    @GetMapping("/deleteByID/{id}")
    public ResponseEntity<Developer> deleteByID(@PathVariable("id") int id) {
        Developer developer = developerService.delteDeveloper(id);
        return new ResponseEntity<>(developer, HttpStatus.OK);
    }

    // filter data by single city
    @GetMapping("/getByCity")
    public ResponseEntity<List<Developer>> getByCity(@RequestParam(required = false) String city) {
        List<Developer> developerList;

        if (city != null) {
            developerList = developerService.getByCity(city);
        } else {
            developerList = developerService.getAllDevelopers();
        }
        return new ResponseEntity<>(developerList, HttpStatus.OK);
    }

    // filter by multiple Cities
    @GetMapping("/filterByCity")
    public ResponseEntity<List<Developer>> getByCity(@RequestParam(required = false) List<String> city) {

        List<Developer> developerList;
        if (city != null) {

            developerList = developerService.filterByCity(city);
        } else {
            developerList = developerService.getAllDevelopers();
        }
        return ResponseEntity.ok(developerList);
    }

    // Filter by Gender
    @GetMapping("/filterByGender")
    public ResponseEntity<List<Developer>> filterByGender(@RequestParam(required = false) String gender) {
        List<Developer> developerList = developerService.filterByGender(gender);
        return new ResponseEntity<>(developerList, HttpStatus.OK);
    }

    // Filter By First Name
    @GetMapping("/filterByFirstName")
    public ResponseEntity<List<Developer>> filterByFirstName(@RequestParam(required = false) String fName) {
        List<Developer> developerList = developerService.filterByFirstName(fName);
        return new ResponseEntity<>(developerList, HttpStatus.OK);
    }

    // Filter By Last  Name
    @GetMapping("/filterByLastName")
    public ResponseEntity<List<Developer>> filterByLasrName(@RequestParam(required = false) String lName) {
        List<Developer> developerList = developerService.filterByFirstName(lName);
        return new ResponseEntity<>(developerList, HttpStatus.OK);
    }

    // get data by city using JQSQL query
    @GetMapping("/getByCity/{city}")
    public ResponseEntity<List<Developer>> geyByCityName(@Param("city") String city)
    {
       List<Developer> developerList = developerService.getByCityName(city);
       return new ResponseEntity<>(developerList, HttpStatus.OK);
    }


}
