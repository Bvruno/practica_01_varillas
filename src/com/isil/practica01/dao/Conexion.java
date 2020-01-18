package com.isil.practica01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.isil.practica01.util.Constants;

public class Conexion {
	
	
	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(Constants.JDBC_CLASS);
			connection = DriverManager.getConnection(Constants.JDBC_URL,Constants.JDBC_AUTONAME , Constants.JDBC_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
