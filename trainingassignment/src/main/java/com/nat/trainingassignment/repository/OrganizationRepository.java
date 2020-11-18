package com.nat.trainingassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.trainingassignment.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
