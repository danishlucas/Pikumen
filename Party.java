package PikumenList;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import main.Move;


public class Party {
	
	private Pikumen[] pokes;
	private Pc storage;
	
	public Party(Pc storage) {
		pokes = new Pikumen[6];
		this.storage = storage;
	}
	
	public void addPikumen(Pikumen poke) {
		int location = 0;
		while(pokes[location] != null || location < 6) {
			location++;
		}
		if(location == 6){								// No room in party? add to Pc
			storage.add(poke);
		}
		else	{
			pokes[location] = poke;						// Room in party? add to party
			
		}
	}
	
	public Pikumen get(int location){
		return (pokes[location]);
	}
	
	public void switchOrder(int first, int second){			//swaps the places of first and second
		Pikumen temp = pokes[second];
		pokes[second] = pokes[first];
		pokes[first] = temp;
	}
		
	public boolean defeated(){
		for (int i = 0; i < pokes.length; i++) {
			if (!(pokes[i] == null && pokes[i].defeated()))
				return false;
		}
		return true;
	}
	
	public void evolvePoke() throws NumberFormatException, FileNotFoundException, SlickException{
		for (int i = 0; i < 6; i++){
			if(pokes[i].readyToEvo()){
				Pikumen newPoke = pokes[i].evoTarget();
				String nickname = pokes[i].getNickname();
				newPoke.setNickName(nickname);
				this.remove(i);
				this.addPikumen(newPoke);
			}
		}
	}
	

	public void remove(int location) {
		pokes[location] = null;
	}
	
	
	
}
