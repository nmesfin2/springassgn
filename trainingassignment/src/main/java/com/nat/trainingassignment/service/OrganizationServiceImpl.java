package com.nat.trainingassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.trainingassignment.dao.DepartmentDAO;
import com.nat.trainingassignment.dao.DepartmentDAOImpl;
import com.nat.trainingassignment.dao.OrganizationDAO;
import com.nat.trainingassignment.dao.OrganizationDAOImpl;
import com.nat.trainingassignment.model.Department;
import com.nat.trainingassignment.model.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	/*
	 * private static OrganizationService orgService; OrganizationDAO
	 * orgDAO=OrganizationDAOImpl.getInstance(); private OrganizationServiceImpl()
	 * {}
	 * 
	 * public static OrganizationService getInstance() { if(orgService == null) {
	 * orgService = new OrganizationServiceImpl(); return orgService; } return
	 * orgService; }
	 */
	
	@Autowired
	private OrganizationDAO orgDAO;
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return orgDAO.addOrganization(organization);
	}

	@Override
	public String updateOrganization(long id,String name, String address) {
		// TODO Auto-generated method stub
		return orgDAO.updateOrganization(id, name, address);
	}

	@Override
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		return orgDAO.deleteOrganization(id);
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		return orgDAO.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return orgDAO.getOrganizations();
	}

	

}
