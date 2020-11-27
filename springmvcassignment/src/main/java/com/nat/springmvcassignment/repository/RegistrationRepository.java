package com.nat.springmvcassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.springmvcassignment.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {

}
