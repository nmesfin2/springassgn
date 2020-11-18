package com.nat.trainingassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.trainingassignment.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
