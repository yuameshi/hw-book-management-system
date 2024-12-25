package com.example.book.db.readers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Reader;
import com.example.book.db.Utils;

public class Update {
	public static void update(Reader oldReader, Reader newReader) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `bookdb`.`reader` SET ");
		if (!oldReader.getId().equals(newReader.getId())) {
			if (sql.substring(25).toString().equals("SET "))
				sql.append("`id`='" + newReader.getId() + "' ");
			else
				sql.append(", `id`='" + newReader.getId() + "' ");
		}
		if (!oldReader.getName().equals(newReader.getName())) {
			if (sql.substring(25).toString().equals("SET "))
				sql.append("`readername`='" + newReader.getName() + "' ");
			else
				sql.append(", `readername`='" + newReader.getName() + "' ");
		}
		if (!oldReader.getCategory().equals(newReader.getCategory())) {
			if (sql.substring(25).toString().equals("SET "))
				sql.append("`readertype`='" + newReader.getCategory() + "' ");
			else
				sql.append(", `readertype`='" + newReader.getCategory() + "' ");
		}
		if (!oldReader.getGender().equals(newReader.getGender())) {
			if (sql.substring(25).toString().equals("SET "))
				sql.append("`sex`='" + newReader.getGender() + " '");
			else
				sql.append(", `sex`='" + newReader.getGender() + " '");
		}
		if (oldReader.getMaxBorrowCount() != newReader.getMaxBorrowCount()) {
			if (sql.substring(25).toString().equals("SET "))
				sql.append("`max_num`='" + newReader.getMaxBorrowCount() + "' ");
			else
				sql.append(", `max_num`='" + newReader.getMaxBorrowCount() + "' ");
		}
		if (oldReader.getMaxBorrowDayCount() != newReader.getMaxBorrowDayCount()) {
			if (sql.substring(25).toString().equals("SET "))
				sql.append("`days_num`='" + newReader.getMaxBorrowDayCount() + "' ");
			else
				sql.append(", `days_num`='" + newReader.getMaxBorrowDayCount() + "' ");
		}
		sql.append(" WHERE `id`='" + oldReader.getId() + "';");
		System.out.println(sql.toString());
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}
}
