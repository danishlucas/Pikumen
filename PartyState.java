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

public class PartyState implements GameState {
	private Image playerImg;
	public static final int PartyStateID = 4;
	private StateBasedGame game;
	private Pikumen pokeTest;
	private PikumenList list;
	private UserParty user;
	private int select1;
	private int select2;
	

	@Override
	public void render(GameContainer gc, StateBasedGame PikumenGame, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("Type the numbers of the two Pikumen that you would like to switch", 20, 20);
		user.get(0).drawImage(10, 50);
		g.drawString("0", 60, 150); // add them numbers under it yo
		g.drawString(user.get(0).getCurrHp() + " / " + user.get(0).getHp() + "HP", 210, 96);
		g.drawString("Lv. " + user.get(0).getLevel(), 210, 80);
		g.drawString(user.get(0).getName(), 110, 80);
		g.drawRect(110, 100, 90, 12);
		g.setColor(Color.green);
		g.fillRect(111, 101, 89, 11);
		if (user.get(1) != null){
			user.get(1).drawImage(315, 50);
			g.setColor(Color.white);
			g.drawString("1", 365, 150);
			g.drawString(user.get(1).getCurrHp() + " / " + user.get(1).getHp() + "HP", 515, 96);
			g.drawString("Lv. " + user.get(1).getLevel(), 515, 80);
			g.drawString(user.get(1).getName(), 415, 80);
			g.drawRect(415, 100, 90, 12);
			g.setColor(Color.green);
			g.fillRect(416, 101, 89, 11);
		}
		if (user.get(2) != null){
			user.get(2).drawImage(10, 200);
			g.setColor(Color.white);
			g.drawString("2", 60, 300);
			g.drawString(user.get(2).getCurrHp() + " / " + user.get(2).getHp() + "HP", 210, 246);
			g.drawString("Lv. " + user.get(2).getLevel(), 210, 230);
			g.drawString(user.get(2).getName(), 110, 230);
			g.drawRect(110, 250, 90, 12);
			g.setColor(Color.green);
			g.fillRect(111, 251, 89, 11);
		}
		if (user.get(3) != null){
			g.setColor(Color.white);
			user.get(3).drawImage(315, 200);
			g.drawString("3", 360, 300);
			g.drawString(user.get(3).getCurrHp() + " / " + user.get(3).getHp() + "HP", 515, 246);
			g.drawString("Lv. " + user.get(3).getLevel(), 515, 230);
			g.drawString(user.get(3).getName(), 415, 230);
			g.drawRect(415, 250, 90, 12);
			g.setColor(Color.green);
			g.fillRect(416, 251, 89, 11);
		}
		if (user.get(4) != null){
			g.setColor(Color.white);
			user.get(4).drawImage(10, 350);
			g.drawString("4", 60, 450);
			g.drawString(user.get(4).getCurrHp() + " / " + user.get(4).getHp() + "HP", 210, 396);
			g.drawString("Lv. " + user.get(4).getLevel(), 210, 380);
			g.drawString(user.get(4).getName(), 110, 380);
			g.drawRect(110, 400, 90, 12);
			g.setColor(Color.green);
			g.fillRect(111, 401, 89, 11);
		}
		if (user.get(5) != null){
			g.setColor(Color.white);
			user.get(5).drawImage(315, 350);
			g.drawString("5", 360, 450);
			g.drawString(user.get(5).getCurrHp() + " / " + user.get(5).getHp() + "HP", 515, 396);
			g.drawString("Lv. " + user.get(5).getLevel(), 515, 380);
			g.drawString(user.get(5).getName(), 415, 380);
			g.drawRect(415, 400, 90, 12);
			g.setColor(Color.green);
			g.fillRect(416, 401, 89, 11);
		}
		g.setColor(new Color(0.78f, 0.36f, 0.34f));
		g.fillRect(466, 463, 154, 38);
		g.setColor(Color.white);
		g.drawString("Press \"Backspace\"", 467, 464);
		g.drawString("to go back", 469, 479);
		g.drawRect(465, 462, 155, 38);
		if (select1 != -1) {
			g.setColor(Color.white);
			g.drawString("Choice 1: " + select1 , 200, 480);
		}
	}



	public static void enterState(int openingmenuid, FadeOutTransition fadeOutTransition,
					   FadeInTransition fadeInTransition, UserParty party) {		
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame game) throws SlickException {
			select1 = -1;
			select2 = -1;
	}
	
	@Override
	public int getID() {
		return PartyStateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		this.game = game;

		list = null;
		try {
			list = new PikumenList();
			
		} catch (SlickException | NumberFormatException | FileNotFoundException e) {
				e.printStackTrace();
		}
		user = UserParty.getInstance();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int millis) throws SlickException {
		if (select1 == -1){
			if (gc.getInput().isKeyPressed(Input.KEY_0)){
				select1 = 0;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_1)){
				select1 = 1;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_2)){
				select1 = 2;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_3)){
				select1 = 3;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_4)){
				select1 = 4;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_5)){
				select1 = 5;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
		}
		else if (select2 == -1){
			if (gc.getInput().isKeyPressed(Input.KEY_0)){
				select2 = 0;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_1)){
				select2 = 1;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_2)){
				select2 = 2;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_3)){
				select2 = 3;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_4)){
				select2 = 4;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_5)){
				select2 = 5;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
		}
		else {
			user.switchOrder(select1, select2);
			select1 = -1;
			select2 = -1;
			return;
		}
		if (gc.getInput().isKeyPressed(Input.KEY_BACK)){
			game.enterState(user.getPartyStatus(), new FadeOutTransition(), new FadeInTransition());
		}
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
