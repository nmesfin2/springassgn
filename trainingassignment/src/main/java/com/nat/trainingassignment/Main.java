package com.nat.trainingassignment;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nat.trainingassignment.config.DBConfig;
import com.nat.trainingassignment.model.Department;
import com.nat.trainingassignment.model.Employee;
import com.nat.trainingassignment.model.Organization;
import com.nat.trainingassignment.service.DepartmentService;
import com.nat.trainingassignment.service.DepartmentServiceImpl;
import com.nat.trainingassignment.service.EmployeeService;
import com.nat.trainingassignment.service.EmployeeServiceImpl;
import com.nat.trainingassignment.service.OrganizationService;
import com.nat.trainingassignment.service.OrganizationServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		DataSource dataSource = context.getBean("getMySQLDataSource", DataSource.class);
		

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
		

		Employee employee = new Employee(1,  "My Name", 99, "My Position", dep, org);
		Employee employee2 = new Employee(9, "second employee name", 34,"second employee Position", dep3, org ); 
		Employee employee3 = new Employee(10,"third employee name", 45, "third employee Position", dep2, org ); 
		
		
		employeeService.addEmployee(employee);
		employeeService.addEmployee(employee2);
		employeeService.addEmployee(employee3);
		
		context.close();
		/*
		 * DataSource dataSource2 = (DataSource) context.getBean("mysqlDataSource");
		 * System.out.println(dataSource.equals(dataSource2));
		 * System.out.println(dataSource == dataSource2);
		 */
		
		/*
		 * EmployeeService employeeService = context.getBean(EmployeeService.class);
		 * EmployeeService employeeService2 = context.getBean(EmployeeService.class);
		 * 
		 * String result = employeeService.addEmployee(employee);
		 * System.out.println(result); context.close();
		 */
		
