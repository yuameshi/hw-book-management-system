package com.example.book.db.user;

import java.sql.Connection;
import java.sql.Statement;

import com.example.book.db.Utils;
import com.example.book.utils.HashPassword;
import com.example.book.view.ResetPassword.ResetPasswordCallbackParam;;

public class ResetPasswordDb {
	public static void reset(ResetPasswordCallbackParam param) throws Exception {
		Connection connection = Utils.getConnection();
		Statement statement = connection.createStatement();
		Utils.Query("""
				UPDATE `bookdb`.`users` SET `password`='%s' WHERE  `id`=%s;
				""".formatted(HashPassword.hashPassword(param.getPassword()), param.getUid()), statement);
		Utils.CloseConnection(null, statement, connection);
	}
}
