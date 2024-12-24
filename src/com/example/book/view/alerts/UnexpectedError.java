package com.example.book.view.alerts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.Consumer;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class UnexpectedError {
	public static void show(Consumer<Integer> callback) {
		System.err.println("An unexpected error occurred. Please restart app.");
		JDialog dialog = new JDialog();
		dialog.setTitle("出现了意料之外的错误");
		dialog.setSize(320, 120);
		dialog.setLocationRelativeTo(null);
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				callback.accept(-1);
			}
		});
		dialog.setResizable(false);

		JLabel label = new JLabel("   程序出现了未捕获的意外错误，请重启程序");
		label.setBounds(0, 10, 300, 100);
		dialog.add(label);

		dialog.setVisible(true);
	}
}
