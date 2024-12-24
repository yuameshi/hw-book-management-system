package com.example.book.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
	public MainFrame() {
		JFrame frame = new JFrame("图书管理系统");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#ffffff"));

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(getBasicManagement());
		menuBar.add(getBorrowManagement());
		menuBar.add(getQueryManagement());
		menuBar.add(getSystemManagement());
		frame.setJMenuBar(menuBar);

		frame.add(panel);
		frame.setVisible(true);
	}

	private JMenu getBasicManagement() {
		JMenu basicManageMenu = new JMenu("基础维护");

		JMenu bookManageMenu = new JMenu("图书维护");
		JMenuItem addBookItem = new JMenuItem("添加图书");
		JMenuItem updateBookItem = new JMenuItem("修改图书");
		JMenuItem deleteBookItem = new JMenuItem("删除图书");
		bookManageMenu.add(addBookItem);
		bookManageMenu.add(updateBookItem);
		bookManageMenu.add(deleteBookItem);

		JMenu readerManageMenu = new JMenu("读者维护");
		JMenuItem addReaderItem = new JMenuItem("添加读者");
		JMenuItem updateReaderItem = new JMenuItem("修改读者");
		JMenuItem deleteReaderItem = new JMenuItem("删除读者");
		readerManageMenu.add(addReaderItem);
		readerManageMenu.add(updateReaderItem);
		readerManageMenu.add(deleteReaderItem);

		basicManageMenu.add(bookManageMenu);
		basicManageMenu.add(readerManageMenu);

		return basicManageMenu;
	}

	private JMenu getBorrowManagement() {
		JMenu borrowManageMenu = new JMenu("借阅管理");
		JMenuItem borrowManageItem = new JMenuItem("借书管理");
		borrowManageItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.err.println("Function not implemented. ");
			}
		});
		borrowManageMenu.add(borrowManageItem);

		JMenuItem returnManageItem = new JMenuItem("还书管理");
		returnManageItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.err.println("Function not implemented. ");
			}
		});
		borrowManageMenu.add(returnManageItem);
		return borrowManageMenu;
	}

	private JMenu getQueryManagement() {
		JMenu queryManageMenu = new JMenu("查询管理");
		JMenuItem bookQuery = new JMenuItem("图书查询");
		queryManageMenu.add(bookQuery);

		JMenuItem readerQuery = new JMenuItem("读者查询");
		queryManageMenu.add(readerQuery);
		return queryManageMenu;
	}

	private JMenu getSystemManagement() {
		JMenu systemManageMenu = new JMenu("系统管理");
		JMenuItem resetPassword = new JMenuItem("借书管理");
		JMenuItem exitSystem = new JMenuItem("退出系统");
		systemManageMenu.add(resetPassword);
		systemManageMenu.add(exitSystem);
		return systemManageMenu;
	}
}
