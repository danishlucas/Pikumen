
package simpleslickgame;

import java.io.FileNotFoundException;
import java.util.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
    
    public Game(String name) {
        super(name);
    }
    
    /**
     * Called once Slick2D is set up, but before the game is actually
     * displayed to the user. If you want to load any images or sounds,
     * you should do it here.
     */
    public void init(GameContainer gc) throws SlickException {
        // We don't need to do this, but the FPS counter is ugly!
        gc.setShowFPS(false);

               
    	}
    
    /**
     * Updates to the game logic should go here.
     *
     * millis is the number of milliseconds since update was last called.
     * @throws SlickException 
     */
    public void update(GameContainer gc, int millis) throws SlickException {

		
    }
    
    /**
     * Drawing to the screen should be done here.
     */
    public void render(GameContainer gc, Graphics g) {
        
        /* Try commenting out these lines: */
        g.translate(gc.getInput().getAbsoluteMouseX(), gc.getInput().getAbsoluteMouseY());
        //g.rotate(0, 0, gc.getInput().getAbsoluteMouseX() / 3);
        
        // Colors a box
        g.setColor(new Color(.5f, 0, 0));
        g.fillRect(10, 10, 400, 200);
        
        // Draws an outline on the box
        g.setColor(Color.red);
        g.setLineWidth(5);
        g.drawRect(10, 10, 400, 200);
        
        g.setColor(Color.green);
        g.drawString("The only limit is your imagination!", 20, 20);
    }
    
    /**
     * This just gets the game started. Anything else you want to
     * do to set the game up should probably go in the init method.
     */
    public static void main(String[] args) {
        
        System.out.println("Starting up the game!");
        try {
            // An AppGameContainer lets Slick2D play the game inside its own window.
            AppGameContainer game = new AppGameContainer(new Game("Title goes here"));
            game.setDisplayMode(640, 480, false); // A 640x480 pixel window. Not fullscreen.
            game.setTargetFrameRate(60); // Without this, the game will play as fast as it can.
            game.start();
            
            // If the game started successfully, nothing past game.start() will ever run.
            // Any game logic should now go in init, update, or render.
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}


