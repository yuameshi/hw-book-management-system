package com.example.book.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Utils {
	private static DataSource dataSource = null;

	static {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException("Failed to initialize druid connection pool.");
		}
	}

	public enum Errors {
		Failed,
		FailedToConnect,
		FailedToExecuteQuery,
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static ResultSet Query(String sql, Statement statement) throws SQLException {
		ResultSet resultSet = null;
		boolean hasResultSer = statement.execute(sql);
		if (hasResultSer) {
			resultSet = statement.getResultSet();
			return resultSet;
		} else {
			return null;
		}
	}

	public static void CloseConnection(ResultSet resultSet, Statement statement, Connection connection)
			throws SQLException {
		// 关闭ResultSet
		if (resultSet != null) {
			resultSet.close();
		}
		// 关闭Statement
		if (statement != null) {
			statement.close();
		}
		// 关闭Connection
		if (connection != null) {
			connection.close();
		}
	}
}