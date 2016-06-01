package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import main.*;
public class punctuation extends Pikumen {
	public punctuation() throws SlickException {
		super("?!?!", new Image("PikumenPics/punctuation.png"), (int)(Math.random()*15 + 10), 
			   (int)(Math.random() * 4 + 2), (int)(Math.random()* 2 + 1), 26, 7, 6, (int)(Math.random() * 4 + 2), 6,
				new MoveSet(new LovingEmbrace(), new Drank(), new Squint(), new Wuuuuut()), -1, 4, 999);
	}
}