package PikumenList;

public class EnemyParty  extends Party{
	private static EnemyParty instance = null;
	private int num;
	private int wildOrOpp; //0 = opponent(uncatchable), 1= wild (catchable)
	protected EnemyParty(Pc storage, int which) {
		super(storage);
		num = 0;
		wildOrOpp = which;
	}
		      // Exists only to defeat instantiation.
		   
	public static EnemyParty getInstance(int i) {
		if(instance == null) {
			instance = new EnemyParty(Pc.getInstance(), i);
		 }
		return instance;
	}
	
	public int getOppOrWild(){
		return wildOrOpp;
	}
}
