package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Gimp extends Pikumen {

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

	public Gimp(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Gimp", level, exp, new Image("res/Gimp.jpg"), 20, 2, 
				3, 20, 3, 8, new Move[4],
				2, 4);
	}
}