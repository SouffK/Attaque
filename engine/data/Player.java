package engine.data;

import engine.map.Plateau;

public class Player {
	 private String name;
	    private Plateau map;
	    private int joueur;

	    public Player(String name, Plateau map, int joueur) {
	        this.name = name;
	        this.map = map;
	        this.joueur = joueur;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getJoueur() {
	        return joueur;
	    }
	
}
