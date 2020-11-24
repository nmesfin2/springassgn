package com.nat.springbootassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nat.springbootassignment.model.Department;
import com.nat.springbootassignment.model.Employee;
import com.nat.springbootassignment.model.Organization;
import com.nat.springbootassignment.service.DepartmentService;
import com.nat.springbootassignment.service.EmployeeService;
import com.nat.springbootassignment.service.OrganizationService;



@SpringBootApplication
public class SpringbootassignmentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootassignmentApplication.class, args);
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		//DataSource dataSource = context.getBean("getMySQLDataSource", DataSource.class);
		

		OrganizationService orgService = context.getBean(OrganizationService.class);	
		DepartmentService depService = context.getBean(DepartmentService.class);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		Organization org = new Organization((long)5, "orgname5", "five adddress", null, null); 
		orgService.addOrganization(org);
		
		Department dep = new Department((long)1, "HR", null, org);
		Department dep2 = new Department((long)4, "Accounting", null, org);
		Department dep3 = new Department((long)5, "Engineering", null, org); 
		
		depService.addDepartment(dep);
		depService.addDepartment(dep2);
		depService.addDepartment(dep3);
		

		Employee employee = new Employee(12,  "My Name", 99, "My Position", dep, org);
		Employee employee2 = new Employee(19, "second employee name", 34,"second employee Position", dep3, org ); 
		Employee employee3 = new Employee(100,"third employee name", 45, "third employee Position", dep2, org ); 
		
		
		employeeService.addEmployee(employee);
		employeeService.addEmployee(employee2);
		employeeService.addEmployee(employee3);
		
		//context.close();
	}

}
