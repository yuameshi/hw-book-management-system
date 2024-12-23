package com.example.book.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class LoginDialog {
	private static JFrame frame = new JFrame("登录");

	public class LoginObject {
		String username;
		String password;

		public LoginObject(String uname, String password) {
			this.username = uname;
			this.password = password;
		}

		public String getPassword() {
			return password;
		}

		public String getUsername() {
			return username;
		}
	}

	public LoginDialog(Consumer<LoginObject> loginHandler, Runnable closeHandler) {
		final Font DEFAULT_FONT = new Font(null, Font.PLAIN, 24);
		final Color WHITE = Color.decode("#ffffff");
		final Color BLACK = Color.decode("#1b1b1b");
		final Color GRAY = Color.decode("#737674");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#f0f0f0"));

		JLabel unameLabel = new JLabel("用户名：");
		unameLabel.setBounds(30, 20, 100, 40);
		unameLabel.setFont(DEFAULT_FONT);
		unameLabel.setForeground(BLACK);
		panel.add(unameLabel);

		JTextField unameField = new JTextField("");
		unameField.setBounds(140, 20, 200, 35);
		unameField.setFont(DEFAULT_FONT);
		unameField.setBackground(WHITE);
		unameField.setForeground(GRAY);
		panel.add(unameField);

		JLabel passwordLabel = new JLabel("密码：");
		passwordLabel.setBounds(30, 70, 100, 40);
		passwordLabel.setFont(DEFAULT_FONT);
		passwordLabel.setForeground(BLACK);
		panel.add(passwordLabel);

		JPasswordField passwordField = new JPasswordField("");
		passwordField.setBounds(140, 70, 200, 35);
		passwordField.setFont(DEFAULT_FONT);
		passwordField.setBackground(WHITE);
		passwordField.setForeground(GRAY);
		panel.add(passwordField);

		JButton loginBtn = new JButton("登录");
		loginBtn.setBounds(125, 130, 110, 45);
		loginBtn.setFont(new Font(null, Font.PLAIN, 20));
		loginBtn.setBackground(WHITE);
		loginBtn.setForeground(BLACK);
		loginBtn.setFocusPainted(false);
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = unameField.getText();
				String password = new String(passwordField.getPassword());
				loginHandler.accept(new LoginObject(username, password));
			}
		});
		panel.add(loginBtn);

		frame.add(panel);
		frame.setVisible(true);
	}

	public void show() {
		frame.setVisible(true);
	}

	public void hide() {
		frame.setVisible(false);
	}
}
