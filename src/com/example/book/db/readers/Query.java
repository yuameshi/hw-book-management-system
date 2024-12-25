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
			builder.withMaxBorrowCount(result.getString("max_num"));
			builder.withMaxBorrowDayCount(result.getString("days_num"));
			Utils.CloseConnection(null, statement, connection);
			return builder.build();
		} else {
			Utils.CloseConnection(result, statement, connection);
			return null;
		}
	}
}
