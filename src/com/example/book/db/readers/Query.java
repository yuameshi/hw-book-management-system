package com.example.book.db.readers;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.book.controller.Reader;
import com.example.book.db.Utils;

public class Query {
	public static Reader byId(int id) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet result = Utils.Query("SELECT * FROM `bookdb`.`reader` WHERE `id`='" + id + "' LIMIT 1;",
				statement);
		Reader.ReaderBuilder builder = new Reader.ReaderBuilder(String.valueOf(id));
		if (result.next()) {
			builder.withName(result.getString("readername"));
			builder.withCategory(result.getString("readertype"));
			builder.withGender(result.getString("sex"));
			builder.withMaxBorrowCount(Integer.valueOf(result.getString("max_num")));
			builder.withMaxBorrowDayCount(Integer.valueOf(result.getString("days_num")));
			Utils.CloseConnection(null, statement, connection);
			return builder.build();
		} else {
			Utils.CloseConnection(result, statement, connection);
			return null;
		}
	}

	public static Reader[] byName(String name) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rowCountQuery = statement
				.executeQuery(
						"SELECT COUNT(*) totalCount FROM `bookdb`.`reader` WHERE `readername` LIKE '%" + name
								+ "%';");
		int rowCount = 999;
		if (rowCountQuery.next()) {
			rowCount = rowCountQuery.getInt("totalCount");
		}
		Reader[] books = new Reader[rowCount];
		ResultSet result = Utils.Query("SELECT * FROM `bookdb`.`reader` WHERE `readername` LIKE '%" + name + "%';",
				statement);
		while (result.next()) {
			Reader.ReaderBuilder builder = new Reader.ReaderBuilder(result.getString("id"));
			builder.withName(result.getString("readername"));
			builder.withCategory(result.getString("readertype"));
			builder.withGender(result.getString("sex"));
			builder.withMaxBorrowCount(Integer.valueOf(result.getString("max_num")));
			builder.withMaxBorrowDayCount(Integer.valueOf(result.getString("days_num")));
			books[result.getRow() - 1] = builder.build();
		}
		Utils.CloseConnection(result, statement, connection);
		return books;
	}
}
