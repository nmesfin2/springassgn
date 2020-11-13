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

import com.nat.trainingassignment.model.Department;
import com.nat.trainingassignment.model.Employee;
import com.nat.trainingassignment.util.DBUtil;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	/*
	 * private static DepartmentDAO depDAO;
	 * 
	 * private DepartmentDAOImpl() {
	 * 
	 * } public static DepartmentDAO getInstance() { if(depDAO == null) { depDAO =
	 * new DepartmentDAOImpl(); return depDAO; } return depDAO; }
	 */
	
	@Autowired
	DBUtil dbUtil;
	
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertEmployee = "insert into department(id, organizationId, name) values (?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(insertEmployee);
			preparedStatement.setLong(1, department.getId());
			preparedStatement.setLong(2, department.getOrganizationId());
			preparedStatement.setString(3, department.getName());
		
			
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
	public String updateDepartment(long id, long orgId, String name) {
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String updateDepartment = "update department set organizationId=?, name=? WHERE id=?";
		
		try {
			preparedStatement = connection.prepareStatement(updateDepartment);
			preparedStatement.setLong(1, orgId);
			preparedStatement.setString(2, name);
			preparedStatement.setLong(3, id);
			
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
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		
		String deleteDepartment = "delete from department where id=?";
		try {
			ps = connection.prepareStatement(deleteDepartment);
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
	public Optional<Department> findById(long id) {

		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department department = null;
		String query = "select * from department where id=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				department = new Department();
				department.setId(rs.getLong("id"));
				department.setOrganizationId(rs.getLong("organizationId"));
				department.setName(rs.getString("name"));
	
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
		return Optional.of(department);
	}

	@Override
	public Optional<List<Department>> getDepartment() {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Department> departmentList = new ArrayList<Department>();
		String query = "select * from department";
		
		try {
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Department dept = new Department();
				dept.setId(rs.getLong("id"));
				dept.setOrganizationId(rs.getLong("organizationId"));
				dept.setName(rs.getString("name"));
		
				departmentList.add(dept);
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
		return Optional.of(departmentList);
	}

	@Override
	public Optional<List<Employee>> findEmployeesInDeparment(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		String query = "select * from employee where departmentId=?";
		
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
