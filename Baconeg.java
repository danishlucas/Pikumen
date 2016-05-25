package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Baconeg extends Pikumen {

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

	public Baconeg(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Baconeg", level, exp, new Image("res/Baconeg.jpeg"), 25, 3, 
				2, 35, 6, 4, new Move[4],
				2, 4);
	}
}