package com.nat.trainingassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.trainingassignment.dao.DepartmentDAO;
//import com.nat.trainingassignment.dao.DepartmentDAOImpl;
import com.nat.trainingassignment.dao.OrganizationDAO;
//import com.nat.trainingassignment.dao.OrganizationDAOImpl;
import com.nat.trainingassignment.model.Department;
import com.nat.trainingassignment.model.Employee;
import com.nat.trainingassignment.model.Organization;
import com.nat.trainingassignment.repository.OrganizationRepository;

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
	
	//@Autowired
	//private OrganizationDAO orgDAO;
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		//return orgDAO.addOrganization(organization);
		Organization org = null;
		try {
			org = organizationRepository.save(organization);
			return "success";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateOrganization(long id,String name, String address) {
		// TODO Auto-generated method stub
		// return orgDAO.updateOrganization(id, name, address);
		return null;
	}

	@Override
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		//return orgDAO.deleteOrganization(id);
		try {
			organizationRepository.deleteById(id);
			return "success";
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		// return orgDAO.findById(id);
		Optional<Organization> optOrg = null;
		try {
			optOrg = organizationRepository.findById(id);
			return optOrg;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		// return orgDAO.getOrganizations();
		Optional<List<Organization>> optOrgList = null;
		try {
			optOrgList =  Optional.of(organizationRepository.findAll());
			return optOrgList;
		}catch(Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

}
