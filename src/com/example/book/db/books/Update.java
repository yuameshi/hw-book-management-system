package com.example.book.db.books;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Book;
import com.example.book.db.Utils;

public class Update {
	public static void add(Book book, Book newBook) throws SQLException, InvalidParameterException {
		if (book.getId() != newBook.getId())
			throw new InvalidParameterException("Two book should have a same ID.");
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `bookdb`.`book` SET ");
		if (book.getBookName() != newBook.getBookName())
			sql.append("`bookname`='" + newBook.getBookName() + "'");
		if (book.getAuthor() != newBook.getAuthor())
			sql.append("`author`='" + newBook.getAuthor() + "'");
		if (book.getTranslator() != newBook.getTranslator())
			sql.append("`translator`='" + newBook.getTranslator() + "'");
		if (book.getCategory() != newBook.getCategory())
			sql.append("`booktype`='" + newBook.getCategory() + "'");
		if (book.getPublisher() != newBook.getPublisher())
			sql.append("`publisher`='" + newBook.getPublisher() + "'");
		if (book.getPublishTime() != newBook.getPublishTime())
			sql.append("`publish_time`='" + newBook.getPublishTime() + "'");
		if (book.getPrice() != newBook.getPrice())
			sql.append("`price`='" + newBook.getPrice() + "'");
		if (book.getStock() != newBook.getStock())
			sql.append("`stock`='" + newBook.getStock() + "'");
		sql.append(" WHERE  `id`='" + newBook.getId() + "';");
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}
}
