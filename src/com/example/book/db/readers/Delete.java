package com.example.book.db.readers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Reader;
import com.example.book.db.Utils;

public class Delete {

	public static void delete(Reader reader) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM `bookdb`.`reader` WHERE `id`='" + reader.getId() + "';");
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}

}
