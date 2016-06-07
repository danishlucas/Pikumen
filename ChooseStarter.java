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

public class ChooseStarter implements GameState {
	public static final int ChooseStarterID = 1;
	private StateBasedGame game;
	private Pikumen eg;
	private Pikumen toof;
	private Pikumen damp;
	private Image image;
	private  PikumenList list;
	private UserParty userParty;
	


	@Override
	public int getID() {
		return 1;
	}

	@Override	 
	public void init(GameContainer container, StateBasedGame game)
	        throws SlickException {
	    this.game = game;
	    list = null;
	    try {
			list = new PikumenList();
			image = new Image("PikumenPics/PikumenChoose.png");
		} catch (SlickException | NumberFormatException | FileNotFoundException e) {
			e.printStackTrace();
		}
	    eg = list.get(0);
	    toof = list.get(26);
	    damp = list.get(8);
	    
	    
	}


	@Override
	public void render(GameContainer gc, StateBasedGame PikumenGame, Graphics g) throws SlickException {
			g.setColor(Color.white);
			eg.drawImage(70,200);
			toof.drawImage(250, 200);
			damp.drawImage(430, 200);
			image.draw(10, 0);
			g.drawString("Eg", 100, 160);
			g.drawString("Toof", 280, 160);
			g.drawString("Damp", 460, 160);
			g.drawString("0", 115, 350);
			g.drawString("1", 295, 350);
			g.drawString("2", 475, 350);
			g.drawString("Type the number of the Pikumen that you want to choose!", 53, 400);
	}
	@Override
	public void update(GameContainer gc, StateBasedGame game, int millis) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_0)){
			UserParty.getInstance().add(list.get(0));
			//userParty.addNewPikumen(list.get(0));
			game.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		else if (gc.getInput().isKeyPressed(Input.KEY_1)){
			UserParty.getInstance().add(list.get(26));
			//userParty.addNewPikumen(list.get(26));
			game.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		else if (gc.getInput().isKeyPressed(Input.KEY_2)){
			UserParty.getInstance().add(list.get(8));
			//userParty.addNewPikumen(list.get(8));
			game.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}

	}

	
	
	
	
	
	
	

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

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
