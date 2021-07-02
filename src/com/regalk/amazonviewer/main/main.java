package com.regalk.amazonviewer.main;
import java.util.Date;


import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import com.regalk.amazonviewer.model.Book;
import com.regalk.amazonviewer.model.Chapter;
import com.regalk.amazonviewer.model.Film;
import com.regalk.amazonviewer.model.Report;
import com.regalk.amazonviewer.model.Serie;
import com.regalk.amazonviewer.model.movie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


/** 
 * <h1>AmazonViewer</h1>
 * AmazonViewer is a program for see movies,series, books and magazines.
 * And you can generate reports...
 * <p>
 * Exists some rules like all elements can be watch or read (Exception Magazines).
 * 
 * @author Regalk
 * @version 1.1
 * @since 2021
 *   
 * **/

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
				break;
			case 6:
				makeReport(new Date());
				break;
			default:
				break;
			}
		}while(exit != 0);
		
	}
	static ArrayList<movie> movies = new ArrayList();
	public static void showMovies() {
		int exit = 1;
		movies = movie.makeMoviesList();
		do {
			System.out.println();
			System.out.println(":: Movies ::");
			System.out.println();
			
			AtomicInteger atomicInteger = new AtomicInteger(1); 
			movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement() + ". " +  m.getTitle() + " Visto: " + m.isViewed()));
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showMenu();
			}
			
			if (response > 0) {
				movie movieSelected = movies.get(response-1);
				movieSelected.view();
			}
			
		}while(exit != 0);
	}
	
	static ArrayList<Serie> series = Serie.makeSeriesList();
	public static void showSeries() {
		int exit = 1;

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
				System.out.println(i + 1 + ". " + chaptersOfSeriesSelected.get(i).getTitle() + " Visto: " + chaptersOfSeriesSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showSeries();
			}
			
			if(response > 0){
				Chapter chapterSelected = chaptersOfSeriesSelected.get(response-1);
			    chapterSelected.view();
			}
		}while(exit != 0);
	}
	static ArrayList<Book> books= Book.makeBookList();
	public static void showBooks() {
		int exit = 1;
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).isReaded());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				Book bookSelected = books.get(response-1);
				bookSelected.view();
				
			}
				
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
		Report report = new Report();
		report.setNameFile("report");
		report.setTitle(":: WHATCH ::");
		report.setExtension("txt");
		StringBuilder contentReport = new StringBuilder();
		
		movies.stream()
		.filter(m -> m.getIsViewed())
		.forEach(m -> contentReport.append(m.toString() + "\n"));
		
		//Predicate<Serie> seriesViewed = s -> s.getIsViewed();
		series.stream().forEach(null);
		
		
		report.setContent(contentReport.toString());
		report.makeReport();
		
	}
	
	public static void makeReport(Date date) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = df.format(date);
			Report report = new Report();
			report.setNameFile("report" + dateString);
			report.setTitle(":: WHATCH ::");
			report.setExtension("txt");
			String contentReport = "";
			
			for (movie Movie : movies) {
				if(Movie.getIsViewed()) {
					contentReport += Movie.toString() + "/n";
				}
			}
			report.setContent(contentReport);
			report.makeReport();
			

	}
	
}
