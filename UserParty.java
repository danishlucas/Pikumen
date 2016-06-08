package PikumenList;

public class UserParty  extends Party{
	private static UserParty instance = null;
	private int pokesInParty;
	protected UserParty(Pc storage) {
		super(storage);
		pokesInParty = 0;
	}
		      // Exists only to defeat instantiation.
		   
	public static UserParty getInstance() {
		if(instance == null) {
			instance = new UserParty(Pc.getInstance());
		 }
		return instance;
	}
		   
	public void addFirstPikumen(Pikumen newPoke){
		pokes[0] = newPoke;
		pokesInParty++;
	}
	
	public void addSecondPikumen(Pikumen newPoke){
		pokes[1] = newPoke;
		pokesInParty++;
	}
	
	public void addThirdPikumen(Pikumen newPoke){
		pokes[2] = newPoke;
		pokesInParty++;
	}
	
	public void addFourthPikumen(Pikumen newPoke){
		pokes[3] = newPoke;
		pokesInParty++;
	}
	
	public void addFifthPikumen(Pikumen newPoke){
		pokes[4] = newPoke;
		pokesInParty++;
	}
	
	public void addSixthPikumen(Pikumen newPoke){
		pokes[5] = newPoke;
		pokesInParty++;
	}
	
	public int getPokeNumber(){
		return pokesInParty;
	}
	
	public void addNewPikumen(Pikumen newPoke){
		add(newPoke);
		return;
	}
		   
		   
		   
		   
		}
