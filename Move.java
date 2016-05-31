package main;

public class Move { 
	protected String description;
	protected String name; 
 	protected int pp; 
	protected int type; //fire, grass, water 
	protected int maxPp;
 	 
 	public Move(String name, String description, int pp, int type) { 
 		this.description = description;
 		this.name = name; 
		this.pp = pp;
		this.type = type;
		this.maxPp = pp;
	}
 	
 	public String toString(){
 		return (name + " " + description + " " + pp + " " + type);
 	}
 	
	public void execMove(){
		return;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPp(){
		return pp;
	}
	
	public void reducePp() {
		pp--;
	}
	
	public void fillPp() {
		pp = maxPp;
	}
} 