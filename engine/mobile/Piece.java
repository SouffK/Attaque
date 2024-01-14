package engine.mobile;

import engine.map.Case;

public class Piece {
	private int rang;
	private Case pos;
	private String nom;
	private int player;

	public Piece(String nom, Case pos, int rang, int player) {
		this.pos = pos;
		this.rang=rang;
		this.nom=nom;
		this.player=player;
	}

	public Case getPos() {
		return pos;
	}
	public String getNom() {
		return nom;
	}
	public int getRang() {
		return rang;
	}

	public void setPos(Case pos) {
		this.pos = pos;
	}

	public int getPlayer() {
		return player;
	}
	
	public boolean isMineTerrestre(Piece p) {
		if(p.getRang()==-5 && p.getNom().equalsIgnoreCase("Mine")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isMarechal(Piece p) {
		if(p.getRang()==9 && p.getNom().equalsIgnoreCase("marechal")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDrapeau(Piece p) {
		if(p.getRang()==0 && p.getNom().equalsIgnoreCase("Drapeau")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isIngenieur(Piece p) {
		if(p.getRang()==1 && p.getNom().equalsIgnoreCase("ingenieur")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isBombe(Piece p) {
		if(p.getRang()==-5 && p.getNom().equalsIgnoreCase("bombe")) {
			return true;
		}
		else {
			return false;
		}
	}

}
