package com.example.book.view.Reader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.book.controller.Reader;
import com.example.book.db.readers.Query;
import com.example.book.view.alerts.DbNotRunning;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class QueryReader {
	private JFrame frame;
	private JTextField nameField;
	JTable table;

	String[] columns = { "读者编号", "读者姓名", "读者性别", "读者类别", "最大可借数", "可借天数" };
	private String[][] queryResults = {};

	public QueryReader(Runnable goMainHandler) {
		final Font DEFAULT_FONT_18 = new Font(null, Font.PLAIN, 18);
		final Font DEFAULT_FONT_14 = new Font(null, Font.PLAIN, 20);
		final Color WHITE = Color.decode("#ffffff");
		final Color BLACK = Color.decode("#1b1b1b");
		final Color GRAY = Color.decode("#737674");

		frame = new JFrame("读者查询");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#eeeeee"));

		JLabel bookNameLabel = new JLabel("读者姓名");
		bookNameLabel.setBounds(160, 20, 80, 30);
		bookNameLabel.setFont(DEFAULT_FONT_18);
		bookNameLabel.setForeground(BLACK);
		panel.add(bookNameLabel);
		nameField = new JTextField("");
		nameField.setBounds(260, 20, 150, 30);
		nameField.setFont(DEFAULT_FONT_18);
		nameField.setBackground(WHITE);
		nameField.setForeground(GRAY);
		panel.add(nameField);

		JButton queryBtn = new JButton("查询");
		queryBtn.setBounds(420, 20, 100, 30);
		queryBtn.setBackground(WHITE);
		queryBtn.setForeground(BLACK);
		queryBtn.setFont(DEFAULT_FONT_14);
		queryBtn.setFocusPainted(false);
		queryBtn.addActionListener((e) -> {
			query();
		});
		panel.add(queryBtn);

		JButton closeBtn = new JButton("关闭");
		closeBtn.setBounds(540, 20, 100, 30);
		closeBtn.setBackground(WHITE);
		closeBtn.setForeground(BLACK);
		closeBtn.setFont(DEFAULT_FONT_14);
		closeBtn.setFocusPainted(false);
		closeBtn.addActionListener((e) -> {
			goMainHandler.run();
			close();
		});
		panel.add(closeBtn);

		DefaultTableModel model = new DefaultTableModel(queryResults, columns);
		table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setRowHeight(25);
		table.setFont(new Font(null, Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 70, 770, 670);
		panel.add(scrollPane);

		frame.add(panel);
	}

	private void query() {
		try {
			if (nameField.getText().isEmpty()) {
				Reader[] results = Query.getAllReaders();
				String[][] tableResults = new String[results.length][];
				for (int i = 0; i < results.length; i++) {
					tableResults[i] = new String[] {
							results[i].getId(),
							results[i].getName(),
							results[i].getGender(),
							results[i].getCategory(),
							String.valueOf(results[i].getMaxBorrowCount()),
							String.valueOf(results[i].getMaxBorrowDayCount()),
					};
				}
				table.setModel(new DefaultTableModel(tableResults, columns));
				return;
			} else {
				Reader[] results = Query.byName(nameField.getText());
				String[][] tableResults = new String[results.length][];
				for (int i = 0; i < results.length; i++) {
					tableResults[i] = new String[] {
							results[i].getId(),
							results[i].getName(),
							results[i].getGender(),
							results[i].getCategory(),
							String.valueOf(results[i].getMaxBorrowCount()),
							String.valueOf(results[i].getMaxBorrowDayCount()),
					};
				}
				table.setModel(new DefaultTableModel(tableResults, columns));
				return;
			}
		} catch (Exception e) {
			DbNotRunning.show((Integer i) -> {
				e.printStackTrace();
			});
		}
	}

	public void show() {
		frame.setVisible(true);
	}

	public void hide() {
		frame.setVisible(false);
	}

	public void close() {
		frame.setVisible(false);
		nameField.setText("");
	}
}
