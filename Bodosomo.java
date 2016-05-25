package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Bodosomo extends Pikumen {

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

	public Bodosomo(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Bodosomo", level, exp, new Image("res/Bodosomo.jpeg"), 30, 2, 
				4, 35, 7, 10, new Move[4],
				3, 3);
	}
}