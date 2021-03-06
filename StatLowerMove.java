package main;

public class StatLowerMove extends Move {
	private int stat;//which stat to raise
	private float accuracy;
	private int amountLower;
	public StatLowerMove(String name, String description, int pp, int type, int stat, float accuracy, int amountLower) {
		super(name, description, pp, type);
		this.stat = stat;
		this.accuracy = accuracy;
		this.amountLower = amountLower;
	}
	
	public String toString(){
		return(name + ", " + description + ", " + amountLower + ", " + accuracy + ", " + stat);
	}
	
	public void execMove(){
		return;
	}
	
	public int getAmountLower(){
		return amountLower;
	}
	
	public float getAcc(){
		return accuracy;
	}
	
	public int getStat(){
		return stat;
	}
}