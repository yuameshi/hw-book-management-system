package com.example.book.controller;

public class UserInfo {
	public int uid;
	public String username;
	public boolean isAdmin;

	public UserInfo(int uid, String uname, boolean isAdmin) {
		this.uid = uid;
		this.username = uname;
		this.isAdmin = isAdmin;
	}
}