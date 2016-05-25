package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class qMark extends Pikumen {

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

	public qMark(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("?", level, exp, new Image("res/qMark.jpeg"), 13, 3, 
				2, 20, 4, 4, new Move[4],
				3, 6);
	}
}