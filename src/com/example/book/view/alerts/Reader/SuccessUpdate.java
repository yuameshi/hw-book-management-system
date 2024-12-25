package com.example.book.view.alerts.Reader;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class SuccessUpdate {
	public static void show() {
		System.out.println("Book information updated successfully. ");
		JDialog dialog = new JDialog();
		dialog.setTitle("成功");
		dialog.setSize(320, 120);
		dialog.setLocationRelativeTo(null);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);

		JLabel label = new JLabel("   读者信息已更新");
		label.setBounds(0, 10, 300, 100);
		dialog.add(label);

		dialog.setVisible(true);
	}
}
