package com.example.book.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ResetPassword {
	private static JFrame frame = new JFrame("重置密码");
	private static int targetUid;

	public class ResetPasswordCallbackParam {
		int uid;
		String password;

		public ResetPasswordCallbackParam(int uid, String password) {
			this.uid = uid;
			this.password = password;
		}

		public String getPassword() {
			return password;
		}

		public int getUid() {
			return this.uid;
		}
	}

	public ResetPassword(Consumer<ResetPasswordCallbackParam> callback, Runnable goMain) {
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

		JLabel newPasswdLabel = new JLabel("新密码");
		newPasswdLabel.setBounds(30, 20, 120, 40);
		newPasswdLabel.setFont(DEFAULT_FONT);
		newPasswdLabel.setForeground(BLACK);
		panel.add(newPasswdLabel);

		JPasswordField newPasswdField = new JPasswordField("");
		newPasswdField.setBounds(160, 20, 200, 35);
		newPasswdField.setFont(DEFAULT_FONT);
		newPasswdField.setBackground(WHITE);
		newPasswdField.setForeground(GRAY);
		panel.add(newPasswdField);

		JLabel passwdComfirmLabel = new JLabel("确认密码");
		passwdComfirmLabel.setBounds(30, 70, 120, 40);
		passwdComfirmLabel.setFont(DEFAULT_FONT);
		passwdComfirmLabel.setForeground(BLACK);
		panel.add(passwdComfirmLabel);

		JPasswordField passwordComfirmField = new JPasswordField("");
		passwordComfirmField.setBounds(160, 70, 200, 35);
		passwordComfirmField.setFont(DEFAULT_FONT);
		passwordComfirmField.setBackground(WHITE);
		passwordComfirmField.setForeground(GRAY);
		panel.add(passwordComfirmField);

		JButton submitBtn = new JButton("确认");
		submitBtn.setBounds(60, 130, 110, 45);
		submitBtn.setFont(new Font(null, Font.PLAIN, 20));
		submitBtn.setBackground(WHITE);
		submitBtn.setForeground(BLACK);
		submitBtn.setFocusPainted(false);
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (new String(newPasswdField.getPassword()).isEmpty()
						|| new String(passwordComfirmField.getPassword()).isEmpty()) {
					return;
				}
				if (!newPasswdField.getPassword().equals(new String(passwordComfirmField.getPassword()))) {
					return;
				}
				String password = new String(passwordComfirmField.getPassword());
				callback.accept(new ResetPasswordCallbackParam(targetUid, password));
			}
		});
		panel.add(submitBtn);

		JButton goBack = new JButton("返回");
		goBack.setBounds(200, 130, 110, 45);
		goBack.setFont(new Font(null, Font.PLAIN, 20));
		goBack.setBackground(WHITE);
		goBack.setForeground(BLACK);
		goBack.setFocusPainted(false);
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goMain.run();
				hide();
			}
		});
		panel.add(goBack);

		frame.add(panel);
	}

	public void show(int uid) {
		targetUid = uid;
		frame.setVisible(true);
	}

	public void hide() {
		frame.setVisible(false);
	}
}
