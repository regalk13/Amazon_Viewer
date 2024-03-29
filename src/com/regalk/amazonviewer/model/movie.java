package com.regalk.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class movie extends Film implements IVisualizable{
	
	private int id;
	private int timeViewed;
	
	public movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}
	
	public int getId() {
		return id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		return "\n Title:" + getTitle() +
				"\n Genre:" + getGenre() +
				"\n Year:" + getYear() +
				"\n Creator:" + getCreator() +
				"\n Duration:" + getDuration();
	}

	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if(dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)dateF.getTime() -(int)dateI.getTime());
		}else {
			setTimeViewed(0);
		}
	}
	
	public static ArrayList<movie> makeMoviesList(){
		ArrayList<movie> movies = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			movies.add(new movie("Movie" + i, "Genre" + i, "Creator" + i, 120, (short)2017));
		}
		
		return movies;
	}
	
}
