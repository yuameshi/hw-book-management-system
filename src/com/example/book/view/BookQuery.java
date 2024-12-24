package com.example.book.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class BookQuery {
	private JFrame frame;

	public BookQuery() {
		final Font DEFAULT_FONT_18 = new Font(null, Font.PLAIN, 18);
		final Font DEFAULT_FONT_14 = new Font(null, Font.PLAIN, 20);
		final Color WHITE = Color.decode("#ffffff");
		final Color BLACK = Color.decode("#1b1b1b");
		final Color GRAY = Color.decode("#737674");

		frame = new JFrame("图书查询");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 800);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#eeeeee"));

		JLabel bookNameLabel = new JLabel("图书名称");
		bookNameLabel.setBounds(60, 20, 80, 30);
		bookNameLabel.setFont(DEFAULT_FONT_18);
		bookNameLabel.setForeground(BLACK);
		panel.add(bookNameLabel);
		JTextField bookNameField = new JTextField("");
		bookNameField.setBounds(140, 20, 150, 30);
		bookNameField.setFont(DEFAULT_FONT_18);
		bookNameField.setBackground(WHITE);
		bookNameField.setForeground(GRAY);
		panel.add(bookNameField);

		JLabel authorLabel = new JLabel("作者");
		authorLabel.setBounds(300, 20, 40, 30);
		authorLabel.setFont(DEFAULT_FONT_18);
		authorLabel.setForeground(BLACK);
		panel.add(authorLabel);
		JTextField authorField = new JTextField("");
		authorField.setBounds(350, 20, 150, 30);
		authorField.setFont(DEFAULT_FONT_18);
		authorField.setBackground(WHITE);
		authorField.setForeground(GRAY);
		panel.add(authorField);

		JLabel pubLabel = new JLabel("出版社");
		pubLabel.setBounds(510, 20, 60, 30);
		pubLabel.setFont(DEFAULT_FONT_18);
		pubLabel.setForeground(BLACK);
		panel.add(pubLabel);
		JTextField pubField = new JTextField("");
		pubField.setBounds(580, 20, 150, 28);
		pubField.setFont(DEFAULT_FONT_18);
		pubField.setBackground(WHITE);
		pubField.setForeground(GRAY);
		panel.add(pubField);

		JButton queryBtn = new JButton("查询");
		queryBtn.setBounds(250, 80, 100, 30);
		queryBtn.setBackground(WHITE);
		queryBtn.setForeground(BLACK);
		queryBtn.setFont(DEFAULT_FONT_14);
		queryBtn.setFocusPainted(false);
		panel.add(queryBtn);

		JButton closeBtn = new JButton("关闭");
		closeBtn.setBounds(400, 80, 100, 30);
		closeBtn.setBackground(WHITE);
		closeBtn.setForeground(BLACK);
		closeBtn.setFont(DEFAULT_FONT_14);
		closeBtn.setFocusPainted(false);
		panel.add(closeBtn);

		String[][] data = {
				{ "图书编号", "图书名称", "图书类别", "作者", "译者", "出版社", "出版日期", "定价", "库存" },
				{ "图书编号", "图书名称", "图书类别", "作者", "译者", "出版社", "出版日期", "定价", "库存" },
				{ "图书编号", "图书名称", "图书类别", "作者", "译者", "出版社", "出版日期", "定价", "库存" },
				{ "图书编号", "图书名称", "图书类别", "作者", "译者", "出版社", "出版日期", "定价", "库存" },
		};
		String[] columns = { "图书编号", "图书名称", "图书类别", "作者", "译者", "出版社", "出版日期", "定价", "库存" };
		DefaultTableModel model = new DefaultTableModel(data, columns);
		JTable table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setRowHeight(25);
		table.setFont(new Font(null, Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 160, 770, 600);
		panel.add(scrollPane);

		frame.add(panel);
	}

	public void show() {
		frame.setVisible(true);
	}

	public void hide() {
		frame.setVisible(false);
	}
}
