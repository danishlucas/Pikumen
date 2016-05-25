package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Threef extends Pikumen {

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

	public Threef(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Threef", level, exp, new Image("res/Threef.jpeg"), 30, 3, 
				4, 50, 6, 15, new Move[4],
				2, 15);
	}
}