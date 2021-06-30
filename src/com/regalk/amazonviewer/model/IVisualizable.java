package com.regalk.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	
	/**
	 * This method capt the exact time of view.
	 * @param dateI Is a object {@code Date} exact time of begin.
	 * @return return the date and hour.
	 * **/
	Date startToSee(Date dateI);
	
	/**
	 * This method capt the exact time of view in the end and compare the begin.
	 * @param dateI Is a object {@code Date} exact time of begin
	 * @param dateF Is a object {@code Date} exact time of end
	 * 
	 * **/
	void stopToSee(Date dateI, Date dateF);
}
