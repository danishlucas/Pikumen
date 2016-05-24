package main;

public class Move { 
	protected String description;
	protected String name; 
 	protected int pp; 
	protected int type; //fire, grass, water 
 	 
 	public Move(String name, String description, int pp, int type) { 
 		this.description = description;
 		this.name = name; 
		this.pp = pp;
		this.type = type;
	}
 	
 	public String toString(){
 		return (name + " " + description + " " + pp + " " + type);
 	}
 	
	public void execMove(){
		return;
	}
} 
