package com.example.book.view.alerts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.Consumer;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class DbNotRunning {
	public static void show(Consumer<Integer> callback) {
		System.err.println("Database is not running. Please start the database and retry again.");
		JDialog dialog = new JDialog();
		dialog.setTitle("连接数据库失败");
		dialog.setSize(320, 120);
		dialog.setLocationRelativeTo(null);
		dialog.setModal(true);
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				callback.accept(1);
			}
		});
		dialog.setResizable(false);

		JLabel label = new JLabel("   连接数据库失败，请检查数据库是否正确启动。");
		label.setBounds(0, 10, 300, 100);
		dialog.add(label);

		dialog.setVisible(true);
	}
}
