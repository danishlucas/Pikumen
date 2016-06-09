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
	

	@Override
	public void render(GameContainer gc, StateBasedGame PikumenGame, Graphics g) throws SlickException {
		g.setColor(Color.white);
		pokeTest.drawImage(10, 10);
		playerImg.draw(200,400);
	}



	public static void enterState(int openingmenuid, FadeOutTransition fadeOutTransition,
					   FadeInTransition fadeInTransition, UserParty party) {		
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame game) throws SlickException {
		enemy = EnemyParty.getInstance();
		user = UserParty.getInstance();
		user.get(0).setLevel(5);
		try {
			user.evolvePoke();
		} catch (NumberFormatException | FileNotFoundException e) {
			e.printStackTrace();
		}
		user.fullHeal();
		enemyPokeTest = list.get(21);
		enemy.setWild(true);
		enemy.add(enemyPokeTest);
		user.add(list.get(29));
		user.add(list.get(3));
		pokeTest = user.get(0);
	}
	
	@Override
	public int getID() {
		return 2;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		playerImg = new Image("PikumenPics/PikumenPlayer.png");	 
		this.game = game;

		list = null;
		try {
			list = new PikumenList();
			
		} catch (SlickException | NumberFormatException | FileNotFoundException e) {
				e.printStackTrace();
		}
		//UserParty.getInstance().addNewPikumen(list.get(12));
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int millis) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_R)){
			gc.getInput().clearKeyPressedRecord();
			game.enterState(3, new FadeOutTransition(), new FadeInTransition());
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
