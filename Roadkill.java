package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Roadkill extends Pikumen {

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

	public Roadkill(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Roadkill", level, exp, new Image("res/Roadkill.jpeg"), 16, 3, 
				2, 20, 8, 4, new Move[4],
				2, 3);
	}
}