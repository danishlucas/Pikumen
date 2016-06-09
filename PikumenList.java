package PikumenList;
import java.util.*;
import org.json.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.*;

import java.io.*;

public class PikumenList {
	private ArrayList<Pikumen> pokes;
	private Scanner scan;
	public PikumenList() throws FileNotFoundException, NumberFormatException, SlickException	{
		pokes = new ArrayList<Pikumen>();
		scan = new Scanner(new File("PikumenListDoc"));
		String line;
		int i = 0;
		MoveSet[] moves = {new MoveSet(new Squish(), new Harden(), new Roast(), new Scramble()), new MoveSet(new Nudge(), new Harden(), new Roast(), new Fry()), 
			new MoveSet(new LovingEmbrace(),new Harden(), new Roast(), new SunnySideUp()),	new MoveSet(new Flick(),new Yodel(), new AwkwardSilence(), new Buzz()), 
			new MoveSet(new GentlePat(), new Yodel(), new AwkwardSilence(), new Bumble()), new MoveSet(new Bonk(), new Bulge(), new Squint(), new Easy()),
			new MoveSet(new Pinch(), new Bulge(), new Squint(), new Breezy()), new MoveSet(new GentlePat(), new Bulge(), new Squint(), new CoverGirl()),
			new MoveSet(new Boop(), new Drank(), new AwkwardSilence(), new Dampen()), new MoveSet(new Nudge(), new Drank(), new AwkwardSilence(), new Moisten()),
			new MoveSet(new GentlePat(), new Drank(), new AwkwardSilence(), new Squirt()), new MoveSet(new Pinch(), new Bulge(), new Squint(), new Spank()), 
			new MoveSet(new LovingEmbrace(), new Bulge(), new AwkwardSilence(), new Whip()), new MoveSet(new Nudge(), new Yodel(), new Roast(), new SnackAttack()),
			new MoveSet(new GentlePat(), new Yodel(), new Roast(), new SuperSized()), new MoveSet(new Pinch(), new Harden(), new AwkwardSilence(), new UnderwearAttack()),
			new MoveSet(new LovingEmbrace(), new Harden(), new AwkwardSilence(), new ShirtStorm()), new MoveSet(new Nudge(), new Bulge(), new AwkwardSilence(), new Type1()),  
			new MoveSet(new LovingEmbrace(), new Bulge(), new AwkwardSilence(), new InsulinShot()), new MoveSet(new Push(), new Yodel(), new Roast(), new Xy()),
			new MoveSet(new Pinch(), new Yodel(), new Roast(), new Xx()), new MoveSet(new LovingEmbrace(), new Yodel(), new Roast(), new Xxx()), 
			new MoveSet(new Flick(), new Drank(), new Squint(), new Wut()), new MoveSet(new LovingEmbrace(), new Drank(), new Squint(), new Wuuuuut()), 
			new MoveSet(new Flick(), new Harden(), new Roast(), new RecklessDriving()), new MoveSet(new GentlePat(), new Harden(), new Roast(), new Manslaughter()),
			new MoveSet(new Jab(), new Harden(), new AwkwardSilence(), new Nibble()), new MoveSet(new Nudge(), new Harden(), new AwkwardSilence(), new Bite()), 
			new MoveSet(new GentlePat(), new Harden(), new AwkwardSilence(), new Chomp()), new MoveSet(new LovingEmbrace(), new Yodel(), new Squint(), new Stank())};
			while(scan.hasNextLine()) {
			line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			String[] values = lineScan.nextLine().split("\t");
			Pikumen poke = new Pikumen(values[0], new Image(values[1]), Integer.parseInt(values[2]),
					Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]),
					Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]), 
					Integer.parseInt(values[9]), moves[i], Integer.parseInt(values[10]), Integer.parseInt(values[11]), i);
			pokes.add(poke);	
			i++;
		}	
			pokes.set(23, new punctuation());
				
			
	}
	
	public Pikumen get(int index){ 
		return pokes.get(index);
	}
	
	
}
