package com.experiment.bebesty.repository;

import com.experiment.bebesty.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
