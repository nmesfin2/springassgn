package com.nat.trainingassignment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Department_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	private Long id;
	
	@Column(name="organization_id")
	private Long organizationId;
	private String name;
	//private List<Employee> employees;

}
