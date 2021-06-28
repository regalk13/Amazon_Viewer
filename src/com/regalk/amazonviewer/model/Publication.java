package com.regalk.amazonviewer.model;

import java.util.Date;

public class Publication {
	
	private String title;
	private String genre;
	private Date edititionDate;
	private String editorial;
	private String[] authors;
	
	
	
	public Publication(String title, String genre, Date edititionDate, String editorial, String[] authors) {
		super();
		this.title = title;
		this.genre = genre;
		this.edititionDate = edititionDate;
		this.editorial = editorial;
		this.authors = authors;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public Date getEdititionDate() {
		return edititionDate;
	}



	public void setEdititionDate(Date edititionDate) {
		this.edititionDate = edititionDate;
	}



	public String getEditorial() {
		return editorial;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	public String[] getAuthors() {
		return authors;
	}



	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
	
	
}
