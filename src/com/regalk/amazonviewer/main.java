package com.regalk.amazonviewer;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		
		movie Movie = new movie("Coco", "Animation", "Pixar", 120, (short)2017);
		Serie serie = new Serie("Breaking Bad", "Drugs", " ", 200, 5);
		System.out.println(Movie);
		System.out.println(serie);
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
			
			int key = 1;
			
			switch(key) {
			case 0:
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
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: Movies ::");
			System.out.println();
		}while(exit != 0);
	}	
	public static void showSeries() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: Series ::");
			System.out.println();
		}while(exit != 0);
	}
	public static void showChapters() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: Chapters ::");
			System.out.println();
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
		
	}
	
	public static void makeReport(Date date) {
			System.out.println(date);
	}
	
}
