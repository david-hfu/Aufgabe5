package de.hfu;
import java.util.Scanner;

/*
 * Die App Klasse in der alles drinnen ist.
 * Sie ist sehr toll.
 */
public class App {
	/*
	 * Nun folgt die Main Klasse die den ganzen Code beinhaltet:
	 * Es sind nur 2 Zeilen Code
	 */
    public static void main( String[] args ) {
    	/*
    	 * Nun wird erst der Input gelesen
    	 * und dann als Grossbuchstabe ausgegeben.
    	 */
    	System.out.println("Gib ein den Spass:");
    	Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine().toUpperCase());
        //scanner.close();
    }
}