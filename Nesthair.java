package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Nesthair extends Pikumen {

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

	public Nesthair(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Nesthair", level, exp, new Image("res/Nesthair.jpg"), 34, 3, 
				3, 30, 15, 2, new Move[4],
				5, 15);
	}
}