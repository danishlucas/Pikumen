package PikumenList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Pikamen.Move;

public class Teef extends Pikumen {

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

	public Teef(int level, int exp, Move[] startingMoves, Move special) throws SlickException {
		super("Teef", level, exp, new Image("res/Teef.jpg"), 20, 2, 
				4, 35, 5, 10, new Move[4],
				2, 10);
		
		
		
		
	}
}