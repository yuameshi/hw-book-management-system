package com.example.book.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Initialization {

	public static class DbCreateStatus {
		boolean DatabaseCrated = false;
		boolean BooksTableCrated = false;
		boolean UsersTableCrated = false;
		boolean BorrowTableCrated = false;
		boolean ReaderTableCrated = false;
	}

	public static void SmartCreate() throws SQLException {
		DbCreateStatus status = CheckIfCreated();
		if (!status.DatabaseCrated) {
			CreateDatabase();
		}
		if (!status.BooksTableCrated) {
			CreateBooksTable();
		}
		if (!status.UsersTableCrated) {
			CreateUsersTable();
		}
		if (!status.BorrowTableCrated) {
			CreateBorrowTable();
		}
		if (!status.ReaderTableCrated) {
			CreateReaderTable();
		}
	}

	public static DbCreateStatus CheckIfCreated() throws SQLException {
		Connection con = Utils.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = Utils.Query("SHOW DATABASES;", statement);
		DbCreateStatus status = new DbCreateStatus();
		while (resultSet.next()) {
			if (resultSet.getString("Database").equals("bookdb")) {
				status.DatabaseCrated = true;
				return status;
			}
		}
		if (status.DatabaseCrated) {
			resultSet = Utils.Query("SHOW TABLES FROM bookdb;", statement);
			while (resultSet.next()) {
				if (resultSet.getString("Tables_in_bookdb").equals("book")) {
					status.BooksTableCrated = true;
				}
				if (resultSet.getString("Tables_in_bookdb").equals("users")) {
					status.UsersTableCrated = true;
				}
				if (resultSet.getString("Tables_in_bookdb").equals("borrow")) {
					status.BorrowTableCrated = true;
				}
				if (resultSet.getString("Tables_in_bookdb").equals("reader")) {
					status.ReaderTableCrated = true;
				}
			}
		}
		Utils.CloseConnection(resultSet, statement, con);
		return status;
	}

	public static void CreateDatabase() throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		Utils.Query("CREATE DATABASE IF NOT EXISTS `bookdb`;", statement);
		Utils.CloseConnection(null, statement, connection);
	}

	public static void CreateBooksTable() throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		Utils.Query("""
				CREATE TABLE IF NOT EXISTS `book` (
					`id` varchar(8) NOT NULL COMMENT '图书编号',
					`bookname` varchar(100) DEFAULT NULL COMMENT '图书名称',
					`booktype` varchar(50) DEFAULT '科技' COMMENT '图书类别',
					`author` varchar(50) DEFAULT NULL COMMENT '图书作者',
					`translator` varchar(50) DEFAULT NULL COMMENT '译者',
					`publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
					`publish_time` datetime DEFAULT NULL COMMENT '出版时间',
					`price` float DEFAULT 28 COMMENT '定价',
					`stock` int(11) DEFAULT 1 COMMENT '库存数量',
					PRIMARY KEY (`id`)
				) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
				""", statement);
		Utils.CloseConnection(null, statement, connection);
	}

	public static void CreateBorrowTable() throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = Utils.Query("""
				CREATE TABLE IF NOT EXISTS `borrow` (
					`int` int(11) NOT NULL AUTO_INCREMENT COMMENT '借阅流水号',
					`book_id` varchar(50) DEFAULT NULL COMMENT '图书编号',
					`reader_id` varchar(50) DEFAULT NULL COMMENT '读者编号',
					`borrow_date` datetime DEFAULT NULL COMMENT '借阅时间',
					`back_date` datetime DEFAULT NULL COMMENT '还书时间',
					`if_back` varchar(2) DEFAULT NULL COMMENT '是否归还',
					PRIMARY KEY (`int`)
				) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
				""", statement);
		Utils.CloseConnection(rs, statement, connection);
	}

	public static void CreateReaderTable() throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		Utils.Query("""
				CREATE TABLE IF NOT EXISTS `reader` (
					`id` varchar(8) NOT NULL COMMENT '读者编号',
					`readername` varchar(50) DEFAULT NULL COMMENT '读者姓名',
					`readertype` varchar(50) DEFAULT NULL COMMENT '读者类别',
					`sex` varchar(2) DEFAULT NULL COMMENT '读者性别',
					`max_num` int(11) DEFAULT NULL COMMENT '最大可借数',
					`days_num` int(11) DEFAULT NULL COMMENT '可借天数',
					PRIMARY KEY (`id`)
				) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
				""", statement);
		Utils.CloseConnection(null, statement, connection);
	}

	public static void CreateUsersTable() throws SQLException {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		Utils.Query("""
				CREATE TABLE IF NOT EXISTS `users` (
					`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户流水号',
					`username` varchar(50) DEFAULT NULL COMMENT '用户姓名',
					`password` varchar(50) DEFAULT NULL COMMENT '用户密码',
					`is_admin` varchar(2) DEFAULT NULL COMMENT '是否为管理员',
					PRIMARY KEY (`id`)
				) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
				""", statement);
		Utils.CloseConnection(null, statement, connection);
	}
}
