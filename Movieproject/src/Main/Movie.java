package Main;


public class Movie {
	// Fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private int year;
	private int runtime;
	
	// Constructor
	public Movie(String title, String actor1, String actor2, String director, int year, int runtime){
		// TODO
		this.title= title;
		this.actor1=actor1;
		this.actor2=actor2;
		this.director = director;
		this.year=year;
		this.runtime = runtime;
	}
	
	// Methods
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getActor1(){
		return actor1;
	}
	
	public void setActor1(String actor1) {
		this.actor1= actor1;
	}
	
	public String getActor2(){
		return actor2;
	}
	
	public void setActor2(String actor2) {
		this.actor2=actor2;
	}
	
	public String getDirector(){
		return director;
	}
	
	public void setDirector(String director){
		this.director= director;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year=year;
	}
	
	
	public int getRuntime(){
		return runtime;
	}
	
	
	public void setRunTime(int runtime){
		this.runtime = runtime;
	}
	
	@Override
	public String toString(){
		return "Movie: title =" + title + ", year =" + year + ", runtime =" 
			+ runtime + ",actor 1 =" +actor1 + ",actor 2 =" + actor2 + ", director =";
	}
	// Optional
	//public boolean isActorInMovie(String actor){
		// TODO
	}

