package com.example.book.db.books;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Book;
import com.example.book.db.Utils;

public class Add {
	public static void add(Book book) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `bookdb`.`book` (");
		sql.append("`id`,");
		if (book.getBookName() != null)
			sql.append("`bookname`,");
		sql.append("`booktype`,");
		if (book.getAuthor() != null)
			sql.append("`author`,");
		if (book.getTranslator() != null)
			sql.append("`translator`,");
		if (book.getPublisher() != null)
			sql.append("`publisher`,");
		if (book.getPublishTime() != null)
			sql.append("`publish_time`,");
		sql.append("`price`,");
		sql.append("`stock`");
		sql.append(") VALUES (");
		sql.append("'" + book.getId() + "',");
		if (book.getBookName() != null)
			sql.append("'" + book.getBookName() + "',");

		sql.append("'" + book.getCategory() + "',");

		if (book.getAuthor() != null)
			sql.append("'" + book.getAuthor() + "',");

		if (book.getTranslator() != null)
			sql.append("'" + book.getTranslator() + "',");

		if (book.getPublisher() != null)
			sql.append("'" + book.getPublisher() + "',");

		if (book.getPublishTime() != null)
			sql.append("'" + book.getPublishTime() + "',");

		sql.append(book.getPrice() + ",");
		sql.append(book.getStock());
		sql.append(");");
		System.err.println(sql.toString());
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}

}