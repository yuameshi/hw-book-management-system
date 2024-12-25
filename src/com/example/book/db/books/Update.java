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
		if (!book.getId().equals(newBook.getId())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`id`='" + newBook.getId() + "' ");
			else
				sql.append(",`id`='" + newBook.getId() + "' ");
		}
		if (!book.getBookName().equals(newBook.getBookName())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`bookname`='" + newBook.getBookName() + "' ");
			else
				sql.append(",`bookname`='" + newBook.getBookName() + "' ");
		}
		if (!book.getAuthor().equals(newBook.getAuthor())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`author`='" + newBook.getAuthor() + " '");
			else
				sql.append(",`author`='" + newBook.getAuthor() + "' ");
		}
		if (!book.getTranslator().equals(newBook.getTranslator())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`translator`='" + newBook.getTranslator() + "' ");
			else
				sql.append(",`translator`='" + newBook.getTranslator() + "' ");
		}
		if (!book.getCategory().equals(newBook.getCategory())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`booktype`='" + newBook.getCategory() + "' ");
			else
				sql.append(",`booktype`='" + newBook.getCategory() + "' ");
		}
		if (!book.getPublisher().equals(newBook.getPublisher())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`publisher`='" + newBook.getPublisher() + "' ");
			else
				sql.append(",`publisher`='" + newBook.getPublisher() + "' ");
		}
		if (!book.getPublishTime().equals(newBook.getPublishTime())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`publish_time`='" + newBook.getPublishTime() + "' ");
			else
				sql.append(",`publish_time`='" + newBook.getPublishTime() + "' ");
		}
		if (book.getPrice() != newBook.getPrice()) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`price`='" + newBook.getPrice() + "' ");
			else
				sql.append(",`price`='" + newBook.getPrice() + "' ");
		}
		if (book.getStock() != (newBook.getStock())) {
			if (sql.substring(23).toString().equals("SET "))
				sql.append("`stock`='" + newBook.getStock() + "' ");
			else
				sql.append(",`stock`='" + newBook.getStock() + "' ");
		}
		sql.append(" WHERE `id`='" + book.getId() + "';");
		System.out.println(sql.toString());
		Utils.Query(sql.toString(), statement);
		Utils.CloseConnection(null, statement, connection);
	}
}
