package com.nat.trainingassignment.dao;

import java.util.List;
import java.util.Optional;

import com.nat.trainingassignment.model.Department;
import com.nat.trainingassignment.model.Employee;

public interface DepartmentDAO {
	public String addDepartment(Department department);
	public String updateDepartment(long id, long orgId, String name);
	public String deleteDepartment(long id);
	public Optional<Department> findById(long id);
	public Optional<List<Department>> getDepartment();
	public Optional<List<Employee>> findEmployeesInDeparment(long id);

}
