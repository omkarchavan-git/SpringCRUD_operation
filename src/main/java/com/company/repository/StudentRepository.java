package com.company.repository;

import com.company.entity.StudentsFrom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentsFrom, Long> {

}
