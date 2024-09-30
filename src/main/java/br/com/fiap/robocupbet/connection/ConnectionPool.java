package br.com.fiap.robocupbet.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
	private static final String ORACLE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", 
			ORACLE_USER = System.getenv("USER_ORACLE_DB_FIAP"),
			ORACLE_PASSWORD = System.getenv("PASSWORD_ORACLE_DB_FIAP");
	private static HikariDataSource ds;
	private static Connection connection;

	static {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			HikariConfig config = new HikariConfig();
			System.out.println(ORACLE_PASSWORD);
			System.out.println(ORACLE_USER);
			
			config.setJdbcUrl(ORACLE_URL);
			config.setUsername(ORACLE_USER);
			config.setPassword(ORACLE_PASSWORD);

			config.setMaximumPoolSize(10);
			config.setMinimumIdle(5);
			config.setIdleTimeout(60000);
			config.setConnectionTimeout(30000);
			ds = new HikariDataSource(config);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
