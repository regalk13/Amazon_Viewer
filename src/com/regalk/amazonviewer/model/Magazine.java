package com.regalk.amazonviewer.model;

import java.util.Date;

public class Magazine extends Publication {
	
	private int id;
	
	public Magazine(String title, String genre, Date edititionDate, String editorial, String[] authors) {
		super(title, genre, edititionDate, editorial, authors);
	}
	
	public int getId() {
		return id;
	}

}
