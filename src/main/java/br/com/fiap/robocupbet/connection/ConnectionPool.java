package br.com.fiap.robocupbet.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
	private static final String ORACLE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", 
			ORACLE_USER = "",
			ORACLE_PASSWORD = "";
	private static HikariDataSource ds;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			HikariConfig config = new HikariConfig();
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
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
