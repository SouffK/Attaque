package engine.map;

import engine.mobile.Piece;

public class Case {
	private Piece piece;
	private int lignes;
	private int colomnes;
	private boolean isOccuped;
	public Case(int lignes, int colomnes, boolean isOccuped) {
		this.lignes = lignes;
		this.colomnes = colomnes;
		this.isOccuped=isOccuped;
	}
	public int getLignes() {
		return lignes;
	}
	public int getColomnes() {
		return colomnes;
	}
	
	public boolean isOccuped() {
		return isOccuped;
	}
	public void setOccuped(boolean isOccuped) {
		this.isOccuped = isOccuped;
	}
	@Override
	public String toString() {
		return "Case [lignes=" + lignes + ", colomnes=" + colomnes + ", nom= " + piece.getNom() + ", joueur : " + piece.getPlayer() + "]";
	}
	public Piece getPiece(){
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
}