//		
//		String status = null; System.out.
//		println("----------------------------------Employee section-----------------------------"); 
//		EmployeeService employeeService = context.getBean(EmployeeService.class);
//		Employee employee = new Employee(1, 1, 1, "My Name", 99, "My Position" );
//		Employee employee2 = new Employee(9, 2, 2, "second employee name", 34,"second employee Position" ); 
//		Employee employee3 = new Employee(10, 1, 2,"third employee name", 45, "third employee Position" ); 
//
//		int counter = 1; 
//		while(counter< 7) { 
//			switch(counter) { 
//				case 1:
//					System.out.println("------------------------------------------------------------------------------"); 
//					System.out.println("Adding Employees"); 
//					status = employeeService.addEmployee(employee); 
//					
//					if(status.equals("success")) {
//						System.out.println("employee added succesfully"); 
//					}else {
//						System.out.println("adding employee failed"); 
//					}
//			  
//					status = employeeService.addEmployee(employee2); 
//					if(status.equals("success")) {
//						System.out.println("employee added succesfully"); 
//					}else {
//						System.out.println("adding employee failed"); 
//					}
//			  
//					status = employeeService.addEmployee(employee3); 
//					if(status.equals("success")) {
//						System.out.println("employee added succesfully"); 
//					}else {
//						System.out.println("adding employee failed"); } System.out.println(); 
//				case 2:
//					System.out.println("------------------------------------------------------------------------------"); 
//					System.out.println("updating employee"); 
//					// status = employeeService.updateEmployee(1, 1, 1, "My Name changed", 29, "My Position changed"); 
//					System.out.println(status); System.out.println();
//			  
//				case 3: 
//					System.out.println("------------------------------------------------------------------------------"); 
//					System.out.println("deleting employee"); 
//					//status =employeeService.deleteEmployee(1); System.out.println(status);
//					System.out.println(); 
//				case 4: System.out.println("----------------------------------------------------"); 
//					System.out.println("find employee by id"); 
//					Optional <Employee> emp = employeeService.findById(2); 
//					
//					if(emp.isPresent()) { 
//						System.out.println(emp.get());
//					}
//					System.out.println(); 
//				case 5: 
//					System.out.println("------------------------------------------------------------------------------"); 
//					System.out.println("Get All Empoyees"); 
//					
//					Optional <List<Employee>> empAll = employeeService.getEmployees(); 
//					
//					if(empAll.isPresent()) { 
//						List<Employee> empList = empAll.get(); 
//						for(Employee e: empList) { 
//							System.out.println(e); 
//						}
//					}
//					System.out.println(); 
//				case 6: 
//					System.out.println("------------------------------------------------------------------------------"); 
//					System.out.println("find employee by organization");
//					
////					Optional<List<Employee>> empoByOrg = employeeService.findByOrganizationId(1);
////					if(empoByOrg.isPresent()) { 
////						List<Employee> empList = empoByOrg.get();
////						for(Employee e: empList) { 
////							System.out.println(e); 
////							} 
////						} 
//					System.out.println(); 
//					}
//				counter++; 
//		  }
//		  
//		  
//		  
//		System.out.println("---------------------------------Department Section------------------------------"); 
//		List<Employee> empListObj = null;
//		  
//		Department dep = new Department((long)1, (long)1, "HR");
//		Department dep2 = new Department((long)4, (long)2, "Accounting");
//		Department dep3 = new Department((long)5, (long)2, "Engineering"); 
//		DepartmentService depService = context.getBean(DepartmentService.class);
//		  
//		  
//		counter = 1; 
//		while(counter< 7) { 
//			switch(counter) { 
//				case 1:
//					System.out.println("----------------------------------------------------------------------------");
//					System.out.println("Adding Department"); 
//					
//					status =depService.addDepartment(dep); 
//					
//					if(status.equals("success")) {
//						System.out.println("added succesfully"); 
//					}else {
//						System.out.println("adding failed"); 
//					}
//		  
//					status = depService.addDepartment(dep2); 
//					
//					if(status.equals("success")) {
//						System.out.println("added succesfully"); 
//					}else {
//						System.out.println("adding failed"); 
//					}
//		  
//					status = depService.addDepartment(dep3); 
//					if(status.equals("success")) {
//						System.out.println("added succesfully"); 
//					}else {
//						System.out.println("adding failed"); 
//					} 
//					System.out.println(); 
//					
//				case 2:
//					System.out.println("------------------------------------------------------------------------"); 
//					System.out.println("updating department"); 
//					
//					//status = depService.updateDepartment(1, 1, "Changed HR"); 
//					System.out.println(status);
//					System.out.println(); 
//					
//				case 3: 
//					System.out.println("------------------------------------------------------------------------"); 
//					System.out.println("deleting department"); 
//					
//					//status = depService.deleteDepartment(1); 
//					
//					System.out.println(status);
//					System.out.println(); 
//					
//				case 4: 
//					System.out.println("---------------------------------------------------------------------------"); System.out.println("find department by id"); Optional<Department> dept =
//					depService.findById(2); 
//					
//					if(dept.isPresent()) {
//						System.out.println(dept.get()); 
//					} 
//					System.out.println(); 
//					
//				case 5:
//					System.out.println( "------------------------------------------------------------------------"); 
//					System.out.println("Get All Department"); Optional <List<Department>>
//		  
//					deptAll = depService.getDepartment(); 
//					
//					if(deptAll.isPresent()) {
//						List<Department> deptList = deptAll.get(); 
//						for(Department d: deptList) {
//							System.out.println(d); 
//						} 
//					} 
//					System.out.println(); 
//					
//				case 6: 
//					System.out.println( "------------------------------------------------------------------------"); 
//					System.out.println("find employee by department"); 
//					
//					//Optional<List<Employee>> empoByDept = depService.findEmployeesInDeparment(2);
//		  
////					if(empoByDept.isPresent()) { 
////						List<Employee> empList = empoByDept.get();
////						
////						for(Employee e: empList) { 
////							System.out.println(e); 
////							} 
////						} 
//					System.out.println();
//		  
//		  } 	counter++; }
//		  
//		  System.out.println("---------------------------------Organization Section------------------------------"); 
//		  List<Employee> empListObjOrg = null; 
//		  List<Department> deptListObjOrg = null;
//		  
//		  Organization org = new Organization((long)1, "orgname1", "first adddress"); 
//		  Organization org2 = new Organization((long)4,"orgname4", "four adddress"); 
//		  Organization org3 = new Organization((long)5, "orgname5", "five adddress"); 
//		  OrganizationService orgService = context.getBean(OrganizationService.class);
//		  
//		  counter = 1; 
//		  while(counter< 6) { 
//			  switch(counter){
//  				case 1: 
//  					System.out.println("--------------------------------------------------------------------------"); 
//  					System.out.println("Adding Organization"); 
//  					
//  					status = orgService.addOrganization(org); 
//  					
//  					if(status.equals("success")) {
//  						System.out.println("added succesfully"); 
//					}else {
//						System.out.println("adding failed"); 
//					}
//		  
//  					status = orgService.addOrganization(org2); 
//  					
//  					if(status.equals("success")) {
//  						System.out.println("added succesfully"); 
//					}else {
//						System.out.println("adding failed"); 
//					}
//		  
//  					status = orgService.addOrganization(org3); 
//  					
//  					if(status.equals("success")) {
//  						System.out.println("added succesfully"); 
//					}else {
//						System.out.println("adding failed"); 
//					} 
//  					System.out.println();
//		  
//  				case 2: 
//  					System.out.println("-----------------------------------------------------------------------"); 
//  					System.out.println("updating organization"); 
//  					
//  					//status = orgService.updateOrganization(1, "changed name", "changed address");
//  					
//  					System.out.println(status); 
//  					System.out.println();
//		  
//		  
//  				case 3: 
//  					System.out.println("-----------------------------------------------------------------------"); 
//  					System.out.println("deleting organization"); 
//  					
//  					//status =orgService.deleteOrganization(1); 
//  					
//  					System.out.println(status);
//  					System.out.println(); 
//  					
//  				case 4: 
//  					System.out.println("-----------------------------------------------------------------"); 
//  					System.out.println("find organization by id"); 
//  					
//  					Optional<Organization>orgtwo = orgService.findById(2); 
//  					
//  					if(orgtwo.isPresent()) {
//  						System.out.println(orgtwo.get()); 
//					} 
//  					System.out.println();
//		  
//		  
//  				case 5: 
//  					System.out.println("------------------------------------------------------------------------"); 
//  					System.out.println("Get All Organization"); 
//  					
//  					Optional <List<Organization>>orgAll = orgService.getOrganizations(); 
//  					
//  					if(orgAll.isPresent()) {
//  						List<Organization> orgList = orgAll.get(); 
//  						for(Organization d: orgList) {
//  							System.out.println(d); 
//						} 
//					} 
//  					System.out.println(); 
//				} 
//			  	counter++; 
//		  }
	}

}
