package com.nat.springbootassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.springbootassignment.model.Employee;
import com.nat.springbootassignment.repository.EmployeeRepository;



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
	//private EmployeeDAO empDAO;
	EmployeeRepository employeeRepository;
	
	
	
	@Override
	public String addEmployee(Employee employee) {
		//String status = empDAO.addEmployee(employee);
		// TODO Auto-generated method stub
		//return status;
		Employee emp = null;
		try {
			
			emp = employeeRepository.save(employee);
			return "success";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateEmployee(long id, long orgId, long depId, String name, int age, String position){
		// TODO Auto-generated method stub
		//return empDAO.updateEmployee(id, orgId, depId, name, age, position);
		return null;
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		//return empDAO.deleteEmployee(id);
		try {
			employeeRepository.deleteById(id);
			return "success";
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		// return empDAO.findById(id);
		Optional<Employee> optEmp = null;
		try {
			optEmp = employeeRepository.findById(id);
			return optEmp;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		// return empDAO.getEmployees();
		Optional<List<Employee>> optEmpList = null;
		try {
			optEmpList =  Optional.of(employeeRepository.findAll());
			return optEmpList;
		}catch(Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
