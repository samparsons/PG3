package com.simplilearn.workshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseUtils {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		Class.forName(driverClassName);
		String url = "jdbc:mysql://localhost/studentdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root";
		String password = "";
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
	}
}
