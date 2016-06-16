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
	private UserParty user;
	private EnemyParty enemy;
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
	private Image pikuball;
	private PikumenList list;
	
	@Override
	public void keyReleased(int key, char c) {
	   
	}
	
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		user = UserParty.getInstance();
		enemy = EnemyParty.getInstance();
		pointInTurn = "chooseMenu";
		executed = false;
		attackChosen = 0;
		effectNum = 0;
		fx = new ArrayList<String>();
	    list = null;
	    try {
	    	list = new PikumenList();
	    } catch (SlickException | NumberFormatException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int getID() {
		return BattleStateID;
	}

	@Override	 
	public void init(GameContainer container, StateBasedGame game)
	        throws SlickException {
	    this.game = game;
	    try {
			title = new Image("PikumenPics/PikumenTitle2.jpg");
			larrow = new Image("PikumenPics/arrowL.png");
			darrow = new Image("PikumenPics/arrowD.png");
			rarrow = new Image("PikumenPics/arrowR.png");
			uarrow = new Image("PikumenPics/arrowU.png");
			pikuball = new Image("PikumenPics/pikuball.png");
		} catch (SlickException | NumberFormatException e) {
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
			g.drawRect(370, 280, 230, 60);
			g.drawRect(20, 70, 231, 60);
			g.setColor(new Color(0.85f, 0.85f, 0.95f));
			g.fillRect(0, 350, 620, 150);
			g.fillRect(371, 281, 229, 59);
			g.fillRect(21, 71, 230, 59);
			//g.drawString("" + user.get(0).defeated(), 50, 300);
			if (!user.get(0).defeated() && !pointInTurn.equals("userDefeated0")) {
				user.get(0).drawImage(100, 250);
				g.setColor(Color.black);
				g.drawString(user.get(0).getCurrHp() + " / " + user.get(0).getHp() + "HP", 470, 310);
				g.drawString("Lv. " + user.get(0).getLevel(), 500, 290);
				g.drawString(user.get(0).getName(), 380, 290);
				g.drawRect(375, 312, 90, 12);
				g.setColor(Color.gray);
				g.fillRect(376, 313, 89, 11);
				if (user.get(0).getCurrHp() > user.get(0).getHp() / 2)
					g.setColor(Color.green);
				if((user.get(0).getCurrHp() > user.get(0).getHp() / 4) && (user.get(0).getCurrHp() <= user.get(0).getHp() / 2))
					g.setColor(Color.yellow);
				if(user.get(0).getCurrHp() <= user.get(0).getHp() / 4)
					g.setColor(Color.red);
				g.fillRect(376, 313, 89 * user.get(0).getCurrHp() / user.get(0).getHp(), 11);
				
			}
			g.setColor(Color.black);
			if (!enemy.get(0).defeated() && !pointInTurn.equals("pikumenCaught") && !pointInTurn.equals("enemyDefeated0")) {
				enemy.get(0).drawImage(370, 60);
				g.drawString(enemy.get(0).getCurrHp() + " / " + enemy.get(0).getHp() + "HP", 125, 100);
				g.drawString("Lv. " + enemy.get(0).getLevel(), 150, 80);
				g.drawString(enemy.get(0).getName(), 30, 80);
				g.setColor(Color.black);
				g.drawRect(26, 102, 90, 12);
										
				g.setColor(Color.gray);
				g.fillRect(27, 103, 89, 11);
				
				if (enemy.get(0).getCurrHp() > enemy.get(0).getHp() / 2)
					g.setColor(Color.green);
				if((enemy.get(0).getCurrHp() > enemy.get(0).getHp() / 4) && (enemy.get(0).getCurrHp() <= enemy.get(0).getHp() / 2))
					g.setColor(Color.yellow);
				if(enemy.get(0).getCurrHp() <= enemy.get(0).getHp() / 4)
					g.setColor(Color.red);
				g.fillRect(27, 103, 89 * enemy.get(0).getCurrHp() / enemy.get(0).getHp(), 11);	
			}
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
				g.setColor(new Color(0.78f, 0.36f, 0.34f));
				g.fillRect(9, 369, 154, 37);
				g.setColor(Color.black);
				g.drawString("Press \"Backspace\"", 10, 370);
				g.drawString("to go back", 12, 385);
				g.drawRect(8, 368, 155, 37);
			}
			
			
			
			if ((pointInTurn.equals("calculatingAttack1E") || pointInTurn.equals("calculatingAttack1U")
			|| pointInTurn.equals("calculatingAttack2U")|| pointInTurn.equals("calculatingAttack2E") 
			|| pointInTurn.equals("throwBallT") || pointInTurn.equals("throwBallW") || pointInTurn.equals("actuallyRunning")
			|| pointInTurn.equals("pikumenCaught") || pointInTurn.equals("pikumenEscape") || pointInTurn.equals("swappingU") 
			|| pointInTurn.equals("userDefeated0") || pointInTurn.equals("endWild") || pointInTurn.equals("swappingE")
			|| pointInTurn.equals("enemyDefeated0") || pointInTurn.equals("endTrainer")) && (fx.size() > 0)  && effectNum != fx.size()){ 
				g.drawString(fx.get(effectNum), 50, 450);
				g.drawString("*Press enter to continue*", 50, 375);
				if (pointInTurn.equals("pikumenCaught")){
					g.setColor(Color.white);
					g.drawRect(370, 60, 110, 110); // draw rect over enemy image, then draw image
					pikuball.draw(390, 80);
					
				}
			}

	}
	@Override
	public void update(GameContainer gc, StateBasedGame game, int millis) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_Z)) {
			user.get(0).fullHeal();
			enemy.get(0).updateHp(50);
		}
		if(pointInTurn.equals("chooseMenu")){
			effectNum = 0;
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
			
			else if (gc.getInput().isKeyPressed(Input.KEY_BACK))
				pointInTurn = "chooseMenu";
			gc.getInput().clearKeyPressedRecord();
		}
		if (pointInTurn.equals("calculatingAttack1") && !enemy.get(0).defeated() && !user.get(0).defeated()){
			fx.clear();
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
				if (!(user.get(0).defeated() || enemy.get(0).defeated())) {
				
					if (pointInTurn.equals("calculatingAttack1U")) {
						fx.clear();
						effectNum = 0;
						pointInTurn = "calculatingAttack2E";

					
					}
					if (effectNum >= fx.size() && pointInTurn.equals("calculatingAttack1E")) {
						fx.clear();
						effectNum = 0;
						pointInTurn = "calculatingAttack2U";

					}
				}
				else {
					if (user.get(0).defeated()){
						fx.clear();
						effectNum = 0;
						pointInTurn = "userDefeated0";
					}
					if (enemy.get(0).defeated()){
						fx.clear();
						effectNum = 0;
						pointInTurn = "enemyDefeated0";
					}
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
				if (user.get(0).defeated())
					pointInTurn = "userDefeated0";
				if (enemy.get(0).defeated())
					pointInTurn = "enemyDefeated0";
				}
		}
		
		if(pointInTurn.equals("calculatingAttack2E") && !enemy.get(0).defeated()){
			if (!executed) {
				fx.clear();
				fx = enemy.get(0).executeAttack((int) (Math.random() * 4), user.get(0), 1);
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
		}
		
		if((pointInTurn.equals("calculatingAttack2E") || pointInTurn.equals("calculatingAttack2U") || pointInTurn.equals("calclatingAttack1") 
				|| pointInTurn.equals("chooseMenu")) && user.get(0).defeated()) {	
			pointInTurn = "userDefeated0";
		}
				
		if (pointInTurn.equals("userDefeated0")){ 
			if (!executed) {
				fx.clear();
				effectNum = 0;
				executed = true;
			}
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
				effectNum++;
				gc.getInput().clearKeyPressedRecord();
			}
			int i = 1;
			if (!user.defeated() && user.get(0).defeated()){
				while (user.get(0).defeated()){	// so we aint displaying the battle effects for roadking // displaying for milli
					user.switchOrder(0, i);
					i++;
				}
				fx.add("Go " + user.get(0).getName() + "!");
				// we should probably make this a choice...
			}

			if (effectNum == fx.size()){
				executed = false;
				fx.clear();
				effectNum = 0;
				pointInTurn = "swappingU";
			}

		}
		
		if (pointInTurn.equals("swappingU")){
			if (gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()) {
				effectNum++;
			}
			if (user.defeated()) {
				fx.clear();
				gc.getInput().clearKeyPressedRecord();
				effectNum = 0;
				game.enterState(6, new FadeOutTransition(), new FadeInTransition());
				return;
			}
			pointInTurn = "chooseMenu";	
		}	
		
		if((pointInTurn.equals("calculatingAttack2U") || pointInTurn.equals("calculatingAttack2U") || pointInTurn.equals("calclatingAttack1")
		|| pointInTurn.equals("calculatingAttack1E") || pointInTurn.equals("calculatingAttack1U") || pointInTurn.equals("chooseMenu")) && enemy.get(0).defeated()) {	
			pointInTurn = "enemyDefeated0";
			executed = false;
		}
		
		
		if (pointInTurn.equals("enemyDefeated0")){ // need to display attack fx
			if (enemy.wild())
				pointInTurn = "endWild";
			else {
				if (enemy.defeated()){
					pointInTurn = "endTrainer";
					executed = false;
					effectNum = 0;
					fx.clear();
					return;
				}
				if (!executed) {
					user.get(0).addExp(enemy.get(0).getLevel());
					effectNum = 0;
					executed = true;
				}
				if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
					effectNum++;
					gc.getInput().clearKeyPressedRecord();
				}
				int i = 1;
				if (!enemy.defeated() && enemy.get(0).defeated()){
					while (enemy.get(0).defeated()){	
						enemy.switchOrder(0, i);
						i++;
					}
				}

				if (effectNum == fx.size()){
					executed = false;
					fx.clear();
					effectNum = 0;
					pointInTurn = "swappingE";
				}
			}

		}
		
		
		if (pointInTurn.equals("swappingE")){			
			if (!executed) {
				fx.clear();
				effectNum = 0;
				fx.add("Your opponent sent out " + enemy.get(0).getName() + "!");
				executed = true;
			}
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
				effectNum++;
				gc.getInput().clearKeyPressedRecord();
			}
			if (user.defeated()) {
				fx.clear();
				gc.getInput().clearKeyPressedRecord();
				effectNum = 0;
				game.enterState(0, new FadeOutTransition(), new FadeInTransition());
				return;
			}
			if (effectNum == fx.size()) {
				
				fx.clear();
				effectNum = 0;
				executed = false;
				pointInTurn = "chooseMenu";	
			}
		}	
		
		if (pointInTurn.equals("endTrainer")) {
			if (!executed) {
				fx.add("Congratulations! You defeated the evil trainer!");
				executed = true;
			}
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
				effectNum++;
				gc.getInput().clearKeyPressedRecord();
			}
			if (effectNum == fx.size()) {
				fx.clear();
				effectNum = 0;
				executed = false;
				user.get(0).addExp(enemy.get(0).getLevel());
				for (int i = 0; i <6; i++){
					if (user.get(i) != null)
						user.get(i).resetStats();
				}
				if (enemy.getBoss())
					user.incMaxArea();
				gc.getInput().clearKeyPressedRecord();
				
				game.enterState(2, new FadeOutTransition(), new FadeInTransition());
			}
			
			
		}
		
		if (pointInTurn.equals("endWild")) {
			if (!executed) {
				executed = true;
				fx.add("You defeated the wild " + enemy.get(0).getName());
				fx.add("Your " + user.get(0).getName() + " gained " + enemy.get(0).getLevel() + " exp!");
				effectNum = 0;
			}
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER) && effectNum < fx.size()){
				effectNum++;
				gc.getInput().clearKeyPressedRecord();
			}
			if(effectNum == fx.size()){
				user.get(0).addExp(enemy.get(0).getLevel());
				user.get(0).resetStats();
				gc.getInput().clearKeyPressedRecord();
				game.enterState(2, new FadeOutTransition(), new FadeInTransition());
			}
		}
		
		
		
		if(pointInTurn.equals("throwBall")){//assumes neither pikumen is defeated	
			fx.clear();
				if(!enemy.wild()){
					fx.add("Cannot catch an opponents Pikumen");
					pointInTurn = "throwBallT"; // T for trainer
				}
				else if (enemy.wild()){
					fx.add("You threw a Pikuball");
					pointInTurn = "throwBallW";
				}
		}		
					
					
		if (pointInTurn.equals("throwBallT")){		
				if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
					pointInTurn = "chooseMenu";
					fx.clear();
				}
					
		}
			
		if (pointInTurn.equals("throwBallW")){
			double rando = Math.random();
			double chance = ((double)enemy.get(0).getCurrHp() / (double)enemy.get(0).getHp());
			if(chance > .9){ // in case no damage has been done or health is above 90%
				if(rando > .90){
					if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
						fx.clear();
						fx.add("The wild " + enemy.get(0).getNickname() + " was caught!");
						pointInTurn = "pikumenCaught";
					}
				}
				else if(!(rando > .90)){
					if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
						fx.clear();
						fx.add("The wild " + enemy.get(0).getNickname() + " escaped!");
						pointInTurn = "pikumenEscape";
					}
				}
			}
			
			else if(rando > chance){ // > used because chance is decreasing  
				if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
					fx.clear();
					fx.add("The wild " + enemy.get(0).getNickname() + " was caught!");
					pointInTurn = "pikumenCaught";
				}
			}
			else if(!(rando > chance)){
				if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
					fx.clear();
					fx.add("The wild " + enemy.get(0).getNickname() + " escaped!");
					pointInTurn = "pikumenEscape";
				}
			}
		}
			
		if(pointInTurn.equals("pikumenCaught")){
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){	
				Pikumen newPoke = list.get(enemy.get(0).getIndex());
				newPoke.setLevel(enemy.get(0).getLevel());
				user.add(newPoke);
				game.enterState(2, new FadeOutTransition(), new FadeInTransition());
				return;
			}
		}
			
		if(pointInTurn.equals("pikumenEscape")){
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
				executed = false;
				pointInTurn = "calculatingAttack2E";

			}
		}
			if(pointInTurn.equals("fleeing")){
				if (!enemy.wild()) {
					fx.add("You can't run from a trainer!");
					pointInTurn = "throwBallT";
				}
				else if (enemy.wild()){
					fx.add("You fled in terror of the mighty " + enemy.get(0).getName());
					pointInTurn = "actuallyRunning";
				}
				
			}
			
			if (pointInTurn.equals("actuallyRunning")){
				if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
					game.enterState(2, new FadeOutTransition(), new FadeInTransition());
				}
			}
			
			if (pointInTurn.equals("partySwap")) {
				user.setPartyStatus(3);
				pointInTurn = "calculatingAttack2E";
				game.enterState(4, new FadeOutTransition(), new FadeInTransition());
			}
			
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
