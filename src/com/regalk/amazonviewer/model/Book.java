package com.regalk.amazonviewer.model;

import java.util.Date;

public class Book extends Publication implements IVisualizable{

	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	
	public Book(String title, String genre, Date edititionDate, String editorial, String[] authors, String isbn, boolean readed, int timeReaded) {
		super(title, genre, edititionDate, editorial, authors);
		this.isbn = isbn;
		this.readed = readed;
		this.timeReaded = timeReaded;
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

	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}

	@Override
	public String toString() {
		return "\n Title:" + getTitle() +
				"\n Genre:" + getGenre() +
				"\n Year:" + getEdititionDate() +
				"\n Creator:" + getEditorial();
	}

	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if(dateF.getSeconds() > dateI.getSeconds()) {
			setTimeReaded(dateF.getSeconds() - dateI.getSeconds());
		}else {
			setTimeReaded(0);
		}
		
	}
}
