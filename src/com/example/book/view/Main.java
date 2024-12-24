package com.example.book.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.example.book.view.alerts.NotImplemented;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	private static JFrame frame;
	public boolean isAdmin = false;
	private static JMenu basicManageMenu;
	private JMenu borrowMenu;

	public Main(
			Runnable openAddBookFrame, Runnable openUpdateBookFrame,
			Runnable openBookQueryFrame,
			Runnable resetPasswordTrigger, Runnable closeHandler) {
		frame = new JFrame("图书管理系统");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#ffffff"));

		JMenuBar menuBar = new JMenuBar();
		basicManageMenu = getBasicManagement(openAddBookFrame, openUpdateBookFrame);
		borrowMenu = getBorrowManagement();
		JMenu queryManageMenu = getQueryManagement(openBookQueryFrame);
		JMenu systemManageMenu = getSystemManagement(resetPasswordTrigger, closeHandler);
		menuBar.add(basicManageMenu);
		menuBar.add(borrowMenu);
		menuBar.add(queryManageMenu);
		menuBar.add(systemManageMenu);
		frame.setJMenuBar(menuBar);

		frame.add(panel);
	}

	private JMenu getBasicManagement(
			Runnable openAddBookFrame, Runnable openUpdateBookFrame) {
		JMenu basicManageMenu = new JMenu("基础维护");
		basicManageMenu.setEnabled(isAdmin);

		JMenu bookManageMenu = new JMenu("图书维护");
		JMenuItem addBookItem = new JMenuItem("添加图书");
		addBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openAddBookFrame.run();
			}
		});
		bookManageMenu.add(addBookItem);
		JMenuItem updateBookItem = new JMenuItem("修改/删除图书");
		updateBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openUpdateBookFrame.run();
			}
		});
		bookManageMenu.add(updateBookItem);

		JMenu readerManageMenu = new JMenu("读者维护");
		JMenuItem addReaderItem = new JMenuItem("添加读者");
		JMenuItem updateReaderItem = new JMenuItem("修改删除/读者");
		readerManageMenu.add(addReaderItem);
		readerManageMenu.add(updateReaderItem);

		basicManageMenu.add(bookManageMenu);
		basicManageMenu.add(readerManageMenu);

		return basicManageMenu;
	}

	private JMenu getBorrowManagement() {
		JMenu borrowManageMenu = new JMenu("借阅管理");
		borrowManageMenu.setEnabled(isAdmin);
		JMenuItem borrowManageItem = new JMenuItem("借书管理");
		borrowManageItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NotImplemented.show();
			}
		});
		borrowManageMenu.add(borrowManageItem);

		JMenuItem returnManageItem = new JMenuItem("还书管理");
		returnManageItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NotImplemented.show();
			}
		});
		borrowManageMenu.add(returnManageItem);
		return borrowManageMenu;
	}

	private JMenu getQueryManagement(Runnable openBookQueryFrame) {
		JMenu queryManageMenu = new JMenu("查询管理");
		JMenuItem bookQuery = new JMenuItem("图书查询");
		bookQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openBookQueryFrame.run();
			}
		});
		queryManageMenu.add(bookQuery);

		JMenuItem readerQuery = new JMenuItem("读者查询");
		queryManageMenu.add(readerQuery);
		return queryManageMenu;
	}

	private JMenu getSystemManagement(Runnable resetPasswordTrigger, Runnable closeHandler) {
		JMenu systemManageMenu = new JMenu("系统管理");
		JMenuItem resetPassword = new JMenuItem("修改密码");
		resetPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetPasswordTrigger.run();
			}
		});
		systemManageMenu.add(resetPassword);

		JMenuItem exitSystem = new JMenuItem("退出系统");
		exitSystem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closeHandler.run();
			}
		});
		systemManageMenu.add(exitSystem);
		return systemManageMenu;
	}

	public void show() {
		frame.setVisible(true);
	}

	public void hide() {
		frame.setVisible(false);
	}

	public void toggleAdmin(boolean isAdmin) {
		basicManageMenu.setEnabled(isAdmin);
		borrowMenu.setEnabled(isAdmin);
	}
}
