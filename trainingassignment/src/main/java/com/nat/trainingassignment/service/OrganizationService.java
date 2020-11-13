package com.nat.trainingassignment.service;

import java.util.List;
import java.util.Optional;

import com.nat.trainingassignment.model.Department;
import com.nat.trainingassignment.model.Organization;

public interface OrganizationService {
	public String addOrganization(Organization organization);
	public String updateOrganization(long id,String name, String address);
	public String deleteOrganization(long id);
	public Optional<Organization> findById(long id);
	public Optional<List<Organization>> getOrganizations();
	//public Optional<List<Organization>> findEmployeesInOrganization(long id);
}
