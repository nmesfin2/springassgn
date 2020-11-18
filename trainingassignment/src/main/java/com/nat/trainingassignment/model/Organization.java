package com.nat.trainingassignment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Organization_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
	
	@Id
	private Long id;
	private String name;
	private String address;
	//private List<Department> departments = new ArrayList<>();
	//private List<Employee> employees = new ArrayList<>();

}
