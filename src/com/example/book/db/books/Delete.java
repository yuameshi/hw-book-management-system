package com.example.book.db.books;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Book;
import com.example.book.db.Utils;

public class Delete {

	public static void delete(Book book) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM `bookdb`.`book` WHERE  `id`='" + book.getId() + "';");
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}

}
