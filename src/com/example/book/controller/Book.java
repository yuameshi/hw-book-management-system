package com.example.book.controller;

import java.util.regex.Pattern;

public class Book {
	private String id = "";
	private String bookName = "";
	private String category = "科技";
	private String author = "";
	private String translator = "";
	private String publisher = "";
	private String publishTime = "";
	private float price = 28;
	private int stock = 1;

	private Book() {
	}

	public static class BookBuilder {
		private String id = "";
		private String bookName = "";
		private String category = "科技";
		private String author = "";
		private String translator = "";
		private String publisher = "";
		private String publishTime = "";
		private float price = 28;
		private int stock = 1;

		public BookBuilder(String id) {
			this.id = id;
		}

		public BookBuilder withName(String name) {
			if (name != null)
				this.bookName = name;
			return this;
		}

		public BookBuilder withAuthor(String author) {
			if (author != null)
				this.author = author;
			return this;
		}

		public BookBuilder withTranslator(String translator) {
			if (translator != null)
				this.translator = translator;
			return this;
		}

		public BookBuilder withCategory(String category) {
			if (category != null)
				this.category = category;
			return this;
		}

		public BookBuilder withPublishTime(String pubTime) {
			if (pubTime != null)
				this.publishTime = pubTime;
			return this;
		}

		public BookBuilder withPublisher(String pub) {
			if (pub != null)
				this.publisher = pub;
			return this;
		}

		public BookBuilder withPrice(float price) {
			if (price >= 0)
				this.price = price;
			return this;
		}

		public BookBuilder withStock(int stock) {
			if (stock >= 0)
				this.stock = stock;
			return this;
		}

		public Book build() {
			Book book = new Book();
			book.id = this.id;
			book.bookName = this.bookName;
			book.translator = this.translator;
			book.publishTime = this.publishTime;
			book.publisher = this.publisher;
			book.price = this.price;
			book.category = this.category;
			book.author = this.author;
			book.stock = this.stock;
			return book;
		}
	}

	public String getId() {
		if (id == null)
			return "";
		return id;
	}

	public void setId(String id) {
		if (id != null)
			this.id = id;
	}

	public String getBookName() {
		if (bookName == null)
			return "";
		return bookName;
	}

	public void setBookName(String bookName) {
		if (bookName != null)
			this.bookName = bookName;
	}

	public String getCategory() {
		if (category == null)
			return "";
		return category;
	}

	public void setCategory(String category) {
		if (category != null)
			this.category = category;
	}

	public String getAuthor() {
		if (author == null)
			return "";
		return author;
	}

	public void setAuthor(String author) {
		if (author != null)
			this.author = author;
	}

	public String getTranslator() {
		if (translator == null)
			return "";
		return translator;
	}

	public void setTranslator(String translator) {
		if (translator != null)
			this.translator = translator;
	}

	public String getPublisher() {
		if (publisher == null)
			return "";
		return publisher;
	}

	public void setPublisher(String publisher) {
		if (publisher != null)
			this.publisher = publisher;
	}

	public String getPublishTime() {
		if (publishTime == null)
			return "";
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		if (publishTime != null) {
			if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}", publishTime))
				this.publishTime = publishTime;
			else
				throw new IllegalArgumentException("Invalid publish time format, should be yyyy-MM-dd HH:mm:ss");
		}
	}

	public float getPrice() {
		if (price < 0)
			return 0;
		return price;
	}

	public void setPrice(float price) {
		if (price >= 0)
			this.price = price;
	}

	public int getStock() {
		if (stock < 0)
			return 0;
		return stock;
	}

	public void setStock(int stock) {
		if (stock >= 0)
			this.stock = stock;
	}
}
