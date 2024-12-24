package com.example.book.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.book.controller.Book;
import com.example.book.db.books.Query;
import com.example.book.view.alerts.DbNotRunning;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class BookQuery {
	private JFrame frame;
	private JTextField bookNameField;
	private JTextField authorField;
	private JTextField pubField;
	JTable table;

	String[] columns = { "图书编号", "图书名称", "图书类别", "作者", "译者", "出版社", "出版日期", "定价", "库存" };
	private String[][] queryResults = {};

	public BookQuery(Runnable goMainHandler) {
		final Font DEFAULT_FONT_18 = new Font(null, Font.PLAIN, 18);
		final Font DEFAULT_FONT_14 = new Font(null, Font.PLAIN, 20);
		final Color WHITE = Color.decode("#ffffff");
		final Color BLACK = Color.decode("#1b1b1b");
		final Color GRAY = Color.decode("#737674");

		frame = new JFrame("图书查询");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#eeeeee"));

		JLabel bookNameLabel = new JLabel("图书名称");
		bookNameLabel.setBounds(60, 20, 80, 30);
		bookNameLabel.setFont(DEFAULT_FONT_18);
		bookNameLabel.setForeground(BLACK);
		panel.add(bookNameLabel);
		bookNameField = new JTextField("");
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
		authorField = new JTextField("");
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
		pubField = new JTextField("");
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
		queryBtn.addActionListener((e) -> {
			query();
		});
		panel.add(queryBtn);

		JButton closeBtn = new JButton("关闭");
		closeBtn.setBounds(400, 80, 100, 30);
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
		scrollPane.setBounds(20, 160, 770, 600);
		panel.add(scrollPane);

		frame.add(panel);
	}

	private void query() {
		try {
			Book[] resultsByBookName = {};
			Book[] resultsByAuthor = {};
			Book[] resultsByPublisher = {};
			if (!bookNameField.getText().isEmpty()) {
				resultsByBookName = Query.byBookName(bookNameField.getText());
			}
			if (!authorField.getText().isEmpty()) {
				resultsByAuthor = Query.byAuthor(authorField.getText());
			}
			if (!pubField.getText().isEmpty()) {
				resultsByPublisher = Query.byPublisher(pubField.getText());
			}
			Book[] results = new Book[resultsByBookName.length + resultsByAuthor.length + resultsByPublisher.length];
			System.arraycopy(resultsByBookName, 0, results, 0, resultsByBookName.length);
			System.arraycopy(resultsByAuthor, 0, results, resultsByBookName.length, resultsByAuthor.length);
			System.arraycopy(resultsByPublisher, 0, results, resultsByBookName.length + resultsByAuthor.length,
					resultsByPublisher.length);

			String[][] tableResults = new String[results.length][];
			int realLength = 0;
			for (int i = 0; i < results.length; i++) {
				boolean isExist = false;
				for (int j = 0; j < i; j++) {
					if (tableResults[j][0].equals(results[i].getId())) {
						isExist = true;
						break;
					}
				}
				if (isExist) {
					continue;
				}
				tableResults[i] = new String[] {
						results[i].getId(),
						results[i].getBookName(),
						results[i].getCategory(),
						results[i].getAuthor(),
						results[i].getTranslator(),
						results[i].getPublisher(),
						results[i].getPublishTime(),
						String.valueOf(results[i].getPrice()),
						String.valueOf(results[i].getStock())
				};
				realLength++;
			}
			String[][] tableResultsFiltered = new String[realLength][];
			for (int i = 0; i < tableResults.length; i++) {
				if (tableResults[i] != null) {
					tableResultsFiltered[i] = tableResults[i];
				}
			}
			table.setModel(new DefaultTableModel(tableResultsFiltered, columns));
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
		pubField.setText("");
		authorField.setText("");
		bookNameField.setText("");
	}
}
