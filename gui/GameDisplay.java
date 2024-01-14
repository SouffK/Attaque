package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import IA.SetPionsIA;
import configuration.GameConfiguration;
import engine.map.Case;
import engine.map.Plateau;
import engine.mobile.Bateau;
import engine.mobile.Bombe;
import engine.mobile.Brigadier;
import engine.mobile.Canon;
import engine.mobile.Capitaine;
import engine.mobile.Colonel;
import engine.mobile.Commandant;
import engine.mobile.Drapeau;
import engine.mobile.General;
import engine.mobile.GenerauxDeDivision;
import engine.mobile.Ingenieur;
import engine.mobile.Lieutenant;
import engine.mobile.Marechal;
import engine.mobile.MinesTerrestres;
import engine.mobile.Piece;
import engine.process.MoveAndActionPiece;
import engine.process.SetMapP1;
import engine.process.SetMapP2;

public class GameDisplay extends JPanel{
	private SetMapP1 set;
	private SetMapP2 setP2;
	private SetPionsIA setIA;
	private Plateau plateau;
	private MoveAndActionPiece manager;
	private PaintPlateau paintPlateau = new PaintPlateau();
	public GameDisplay(Plateau p, MoveAndActionPiece manager, SetMapP1 set, SetMapP2 setP2, SetPionsIA setIA ) {
		this.plateau=p;
		this.manager=manager;
		this.set=set;
		this.setP2 =setP2;
		this.setIA=setIA;

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPlateau.paint(plateau, g);
		Bateau bateau = manager.getBateau();
		paintPlateau.paint(bateau, g);
		Bateau bateau2 = manager.getBateau2();
		paintPlateau.paint(bateau2, g);
		
		Marechal mar = set.getMarechal();
		if( mar != null) {
			paintPlateau.paint(mar, g);
		}
		
		Drapeau drapeau = set.getDrapeau();
		if(drapeau != null) {
			paintPlateau.paint(drapeau, g);
		}
		Bombe bomb = set.getBomb();
		if(bomb != null) {
			paintPlateau.paint(bomb, g);
		}
		Bombe bomb2 = set.getBomb2();
		if(bomb2 != null) {
			paintPlateau.paint(bomb2, g);
		}
		MinesTerrestres mine = set.getMine();
		if ( mine != null) {
			paintPlateau.paint(mine, g);
		}
		MinesTerrestres mine2 = set.getMine2();
		if ( mine2 != null) {
			paintPlateau.paint(mine2, g);
		}
		MinesTerrestres mine3 = set.getMine3();
		if ( mine3 != null) {
			paintPlateau.paint(mine3, g);
		}
		General general = set.getGeneral();
		if ( general != null) {
			paintPlateau.paint(general, g);
		}
		
		GenerauxDeDivision gdd = set.getGdd();
		if ( gdd != null) {
			paintPlateau.paint(gdd, g);
		}
		GenerauxDeDivision gdd2 = set.getGdd2();
		if ( gdd2 != null) {
			paintPlateau.paint(gdd2, g);
		}
		
		Brigadier brigadier = set.getBrigadier();
		if( brigadier != null) {
			paintPlateau.paint(brigadier, g);
		}
		Brigadier brigadier2 = set.getBrigadier2();
		if( brigadier2 != null) {
			paintPlateau.paint(brigadier2, g);
		}
		Colonel colonel = set.getColonel();
		if( colonel != null) {
			paintPlateau.paint(colonel, g);
		}
		Colonel colonel2 = set.getColonel2();
		if( colonel2 != null) {
			paintPlateau.paint(colonel2, g);
		}
		
		Commandant commandant = set.getCommandant();
		if(commandant != null) {
			paintPlateau.paint(commandant, g);
		}
		Commandant commandant2 = set.getCommandant2();
		if(commandant2 != null) {
			paintPlateau.paint(commandant2, g);
		}
		Capitaine capitaine = set.getCapitaine();
		if(capitaine != null) {
			paintPlateau.paint(capitaine, g);
		}
		Capitaine capitaine2 = set.getCapitaine2();
		if(capitaine2 != null) {
			paintPlateau.paint(capitaine2, g);
		}
		Capitaine capitaine3 = set.getCapitaine3();
		if(capitaine3 != null) {
			paintPlateau.paint(capitaine3, g);
		}
		Lieutenant lieutenant = set.getLieutenant();
		if( lieutenant != null) {
			paintPlateau.paint(lieutenant, g);
		}

		Lieutenant lieutenant2 = set.getLieutenant2();
		if( lieutenant2 != null) {
			paintPlateau.paint(lieutenant2, g);
		}
		Lieutenant lieutenant3 = set.getLieutenant3();
		if( lieutenant3 != null) {
			paintPlateau.paint(lieutenant3, g);
		}
		Ingenieur ingenieur = set.getIngenieur();
		if (ingenieur != null) {
			paintPlateau.paint(ingenieur, g);
		}
		Ingenieur ingenieur2 = set.getIngenieur2();
		if (ingenieur2 != null) {
			paintPlateau.paint(ingenieur2, g);
		}
		Ingenieur ingenieur3 = set.getIngenieur3();
		if (ingenieur3 != null) {
			paintPlateau.paint(ingenieur3, g);
		}

		//PLAYER2
		Marechal marP2 = setP2.getMarechalP2();
		if( marP2 != null) {
			paintPlateau.paint(marP2, g);
		}
		
		Drapeau drapeauP2 = setP2.getDrapeauP2();
		if(drapeauP2 != null) {
			paintPlateau.paint(drapeauP2, g);

		}
		Bombe bombP2 = setP2.getBombP2();
		if(bombP2 != null) {
			paintPlateau.paint(bombP2, g);
		}
		Bombe bomb2P2 = setP2.getBomb2P2();
		if(bomb2P2 != null) {
			paintPlateau.paint(bomb2P2, g);
		}
		MinesTerrestres mineP2 = setP2.getMineP2();
		if ( mineP2 != null) {
			paintPlateau.paint(mineP2, g);
		}
		MinesTerrestres mine2P2 = setP2.getMine2P2();
		if ( mine2P2 != null) {
			paintPlateau.paint(mine2P2, g);
		}
		MinesTerrestres mine3P2 = setP2.getMine3P2();
		if ( mine3P2 != null) {
			paintPlateau.paint(mine3P2, g);
		}
		General generalP2 = setP2.getGeneralP2();
		if ( generalP2 != null) {
			paintPlateau.paint(generalP2, g);

		}
		
		GenerauxDeDivision gddP2 = setP2.getGddP2();
		if ( gddP2 != null) {
			paintPlateau.paint(gddP2, g);
	
		}
		GenerauxDeDivision gdd2P2 = setP2.getGdd2P2();
		if ( gdd2P2 != null) {
			paintPlateau.paint(gdd2P2, g);
		}
		
		Brigadier brigadierP2 = setP2.getBrigadierP2();
		if( brigadierP2 != null) {
			paintPlateau.paint(brigadierP2, g);

		}
		Brigadier brigadier2P2 = setP2.getBrigadier2P2();
		if( brigadier2P2 != null) {
			paintPlateau.paint(brigadier2P2, g);

		}
		Colonel colonelP2 = setP2.getColonelP2();
		if( colonelP2 != null) {
			paintPlateau.paint(colonelP2, g);

		}
		Colonel colonel2P2 = setP2.getColonel2P2();
		if( colonel2P2 != null) {
			paintPlateau.paint(colonel2P2, g);

		}
		
		Commandant commandantP2 = setP2.getCommandantP2();
		if(commandantP2 != null) {
			paintPlateau.paint(commandantP2, g);

		}
		Commandant commandant2P2 = setP2.getCommandant2P2();
		if(commandant2P2 != null) {
			paintPlateau.paint(commandant2P2, g);

		}
		Capitaine capitaineP2 = setP2.getCapitaineP2();
		if(capitaineP2 != null) {
			paintPlateau.paint(capitaineP2, g);

		}
		Capitaine capitaine2P2 = setP2.getCapitaine2P2();
		if(capitaine2P2 != null) {
			paintPlateau.paint(capitaine2P2, g);

		}
		Capitaine capitaine3P2 = setP2.getCapitaine3P2();
		if(capitaine3P2 != null) {
			paintPlateau.paint(capitaine3P2, g);
		

		}
		Lieutenant lieutenantP2 = setP2.getLieutenantP2();
		if( lieutenantP2 != null) {
			paintPlateau.paint(lieutenantP2, g);

		}
		Lieutenant lieutenant2P2 = setP2.getLieutenant2P2();
		if( lieutenant2P2 != null) {
			paintPlateau.paint(lieutenant2P2, g);

		}
		Lieutenant lieutenant3P2 = setP2.getLieutenant3P2();
		if( lieutenant3P2 != null) {
			paintPlateau.paint(lieutenant3P2, g);

		}
		Ingenieur ingenieurP2 = setP2.getIngenieurP2();
		if (ingenieurP2 != null) {
			paintPlateau.paint(ingenieurP2, g);

		}
		Ingenieur ingenieur2P2 = setP2.getIngenieur2P2();
		if (ingenieur2P2 != null) {
			paintPlateau.paint(ingenieur2P2, g);

		}
		Ingenieur ingenieur3P2 = setP2.getIngenieur3P2();
		if (ingenieur3P2 != null) {
			paintPlateau.paint(ingenieur3P2, g);
		}
		
		// PlayerIA
		
		Marechal marIA = setIA.getMarechalIA();
		if( marIA != null) {
			paintPlateau.paint(marIA, g);
		}
		
		Drapeau drapeauIA = setIA.getDrapeauIA();
		if(drapeauIA != null) {
			paintPlateau.paint(drapeauIA, g);

		}
		Bombe bombIA = setIA.getBombIA();
		if(bombIA != null) {
			paintPlateau.paint(bombIA, g);
		}
		Bombe bomb2IA = setIA.getBomb2IA();
		if(bomb2IA != null) {
			paintPlateau.paint(bomb2IA, g);
		}
		MinesTerrestres mineIA = setIA.getMineIA();
		if ( mineIA != null) {
			paintPlateau.paint(mineIA, g);
		}
		MinesTerrestres mine2IA = setIA.getMine2IA();
		if ( mine2IA != null) {
			paintPlateau.paint(mine2IA, g);
		}
		MinesTerrestres mine3IA = setIA.getMine3IA();
		if ( mine3IA != null) {
			paintPlateau.paint(mine3IA, g);
		}
		General generalIA = setIA.getGeneralIA();
		if ( generalIA != null) {
			paintPlateau.paint(generalIA, g);

		}
		
		GenerauxDeDivision gddIA = setIA.getGddIA();
		if ( gddIA != null) {
			paintPlateau.paint(gddIA, g);
	
		}
		GenerauxDeDivision gdd2IA = setIA.getGdd2IA();
		if ( gdd2IA != null) {
			paintPlateau.paint(gdd2IA, g);
		}
		
		Brigadier brigadierIA = setIA.getBrigadierIA();
		if( brigadierIA != null) {
			paintPlateau.paint(brigadierIA, g);

		}
		Brigadier brigadier2IA = setIA.getBrigadier2IA();
		if( brigadier2IA != null) {
			paintPlateau.paint(brigadier2IA, g);

		}
		Colonel colonelIA = setIA.getColonelIA();
		if( colonelIA != null) {
			paintPlateau.paint(colonelIA, g);

		}
		Colonel colonel2IA = setIA.getColonel2IA();
		if( colonel2IA != null) {
			paintPlateau.paint(colonel2IA, g);

		}
		
		Commandant commandantIA = setIA.getCommandantIA();
		if(commandantIA != null) {
			paintPlateau.paint(commandantIA, g);

		}
		Commandant commandant2IA = setIA.getCommandant2IA();
		if(commandant2IA != null) {
			paintPlateau.paint(commandant2IA, g);

		}
		Capitaine capitaineIA = setIA.getCapitaineIA();
		if(capitaineIA != null) {
			paintPlateau.paint(capitaineIA, g);

		}
		Capitaine capitaine2IA = setIA.getCapitaine2IA();
		if(capitaine2IA != null) {
			paintPlateau.paint(capitaine2IA, g);

		}
		Capitaine capitaine3IA = setIA.getCapitaine3IA();
		if(capitaine3IA != null) {
			paintPlateau.paint(capitaine3IA, g);
		

		}
		Lieutenant lieutenantIA = setIA.getLieutenantIA();
		if( lieutenantIA != null) {
			paintPlateau.paint(lieutenantIA, g);

		}
		Lieutenant lieutenant2IA = setIA.getLieutenant2IA();
		if( lieutenant2IA != null) {
			paintPlateau.paint(lieutenant2IA, g);

		}
		Lieutenant lieutenant3IA = setIA.getLieutenant3IA();
		if( lieutenant3IA != null) {
			paintPlateau.paint(lieutenant3IA, g);

		}
		Ingenieur ingenieurIA = setIA.getIngenieurIA();
		if (ingenieurIA != null) {
			paintPlateau.paint(ingenieurIA, g);

		}
		Ingenieur ingenieur2IA = setIA.getIngenieur2IA();
		if (ingenieur2IA != null) {
			paintPlateau.paint(ingenieur2IA, g);

		}
		Ingenieur ingenieur3IA = setIA.getIngenieur3IA();
		if (ingenieur3IA != null) {
			paintPlateau.paint(ingenieur3IA, g);
		}
		for (Canon canon : manager.getCanons()) {
			
		}

	}
	
	public Case getPiece(int x, int y) {
		int line = y / GameConfiguration.BLOCK_SIZE;
		int column = x / GameConfiguration.BLOCK_SIZE;
		return plateau.getCase(line, column);
	}

}