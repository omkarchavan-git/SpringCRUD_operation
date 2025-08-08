package com.company.serviceImpl;

import com.company.entity.Developer;
import com.company.exceptionHandeler.ResourceNotFoundException;
import com.company.repository.DeveloperRepository;
import com.company.service.DeveloperService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    // obj of
    @Autowired
    private DeveloperRepository developerRepository;

    // save single data into the developer
    @Override
    public String saveDeveloper(Developer developer) {

        Developer saveDeveloper = developerRepository.save(developer);
        return "developer saved";
    }

    // add multiple developers data at once
    @Override
    public List<Developer> addAllDevelopers(List<Developer> developerList) {

        List<Developer> developerList1 = developerRepository.saveAll(developerList);
        return developerList1;
    }

    @Override
    public List<Developer> getAllDevelopers() {
        List<Developer> developerList = developerRepository.findAll();
        return developerList;
    }

    @Override
    public Developer getDeveloperById(int id) {
        Developer developerList = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found " +id));
        return developerList;
    }

    @Override
    public Developer updateDeveloper(int id, @NotNull @RequestBody Developer newData) {
        Developer developer = developerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        developer.setfName(newData.getfName());
        developer.setlName(newData.getlName());
        developer.setAge(newData.getAge());
        developer.setCity(newData.getCity());
        developer.setGender(newData.getGender());
        developer.setSalary(newData.getSalary());

        Developer updateDeveloper = developerRepository.save(developer);
        return updateDeveloper;
    }

    @Override
    public Developer delteDeveloper(int id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ID not Found" + id));
        developerRepository.deleteById(id);

        return null;
    }

}
