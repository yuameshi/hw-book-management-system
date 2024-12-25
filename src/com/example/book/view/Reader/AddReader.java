package com.example.book.view.Reader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.example.book.controller.Reader;
import com.example.book.db.readers.Add;
import com.example.book.db.readers.Query;
import com.example.book.view.alerts.DbNotRunning;
import com.example.book.view.alerts.Reader.SuccessAdd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReader {
	private static JFrame frame;
	private static JTextField idField;
	private static JTextField readerNameField;
	private static JTextField readerTypeCombo;
	private static JTextField readerSexField;
	private static JTextField maxBorrowBookCountField;
	private static JTextField maxBorrowDayCountField;
	private static JLabel errorLabel;

	public AddReader(Runnable goHome) {
		final Font DEFAULT_FONT_20 = new Font(null, Font.PLAIN, 20);
		final Font DEFAULT_FONT_14 = new Font(null, Font.PLAIN, 14);
		final Color WHITE = Color.decode("#ffffff");
		final Color BLACK = Color.decode("#1b1b1b");
		final Color GRAY = Color.decode("#737674");

		frame = new JFrame("添加读者");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(750, 400);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#eeeeee"));

		JLabel idLabel = new JLabel("读者编号");
		idLabel.setBounds(50, 30, 80, 30);
		idLabel.setFont(DEFAULT_FONT_20);
		idLabel.setForeground(BLACK);
		panel.add(idLabel);
		idField = new JTextField("");
		idField.setBounds(150, 30, 200, 30);
		idField.setFont(DEFAULT_FONT_20);
		idField.setBackground(WHITE);
		idField.setForeground(GRAY);
		panel.add(idField);

		JLabel readerNameLabel = new JLabel("读者姓名");
		readerNameLabel.setBounds(50, 80, 80, 30);
		readerNameLabel.setFont(DEFAULT_FONT_20);
		readerNameLabel.setForeground(BLACK);
		panel.add(readerNameLabel);
		readerNameField = new JTextField("");
		readerNameField.setBounds(150, 80, 200, 30);
		readerNameField.setFont(DEFAULT_FONT_20);
		readerNameField.setBackground(WHITE);
		readerNameField.setForeground(GRAY);
		panel.add(readerNameField);

		JLabel readerTypeLabel = new JLabel("读者类别");
		readerTypeLabel.setBounds(50, 180, 80, 30);
		readerTypeLabel.setFont(DEFAULT_FONT_20);
		readerTypeLabel.setForeground(BLACK);
		panel.add(readerTypeLabel);
		readerTypeCombo = new JTextField("");
		readerTypeCombo.setBounds(150, 180, 200, 30);
		readerTypeCombo.setFont(DEFAULT_FONT_20);
		readerTypeCombo.setBackground(WHITE);
		readerTypeCombo.setForeground(GRAY);
		panel.add(readerTypeCombo);

		JLabel readerSexLabel = new JLabel("读者性别");
		readerSexLabel.setBounds(50, 130, 80, 30);
		readerSexLabel.setFont(DEFAULT_FONT_20);
		readerSexLabel.setForeground(BLACK);
		panel.add(readerSexLabel);
		readerSexField = new JTextField("");
		readerSexField.setBounds(150, 130, 200, 30);
		readerSexField.setFont(DEFAULT_FONT_20);
		readerSexField.setBackground(WHITE);
		readerSexField.setForeground(GRAY);
		panel.add(readerSexField);

		JLabel maxBorrowBookCountLabel = new JLabel("最大可借数");
		maxBorrowBookCountLabel.setBounds(380, 30, 100, 30);
		maxBorrowBookCountLabel.setFont(DEFAULT_FONT_20);
		maxBorrowBookCountLabel.setForeground(BLACK);
		panel.add(maxBorrowBookCountLabel);
		maxBorrowBookCountField = new JTextField("");
		maxBorrowBookCountField.setBounds(500, 30, 200, 30);
		maxBorrowBookCountField.setFont(DEFAULT_FONT_20);
		maxBorrowBookCountField.setBackground(WHITE);
		maxBorrowBookCountField.setForeground(GRAY);
		panel.add(maxBorrowBookCountField);

		JLabel maxBorrowDayCountLabel = new JLabel("可借天数");
		maxBorrowDayCountLabel.setBounds(380, 80, 100, 30);
		maxBorrowDayCountLabel.setFont(DEFAULT_FONT_20);
		maxBorrowDayCountLabel.setForeground(BLACK);
		panel.add(maxBorrowDayCountLabel);
		maxBorrowDayCountField = new JTextField("");
		maxBorrowDayCountField.setBounds(500, 80, 200, 30);
		maxBorrowDayCountField.setFont(DEFAULT_FONT_20);
		maxBorrowDayCountField.setBackground(WHITE);
		maxBorrowDayCountField.setForeground(GRAY);
		panel.add(maxBorrowDayCountField);

		errorLabel = new JLabel("");
		errorLabel.setBounds(400, 180, 300, 30);
		errorLabel.setFont(DEFAULT_FONT_20);
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		panel.add(errorLabel);

		JButton saveBtn = new JButton("保存");
		saveBtn.setBounds(230, 280, 120, 30);
		saveBtn.setBackground(WHITE);
		saveBtn.setForeground(BLACK);
		saveBtn.setFont(DEFAULT_FONT_14);
		saveBtn.setFocusPainted(false);
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addBookHandler(goHome);
			}
		});
		panel.add(saveBtn);

		JButton closeBtn = new JButton("关闭");
		closeBtn.setBounds(400, 280, 120, 30);
		closeBtn.setBackground(WHITE);
		closeBtn.setForeground(BLACK);
		closeBtn.setFont(DEFAULT_FONT_14);
		closeBtn.setFocusPainted(false);
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
				goHome.run();
			}
		});
		panel.add(closeBtn);

		frame.add(panel);
	}

	private void addBookHandler(Runnable goHome) {
		String id = idField.getText();
		if (id.isEmpty()) {
			errorLabel.setText("读者不能为空");
			errorLabel.setVisible(true);
			return;
		}
		try {
			Reader reader = Query.byId(Integer.valueOf(id));
			if (reader != null) {
				errorLabel.setText("读者编号已存在");
				errorLabel.setVisible(true);
				return;
			}
		} catch (Exception e) {
			DbNotRunning.show((Integer i) -> {
				// System.exit(1);
			});
			e.printStackTrace();
			return;
		}
		String name = readerNameField.getText();
		String readerType = readerTypeCombo.getText();
		String gender = readerSexField.getText();
		String maxBorrowBookCount = maxBorrowBookCountField.getText();
		String maxBorrowDayCount = maxBorrowDayCountField.getText();

		try {
			Reader.ReaderBuilder readerBuilder = new Reader.ReaderBuilder(id);
			if (!name.isEmpty())
				readerBuilder = readerBuilder.withName(name);
			if (!readerType.isEmpty())
				readerBuilder.withCategory(readerType);
			if (!gender.isEmpty())
				readerBuilder.withGender(gender);
			if (!maxBorrowBookCount.isEmpty())
				readerBuilder.withMaxBorrowCount(maxBorrowBookCount);
			if (!maxBorrowDayCount.isEmpty())
				readerBuilder.withMaxBorrowDayCount(maxBorrowDayCount);
			try {
				Add.add(readerBuilder.build());
			} catch (Exception e) {
				errorLabel.setText("读者编号已存在");
				errorLabel.setVisible(true);
				e.printStackTrace();
				return;
			}
			SuccessAdd.show();
			goHome.run();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		goHome.run();
	}

	public void show() {
		frame.setVisible(true);
	}

	public void hide() {
		frame.setVisible(false);
	}

	public void close() {
		frame.setVisible(false);
		idField.setText("");
		readerNameField.setText("");
		readerTypeCombo.setText("");
		readerSexField.setText("");
		maxBorrowBookCountField.setText("");
		maxBorrowDayCountField.setText("");
	}

	public void reset() {
		idField.setText("");
		readerNameField.setText("");
		readerTypeCombo.setText("");
		readerSexField.setText("");
		maxBorrowBookCountField.setText("");
		maxBorrowDayCountField.setText("");
	}
}
