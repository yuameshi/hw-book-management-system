package com.example.book.controller;

public class Reader {
	private String id;
	private String name;
	private String category = "普通读者";
	private String gender;
	private int maxBorrowCount;
	private int maxBorrowDayCount;

	public Reader() {
	}

	public static class ReaderBuilder {
		private String id;
		private String name;
		private String category = "普通读者";
		private String gender;
		private int maxBorrowCount;
		private int maxBorrowDayCount;

		public ReaderBuilder(String id) {
			this.id = id;
		}

		public ReaderBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public ReaderBuilder withCategory(String category) {
			this.category = category;
			return this;
		}

		public ReaderBuilder withGender(String gender) {
			this.gender = gender;
			return this;
		}

		public ReaderBuilder withMaxBorrowCount(int maxBorrowCount) {
			this.maxBorrowCount = maxBorrowCount;
			return this;
		}

		public ReaderBuilder withMaxBorrowDayCount(int maxBorrowDayCount) {
			this.maxBorrowDayCount = maxBorrowDayCount;
			return this;
		}

		public Reader build() {
			Reader reader = new Reader();
			reader.id = this.id;
			reader.name = this.name;
			reader.category = this.category;
			reader.gender = this.gender;
			reader.maxBorrowCount = this.maxBorrowCount;
			reader.maxBorrowDayCount = this.maxBorrowDayCount;

			return reader;
		}
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setMaxBorrowCount(int maxBorrowCount) {
		this.maxBorrowCount = maxBorrowCount;
	}

	public int getMaxBorrowCount() {
		return maxBorrowCount;
	}

	public void setMaxBorrowDayCount(int maxBorrowDayCount) {
		this.maxBorrowDayCount = maxBorrowDayCount;
	}

	public int getMaxBorrowDayCount() {
		return maxBorrowDayCount;
	}
}
