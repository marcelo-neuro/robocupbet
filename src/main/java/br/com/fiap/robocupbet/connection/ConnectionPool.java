package br.com.fiap.robocupbet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
	 private static final String ORACLE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
			 	ORACLE_USER = "rm551107", //coloque o usuario
			 	ORACLE_PASSWORD = "210205"; //coloque o password
	 
	 public static Connection getConnection() {
		 try {
			 return DriverManager.getConnection(ORACLE_URL, ORACLE_USER, ORACLE_PASSWORD);
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	 }
}
