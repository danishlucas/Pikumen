package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Larj extends Pikumen {

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

	public Larj(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Larj", level, exp, new Image("res/Larj.jpg"), 30, 2, 
				2, 40, 3, 7, new Move[4],
				1, 6);
	}
}