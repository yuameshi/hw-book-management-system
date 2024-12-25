package com.example.book.controller;

public class Reader {
	private String id = "";
	private String name = "";
	private String category = "普通读者";
	private String gender = "";
	private int maxBorrowCount;
	private int maxBorrowDayCount;

	public Reader() {
	}

	public static class ReaderBuilder {
		private String id = "";
		private String name = "";
		private String category = "普通读者";
		private String gender = "";
		private int maxBorrowCount;
		private int maxBorrowDayCount;

		public ReaderBuilder(String id) {
			this.id = id;
		}

		public ReaderBuilder withName(String name) {
			if (name != null)
				this.name = name;
			return this;
		}

		public ReaderBuilder withCategory(String category) {
			if (category != null)
				this.category = category;
			return this;
		}

		public ReaderBuilder withGender(String gender) {
			if (gender != null)
				this.gender = gender;
			return this;
		}

		public ReaderBuilder withMaxBorrowCount(int maxBorrowCount) {
			if (maxBorrowCount >= 0)
				this.maxBorrowCount = maxBorrowCount;
			return this;
		}

		public ReaderBuilder withMaxBorrowDayCount(int maxBorrowDayCount) {
			if (maxBorrowDayCount >= 0)
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
		if (id == null)
			return "";
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		if (name == null)
			return "";
		return name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		if (category == null)
			return "";
		return category;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		if (gender == null)
			return "";
		return gender;
	}

	public void setMaxBorrowCount(int maxBorrowCount) {
		this.maxBorrowCount = maxBorrowCount;
	}

	public Integer getMaxBorrowCount() {
		if (maxBorrowCount < 0)
			return Integer.valueOf(0);
		return Integer.valueOf(maxBorrowCount);
	}

	public void setMaxBorrowDayCount(int maxBorrowDayCount) {
		this.maxBorrowDayCount = maxBorrowDayCount;
	}

	public Integer getMaxBorrowDayCount() {
		if (maxBorrowDayCount < 0)
			return Integer.valueOf(0);
		return Integer.valueOf(maxBorrowDayCount);
	}
}
