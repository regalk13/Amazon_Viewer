package com.regalk.amazonviewer.model;

import java.util.ArrayList;

/**
 * Inherits of {@link movie}
 * @see Film
 * **/

public class Chapter extends movie{
	private int id;
	private int sessionNumber;
	private Serie serie;
	
	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
		super(title, genre, creator, duration, year);
		this.setSessionNumber(sessionNumber);
		this.setSerie(serie);
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	
	@Override
	public String toString() {
		return "\n Title:" + getTitle() +
				"\n Genre:" + getGenre() +
				"\n Year:" + getYear() +
				"\n Creator:" + getCreator();
	}
	
	public static ArrayList<Chapter> makeChaptersList(Serie serie){
		ArrayList<Chapter> chapters = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Chapter" + i, "Genre" + i, "creator" + i, 45, (short)(2017+i), i, serie));
		}
		return chapters;
	}
	
	@Override
	public void view() {
		super.view();
		ArrayList<Chapter> chapters =  getSerie().getChapters();
		int chapterViewedCounter = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}
		
		if (chapterViewedCounter == chapters.size()) {
			getSerie().view();
		}
	}
	
}
