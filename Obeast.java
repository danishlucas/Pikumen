package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Obeast extends Pikumen {

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

	public Obeast(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Obeast", level, exp, new Image("res/Obeast.jpg"), 50, 2, 
				3, 50, 5, 9, new Move[4],
				1, 7);
	}
}