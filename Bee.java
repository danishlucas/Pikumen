package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Bee extends Pikumen {

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

	public Bee(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Bee", level, exp, new Image("res/Bee.jpeg"), 10, 3, 
				2, 15, 7, 4, new Move[4],
				3, 7);
	}
}