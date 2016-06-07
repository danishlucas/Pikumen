package PikumenList;

public class EnemyParty  extends Party{
	private static EnemyParty instance = null;
	private int num;
	protected EnemyParty(Pc storage) {
		super(storage);
		num = 0;
	}
		      // Exists only to defeat instantiation.
		   
	public static EnemyParty getInstance() {
		if(instance == null) {
			instance = new EnemyParty(Pc.getInstance());
		 }
		return instance;
	}
}