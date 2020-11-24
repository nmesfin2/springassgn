package com.nat.springbootassignment.service;

import java.util.List;
import java.util.Optional;

import com.nat.springbootassignment.model.Department;
import com.nat.springbootassignment.model.Employee;



public interface DepartmentService {
	public String addDepartment(Department department);
	public String updateDepartment(long id, long orgId, String name);
	public String deleteDepartment(long id);
	public Optional<Department> findById(long id);
	public Optional<List<Department>> getDepartment();
	public Optional<List<Employee>> findEmployeesInDeparment(long id);
}
