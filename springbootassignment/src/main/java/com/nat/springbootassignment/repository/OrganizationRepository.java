package com.nat.springbootassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.springbootassignment.model.Organization;



@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
