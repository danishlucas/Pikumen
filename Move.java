package Pikamen;
import java.util.ArrayList;
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


public abstract class Move {
	private String description;
	private String name;
	private int pp;
	
	public Move(String description, String name, int pp) {
		this.description = description;
		this.name = name;
		this.pp = pp;
	}
	
	public abstract void execMove();
}
