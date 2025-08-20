package com.company.repository;

import com.company.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

    //Search by City

    // adding JPSQL query

    @Query("SELECT d FROM Developer d WHERE d.city = :city")
   List<Developer> findByCity(String city);

    // adding MySQL query to get data by age
    @Query(value = "SELECT * FROM developer WHERE age = :age", nativeQuery = true)
    List<Developer> findByAge(@Param("age") int age);



}
