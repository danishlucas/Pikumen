package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Hair extends Pikumen {

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

	public Hair(int level, int exp, Move[] startingMoves) throws SlickException {
		super("Hair", level, exp, new Image("res/Hair.jpg"), 19, 2, 
				2, 20, 4, 4, new Move[4],
				3, 6);
	}
}