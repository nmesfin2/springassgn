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
import com.nat.trainingassignment.model.Organization;
import com.nat.trainingassignment.util.DBUtil;

//@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

	/*
	 * private static OrganizationDAO orgDAO;
	 * 
	 * private OrganizationDAOImpl() {
	 * 
	 * } public static OrganizationDAO getInstance() { if(orgDAO == null) { orgDAO =
	 * new OrganizationDAOImpl(); return orgDAO; } return orgDAO; }
	 */
	@Autowired
	DBUtil dbUtil;
	
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertOrganization = "insert into organization(id, name, address) values (?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(insertOrganization);
			preparedStatement.setLong(1, organization.getId());
			preparedStatement.setString(2, organization.getName());
			preparedStatement.setString(3, organization.getAddress());
		
			
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
	public String updateOrganization(long id, String name, String address) {
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String updateOrg = "update organization set name=?, address=? WHERE id=?";
		
		try {
			preparedStatement = connection.prepareStatement(updateOrg);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, address);
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
	public String deleteOrganization(long id) {
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		
		String deleteOrgaanization = "delete from organization where id=?";
		try {
			ps = connection.prepareStatement(deleteOrgaanization);
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
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Organization organization = null;
		String query = "select * from organization where id=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				organization = new Organization();
				organization.setId(rs.getLong("id"));
				organization.setName(rs.getString("name"));
				organization.setAddress(rs.getString("address"));
	
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
		return Optional.of(organization);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Organization> orgList = new ArrayList<Organization>();
		String query = "select * from organization";
		
		try {
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Organization org = new Organization();
				org.setId(rs.getLong("id"));
				org.setName(rs.getString("name"));
				org.setAddress(rs.getString("address"));
		
				orgList.add(org);
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
		return Optional.of(orgList);
	}

	

}
