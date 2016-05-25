package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Drowned extends Pikumen {

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

	public Drowned(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Drown'd", level, exp, new Image("res/Drown'd.jpeg"), 29, 2, 
				4, 37, 7, 8, new Move[4],
				2, 3);
	}
}