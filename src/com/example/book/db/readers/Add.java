package com.example.book.db.readers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Reader;
import com.example.book.db.Utils;

public class Add {
	public static void add(Reader reader) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `bookdb`.`reader` (");
		sql.append("`id`");
		if (reader.getName() != null)
			sql.append(",`readername`");
		if (reader.getCategory() != null)
			sql.append(",`readertype`");
		if (reader.getGender() != null)
			sql.append(",`sex`");
		if (reader.getMaxBorrowCount() != null)
			sql.append(",`max_num`");
		if (reader.getMaxBorrowDayCount() != null)
			sql.append(",`days_num`");
		sql.append(") VALUES (");
		sql.append("'" + reader.getId() + "'");
		if (reader.getName() != null)
			sql.append(",'" + reader.getName() + "'");

		if (reader.getCategory() != null)
			sql.append(",'" + reader.getCategory() + "'");

		if (reader.getGender() != null)
			sql.append(",'" + reader.getGender() + "'");

		if (reader.getMaxBorrowCount() != null)
			sql.append(",'" + reader.getMaxBorrowCount() + "'");

		if (reader.getMaxBorrowDayCount() != null)
			sql.append(",'" + reader.getMaxBorrowDayCount() + "'");

		sql.append(");");
		System.err.println(sql.toString());
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}
}
