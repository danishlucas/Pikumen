package ActualGame;

import org.newdawn.slick.Color;
import java.awt.*;
import java.io.FileNotFoundException;
import main.*;
import PikumenList.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

import PikumenList.Pc;
import PikumenList.PikumenList;
import PikumenList.UserParty;

public class Overworld implements GameState {
	private Image playerImg;
	public static final int OverworldID = 2;
	private StateBasedGame game;
	private Pikumen pokeTest;
	private PikumenList list;
	private Pikumen enemyPokeTest;
	private UserParty user;
	private EnemyParty enemy;
	private int selected;
	private int currentArea;
	private Image larrow;
	private Image rarrow;
	

	@Override
	public void render(GameContainer gc, StateBasedGame PikumenGame, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("Press enter to select", 197, 100);
		g.drawString("Press arrow keys to navigate menu", 155, 120);
		g.drawString("Area " + currentArea, 273, 35);
		g.drawString("Adjust party", 70, 200);
		g.drawString("Access storage", 70, 260);
		g.drawString("Battle wild Pikumen", 70, 320);
		g.drawString("Battle trainer", 70, 380);
		g.drawString("Battle area boss", 70, 440);
		if (currentArea == 0)
			g.drawString(" (Lesser Fool Noah)" , 220, 440);
		if (currentArea == 1)
			g.drawString(" (Greater Fool Daniel)", 220, 440);
		if (currentArea == 2)
			g.drawString(" (Dank memer Dane)", 220, 440);
		if (currentArea == 3)
			g.drawString(" ( Sneaky Snek Sean)", 220, 440);
		if (currentArea == 4)
			g.drawString(" (Grand Poobah Bean)", 220, 440);
		if (currentArea == 5)
			g.drawString(" (Lord of the Code Bergquist)", 220, 440);
		if (currentArea > 0) {
			g.drawImage(larrow, 0, 10);
			g.drawString("To area " + (currentArea - 1), 0, 80);
		}
		if (currentArea != 5 && currentArea < user.getMaxArea()){
			g.drawImage(rarrow, 540, 10); 
			g.drawString("To area " + (currentArea + 1), 535, 80);	
		}
		playerImg.draw(0, 180 + selected * 60);

	}



	public static void enterState(int openingmenuid, FadeOutTransition fadeOutTransition,
					   FadeInTransition fadeInTransition, UserParty party) {		
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame game) throws SlickException {
		enemy.clear();
		user.fullHeal();
		for (int i = 0; i < 6; i++){
			if (user.get(i) != null)
				user.get(i).resetStats();
		}
		selected = 0;
	}
	
