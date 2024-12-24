package com.example.book.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class AddBook {
	private static JFrame frame;
	private static JTextField idField;
	private static JTextField categoryCombo;
	private static JTextField publishTimeField;
	private static JTextField stockField;
	private static JTextField translatorField;
	private static JTextField nameField;
	private static JTextField authorField;
	private static JTextField pubField;
	private static JTextField priceField;

	public AddBook() {
		final Font DEFAULT_FONT_20 = new Font(null, Font.PLAIN, 20);
		final Font DEFAULT_FONT_14 = new Font(null, Font.PLAIN, 14);
		final Color WHITE = Color.decode("#ffffff");
		final Color BLACK = Color.decode("#1b1b1b");
		final Color GRAY = Color.decode("#737674");

		frame = new JFrame("添加图书");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 400);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#eeeeee"));

		JLabel idLabel = new JLabel("图书编号");
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

		JLabel categoryLabel = new JLabel("图书类别");
		categoryLabel.setBounds(50, 80, 80, 30);
		categoryLabel.setFont(DEFAULT_FONT_20);
		categoryLabel.setForeground(BLACK);
		panel.add(categoryLabel);
		categoryCombo = new JTextField("");
		categoryCombo.setBounds(150, 80, 200, 30);
		categoryCombo.setFont(DEFAULT_FONT_20);
		categoryCombo.setBackground(WHITE);
		categoryCombo.setForeground(GRAY);
		panel.add(categoryCombo);

		JLabel publishTimeLabel = new JLabel("出版时间");
		publishTimeLabel.setBounds(50, 180, 80, 30);
		publishTimeLabel.setFont(DEFAULT_FONT_20);
		publishTimeLabel.setForeground(BLACK);
		panel.add(publishTimeLabel);
		publishTimeField = new JTextField("");
		publishTimeField.setBounds(150, 230, 200, 30);
		publishTimeField.setFont(DEFAULT_FONT_20);
		publishTimeField.setBackground(WHITE);
		publishTimeField.setForeground(GRAY);
		panel.add(publishTimeField);

		JLabel stockLabel = new JLabel("库存数量");
		stockLabel.setBounds(50, 230, 80, 30);
		stockLabel.setFont(DEFAULT_FONT_20);
		stockLabel.setForeground(BLACK);
		panel.add(stockLabel);
		stockField = new JTextField("");
		stockField.setBounds(150, 180, 200, 30);
		stockField.setFont(DEFAULT_FONT_20);
		stockField.setBackground(WHITE);
		stockField.setForeground(GRAY);
		panel.add(stockField);

		JLabel translatorLabel = new JLabel("译者");
		translatorLabel.setBounds(50, 130, 80, 30);
		translatorLabel.setFont(DEFAULT_FONT_20);
		translatorLabel.setForeground(BLACK);
		panel.add(translatorLabel);
		translatorField = new JTextField("");
		translatorField.setBounds(150, 130, 200, 30);
		translatorField.setFont(DEFAULT_FONT_20);
		translatorField.setBackground(WHITE);
		translatorField.setForeground(GRAY);
		panel.add(translatorField);

		JLabel nameLabel = new JLabel("图书名称");
		nameLabel.setBounds(400, 30, 80, 30);
		nameLabel.setFont(DEFAULT_FONT_20);
		nameLabel.setForeground(BLACK);
		panel.add(nameLabel);
		nameField = new JTextField("");
		nameField.setBounds(500, 30, 200, 30);
		nameField.setFont(DEFAULT_FONT_20);
		nameField.setBackground(WHITE);
		nameField.setForeground(GRAY);
		panel.add(nameField);

		JLabel authorLabel = new JLabel("作者");
		authorLabel.setBounds(400, 80, 80, 30);
		authorLabel.setFont(DEFAULT_FONT_20);
		authorLabel.setForeground(BLACK);
		panel.add(authorLabel);
		authorField = new JTextField("");
		authorField.setBounds(500, 80, 200, 30);
		authorField.setFont(DEFAULT_FONT_20);
		authorField.setBackground(WHITE);
		authorField.setForeground(GRAY);
		panel.add(authorField);

		JLabel pubLabel = new JLabel("出版社");
		pubLabel.setBounds(400, 130, 80, 30);
		pubLabel.setFont(DEFAULT_FONT_20);
		pubLabel.setForeground(BLACK);
		panel.add(pubLabel);
		pubField = new JTextField("");
		pubField.setBounds(500, 130, 200, 30);
		pubField.setFont(DEFAULT_FONT_20);
		pubField.setBackground(WHITE);
		pubField.setForeground(GRAY);
		panel.add(pubField);

		JLabel priceLabel = new JLabel("定价");
		priceLabel.setBounds(400, 180, 80, 30);
		priceLabel.setFont(DEFAULT_FONT_20);
		priceLabel.setForeground(BLACK);
		panel.add(priceLabel);
		priceField = new JTextField("");
		priceField.setBounds(500, 180, 200, 30);
		priceField.setFont(DEFAULT_FONT_20);
		priceField.setBackground(WHITE);
		priceField.setForeground(GRAY);
		panel.add(priceField);

		JButton saveBtn = new JButton("保存");
		saveBtn.setBounds(230, 280, 120, 30);
		saveBtn.setBackground(WHITE);
		saveBtn.setForeground(BLACK);
		saveBtn.setFont(DEFAULT_FONT_14);
		saveBtn.setFocusPainted(false);
		panel.add(saveBtn);

		JButton closeBtn = new JButton("关闭");
		closeBtn.setBounds(400, 280, 120, 30);
		closeBtn.setBackground(WHITE);
		closeBtn.setForeground(BLACK);
		closeBtn.setFont(DEFAULT_FONT_14);
		closeBtn.setFocusPainted(false);
		panel.add(closeBtn);

		frame.add(panel);
		frame.setVisible(true);
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
		categoryCombo.setText("");
		publishTimeField.setText("");
		stockField.setText("");
		translatorField.setText("");
		nameField.setText("");
		authorField.setText("");
		pubField.setText("");
		priceField.setText("");
	}

	public void reset() {
		idField.setText("");
		categoryCombo.setText("");
		publishTimeField.setText("");
		stockField.setText("");
		translatorField.setText("");
		nameField.setText("");
		authorField.setText("");
		pubField.setText("");
		priceField.setText("");
	}
}
