package com.example.book.db.books;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.book.controller.Book;
import com.example.book.db.Utils;

public class Query {

	public static Book byId(int id) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM `bookdb`.`book` WHERE `id`='" + id + "' LIMIT 1;");
		ResultSet result = Utils.Query(sql.toString(), statement);
		Book.BookBuilder builder = new Book.BookBuilder(String.valueOf(id));
		if (result.next()) {
			builder.withName(result.getString("bookname"));
			builder.withCategory(result.getString("booktype"));
			builder.withAuthor(result.getString("author"));
			builder.withTranslator(result.getString("translator"));
			builder.withPublisher(result.getString("publisher"));
			builder.withPublishTime(result.getString("publish_time"));
			builder.withPrice(result.getFloat("price"));
			builder.withStock(result.getInt("stock"));
			Utils.CloseConnection(null, statement, connection);
			return builder.build();
		} else {
			Utils.CloseConnection(result, statement, connection);
			return null;
		}
	}

	public static Book[] byBookName(String bookName) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rowCountQuery = statement
				.executeQuery(
						"SELECT COUNT(*) totalCount FROM `bookdb`.`book` WHERE `bookname` LIKE '%" + bookName
								+ "%';");
		int rowCount = 999;
		if (rowCountQuery.next()) {
			rowCount = rowCountQuery.getInt("totalCount");
		}
		Book[] books = new Book[rowCount];
		ResultSet result = Utils.Query("SELECT * FROM `bookdb`.`book` WHERE `bookname` LIKE '%" + bookName + "%';",
				statement);
		while (result.next()) {
			Book.BookBuilder builder = new Book.BookBuilder(result.getString("id"));
			builder.withName(result.getString("bookname"));
			builder.withCategory(result.getString("booktype"));
			builder.withAuthor(result.getString("author"));
			builder.withTranslator(result.getString("translator"));
			builder.withPublisher(result.getString("publisher"));
			builder.withPublishTime(result.getString("publish_time"));
			builder.withPrice(result.getFloat("price"));
			builder.withStock(result.getInt("stock"));
			books[result.getRow() - 1] = builder.build();
		}
		Utils.CloseConnection(result, statement, connection);
		return books;
	}

	public static Book[] byAuthor(String author) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rowCountQuery = statement
				.executeQuery(
						"SELECT COUNT(*) totalCount FROM `bookdb`.`book` WHERE `author` LIKE '%" + author
								+ "%';");
		int rowCount = 999;
		if (rowCountQuery.next()) {
			rowCount = rowCountQuery.getInt("totalCount");
		}
		Book[] books = new Book[rowCount];
		ResultSet result = Utils.Query("SELECT * FROM `bookdb`.`book` WHERE `author` LIKE '%" + author + "%';",
				statement);
		while (result.next()) {
			Book.BookBuilder builder = new Book.BookBuilder(result.getString("id"));
			builder.withName(result.getString("bookname"));
			builder.withCategory(result.getString("booktype"));
			builder.withAuthor(result.getString("author"));
			builder.withTranslator(result.getString("translator"));
			builder.withPublisher(result.getString("publisher"));
			builder.withPublishTime(result.getString("publish_time"));
			builder.withPrice(result.getFloat("price"));
			builder.withStock(result.getInt("stock"));
			books[result.getRow() - 1] = builder.build();
		}
		Utils.CloseConnection(result, statement, connection);
		return books;
	}

	public static Book[] byPublisher(String publisher) throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rowCountQuery = statement
				.executeQuery(
						"SELECT COUNT(*) totalCount FROM `bookdb`.`book` WHERE `publisher` LIKE '%" + publisher
								+ "%';");
		int rowCount = 999;
		if (rowCountQuery.next()) {
			rowCount = rowCountQuery.getInt("totalCount");
		}
		Book[] books = new Book[rowCount];
		ResultSet result = Utils.Query("SELECT * FROM `bookdb`.`book` WHERE `publisher` LIKE '%" + publisher + "%';",
				statement);
		while (result.next()) {
			Book.BookBuilder builder = new Book.BookBuilder(result.getString("id"));
			builder.withName(result.getString("bookname"));
			builder.withCategory(result.getString("booktype"));
			builder.withAuthor(result.getString("author"));
			builder.withTranslator(result.getString("translator"));
			builder.withPublisher(result.getString("publisher"));
			builder.withPublishTime(result.getString("publish_time"));
			builder.withPrice(result.getFloat("price"));
			builder.withStock(result.getInt("stock"));
			books[result.getRow() - 1] = builder.build();
		}
		Utils.CloseConnection(result, statement, connection);
		return books;
	}

	public static Book[] getAllBooks() throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rowCountQuery = statement
				.executeQuery("SELECT COUNT(*) totalCount FROM `bookdb`.`book`;");
		int rowCount = 999;
		if (rowCountQuery.next()) {
			rowCount = rowCountQuery.getInt("totalCount");
		}
		Book[] books = new Book[rowCount];
		ResultSet result = Utils.Query("SELECT * FROM `bookdb`.`book`;",
				statement);
		while (result.next()) {
			Book.BookBuilder builder = new Book.BookBuilder(result.getString("id"));
			builder.withName(result.getString("bookname"));
			builder.withCategory(result.getString("booktype"));
			builder.withAuthor(result.getString("author"));
			builder.withTranslator(result.getString("translator"));
			builder.withPublisher(result.getString("publisher"));
			builder.withPublishTime(result.getString("publish_time"));
			builder.withPrice(result.getFloat("price"));
			builder.withStock(result.getInt("stock"));
			books[result.getRow() - 1] = builder.build();
		}
		Utils.CloseConnection(result, statement, connection);
		return books;
	}
}
