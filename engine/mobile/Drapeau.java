package engine.mobile;

import engine.map.Case;

public class Drapeau extends Piece{
	private Boolean captured = false;
	public Drapeau(String nom, Case pos, int rang, int player) {
		super(nom, pos, rang, player);
		// TODO Auto-generated constructor stub
	}
	public boolean isCaptured() {
		return captured;
	}
	public void setCaptured(Boolean captured) {
		this.captured=captured;
	}
	public boolean isFlagCaptured(Drapeau d) {
		if((d != null) && isCaptured() == false ) {
			return false;
		}
		else {
			return true;
		}
	}
}
