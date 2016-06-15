package PikumenList;

public class EnemyParty  extends Party{
	private static EnemyParty instance = null;
	private int num;
	private boolean wild;
	private boolean boss;
	protected EnemyParty(Pc storage) {
		super(storage);
		num = 0;
		wild = true;
	}
		      // Exists only to defeat instantiation.
		   
	public static EnemyParty getInstance() {
		if(instance == null) {
			instance = new EnemyParty(Pc.getInstance());
		 }
		return instance;
	}
	public boolean wild(){
		return wild;
	}
	
	public void setWild(boolean wild){
		this.wild = wild;
	}
	
	public void isBoss(boolean boss){
		this.boss = boss;
	}
	
	public boolean getBoss(){
		return this.boss;
	}
	

}