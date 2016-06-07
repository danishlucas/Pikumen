package ActualGame;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

public class BattleState implements GameState {
	public static final int BattleStateID = 3;
	private StateBasedGame game;
	private Party user;
	private EnemyParty enemy;
	private int oppOrWild;
	private Image title;
	private ArrayList<String> fx;
	private String pointInTurn;
	private String displayFx;
	private int effectNum;
	private boolean executed;
	private int attackChosen;
	private Image larrow;
	private Image darrow;
	private Image uarrow;
	private Image rarrow;
	
	@Override
	public void keyReleased(int key, char c) {
	   
	}
	
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		user = UserParty.getInstance();
		enemy = EnemyParty.getInstance(oppOrWild);
		pointInTurn = "chooseMenu";
		executed = false;
		attackChosen = 0;
		effectNum = 0;

	}

	@Override
	public int getID() {
		return BattleStateID;
	}

	@Override	 
	public void init(GameContainer container, StateBasedGame game)
	        throws SlickException {
	    this.game = game;
	    PikumenList list = null;
	    try {
			list = new PikumenList();
			title = new Image("PikumenPics/PikumenTitle2.jpg");
			larrow = new Image("PikumenPics/arrowL.png");
			darrow = new Image("PikumenPics/arrowD.png");
			rarrow = new Image("PikumenPics/arrowR.png");
			uarrow = new Image("PikumenPics/arrowU.png");
		} catch (SlickException | NumberFormatException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    fx = new ArrayList<String>();
	    fx = null;
	    
	    
	    
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer gc, StateBasedGame PikumenGame, Graphics g) throws SlickException {
			g.setColor(Color.white);
			g.fillRect(0, 0, 620, 500);
			g.setColor(Color.black);
			g.drawRect(400, 280, 200, 60);
			g.drawRect(20, 70, 200, 60);
			g.setColor(new Color(0.85f, 0.85f, 0.95f));
			g.fillRect(0, 350, 620, 150);
			g.fillRect(401, 281, 199, 59);
			g.fillRect(21, 71, 199, 59);
			user.get(0).drawImage(100, 250);
			enemy.get(0).drawImage(370, 60);
			g.setColor(Color.black);
			g.drawString(enemy.get(0).getCurrHp() + " / " + enemy.get(0).getHp() + "HP", 125, 100);
			g.drawString(user.get(0).getCurrHp() + " / " + user.get(0).getHp() + "HP", 505, 310);
			g.drawString("Lv. " + enemy.get(0).getLevel(), 150, 80);
			g.drawString("Lv. " + user.get(0).getLevel(), 530, 290);
			g.drawString(enemy.get(0).getName(), 30, 80);
			g.drawString(user.get(0).getName(), 410, 290);
			g.drawRect(405, 310, 90, 12);						// user Hp bar
			g.setColor(Color.gray);
			g.fillRect(406, 311, 89, 11);
			if (user.get(0).getCurrHp() > user.get(0).getHp() / 2)
				g.setColor(Color.green);
			if(user.get(0).getCurrHp() < user.get(0).getHp() / 4)
				g.setColor(Color.red);
			if((user.get(0).getCurrHp() > user.get(0).getHp() / 4) && (user.get(0).getCurrHp() <= user.get(0).getHp() / 2))
				g.setColor(Color.yellow);
			g.fillRect(406, 311, 89 * user.get(0).getCurrHp() / user.get(0).getHp(), 11);		// end user Hp bar	
			g.setColor(Color.black);
			if (pointInTurn.equals("chooseMenu")){
				uarrow.draw(292, 380);
				g.drawString("Attack", 275, 370);
				darrow.draw(294, 423);
				g.drawString("Flee", 292, 480);
				larrow.draw(260, 420);
				g.drawString("Party", 208, 422);
				rarrow.draw(300, 418);
				g.drawString("Ball", 355, 422);
			}
			if(pointInTurn.equals("chooseAttack")){
				uarrow.draw(292, 380);
				g.drawString("" + user.get(0).getMove(0).getName(), 275, 370);
				darrow.draw(294, 423);
				g.drawString("" + user.get(0).getMove(3).getName(), 292, 480);
				larrow.draw(260, 420);
				g.drawString("" + user.get(0).getMove(1).getName(), 208, 422);
				rarrow.draw(300, 418);
				g.drawString("" + user.get(0).getMove(2).getName(), 355, 422);
			}
			
			
			
			if (pointInTurn.equals("calculatingAttack1E") || pointInTurn.equals("calculatingAttack1U") || pointInTurn.equals("calculatingAttack2U")
			|| pointInTurn.equals("calculatingAttack2E") || pointInTurn.equals("throwBall")){
				g.drawString(fx.get(effectNum), 50, 450);
				g.drawString("*Press enter to continue*", 50, 375);
			}

	}
	@Override
	public void update(GameContainer gc, StateBasedGame game, int millis) throws SlickException {
		if(pointInTurn.equals("chooseMenu")){
			if(gc.getInput().isKeyPressed(Input.KEY_UP))
				pointInTurn = "chooseAttack";
			else if(gc.getInput().isKeyPressed(Input.KEY_LEFT))
				pointInTurn = "partySwap";
			else if(gc.getInput().isKeyPressed(Input.KEY_RIGHT))
				pointInTurn = "throwBall";
			else if(gc.getInput().isKeyPressed(Input.KEY_DOWN))
				pointInTurn = "fleeing";
		}
		if(pointInTurn.equals("chooseAttack")){
			if (gc.getInput().isKeyPressed(Input.KEY_UP)) { // upgrade to actually use battle
				attackChosen = 0;
				pointInTurn = "calculatingAttack1";
			}
			else if (gc.getInput().isKeyPressed(Input.KEY_LEFT)) { // may not be working
				attackChosen = 1;
				pointInTurn = "calculatingAttack1";
			}
			else if (gc.getInput().isKeyPressed(Input.KEY_RIGHT)) {
				attackChosen = 2;
				pointInTurn = "calculatingAttack1";
			}
			else if (gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
				attackChosen = 3;
				pointInTurn = "calculatingAttack1";
			}
				//fx = user.get(0).executeAttack(3, enemy.get(0));
			
		}
		if (pointInTurn.equals("calculatingAttack1")){
			int userSpd = user.get(0).getTempSpd();
			int enemySpd = enemy.get(0).getTempSpd();
			if (userSpd > enemySpd || (userSpd == enemySpd && Math.random() > 0.5)){
				pointInTurn = "calculatingAttack1U";
				fx = user.get(0).executeAttack(attackChosen, enemy.get(0), 0);
			}
			else if (userSpd <= enemySpd){
				pointInTurn = "calculatingAttack1E";
				fx = enemy.get(0).executeAttack((int)(Math.random() * 4), user.get(0), 1);
			}
		}
		if(pointInTurn.equals("calculatingAttack1E") || pointInTurn.equals("calculatingAttack1U")){
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
				effectNum++;
				gc.getInput().clearKeyPressedRecord();
			}
			if (effectNum == fx.size()){
				if (pointInTurn.equals("calculatingAttack1U")) {
					pointInTurn = "calculatingAttack2E";
					fx.clear();;
					effectNum = 0;
					
				}
				if (effectNum >= fx.size() && pointInTurn.equals("calculatingAttack1E")) {
					pointInTurn = "calculatingAttack2U";
					fx.clear();
					effectNum = 0;
				}
			}
		}
		
		if(pointInTurn.equals("calculatingAttack2U") && !user.get(0).defeated() && !enemy.get(0).defeated()){
			if (!executed) {
				fx = user.get(0).executeAttack(attackChosen, enemy.get(0), 0);
				executed = true;
				gc.getInput().clearKeyPressedRecord();
				effectNum = 0;
			}
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
				effectNum++;
				gc.getInput().clearKeyPressedRecord();
			}
			
			if (effectNum == fx.size() && !user.get(0).defeated() && !enemy.get(0).defeated()) {
				effectNum = 0;
				fx.clear();
				executed = false;
				pointInTurn = "chooseMenu";
			}
			else if (effectNum == fx.size() && (user.get(0).defeated() || enemy.get(0).defeated())){
				//basically switch a poke out
			}
		}
		
		if(pointInTurn.equals("calculatingAttack2E") && !user.get(0).defeated() && !enemy.get(0).defeated()){
			if (!executed) {
				fx = enemy.get(0).executeAttack((int) (Math.random() * 4), user.get(0),1 );
				executed = true;
				gc.getInput().clearKeyPressedRecord();
				effectNum = 0;
			}
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
				effectNum++;
				gc.getInput().clearKeyPressedRecord();
			}
			
			if (effectNum == fx.size() && !user.get(0).defeated() && !enemy.get(0).defeated()) {
				pointInTurn = "chooseMenu";
				fx.clear();
				executed = false;
				effectNum = 0;
			}	
				
			else if (effectNum == fx.size() && (user.get(0).defeated())){
				if (user.defeated()) {
					fx.clear();
					gc.getInput().clearKeyPressedRecord();
					effectNum = 0;
					game.enterState(2, new FadeOutTransition(), new FadeInTransition());
				}
				int i = 1;
				while (user.get(0).defeated()){
					user.switchOrder(0, i);
					// we should probably make this a choice...
				}
				pointInTurn = "chooseMenu";
			}
		}
		if(pointInTurn.equals("throwBall")){//assumes neither pikumen is defeated		
			int oppOrWild = enemy.getOppOrWild();
			ArrayList<String> pikuballEffects = new ArrayList<String>();
			if(oppOrWild == 0){
				pikuballEffects.add("Cannot catch an opponents Pikumen");
				fx = pikuballEffects;
				pointInTurn = "chooseMenu";
			}
				
		}
		if(pointInTurn.equals("fleeing")){
			game.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		
		
		
		//if (user.isDefeated())
		
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
