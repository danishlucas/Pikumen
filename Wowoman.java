package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Wowoman extends Pikumen {

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

	public Wowoman(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Wowoman", level, exp, new Image("res/Wowoman.jpg"), 21, 5, 
				2, 40, 20, 9, new Move[4],
				5, 12);
	}
	
}