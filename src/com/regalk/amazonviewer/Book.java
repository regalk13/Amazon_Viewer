package com.regalk.amazonviewer;

import java.util.Date;

public class Book extends Publication{

	private int id;
	private String isbn;
	
	public Book(String title, String genre, Date edititionDate, String editorial, String[] authors, String isbn) {
		super(title, genre, edititionDate, editorial, authors);
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "\n Title:" + getTitle() +
				"\n Genre:" + getGenre() +
				"\n Year:" + getEdititionDate() +
				"\n Creator:" + getEditorial();
	}
}
