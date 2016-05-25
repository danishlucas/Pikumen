package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Soaked extends Pikumen {

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

	public Soaked(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Soak'd", level, exp, new Image("res/Soak'd.jpg"), 23, 2, 
				3, 26, 7, 8, new Move[4],
				1, 6);
	}
}