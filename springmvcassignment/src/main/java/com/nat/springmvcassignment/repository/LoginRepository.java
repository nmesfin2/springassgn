package com.nat.springmvcassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.springmvcassignment.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
