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

public class ResetPassword {
	private static JFrame frame = new JFrame("重置密码");

	public class ResetPasswordReturn {
		String password;

		public ResetPasswordReturn(String password) {
			this.password = password;
		}

		public String getPassword() {
			return password;
		}
	}

	public ResetPassword(Consumer<ResetPasswordReturn> loginHandler, Runnable closeHandler) {
		Font DEFAULT_FONT = new Font(null, Font.PLAIN, 24);
		Color WHITE = Color.decode("#ffffff");
		Color BLACK = Color.decode("#1b1b1b");
		Color GRAY = Color.decode("#737674");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#f0f0f0"));

		JLabel newPasswdLabel = new JLabel("新密码：");
		newPasswdLabel.setBounds(30, 20, 100, 40);
		newPasswdLabel.setFont(DEFAULT_FONT);
		newPasswdLabel.setForeground(BLACK);
		panel.add(newPasswdLabel);

		JTextField newPasswdField = new JTextField("");
		newPasswdField.setBounds(140, 20, 200, 35);
		newPasswdField.setFont(DEFAULT_FONT);
		newPasswdField.setBackground(WHITE);
		newPasswdField.setForeground(GRAY);
		panel.add(newPasswdField);

		JLabel passwdComfirmLabel = new JLabel("确认密码：");
		passwdComfirmLabel.setBounds(30, 70, 100, 40);
		passwdComfirmLabel.setFont(DEFAULT_FONT);
		passwdComfirmLabel.setForeground(BLACK);
		panel.add(passwdComfirmLabel);

		JPasswordField passwordComfirmField = new JPasswordField("");
		passwordComfirmField.setBounds(140, 70, 200, 35);
		passwordComfirmField.setFont(DEFAULT_FONT);
		passwordComfirmField.setBackground(WHITE);
		passwordComfirmField.setForeground(GRAY);
		panel.add(passwordComfirmField);

		JButton submitBtn = new JButton("登录");
		submitBtn.setBounds(125, 130, 110, 45);
		submitBtn.setFont(new Font(null, Font.PLAIN, 20));
		submitBtn.setBackground(WHITE);
		submitBtn.setForeground(BLACK);
		submitBtn.setFocusPainted(false);
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordComfirmField.getPassword());
				loginHandler.accept(new ResetPasswordReturn(password));
			}
		});
		panel.add(submitBtn);

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
