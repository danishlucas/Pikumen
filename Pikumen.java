package PikumenList;
import java.util.ArrayList;
import java.awt.*;
import java.io.FileNotFoundException;

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
import main.*;



public class Pikumen {
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
	private int currHp;
	private int maxHp;
	private int evo;
	private int type;
	private int tempAtk;
	private int tempDef;
	private int tempSpd;
	private int atk;
	private int def;
	private int spd;
	private int index;
	
	
	public Pikumen(String name, Image image, int hpPLvl, int atkPLvl, 
					int defPLvl, int startHp, int startAtk, int startDef, 
					int spdPLvl, int startSpd, MoveSet startingMoves, int evo, int type, int index) throws SlickException{
		this.name = name;
		this.level = 1;		
		this.exp = 0;
		this.image = image;
		this.hpPLvl = hpPLvl;
		this.atkPLvl = atkPLvl;
		this.defPLvl = defPLvl;
		this.spdPLvl = spdPLvl;
		this.startHp = startHp;
		this.startAtk = startAtk;
		this.startDef = startDef;
		this.startSpd = startSpd;
		this.maxHp =  (int) (startHp + hpPLvl * level);
		this.currHp = maxHp;
		this.evo = evo; // if -1, max evo
		this.type = type;
		this.index = index;
		nickname = name;
		moves = startingMoves.getMoveSet();
		this.resetStats();
		tempAtk = atk;
		tempDef = def;
		tempSpd = spd;
	}
	
	public boolean readyToEvo(){
		if(evo == -1){
			return false;
		}
		if(level >= evo){
			return true;
		}
		return false;
	}
	
	public Pikumen evoTarget() throws NumberFormatException, FileNotFoundException, SlickException{
		PikumenList list = new PikumenList();
		if (index == 22){
			return new punctuation();
		}
		return list.get(index + 1);
	}
	
