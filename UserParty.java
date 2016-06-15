package PikumenList;

public class UserParty  extends Party{
	private static UserParty instance = null;
	private int pokesInParty;
	private int partyStatus; // 2: from overworld, 3: from battle
	private int notChosen1;
	private int notChosen2;
	private int maxArea;
	protected UserParty(Pc storage) {
		super(storage);
		maxArea = 0;
		pokesInParty = 0;
		partyStatus = 0;
		notChosen1 = 0;
		notChosen2 = 0;
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
	
	public void setPartyStatus(int i) {
		partyStatus = i;
	}
	
	public int getPartyStatus() {
		return partyStatus;
	}
	
	public void setNotChosen1(int i) {
		notChosen1 = i;
	}
	
	public void setNotChosen2(int i){
		notChosen2 = i;
	}
	
	public int getNotChosen1(){
		return notChosen1;
	}
	
	public int getNotChosen2() {
		return notChosen2;
	}
	
	public void incMaxArea(){
		maxArea++;
	}
	
	public int getMaxArea(){
		return maxArea;
	}
	
	
	
	
}