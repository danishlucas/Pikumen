package main;

public class AttackMove extends Move {
	private int damage;
	private float accuracy;
	public AttackMove(String name, String description, int pp, int type, int damage, float accuracy) {
		super(name, description, pp, type);
			this.damage = damage;
			this.accuracy = accuracy;
	}

	public String toString(){
		return (name + ", " + description + ", " + damage + ", " + accuracy + ", " + pp);
	}
	
	public void execMove(){
		return;
	}
	
	public int getDmg(){
		return damage;
	}
	
	public float getAcc(){
		return accuracy;
	}
	
	public int getType(){
		return type;
	}
}