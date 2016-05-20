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
	private int type; //fire, grass, water
	
	public Move(String description, String name, int pp, int type) {
		this.description = description;
		this.name = name;
		this.pp = pp;
		this.type = type;
	}
	
	public abstract void execMove();
}
