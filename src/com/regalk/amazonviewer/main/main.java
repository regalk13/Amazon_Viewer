package com.regalk.amazonviewer.main;
import java.util.Date;


import java.util.Scanner;

import com.regalk.amazonviewer.model.Chapter;
import com.regalk.amazonviewer.model.Serie;
import com.regalk.amazonviewer.model.movie;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		showMenu();
	}
	
	public static void showMenu() {
		int exit = 0;
		do {
			System.out.println("Welcome to the amazon viewer");
			System.out.println("");
			System.out.println("Selecciona el número de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			
			//Read user input... 
			Scanner sc = new Scanner(System.in);
			int key = Integer.valueOf(sc.nextLine());
			
			switch(key) {
			case 0:
				key = 0;
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
			case 6:
				makeReport(new Date());
			default:
				break;
			}
			
			
		}while(exit != 0);
		
	}
	
	public static void showMovies() {
		int exit = 1;
		ArrayList<movie> movies = movie.makeMoviesList();
		do {
			System.out.println();
			System.out.println(":: Movies ::");
			System.out.println();
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showMenu();
			}
			movie movieSelected = movies.get(response-1);
			movieSelected.setViewed(true);
			Date dateI = movieSelected.startToSee(new Date());
			
			for (int i = 0; i < 10000; i++) {
				System.out.println("..........");
			}
			
			movieSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("Viste: " + movieSelected);
			System.out.println("Por: " + movieSelected.getTimeViewed() + "ms");
			
		}while(exit != 0);
	}
	
	public static void showSeries() {
		int exit = 0;
		ArrayList<Serie> series = Serie.makeSeriesList();
		do {
			System.out.println();
			System.out.println(":: Series ::");
			System.out.println();
			
			for (int i = 0; i < series.size(); i++) {
				System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showMenu();
			}
			
			showChapters(series.get(response-1).getChapters());
			
		}while(exit != 0);
	}
	public static void showChapters(ArrayList<Chapter> chaptersOfSeriesSelected) {
		int exit = 1;
		do {
			System.out.println();
			System.out.println(":: Chapters ::");
			System.out.println();
			
			for(int i = 0; i < chaptersOfSeriesSelected.size(); i++) {
				System.out.println(i + 1 + ". " + chaptersOfSeriesSelected.get(i).getTitle() + "Visto: " + chaptersOfSeriesSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showSeries();
			}
			
			Chapter chapterSelected = chaptersOfSeriesSelected.get(response-1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startToSee(new Date());
			
			for (int i = 0; i < 10000; i++) {
				System.out.println(".........");
			}
			
			chapterSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("Viste: " + chapterSelected);
			System.out.println("Por: " + chapterSelected.getTimeViewed() + "ms");
			
		}while(exit != 0);
	}
	public static void showBooks() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: Books ::");
			System.out.println();
		}while(exit != 0);
	}
	

	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: Magazines ::");
			System.out.println();
		}while(exit != 0);
	}
	public static void makeReport() {
		// Report report = new Report();
	}
	
	public static void makeReport(Date date) {
			System.out.println(date);
	}
	
}
