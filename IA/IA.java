package IA;

import engine.data.Player;
import engine.map.Case;
import engine.map.Plateau;
import engine.mobile.Piece;
import engine.process.MoveAndActionPiece;

public class IA extends Player {
	private MoveAndActionPiece manager;
	public IA(String name, Plateau map, int joueur, MoveAndActionPiece manager) {
		super(name, map, joueur);
		this.manager=manager;
		// TODO Auto-generated constructor stub
	}

}
