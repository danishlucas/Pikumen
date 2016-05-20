package Pikumen;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;


public class Pikumen {
	private String name;
	private int level;
	private int exp;
	private int pokedexNum; // for differentiating pikumen from each other and comparing easily
	private int type; //water, fire, grass type
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
	
	public Pikumen(String name, int level, int exp, int pokedexNum, int type, Image image, float hpPLvl, float atkPLvl, 
					float defPLvl, int startHp, int startAtk, int startDef, int[] startingMoves,
					float spdPLvl, int startSpd){
		this.name = name;
		this.level = level;			// or does level = a certain point of experience?
		this.exp = exp;
		this.pokedexNum = pokedexNum;
		this.type = type;
		this.image = image;
		this.hpPLvl = hpPLvl;
		this.atkPLvl = atkPLvl;
		this.defPLvl = defPLvl;
		this.spdPLvl = spdPLvl;
		this.startHp = startHp;
		this.startAtk = startAtk;
		this.startDef = startDef;
		this.startSpd = startSpd;
		nickname = name;
		moves = startingMoves;
	}
	
	public void setNickName(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickname(){
		return nickname;	
	}
	
	public String getName(){
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHp() {
		return (int)(level * hpPLvl + startHp);
	}
	
	public int getAtk() {
		return (int)(level * atkPLvl + startAtk);
	}
	
	public int getDef() {
		return (int)(level * defPLvl + startDef);
	}
	
	public void executeAttack(int moveNum) {
												// attacks
	}
	
	
	
