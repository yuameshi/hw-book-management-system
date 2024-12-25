package com.example.book.view.Reader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.example.book.controller.Reader;
import com.example.book.db.readers.Query;
import com.example.book.db.readers.Update;
import com.example.book.db.readers.Delete;
import com.example.book.view.alerts.DbNotRunning;
import com.example.book.view.alerts.Reader.SuccessUpdate;
import com.example.book.view.alerts.Reader.SuccessDelete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateReader {
	private static JFrame frame;
	private static JTextField idField;
	private static JTextField readerNameField;
	private static JTextField readerTypeCombo;
	private static JTextField readerSexField;
	private static JTextField maxBorrowBookCountField;
	private static JTextField maxBorrowDayCountField;
	private static JTextField queryIdLabelField;
	private static JLabel errorLabel;
	private static JButton saveBtn;
	private static JButton deleteBtn;

	private static Reader oldReader;

	public UpdateReader(Runnable goHome) {
		final Font DEFAULT_FONT_20 = new Font(null, Font.PLAIN, 20);
		final Font DEFAULT_FONT_14 = new Font(null, Font.PLAIN, 14);
		final Color WHITE = Color.decode("#ffffff");
		final Color BLACK = Color.decode("#1b1b1b");
		final Color GRAY = Color.decode("#737674");

		frame = new JFrame("修改/删除读者");
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
		idField.setEnabled(false);
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
		readerNameField.setEnabled(false);
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
		readerTypeCombo.setEnabled(false);
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
		readerSexField.setEnabled(false);
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
		maxBorrowBookCountField.setEnabled(false);
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
		maxBorrowDayCountField.setEnabled(false);
		maxBorrowDayCountField.setBounds(500, 80, 200, 30);
		maxBorrowDayCountField.setFont(DEFAULT_FONT_20);
		maxBorrowDayCountField.setBackground(WHITE);
		maxBorrowDayCountField.setForeground(GRAY);
		panel.add(maxBorrowDayCountField);

		errorLabel = new JLabel("");
		errorLabel.setBounds(380, 180, 300, 30);
		errorLabel.setFont(DEFAULT_FONT_20);
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		panel.add(errorLabel);

		JLabel queryIdLabel = new JLabel("读者编号");
		queryIdLabel.setBounds(150, 240, 80, 30);
		queryIdLabel.setFont(DEFAULT_FONT_20);
		queryIdLabel.setForeground(BLACK);
		panel.add(queryIdLabel);
		queryIdLabelField = new JTextField("");
		queryIdLabelField.setBounds(250, 240, 200, 30);
		queryIdLabelField.setFont(DEFAULT_FONT_20);
		queryIdLabelField.setBackground(WHITE);
		queryIdLabelField.setForeground(GRAY);
		panel.add(queryIdLabelField);
		JButton queryBtn = new JButton("查询");
		queryBtn.setBounds(460, 240, 80, 30);
		queryBtn.setBackground(WHITE);
		queryBtn.setForeground(BLACK);
		queryBtn.setFont(DEFAULT_FONT_14);
		queryBtn.setFocusPainted(false);
		queryBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				queryReader();
			}
		});
		panel.add(queryBtn);

		saveBtn = new JButton("保存");
		saveBtn.setBounds(200, 300, 100, 30);
		saveBtn.setEnabled(false);
		saveBtn.setBackground(WHITE);
		saveBtn.setForeground(BLACK);
		saveBtn.setFont(DEFAULT_FONT_14);
		saveBtn.setFocusPainted(false);
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		panel.add(saveBtn);

		JButton closeBtn = new JButton("关闭");
		closeBtn.setBounds(320, 300, 100, 30);
		closeBtn.setBackground(WHITE);
		closeBtn.setForeground(BLACK);
		closeBtn.setFont(DEFAULT_FONT_14);
		closeBtn.setFocusPainted(false);
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goHome.run();
				close();
			}
		});
		panel.add(closeBtn);

		deleteBtn = new JButton("删除");
		deleteBtn.setBounds(440, 300, 100, 30);
		deleteBtn.setEnabled(false);
		deleteBtn.setBackground(WHITE);
		deleteBtn.setForeground(BLACK);
		deleteBtn.setFont(DEFAULT_FONT_14);
		deleteBtn.setFocusPainted(false);
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Delete.delete(oldReader);
					SuccessDelete.show();
					goHome.run();
					close();
				} catch (Exception e1) {
					DbNotRunning.show((Integer i) -> {
						// System.exit(1);
					});
					e1.printStackTrace();
				}
			}
		});
		panel.add(deleteBtn);

		frame.add(panel);
	}

	private void queryReader() {
		String id = queryIdLabelField.getText();
		if (id.isEmpty()) {
			errorLabel.setText("请输入图书编号");
			errorLabel.setVisible(true);
			return;
		}
		try {
			Reader queryBook = Query.byId(Integer.valueOf(id));
			if (queryBook == null) {
				errorLabel.setText("图书不存在");
				errorLabel.setVisible(true);
				return;
			} else {
				oldReader = queryBook;
				idField.setText((queryBook.getId()));
				idField.setEnabled(true);
				readerNameField.setText(queryBook.getName());
				readerNameField.setEnabled(true);
				readerTypeCombo.setText(queryBook.getCategory());
				readerTypeCombo.setEnabled(true);
				readerSexField.setText(queryBook.getGender());
				readerSexField.setEnabled(true);
				maxBorrowBookCountField.setText(String.valueOf(queryBook.getMaxBorrowCount()));
				maxBorrowBookCountField.setEnabled(true);
				maxBorrowDayCountField.setText(String.valueOf(queryBook.getMaxBorrowDayCount()));
				maxBorrowDayCountField.setEnabled(true);
				errorLabel.setText("");
				errorLabel.setVisible(false);
				queryIdLabelField.setText("");
				saveBtn.setEnabled(true);
				deleteBtn.setEnabled(true);
			}
		} catch (Exception e) {
			DbNotRunning.show((Integer i) -> {
				// System.exit(1);
			});
			e.printStackTrace();
			return;
		}

	}

	private void save() {
		String id = idField.getText();
		String name = readerNameField.getText();
		String category = readerTypeCombo.getText();
		String gender = readerSexField.getText();
		String maxBorrowBookCount = maxBorrowBookCountField.getText();
		String maxBorrowDayCount = maxBorrowDayCountField.getText();
		try {
			Reader.ReaderBuilder readerBuilder = new Reader.ReaderBuilder(id);
			if (!name.isEmpty())
				readerBuilder = readerBuilder.withName(name);
			if (!category.isEmpty())
				readerBuilder = readerBuilder.withCategory(category);
			if (!gender.isEmpty())
				readerBuilder = readerBuilder.withGender(gender);
			if (!maxBorrowBookCount.isEmpty())
				readerBuilder = readerBuilder.withMaxBorrowCount(Integer.valueOf(maxBorrowBookCount));
			if (!maxBorrowDayCount.isEmpty())
				readerBuilder = readerBuilder.withMaxBorrowDayCount(Integer.valueOf(maxBorrowDayCount));

			try {
				Reader newReader = readerBuilder.build();
				Update.update(oldReader, newReader);
				oldReader = newReader;
			} catch (Exception e) {
				errorLabel.setText("读者信息更新失败");
				errorLabel.setVisible(true);
				e.printStackTrace();
				return;
			}
			SuccessUpdate.show();
		} catch (Exception e) {
			DbNotRunning.show((Integer i) -> {
				// System.exit(1);
			});
			e.printStackTrace();
			return;
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
	}

}
