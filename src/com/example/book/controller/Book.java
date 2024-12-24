package com.example.book.controller;

public class Book {
	private String id;
	private String bookName;
	private String category = "科技";
	private String author;
	private String translator;
	private String publisher;
	private String publishTime;
	private float price = 28;
	private int stock = 1;

	private Book() {
	}

	public static class BookBuilder {
		private String id;
		private String bookName;
		private String category = "科技";
		private String author;
		private String translator;
		private String publisher;
		private String publishTime;
		private float price = 28;
		private int stock = 1;

		public BookBuilder(String id) {
			this.id = id;
		}

		public BookBuilder withName(String name) {
			this.bookName = name;
			return this;
		}

		public BookBuilder withAuthor(String author) {
			this.author = author;
			return this;
		}

		public BookBuilder withTranslator(String translator) {
			this.translator = translator;
			return this;
		}

		public BookBuilder withCategory(String category) {
			this.category = category;
			return this;
		}

		public BookBuilder withPublishTime(String pubTime) {
			this.publishTime = pubTime;
			return this;
		}

		public BookBuilder withPublisher(String pub) {
			this.publisher = pub;
			return this;
		}

		public BookBuilder withPrice(float price) {
			this.price = price;
			return this;
		}

		public BookBuilder withStock(int stock) {
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
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
