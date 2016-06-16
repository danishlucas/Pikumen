package ActualGame;
import java.awt.*;
import java.io.FileNotFoundException;
import main.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;
import org.newdawn.slick.Color;
import PikumenList.*;
import PikumenPics.*;

public class PcState implements GameState {
	public static final int PcStateID = 5;
	private StateBasedGame game;
	private PikumenList list;
	private UserParty user;
	private Pc Pc;
	private int select1;
	private int select2;
	private boolean selectCheck;
	


	@Override
	public int getID() {
		return 5;
	}

	@Override	 
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		selectCheck = true;
		user = UserParty.getInstance();
		select1 = -1;
		select2 = -1;
		Pc = Pc.getInstance();
	    this.game = game;
	    list = null;
	    try {
			list = new PikumenList();
		} catch (SlickException | NumberFormatException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void render(GameContainer gc, StateBasedGame PikumenGame, Graphics g) throws SlickException { // reset all the stuff down from render
			g.setColor(Color.white);
			g.drawString("Swap with storage", 220, 40);
			g.drawString("Party", 100, 110);
			g.drawString("Storage", 470, 110);
			int i = 0;
			while (i < 6 && user.get(i) != null) {
				g.setColor(Color.white);
				g.drawString("" + i + " " + user.get(i).getName() + "   Lv. " + user.get(i).getLevel(), 70, 150 + i * 30);
				if (select1 == i) {
					g.setColor(Color.yellow);
					g.fillOval(60, 155 + i * 30, 10, 10);
				}
				i++;
				
			}
			g.setColor(Color.white);
			i = 0;
			while(i < Pc.getSize() && Pc.get(i) != null) {
				g.drawString("" + i + " " + Pc.get(i).getName()  + "   Lv. " + Pc.get(i).getLevel(), 420, 150 + i * 30);
				i++;
			}
			if (Pc.getSize() == 0)
				g.drawString("Your storage is empty", 410, 150);
			g.setColor(new Color(0.78f, 0.36f, 0.34f));
			g.fillRect(466, 463, 154, 38);
			g.setColor(Color.white);
			g.drawString("Press \"Backspace\"", 467, 464);
			g.drawString("to go back", 469, 479);
			g.drawRect(465, 462, 155, 38);
			if (select1 == -1){
				g.drawString("Select the Pikumen number from your party", 100, 60);
			}
			else 
				g.drawString("Select the Pikumen number from your storage", 92, 60);
			if (!selectCheck)
				g.drawString("Please select numbers of Pikumen that exist", 90, 80);
	}
	@Override
	public void update(GameContainer gc, StateBasedGame game, int millis) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_BACK)){
			game.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
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
		else {
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
			if (gc.getInput().isKeyPressed(Input.KEY_6)){
				select2 = 6;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_7)){
				select2 = 7;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_8)){
				select2 = 8;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
			if (gc.getInput().isKeyPressed(Input.KEY_9)){
				select2 = 9;
				gc.getInput().clearKeyPressedRecord();
				return;
			}
		}
		if (select1 != -1 && select2 != -1){
			if(select1 < 6 && user.get(select1) != null && select2 < Pc.getSize() && Pc.get(select2) != null){
				selectCheck = true;
				Pc.swap(user, select1, select2);
			}
			else {
				selectCheck = false;
			}
			select1 = -1;
			select2 = -1;
		}
	}

	

	
	
	
	
	
	
	

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		select1 = -1;
		select2 = -1;

	}
	
	@Override
	public void keyReleased(int key, char c) {
	   
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

	@Override
	public void keyPressed(int arg0, char arg1) {
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


}
