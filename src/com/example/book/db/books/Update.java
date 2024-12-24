package com.example.book.db.books;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Book;
import com.example.book.db.Utils;

public class Update {
	public static void update(Book book, Book newBook) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `bookdb`.`book` SET ");
		if (!book.getId().equals(newBook.getId()))
			sql.append("`id`='" + newBook.getId() + "' ");
		if (!book.getBookName().equals(newBook.getBookName()))
			sql.append("`bookname`='" + newBook.getBookName() + "' ");
		if (!book.getAuthor().equals(newBook.getAuthor()))
			sql.append("`author`='" + newBook.getAuthor() + " '");
		if (!book.getTranslator().equals(newBook.getTranslator()))
			sql.append("`translator`='" + newBook.getTranslator() + "' ");
		if (!book.getCategory().equals(newBook.getCategory()))
			sql.append("`booktype`='" + newBook.getCategory() + "' ");
		if (!book.getPublisher().equals(newBook.getPublisher()))
			sql.append("`publisher`='" + newBook.getPublisher() + "' ");
		if (!book.getPublishTime().equals(newBook.getPublishTime()))
			sql.append("`publish_time`='" + newBook.getPublishTime() + "' ");
		if (book.getPrice() != newBook.getPrice())
			sql.append("`price`='" + newBook.getPrice() + "' ");
		if (book.getStock() != (newBook.getStock()))
			sql.append("`stock`='" + newBook.getStock() + "' ");
		sql.append(" WHERE `id`='" + book.getId() + "';");
		System.out.println(sql.toString());
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}
}
