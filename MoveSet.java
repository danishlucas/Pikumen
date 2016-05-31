package main;
import java.util.*;

public class MoveSet {
	private Move[] moves;
	public MoveSet(Move a, Move b, Move c, Move d){
		moves = new Move[4];
		moves[0] = a;
		moves[1] = b;
		moves[2] = c;
		moves[3] = d;
	}
	
	public Move[] getMoveSet(){
		return moves;
	}
}
