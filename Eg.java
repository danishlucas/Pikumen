package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Eg extends Pikumen {

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

	public Eg(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Eg", level, exp, new Image("res/Eg.jpg"), 15, 2, 
				2, 20, 5, 4, new Move[4],
				2, 4);
	}
}