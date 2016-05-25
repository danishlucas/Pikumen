package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Chesthair extends Pikumen {

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

	public Chesthair(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Chesthair", level, exp, new Image("res/Chesthair.jpeg"), 26, 3, 
				2, 30, 5, 8, new Move[4],
				4, 6);
	}
}