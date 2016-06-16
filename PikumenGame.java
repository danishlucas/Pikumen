package ActualGame;
import java.io.FileNotFoundException;
import java.util.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import main.*;
import java.awt.*;
import PikumenList.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class PikumenGame extends StateBasedGame{
   
   public static final String gamename = "Pikumen";
   public static final int OpeningMenu = 0;
   public static final int Overworld = 1;
   public static final int xSize = 620;
   public static final int ySize = 500;
   public static final Pc storage = Pc.getInstance();
   public UserParty userParty = UserParty.getInstance();

   
   public PikumenGame(String gamename){
      super(gamename);
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
	   this.addState(new OpeningMenu());
	   this.addState(new ChooseStarter());
       this.addState(new Overworld());
       this.addState(new BattleState());
       this.addState(new PartyState());
       this.addState(new PcState());
       this.addState(new YouDiedState());
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new PikumenGame(gamename));
         appgc.setDisplayMode(xSize, ySize, false);
         appgc.setTargetFrameRate(60);
         appgc.setShowFPS(false);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
}