	public void setLevel(int level){
		this.level = level;
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
	
	public int getExp() {
		return exp;
	}
	
	public int getHp() {
		setMaxHp();
		return maxHp;
	}
	
	public void setMaxHp() {
		maxHp = (int)(level * hpPLvl + startHp);
	}
	
	public void setAtk() {
		atk =  (int)(level * atkPLvl + startAtk);
	}
	
	public void setDef() {
		def =  (int)(level * defPLvl + startDef);
	}
	
	public void setSpd() {
		spd = (int)(level * spdPLvl + startSpd);
	}
	
	public int getAtk(){
		setAtk();
		return atk;
	}
	
	public int getDef(){
		setDef();
		return def;
	}
	
	public int getSpd(){
		setSpd();
		return spd;
	}
	
	public int getCurrHp() {
		return currHp;
	}
	
	public void updateHp(int damage) {
		currHp -=damage;
		if (currHp < 0)
			currHp = 0;
		if (currHp > maxHp)
			currHp = maxHp;
	}
	
	public boolean defeated() {
		if (currHp == 0)
			return true;
		return false;
	}
	
	public void fullHeal() {
		setMaxHp();
		currHp = (int)(level * hpPLvl + startHp);
	}
	
	
	public ArrayList<String> executeAttack(int moveNum, Pikumen target, int which) { //moveNum: 0 = basic, 1 = statRaise, 2 = statLower, 3 = special
		//which = int user or opponent pokemon, 0 = user, 1= opponent
		Move attack = moves[moveNum];
		ArrayList<String> effects = new ArrayList<String>();
		String oppOrUse = "";
		String other = "";
		if(which == 0) {
			other = "Opponent";
			oppOrUse = "User";
		}
		if(which == 1) {
			other = "User";
			oppOrUse = "Opponent";
		}
		effects.add(oppOrUse + "'s " + this.getNickname() + " used " + attack.getName());
		if (attack instanceof AttackMove){
			double rando = Math.random();
			if (.85 >= rando){
				float mult = 1;
				if ((((AttackMove) attack).getType() == 2 && target.getType() == 3) || ((AttackMove) attack).getType() == 3 && target.getType() == 4	
						|| (((AttackMove) attack).getType() == 4 && target.getType() == 2)) {
					mult *= 1.5;			
					effects.add("It's super effective! Nice decision bucko!");
				}
				if((((AttackMove) attack).getType() == 2 && target.getType() == 4) || (((AttackMove) attack).getType() == 3 && target.getType() == 2)
						|| (((AttackMove) attack).getType() == 4 && target.getType() == 3)) {
					mult/= 1.5;
					
					effects.add("It's not very effective... Bad decision");
				}
				if (Math.random() <= 0.1) {
					mult *= 1.5;
					effects.add("Yes! A critical hit!");
				}
				int damage = ((int) (((AttackMove) attack).getDmg()  * mult * this.getTempAtk() / target.getTempDef() * .75));
				if (damage == 0)
					damage = 1;
				target.updateHp((damage));
			}
			else  
				effects.add("The attack missed");

		}
		else if(attack instanceof StatRaiseMove){
			int stat = ((StatRaiseMove) attack).getStat();
			if(which == 0)
				oppOrUse = "User";
			if(which == 1)
				oppOrUse = "Opponent";
			if(stat == 2) {
				if (tempAtk >= getAtk() * 2)
					effects.add(oppOrUse + "'s " + this.getNickname() + " attack cannot go any higher!");
				else {
					raiseTempAtk();
					effects.add(oppOrUse + "'s " + this.getNickname() + " attack rose!");
				}
			} else if(stat == 3) {
				if (tempDef >= 2 * getDef())
					effects.add(oppOrUse + "'s " + this.getNickname() + " defense cannot go any higher!");
				else {	
					raiseTempDef();
					effects.add(oppOrUse + "'s " + this.getNickname() + " defense rose!");
				}
			} else if(stat == 1) {
				updateHp( 0 - (getHp() / 4));
				effects.add(oppOrUse + "'s " + this.getNickname() + " recovered health!");
			} else {
				if (tempSpd >= 2 * getSpd())
					effects.add(oppOrUse + "'s " + this.getNickname() + " speed cannot go any higher!");
				else {
					raiseTempSpd();
					effects.add(oppOrUse + "'s " + this.getNickname() + " speed rose!");
				}
			}	
		}
		else if(moves[moveNum] instanceof StatLowerMove){
			int stat = ((StatLowerMove) attack).getStat();
			double rando = Math.random();
			if(which == 0)
				oppOrUse = "Opponent";
			if(which == 1)
				oppOrUse = "User";
			if (.85 >= rando){
				if(stat == 3) {
					if(target.getTempAtk() <= getAtk() / 2)
						effects.add(oppOrUse + "'s " + this.getNickname() + " attack cannot go any lower!");
					else {
						target.lowerTempAtk();
						effects.add(oppOrUse + "'s " + target.getNickname() + " attack fell!");
					}
				} else if(stat == 4) {
					if (target.getTempDef() <= getDef() / 2)
						effects.add(oppOrUse + "'s " + this.getNickname() + " defense cannot go any lower");
					else {
						target.lowerTempDef();
						effects.add(oppOrUse + "'s " + target.getNickname() + " defense fell!");
					}
				} else {
					if (target.getTempSpd() <= getSpd() / 2)
						effects.add(oppOrUse + "'s " + this.getNickname() + " speed cannot go any lower");
					else {
						target.lowerTempSpd();
						effects.add(oppOrUse + "'s " + target.getNickname() + " speed fell!");
					}
				}	
			}
			else {
				effects.add("The attack missed");
			}
		}
		attack.reducePp();
		if(which == 1)
			oppOrUse = "User";
		if(which == 0)
			oppOrUse = "Opponent";
		if (target.defeated())
			effects.add(oppOrUse + "'s " + target.getName() + " fainted");
		return effects;
	}
	
	public int getType() {
		return type;
	}

	public void drawImage(int x, int y) {
		image.draw(x, y);
	}
	
	public void addExp(int addedExp){ // addedExp = level of defeated poke
		exp += addedExp;
		int toNext = 4 * level;
		while(exp >= toNext) {
			level++;
			resetStats();
			setMaxHp();
			exp -= toNext;
			toNext+=5;
		}
	}
	
	public int getTempAtk(){
		return tempAtk;
	}
	
	public int getTempDef(){
		return tempDef;
	}
	
	public int getTempSpd(){
		return tempSpd;
	}
	
	public void raiseTempAtk(){
		tempAtk *= 1.5;
	}
	
	public void raiseTempDef(){
		tempDef *= 1.5;
	}
	
	public void raiseTempSpd(){
		tempSpd *= 1.5;
	}
	public void lowerTempAtk(){
		tempAtk *= 0.75;
		if (tempAtk < 0)
			tempAtk = 0;
	}
	
	public void lowerTempDef(){
		tempDef *= 0.75;
		if(tempDef < 0)
			tempDef = 0;
	}
	
	public void lowerTempSpd(){
		tempSpd *= 0.75;
		if(tempSpd < 0)
			tempSpd = 0;
	}
	
	public Move getMove(int location){
		return moves[location];
		
	}
	public void resetStats() {
		setAtk();
		setDef();
		setSpd();
	}
	
	public int getIndex(){
		return index;
	}
	
	
	
}
