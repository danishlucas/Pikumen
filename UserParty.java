package PikumenList;

public class UserParty  extends Party{
	private boolean trainer;
	private static UserParty instance = null;
	private int num;
	protected UserParty(Pc storage) {
		super(storage);
		num = 0;
	}
		      // Exists only to defeat instantiation.
		   
	public static UserParty getInstance() {
		if(instance == null) {
			instance = new UserParty(Pc.getInstance());
		 }
		return instance;
	}
	
	public boolean trainer(){
		return trainer;
	}
	
	public void setTrainer(boolean trainer){
		this.trainer = trainer;
	}
}