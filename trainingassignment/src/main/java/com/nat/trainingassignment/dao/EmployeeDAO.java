package com.nat.trainingassignment.dao;

import java.util.List;
import java.util.Optional;

import com.nat.trainingassignment.model.Employee;

public interface EmployeeDAO {
	public String addEmployee(Employee employee);
	public String updateEmployee(long id, long orgId, long depId, String name, int age, String position);
	public String deleteEmployee(long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganizationId(long id);

}
