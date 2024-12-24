package com.example.book.db.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.example.book.utils.HashPassword;
import com.example.book.controller.UserInfo;
import com.example.book.db.Utils;

public class Login {

	public static UserInfo login(String username, String password) throws Exception {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet result = Utils.Query("""
				SELECT * FROM `bookdb`.`users` WHERE `username` = '%s' AND `password` = '%s' LIMIT 1;
				""".formatted(username, HashPassword.hashPassword(password)), statement);
		if (result.next()) {
			UserInfo info = new UserInfo(
					result.getInt("id"),
					result.getString("username"),
					result.getString("is_admin").equals("y"));
			Utils.CloseConnection(result, statement, connection);
			return info;
		} else {
			Utils.CloseConnection(result, statement, connection);
			UserInfo info = new UserInfo(-1, "", false);
			return info;
		}
	}
}
