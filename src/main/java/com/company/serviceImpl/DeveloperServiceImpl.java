package com.company.serviceImpl;

import com.company.entity.Developer;
import com.company.repository.DeveloperRepository;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    // obj of
    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public String saveDeveloper(Developer developer) {

        Developer saveDeveloper = developerRepository.save(developer);
        return "developer saved";
    }

    @Override
    public List<Developer> getAllDevelopers() {
        List<Developer> developerList = developerRepository.findAll();
        return developerList;
    }

    @Override
    public Developer getDeveloperById(int id) {
        Developer developerList = developerRepository.findById(id).orElseThrow(() -> new NullPointerException("Id not found " +id));
        return developerList;
    }

    @Override
    public Developer updateDeveloper(int id, Developer newData) {
        Developer developer = developerRepository.findById(id).orElseThrow(() -> new NullPointerException("Id not found " + id));
        developer.setfName(newData.getfName());
        developer.setlName(newData.getlName());
        developer.setAge(newData.getAge());
        developer.setCity(newData.getCity());
        developer.setGender(newData.getGender());
        developer.setSalary(newData.getSalary());

        Developer updateDeveloper = developerRepository.save(developer);
        return updateDeveloper;
    }

}
