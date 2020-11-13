package com.nat.trainingassignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// whenever we come across to utility classes, the we should mark these casses with @Component
@Component
public class DBUtil {
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	public void init() {
		System.out.println("init called");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroy called");
	}
	public Connection getConnection() {
		Connection connection = null; 
		
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		/*
		 * Connection connection = null; try {
		 * Class.forName("com.mysql.cj.jdbc.Driver"); connection =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/nat?useSSL=false",
		 * "root", "Iw2hacc@mysql1"); connection.setAutoCommit(false); return
		 * connection; } catch (ClassNotFoundException | SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } return connection;
		 */
	}
	
	public void closeCollection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
