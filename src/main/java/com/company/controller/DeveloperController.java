package com.company.controller;

import com.company.entity.Developer;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping("/addData")
    public ResponseEntity<String> addDeveloper(@RequestBody Developer developer) {

        System.err.println(developer);
        developerService.saveDeveloper(developer);
        return new ResponseEntity<>("Developer Data Saved", HttpStatus.CREATED);
    }

    // Get all developers data
    @GetMapping("/getAllDeveloper")
    public ResponseEntity<List<Developer>> getAllDevelopers(){
        List<Developer> developerList = developerService.getAllDevelopers();
        return new ResponseEntity<>(developerList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable("id") int id){
        Developer developer = developerService.getDeveloperById(id);

        if (developer != null) {
            return  ResponseEntity.ok(developer);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateDeveloper/{id}")
    public ResponseEntity<Developer> updateDeveloperByID(@PathVariable("id") int id, @RequestBody Developer developer)
    {
        Developer dev = developerService.updateDeveloper(id, developer);
        return new ResponseEntity<>(dev, HttpStatus.OK);
    }

    // Delete developer data by ID
    @GetMapping("/deleteByID/{id}")
    public ResponseEntity<Developer> deleteByID(@PathVariable("id") int id)
    {
        Developer developer = developerService.delteDeveloper(id);
        return new ResponseEntity<>(developer, HttpStatus.OK);
    }

}
