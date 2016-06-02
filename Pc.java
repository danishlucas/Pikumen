package PikumenList;
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


public class Pc {
	private ArrayList<Pikumen> pokes;
	private static Pc instance = null;
		
	protected Pc() {
			pokes = new ArrayList<Pikumen>();
	}
	
	public static Pc getInstance() {
		      if(instance == null) {
		         instance = new Pc();
		      }
		      return instance;
	}
	
	// do we need a getLocation method?
	
	public Pikumen get(int location){
		return pokes.get(location);
		
	}
	
	public void add(Pikumen other){
		pokes.add(other);
	}
		
	public void swap(Party other, int swappedParty, int swappedPc) { //swapped party is location of poke in party
		Pikumen poke = other.get(swappedParty);						 //Swapped pc is location of poke in pc
		Pikumen temp = pokes.get(swappedPc);
		pokes.set(swappedPc, poke);
		other.remove(swappedParty);
		other.addPikumen(temp);
	}
	
	
}
