package com.nat.trainingassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.trainingassignment.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
