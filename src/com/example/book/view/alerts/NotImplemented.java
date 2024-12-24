package com.example.book.view.alerts;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class NotImplemented {
	public static void show() {
		System.err.println("Function not implemented. ");
		JDialog dialog = new JDialog();
		dialog.setTitle("错误");
		dialog.setSize(320, 120);
		dialog.setLocationRelativeTo(null);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);

		JLabel label = new JLabel("   方法未实现");
		label.setBounds(0, 10, 300, 100);
		dialog.add(label);

		dialog.setVisible(true);
	}
}