	@Override
	public int getID() {
		return 2;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		playerImg = new Image("PikumenPics/PikumenPlayer.png");	 
		rarrow = new Image("PikumenPics/white right.png");
		larrow = new Image("PikumenPics/white left.png");
		currentArea = 0;
		this.game = game;

		list = null;
		try {
			list = new PikumenList();
			
		} catch (SlickException | NumberFormatException | FileNotFoundException e) {
				e.printStackTrace();
		}
		enemy = EnemyParty.getInstance();
		user = UserParty.getInstance();
		
		
		enemy.setWild(true);
		//UserParty.getInstance().addNewPikumen(list.get(12));
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int millis) throws SlickException { // final mission: pc, improve stages
		user.fullHeal();
		enemy.fullHeal();
		try {
			user.evolvePoke();
		} catch (NumberFormatException | FileNotFoundException e) {
			e.printStackTrace();
		}
		if (currentArea < user.getMaxArea() && gc.getInput().isKeyPressed(Input.KEY_RIGHT)) {
			currentArea++;
			gc.getInput().clearKeyPressedRecord();
		}
		if (currentArea > 0 && gc.getInput().isKeyPressed(Input.KEY_LEFT)){
			currentArea--;
			gc.getInput().clearKeyPressedRecord();
		}
		if (gc.getInput().isKeyPressed(Input.KEY_UP) && selected != 0){
			selected--;
			gc.getInput().clearKeyPressedRecord();
			return;
		}
		if (gc.getInput().isKeyPressed(Input.KEY_DOWN) && selected != 4) {
			selected ++;
			gc.getInput().clearKeyPressedRecord();
			return;
		}
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			if (selected == 0) { // party
				user.setPartyStatus(2);
				game.enterState(4, new FadeOutTransition(), new FadeInTransition());
			}
			if (selected == 1){
				//enter pc
			}
			if (selected == 2){ // battle wild
				enemy.clear();
				enemy.setWild(true);
				enemy.isBoss(false);
				if (currentArea == 0){
					int rando = (int)(Math.random() * 4);
					if(rando == 0)
						enemy.add(list.get(5));
					if(rando == 1)
						enemy.add(list.get(19));
					if(rando == 2)
						enemy.add(list.get(user.getNotChosen1()));
					if (rando == 3)
						enemy.add(list.get(user.getNotChosen2()));
					enemy.get(0).setLevel(1);
				}
				if (currentArea == 1){
					int rando = (int)(Math.random() * 4);
					if(rando == 0)
						enemy.add(list.get(5));
					if(rando == 1)
						enemy.add(list.get(19));
					if(rando == 2)
						enemy.add(list.get(user.getNotChosen1()));
					if (rando == 3)
						enemy.add(list.get(user.getNotChosen2()));
					enemy.get(0).setLevel(3);
				}
				if (currentArea == 3){
					int rando = (int)(Math.random() * 12);
					if(rando == 0)
						enemy.add(list.get(3));
					if(rando == 1)
						enemy.add(list.get(6));
					if(rando == 2)
						enemy.add(list.get(11));
					if(rando == 3)
						enemy.add(list.get(13));
					if(rando == 4)
						enemy.add(list.get(15));
					if(rando == 5)
						enemy.add(list.get(17));
					if(rando == 6)
						enemy.add(list.get(20));
					if(rando == 7)
						enemy.add(list.get(22));
					if(rando == 8)
						enemy.add(list.get(24));
					if(rando == 9)
						enemy.add(list.get(1));
					if(rando == 10)
						enemy.add(list.get(9));
					if(rando == 11)
						enemy.add(list.get(27));
					enemy.get(0).setLevel(5);
				}
				if (currentArea == 3){
					int rando = (int)(Math.random() * 12);
					if(rando == 0)
						enemy.add(list.get(3));
					if(rando == 1)
						enemy.add(list.get(6));
					if(rando == 2)
						enemy.add(list.get(11));
					if(rando == 3)
						enemy.add(list.get(13));
					if(rando == 4)
						enemy.add(list.get(15));
					if(rando == 5)
						enemy.add(list.get(17));
					if(rando == 6)
						enemy.add(list.get(20));
					if(rando == 7)
						enemy.add(list.get(22));
					if(rando == 8)
						enemy.add(list.get(24));
					if(rando == 9)
						enemy.add(list.get(1));
					if(rando == 10)
						enemy.add(list.get(9));
					if(rando == 11)
						enemy.add(list.get(27));
					enemy.get(0).setLevel(7);
				}
				if (currentArea == 4){ 
					int rando = (int)(Math.random() * 30);
					enemy.add(list.get(rando));
					enemy.get(0).setLevel(10);
				}
				if (currentArea == 5){ 
					int rando = (int)(Math.random() * 30);
					enemy.add(list.get(rando));
					enemy.get(0).setLevel(13);
				}
				enemy.fullHeal();
				for (int i = 0; i < 6; i++) {
					if (enemy.get(i) != null)
						enemy.get(i).resetStats();
				}
				game.enterState(3, new FadeOutTransition(), new FadeInTransition());
			}	
			if (selected == 3) { // battle trainer
				enemy.isBoss(false);
				enemy.clear();
				enemy.setWild(false);
				if (currentArea == 0) {
					int rando = (int)(Math.random() * 5);
					if(rando == 0)
						enemy.add(list.get(5));
					if(rando == 1)
						enemy.add(list.get(19));
					if(rando == 2)
						enemy.add(list.get(0));
					if (rando == 3)
						enemy.add(list.get(26));
					if (rando == 4)
						enemy.add(list.get(8));
					rando = (int)(Math.random() * 5);
					if(rando == 0)
						enemy.add(list.get(5));
					if(rando == 1)
						enemy.add(list.get(19));
					if(rando == 2)
						enemy.add(list.get(0));
					if (rando == 3)
						enemy.add(list.get(26));
					if (rando == 4)
						enemy.add(list.get(8));
					enemy.get(0).setLevel(2);
					enemy.get(1).setLevel(2);
				}
				if (currentArea == 1) {
					int rando = (int)(Math.random() * 5);
					if(rando == 0)
						enemy.add(list.get(5));
					if(rando == 1)
						enemy.add(list.get(19));
					if(rando == 2)
						enemy.add(list.get(0));
					if (rando == 3)
						enemy.add(list.get(26));
					if (rando == 4)
						enemy.add(list.get(8));
					rando = (int)(Math.random() * 5);
					if(rando == 0)
						enemy.add(list.get(5));
					if(rando == 1)
						enemy.add(list.get(19));
					if(rando == 2)
						enemy.add(list.get(0));
					if (rando == 3)
						enemy.add(list.get(26));
					if (rando == 4)
						enemy.add(list.get(8));
					enemy.get(0).setLevel(4);
					enemy.get(1).setLevel(4);
				}
				if (currentArea == 2){
					int rando = (int)(Math.random() * 12);
					if(rando == 0)
						enemy.add(list.get(3));
					if(rando == 1)
						enemy.add(list.get(6));
					if(rando == 2)
						enemy.add(list.get(11));
					if(rando == 3)
						enemy.add(list.get(13));
					if(rando == 4)
						enemy.add(list.get(15));
					if(rando == 5)
						enemy.add(list.get(17));
					if(rando == 6)
						enemy.add(list.get(20));
					if(rando == 7)
						enemy.add(list.get(22));
					if(rando == 8)
						enemy.add(list.get(24));
					if(rando == 9)
						enemy.add(list.get(1));
					if(rando == 10)
						enemy.add(list.get(9));
					if(rando == 11)
						enemy.add(list.get(27));
					enemy.get(0).setLevel(6);
					rando = (int)(Math.random() * 12);
					if(rando == 0)
						enemy.add(list.get(3));
					if(rando == 1)
						enemy.add(list.get(6));
					if(rando == 2)
						enemy.add(list.get(11));
					if(rando == 3)
						enemy.add(list.get(13));
					if(rando == 4)
						enemy.add(list.get(15));
					if(rando == 5)
						enemy.add(list.get(17));
					if(rando == 6)
						enemy.add(list.get(20));
					if(rando == 7)
						enemy.add(list.get(22));
					if(rando == 8)
						enemy.add(list.get(24));
					if(rando == 9)
						enemy.add(list.get(1));
					if(rando == 10)
						enemy.add(list.get(9));
					if(rando == 11)
						enemy.add(list.get(27));
					enemy.get(1).setLevel(5);
				}
				if (currentArea == 2){
					int rando = (int)(Math.random() * 12);
					if(rando == 0)
						enemy.add(list.get(3));
					if(rando == 1)
						enemy.add(list.get(6));
					if(rando == 2)
						enemy.add(list.get(11));
					if(rando == 3)
						enemy.add(list.get(13));
					if(rando == 4)
						enemy.add(list.get(15));
					if(rando == 5)
						enemy.add(list.get(17));
					if(rando == 6)
						enemy.add(list.get(20));
					if(rando == 7)
						enemy.add(list.get(22));
					if(rando == 8)
						enemy.add(list.get(24));
					if(rando == 9)
						enemy.add(list.get(1));
					if(rando == 10)
						enemy.add(list.get(9));
					if(rando == 11)
						enemy.add(list.get(27));
					enemy.get(0).setLevel(8);
					rando = (int)(Math.random() * 12);
					if(rando == 0)
						enemy.add(list.get(3));
					if(rando == 1)
						enemy.add(list.get(6));
					if(rando == 2)
						enemy.add(list.get(11));
					if(rando == 3)
						enemy.add(list.get(13));
					if(rando == 4)
						enemy.add(list.get(15));
					if(rando == 5)
						enemy.add(list.get(17));
					if(rando == 6)
						enemy.add(list.get(20));
					if(rando == 7)
						enemy.add(list.get(22));
					if(rando == 8)
						enemy.add(list.get(24));
					if(rando == 9)
						enemy.add(list.get(1));
					if(rando == 10)
						enemy.add(list.get(9));
					if(rando == 11)
						enemy.add(list.get(27));
					enemy.get(1).setLevel(8);
				}
				
				enemy.fullHeal();
				for (int i = 0; i < 6; i++) {
					if (enemy.get(i) != null)
						enemy.get(i).resetStats();
				}
				game.enterState(3, new FadeOutTransition(), new FadeInTransition());
			}
			if (selected == 4){ // boss fight //need to make sure maxArea increases
				enemy.clear();
				if (user.getMaxArea() == currentArea)
					enemy.isBoss(true);
				enemy.setWild(false);
				if (currentArea == 0){ //lesser fool Noah
					enemy.add(list.get(0));
					enemy.add(list.get(26));
					enemy.add(list.get(8));
					enemy.get(0).setLevel(3);
					enemy.get(1).setLevel(3);
					enemy.get(2).setLevel(3);
				}
				if (currentArea == 1){ // Greater fool daniel
					enemy.add(list.get(8));
					enemy.add(list.get(19));
					enemy.add(list.get(17));
					enemy.get(0).setLevel(4);
					enemy.get(1).setLevel(5);
					enemy.get(2).setLevel(5);
				}
				if (currentArea == 2){ //dan
					enemy.add(list.get(10));
					enemy.add(list.get(24));
					enemy.add(list.get(6));
					enemy.get(0).setLevel(7);
					enemy.get(1).setLevel(7);
					enemy.get(2).setLevel(7);
				}
				if (currentArea == 3){ //seeeeen
					enemy.add(list.get(13));
					enemy.add(list.get(17));
					enemy.add(list.get(22));
					enemy.get(0).setLevel(8);
					enemy.get(1).setLevel(9);
					enemy.get(2).setLevel(8);
				}
				if (currentArea == 4) { // bean
					enemy.add(list.get(4));
					enemy.add(list.get(12));
					enemy.add(list.get(2));
					enemy.get(0).setLevel(10);
					enemy.get(1).setLevel(11);
					enemy.get(2).setLevel(11);
				}
				if (currentArea == 5){ //yung berg
					enemy.add(list.get(14));
					enemy.add(list.get(16));
					enemy.add(list.get(10));
					enemy.add(list.get(25));
					enemy.add(list.get(29));
					enemy.get(0).setLevel(15);
					enemy.get(1).setLevel(15);
					enemy.get(2).setLevel(15);
					enemy.get(3).setLevel(15);
					enemy.get(4).setLevel(15);
				}
				enemy.fullHeal();
				for (int i = 0; i < 6; i++) {
					if (enemy.get(i) != null)
						enemy.get(i).resetStats();
				}
				game.enterState(3, new FadeOutTransition(), new FadeInTransition());
			}
		}
		
		
		
		//enemy.add(list.get((int)(Math.random() * 30)));
		//gc.getInput().clearKeyPressedRecord();
		//game.enterState(3, new FadeOutTransition(), new FadeInTransition());
	}
	
	
	
	
	
	
	
	@Override
	public void keyPressed(int arg0, char arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub

	}




	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

}
