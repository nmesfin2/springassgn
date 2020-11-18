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
import com.nat.trainingassignment.repository.DepartmentRepository;

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
	
	/*
	 * @Autowired private DepartmentDAO deptDAO;
	 */
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		Department dep = null;
		try {
			dep = departmentRepository.save(department);
			return "success";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateDepartment(long id, long orgId, String name) {
		// TODO Auto-generated method stub
		//return deptDAO.updateDepartment(id, orgId, name);
		return null;
		
	}

	@Override
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		try {
			departmentRepository.deleteById(id);
			return "success";
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		//return deptDAO.findById(id);
		Optional<Department> optDept = null;
		try {
			optDept = departmentRepository.findById(id);
			return optDept;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<List<Department>> getDepartment() {
		// TODO Auto-generated method stub
		Optional<List<Department>> optDeptList = null;
		try {
			optDeptList =  Optional.of(departmentRepository.findAll());
			return optDeptList;
		}catch(Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
		
	}

	@Override
	public Optional<List<Employee>> findEmployeesInDeparment(long id) {
		// TODO Auto-generated method stub
		//return deptDAO.findEmployeesInDeparment(id);
		return null;
	}

}
