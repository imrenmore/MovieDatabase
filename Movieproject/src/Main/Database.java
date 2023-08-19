package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



//This class will store the movie records onto memory
public class Database {
	// Fields
	private ArrayList<Movie> movies;
	private fileWrite fileWrite;
	
	// Constructor
	public Database(String db) throws IOException{
		movies = new ArrayList<>();
		fileRead fr = new fileRead("db.txt");
		
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			String line = fr.getLine(i);
			// TODO: Parse using the StringTokenizer here and place into movies as single entries...
			StringTokenizer st = new StringTokenizer(line,"*");
			// parse through database with tokens
			
			fileWrite = new fileWrite("db.txt");
			String title = st.nextToken();
			int year = Integer.parseInt(st.nextToken());
			int runtime = Integer.parseInt(st.nextToken());
			String actor1 = st.nextToken();
			String actor2 = st.nextToken();
			String director = st.nextToken();
			//creating a movie
			Movie newMovie = new Movie(title, actor1, actor2, director, year, runtime);
			this.movies.add(newMovie);
		}
	}
	
	// Methods
	
	public void addEntry() throws IOException{
		// TODO
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter title>");
		String title = sc.next();
		System.out.println("Enter year>");
		int year =sc.nextInt();
		System.out.println("Enter runtime(minutes)>");
		int runtime = sc.nextInt();
		System.out.println("Enter Actor 1");
		String actor1 = sc.next();
		System.out.println("Enter Actor 2");
		String actor2 = sc.next();
		System.out.println("Enter Director");
		String director = sc.next();
		
		writeIntoFile(title,year,runtime,actor1,actor2, director);
		

		//File writer get title, year, runtime, actor 1, actor 2, director, save file
	}
	
	private void writeIntoFile(String title, int year, int runtime, String actor1, String actor2, String director) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("db.txt", true);
		fw.write("\n"+ title + "*" + actor1 + "*" + actor2 + "*" + director + "*" + year + "*"+ runtime);
			fileWrite.saveFile();
			fw.close();
			System.out.println("The new movie has been added!");
			
	}

	public void searchByTitle(String title) throws IOException{
		// searches for movie and prints with title
		boolean found= false;
		for(Movie movie: movies) {
			if(movie.getTitle().toLowerCase().contains(title.toLowerCase())){
				System.out.println("\nMovie Title Found: " + movie.getTitle());
				System.out.println("Actors: " + movie.getActor1() +", " +movie.getActor2());
				System.out.println("Director: " + movie.getDirector());
				System.out.println("Year: " + movie.getYear());
				System.out.println("Runtime: "+ movie.getRuntime());
				found = true;
			}
		}
		if (!found){
			System.out.println("No films were found with the title '" + title + "'.");
		}
	}
	
	public void searchByActor(String actor){
		// searches for actor and prints the movies by the actor
		
		boolean found = false;
		
		for(Movie movie:movies){
	           if (movie.getActor1().toLowerCase().trim().contains(actor.toLowerCase().trim()) 
	        		   || movie.getActor2().toLowerCase().trim().contains(actor.toLowerCase().trim())){
	               System.out.println(movie.getTitle());
	               found = true;
	           }
	       }
	      
	       if (!found){
	           System.out.println("No titles found for '" + actor + "'.");
	       }
	   }
	
	public void searchByDirector(String director){
		// TODO
		boolean found = false;
		for(Movie movie:movies) {
			if(movie.getDirector().toLowerCase().trim().contains(director.toLowerCase().trim())){
				System.out.println(movie.getTitle());
				found = true;
			}
		}
		if (!found){
			System.out.println("No titles found made by that director.");
		}
	}
	
	public void searchByYear(int year){
		// TODO
		boolean found= false;
		for (Movie movie: movies){
			if(movie.getYear() == year) {
				System.out.println(movie.getTitle());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No titles found for that year.");
		}
	}
	
	public void searchByRuntime(int runtime){
		// TODO
		boolean found=false;
		for (Movie movie: movies) {
			if(movie.getRuntime() == runtime){
				System.out.println(movie.getTitle());
				found= true;
			}
		}
		if(!found) {
			System.out.println("No titles found with such runtime.");
		}
	}
}