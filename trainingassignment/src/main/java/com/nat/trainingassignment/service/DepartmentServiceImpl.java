package com.nat.trainingassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.trainingassignment.dao.DepartmentDAO;
import com.nat.trainingassignment.dao.DepartmentDAOImpl;
import com.nat.trainingassignment.dao.EmployeeDAO;
import com.nat.trainingassignment.dao.EmployeeDAOImpl;
import com.nat.trainingassignment.model.Department;
import com.nat.trainingassignment.model.Employee;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	/*
	 * private static DepartmentService deptService; DepartmentDAO
	 * deptDAO=DepartmentDAOImpl.getInstance(); private DepartmentServiceImpl() {}
	 * 
	 * public static DepartmentService getInstance() { if(deptService == null) {
	 * deptService = new DepartmentServiceImpl(); return deptService; } return
	 * deptService; }
	 */
	
	@Autowired
	private DepartmentDAO deptDAO;
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		return deptDAO.addDepartment(department);
	}

	@Override
	public String updateDepartment(long id, long orgId, String name) {
		// TODO Auto-generated method stub
		return deptDAO.updateDepartment(id, orgId, name);
	}

	@Override
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		return deptDAO.deleteDepartment(id);
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return deptDAO.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartment() {
		// TODO Auto-generated method stub
		return deptDAO.getDepartment();
	}

	@Override
	public Optional<List<Employee>> findEmployeesInDeparment(long id) {
		// TODO Auto-generated method stub
		return deptDAO.findEmployeesInDeparment(id);
	}

}
