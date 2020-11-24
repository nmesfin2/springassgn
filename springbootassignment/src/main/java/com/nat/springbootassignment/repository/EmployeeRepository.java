package com.nat.springbootassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.springbootassignment.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
