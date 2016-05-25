package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Damp extends Pikumen {

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

	public Damp(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Damp", level, exp, new Image("res/Damp.jpg"), 18, 2, 
				3, 20, 4, 4, new Move[4],
				1, 3);
	}
}