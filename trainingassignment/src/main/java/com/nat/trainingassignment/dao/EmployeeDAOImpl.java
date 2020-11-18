package com.nat.trainingassignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nat.trainingassignment.model.Employee;
import com.nat.trainingassignment.util.DBUtil;

//@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	/*
	 * private static EmployeeDAO empDAO;
	 * 
	 * private EmployeeDAOImpl() {
	 * 
	 * } public static EmployeeDAO getInstance() { if(empDAO == null) { empDAO = new
	 * EmployeeDAOImpl(); return empDAO; } return empDAO; }
	 */
	
	@Autowired
	DBUtil dbUtil;
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertEmployee = "insert into employee(id, organizationId, departmentId, name, age, position) values (?,?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(insertEmployee);
			preparedStatement.setLong(1, employee.getId());
			preparedStatement.setLong(2, employee.getOrganizationId());
			preparedStatement.setLong(3, employee.getDepartmentId());
			preparedStatement.setString(4, employee.getName());
			preparedStatement.setInt(5, employee.getAge());
			preparedStatement.setString(6, employee.getPosition());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return "success";
			}else {
				return "fail";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}finally {
			dbUtil.closeCollection(connection);
		}
	}


	@Override
	public String updateEmployee(long id, long orgId, long depId, String name, int age, String position) {
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String updateEmployee = "update employee set organizationId=?, departmentId=?, name=?, age=?, position=? WHERE id=?";
		
		try {
			preparedStatement = connection.prepareStatement(updateEmployee);
			preparedStatement.setLong(1, orgId);
			preparedStatement.setLong(2, depId);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, age);
			preparedStatement.setString(5, position);
			preparedStatement.setLong(6, id);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return "success updating";
			}else {
				return "fail updating";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}finally {
			dbUtil.closeCollection(connection);
		}
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		
		String deleteEmployee = "delete from employee where id=?";
		try {
			ps = connection.prepareStatement(deleteEmployee);
			ps.setLong(1, id);
			result = ps.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return "success deleting";
			}else {
				return "fail updating";
			}
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}finally {
			dbUtil.closeCollection(connection);
		}
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		String query = "select * from employee where id=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setOrganizationId(rs.getLong("organizationId"));
				employee.setDepartmentId(rs.getLong("departmentId"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setPosition(rs.getString("position"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}finally {
			dbUtil.closeCollection(con);
		}
		return Optional.of(employee);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		String query = "select * from employee";
		
		try {
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setOrganizationId(rs.getLong("organizationId"));
				employee.setDepartmentId(rs.getLong("departmentId"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setPosition(rs.getString("position"));
				
				employeeList.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}finally {
			dbUtil.closeCollection(con);
		}
		return Optional.of(employeeList);
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		String query = "select * from employee where organizationId=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setOrganizationId(rs.getLong("organizationId"));
				employee.setDepartmentId(rs.getLong("departmentId"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setPosition(rs.getString("position"));
				
				employeeList.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		}finally {
			dbUtil.closeCollection(con);
		}
		return Optional.of(employeeList);
	}

}
