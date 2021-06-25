package com.regalk.amazonviewer;

public class movie extends Film{
	
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
		//System.out.println("Genre:" + genre);
		//System.out.println("Year:" + year);
	}
	
}
