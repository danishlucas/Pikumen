package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Beeeeee extends Pikumen {

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

	public Beeeeee(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Beeeeee", level, exp, new Image("res/Beeeeee.jpeg"), 17, 4, 
				2, 25, 7, 6, new Move[4],
				4, 10);
	}
}