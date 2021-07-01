package com.regalk.amazonviewer.model;

import java.util.ArrayList;
import com.regalk.amazonviewer.dao.MovieDAO;
import java.util.Date;

/**
 * Inherits of {@link Film}
 * Implement of {@link IVisualizable} 
 * **/


public class movie extends Film implements IVisualizable, MovieDAO{
	
	private int id;
	private int timeViewed;
	
	public movie() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	/**
	 * {@inheritDoc}
	 * **/
	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}
	
	/**
	 * {@inheritDoc}
	 * **/
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if(dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)dateF.getTime() -(int)dateI.getTime());
		}else {
			setTimeViewed(0);
		}
	}
	
	public static ArrayList<movie> makeMoviesList(){
		movie Movie = new movie();
		
		return Movie.read();
	}
	
	/**
	 * {@inheritDoc}
	 * **/
	@Override
	public void view() {
		setViewed(true);
		movie Movie = new movie();
		Movie.setMovieViewed(this);
		Date dateI = startToSee(new Date());
		for (int i = 0; i < 10000; i++) {
			System.out.println("..........");
		}
		
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + "ms");
		
	}
	
}
