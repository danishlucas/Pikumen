package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class punctuation extends Pikumen {

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

	public punctuation(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("?!?!", level, exp, new Image("res/punctuation.jpeg"), (int)(Math.random()*15 + 10), (int)(Math.random() * 4 + 2), 
				(int)(Math.random()* 2 + 1), 26, 7, 6, new Move[4],
				(int)(Math.random() * 4 + 2), 6);
	}
}