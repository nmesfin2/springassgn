package com.nat.trainingassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.trainingassignment.dao.EmployeeDAO;
import com.nat.trainingassignment.dao.EmployeeDAOImpl;
import com.nat.trainingassignment.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*
	 * private static EmployeeService empService; EmployeeDAO
	 * empDAO=EmployeeDAOImpl.getInstance(); private EmployeeServiceImpl() {}
	 * 
	 * public static EmployeeService getInstance() { if(empService == null) {
	 * empService = new EmployeeServiceImpl(); return empService; } return
	 * empService; }
	 */
	@Autowired
	private EmployeeDAO empDAO;
	@Override
	public String addEmployee(Employee employee) {
		String status = empDAO.addEmployee(employee);
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public String updateEmployee(long id, long orgId, long depId, String name, int age, String position){
		// TODO Auto-generated method stub
		return empDAO.updateEmployee(id, orgId, depId, name, age, position);
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return empDAO.deleteEmployee(id);
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return empDAO.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return empDAO.getEmployees();
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return empDAO.findByOrganizationId(id);
	}

}
