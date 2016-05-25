package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Toof extends Pikumen {

	private String name;
	private int level;
	private int exp;
	private Image image;
	private float hpPLvl;
	private float atkPLvl;
	private float defPLvl;
	private String nickname;
	private int startHp;
	private int startAtk;
	private int startDef;
	private Move[] moves;
	private float spdPLvl;
	private int startSpd;
	private Move special;

	public Toof(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Toof", level, exp, new Image("res/Toof.jpg"), 16, 2, 
				3, 25, 3, 8, new Move[4],
				2, 2);
	}
	
	
	
	
	

}
