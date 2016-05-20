package Pikamen;

public class DamagingMove extends Move {
	private int damage;
	
	public DamagingMove(String description, String name, int pp, int damage){
		super(description, name, pp);
		this.damage = damage;
		
		
	}

	@Override
	public void execMove() {
		// TODO add how damage affects enemy pikamen
		
	}

}
