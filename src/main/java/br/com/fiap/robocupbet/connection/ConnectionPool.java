package br.com.fiap.robocupbet.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
	 private static final String ORACLE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
			 	ORACLE_USER = "rm551107", //coloque o usuario
			 	ORACLE_PASSWORD = "210205"; //coloque o password
	 
	 private static HikariDataSource dataSource;
	 
	 static {
		 HikariConfig config = new HikariConfig();
		 config.setJdbcUrl(ORACLE_URL);
		 config.setUsername(ORACLE_USER);
		 config.setPassword(ORACLE_PASSWORD);
		 
		 config.setMaximumPoolSize(10);
		 config.setMinimumIdle(5);
		 config.setIdleTimeout(60000);
		 config.setConnectionTimeout(30000);
		 
		 dataSource = new HikariDataSource(config);
	 }
	 
	 public static Connection getConnection() {
		 try {
			 return dataSource.getConnection();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	 }
}
