package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Wardroab extends Pikumen {

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

	public Wardroab(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Wardroab", level, exp, new Image("res/Wardroab.jpeg"), 30, 2, 
				5, 40, 4, 10, new Move[4],
				2, 10);
	}
}