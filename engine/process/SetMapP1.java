package engine.process;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

import org.apache.log4j.Logger;

import engine.map.Case;
import engine.map.Plateau;
import engine.mobile.Bateau;
import engine.mobile.Bombe;
import engine.mobile.Brigadier;
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
import log.LoggerUtility;

public class SetMapP1 {
	private static Logger logger = LoggerUtility.getLogger(MoveAndActionPiece.class, "html");

	private Bateau bateau;
	private Bateau bateau2;
	private Marechal mar = null;
	private Drapeau drapeau = null;
	private MinesTerrestres mines = null;
	private MinesTerrestres mines2 = null;
	private MinesTerrestres mines3 = null;
	private General general = null;
	private GenerauxDeDivision gdd = null;
	private GenerauxDeDivision gdd2 = null;
	private Brigadier brigadier = null;
	private Brigadier brigadier2 = null;
	private Colonel colonel = null;
	private Colonel colonel2 = null;
	private Commandant commandant = null;
	private Commandant commandant2 = null;
	private Capitaine capitaine = null;
	private Capitaine capitaine2 = null;
	private Capitaine capitaine3 = null;
	private Lieutenant lieutenant = null;
	private Lieutenant lieutenant2 = null;
	private Lieutenant lieutenant3 = null;
	private Ingenieur ingenieur = null;
	private Ingenieur ingenieur2 = null;
	private Ingenieur ingenieur3 = null;
	private Bombe bomb = null;
	private Bombe bomb2 = null;
	private ArrayList<Piece> pieces = new ArrayList<Piece>(); 

	private List<Case> CasesFree = new ArrayList<Case>();
	private Plateau map;
	private MoveAndActionPiece manager;
	public SetMapP1(Plateau map,	MoveAndActionPiece manager) {
		this.map = map;
		this.manager=manager;
	}
	
	public static Logger getLogger() {
		return logger;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public Bateau getBateau2() {
		return bateau2;
	}
	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public void setBateau2(Bateau bateau) {
		this.bateau2 = bateau;
	}

	public List<Case> getCasesFree() {
		return CasesFree;
	}

	public Marechal getMarechal() {
		return mar;
	}
	public void setMarechal(Marechal marechal) {
		this.mar = marechal;
	}
	public GenerauxDeDivision getGdd() {
		return gdd;
	}
	public GenerauxDeDivision getGdd2() {
		return gdd2;
	}
	public void setGdd(GenerauxDeDivision gdd) {
		this.gdd = gdd;
	}

	public Commandant getCommandant() {
		return commandant;
	}
	public Commandant getCommandant2() {
		return commandant2;
	}
	public void setCommandant(Commandant commandant) {
		this.commandant = commandant;
	}
	public Colonel getColonel() {
		return colonel;
	}
	public Colonel getColonel2() {
		return colonel2;
	}

	public void setColonel(Colonel colonel) {
		this.colonel = colonel;
	}
	public Brigadier getBrigadier() {
		return brigadier;
	}
	public Brigadier getBrigadier2() {
		return brigadier2;
	}
	public void setBrigadier(Brigadier brigadier) {
		this.brigadier = brigadier;
	}

	public Capitaine getCapitaine() {
		return capitaine;
	}
	public Capitaine getCapitaine2() {
		return capitaine2;
	}
	public Capitaine getCapitaine3() {
		return capitaine3;
	}
	public void setCapitaine(Capitaine capitaine) {
		this.capitaine = capitaine;
	}
	public General getGeneral() {
		return general;
	}
	public void setGeneral(General general) {
		this.general = general;
	}
	public Drapeau getDrapeau() {
		return drapeau;
	}
	public void setDrapeau(Drapeau drapeau) {
		this.drapeau = drapeau;
	}

	public Bombe getBomb() {
		return bomb;
	}
	public Bombe getBomb2() {
		return bomb2;
	}
	public void setBomb(Bombe bomb) {
		this.bomb = bomb;
	}
	public Ingenieur getIngenieur() {
		return ingenieur;
	}
	public Ingenieur getIngenieur2() {
		return ingenieur2;
	}
	public Ingenieur getIngenieur3() {
		return ingenieur3;
	}
	public void setIngenieur(Ingenieur ingenieur) {
		this.ingenieur = ingenieur;
	}
	public Lieutenant getLieutenant() {
		return lieutenant;
	}
	public Lieutenant getLieutenant2() {
		return lieutenant2;
	}
	public Lieutenant getLieutenant3() {
		return lieutenant3;
	}
	public void setLieutenant(Lieutenant lieutenant) {
		this.lieutenant = lieutenant;
	}
	public MinesTerrestres getMine() {
		return mines;
	}
	public MinesTerrestres getMine2() {
		return mines2;
	}
	public MinesTerrestres getMine3() {
		return mines3;
	}
	public void setMine(MinesTerrestres mines) {
		this.mines = mines;
	}
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	private static int getRandomNumber() {
		Random random = new Random();
	    int[] values = {3, 7};
	    int index = random.nextInt(values.length);
	    return values[index];
	}
	public void putMarechalP1(Case position) {
		if(mar == null && position.isOccuped() == false) {
			mar = new Marechal("Marechal", position, 9, 1);
			pieces.add(mar);
			position.setOccuped(true);
			position.setPiece(mar);
			logger.info("Pion add in board : " + mar.getNom());
		}
	}
	public void putDrapeauP1(Case position) {
		if(drapeau == null && position.isOccuped() == false) {
			drapeau = new Drapeau("Drapeau", position, 0, 1);
			pieces.add(drapeau);
			position.setOccuped(true);
			position.setPiece(drapeau);
			logger.info("Pion add in board : " + drapeau.getNom());
		}

	}
	public void putMineP1(Case position) {
		if(mines == null && position.isOccuped() == false) {
			mines = new MinesTerrestres("Mine", position, -5, 1);
			pieces.add(mines);
			position.setOccuped(true);
			position.setPiece(mines);
			logger.info("Pion add in board : " + mines.getNom());
		}
		if(mines2 == null && position.isOccuped() == false) {
			mines2 = new MinesTerrestres("Mine", position, -5, 1);
			pieces.add(mines2);
			position.setOccuped(true);
			position.setPiece(mines2);
			logger.info("Pion add in board : " + mines2.getNom());
		}
		if(mines3 == null && position.isOccuped() == false) {
			mines3 = new MinesTerrestres("Mine", position, -5, 1);
			pieces.add(mines3);
			position.setOccuped(true);
			position.setPiece(mines3);
			logger.info("Pion add in board : " + mines3.getNom());
		}
	}
	public void putGeneralP1(Case position) {
		if(general == null && position.isOccuped() == false) {
			general = new General("general", position, 8, 1);
			pieces.add(general);
			position.setOccuped(true);
			position.setPiece(general);
			logger.info("Pion add in board : " + general.getNom());
		}
	}
	public void putGDDP1(Case position) {
		if(gdd == null && position.isOccuped() == false) {
			gdd = new GenerauxDeDivision("GDD", position, 7, 1);
			pieces.add(gdd);
			position.setOccuped(true);
			position.setPiece(gdd);
			logger.info("Pion add in board : " + gdd.getNom());
		}
		if(gdd2 == null && position.isOccuped() == false) {
			gdd2 = new GenerauxDeDivision("GDD", position, 7, 1);
			pieces.add(gdd2);
			position.setOccuped(true);
			position.setPiece(gdd2);
			logger.info("Pion add in board : " + gdd2.getNom());
		}

	}
	public void putBrigadierP1(Case position) {
		if(brigadier == null && position.isOccuped() == false) {
			brigadier = new Brigadier("Brigadier", position, 6, 1);
			pieces.add(brigadier);
			position.setOccuped(true);
			position.setPiece(brigadier);
			logger.info("Pion add in board : " + brigadier.getNom());
		}
		if(brigadier2 == null && position.isOccuped() == false) {
			brigadier2 = new Brigadier("Brigadier", position, 6, 1);
			pieces.add(brigadier2);
			position.setOccuped(true);
			position.setPiece(brigadier2);
			logger.info("Pion add in board : " + brigadier2.getNom());
		}
	}
	public void putColonelP1(Case position) {
		if(colonel == null && position.isOccuped() == false) {
			colonel = new Colonel("colonel", position, 5, 1);
			pieces.add(colonel);
			position.setOccuped(true);
			position.setPiece(colonel);
			logger.info("Pion add in board : " + colonel.getNom());
		}
		if(colonel2 == null && position.isOccuped() == false) {
			colonel2 = new Colonel("colonel", position, 5, 1);
			pieces.add(colonel2);
			position.setOccuped(true);
			position.setPiece(colonel2);
			logger.info("Pion add in board : " + colonel2.getNom());
		}
	}
	public void putCommandantP1(Case position) {
		if(commandant == null && position.isOccuped() == false) {
			commandant = new Commandant("Commandant", position, 4, 1);
			pieces.add(commandant);
			position.setOccuped(true);
			position.setPiece(commandant);
			logger.info("Pion add in board : " + commandant.getNom());
		}
		if(commandant2 == null && position.isOccuped() == false) {
			commandant2 = new Commandant("Commandant", position, 4, 1);
			pieces.add(commandant2);
			position.setOccuped(true);
			position.setPiece(commandant2);
			logger.info("Pion add in board : " + commandant2.getNom());
		}
	}
	public void putCapitaineP1(Case position) {
		if(capitaine == null && position.isOccuped() == false) {
			capitaine = new Capitaine("capitaine", position, 3, 1);
			pieces.add(capitaine);
			position.setOccuped(true);
			position.setPiece(capitaine);
			logger.info("Pion add in board : " + capitaine.getNom());
		}
		if(capitaine2 == null && position.isOccuped() == false) {
			capitaine2 = new Capitaine("capitaine", position, 3, 1);
			pieces.add(capitaine2);
			position.setOccuped(true);
			position.setPiece(capitaine2);
			logger.info("Pion add in board : " + capitaine2.getNom());
		}
		if(capitaine3 == null && position.isOccuped() == false) {
			capitaine3 = new Capitaine("capitaine", position, 3, 1);
			pieces.add(capitaine3);
			position.setOccuped(true);
			position.setPiece(capitaine3);
			logger.info("Pion add in board : " + capitaine3.getNom());
		}
	}
	public void putLieutenantP1(Case position) {
		int i =0;
		if(lieutenant == null && position.isOccuped() == false) {
			lieutenant = new Lieutenant("lieutenant", position, 2, 1);
			pieces.add(lieutenant);
			i++;
			position.setOccuped(true);
			position.setPiece(lieutenant);
			logger.info("Pion add in board : " + lieutenant.getNom());
		}
		if(lieutenant2 == null && position.isOccuped() == false) {
			lieutenant2 = new Lieutenant("lieutenant", position, 2, 1);
			pieces.add(lieutenant2);
			position.setOccuped(true);
			position.setPiece(lieutenant2);
			i++;
			logger.info("Pion add in board : " + lieutenant2.getNom());
		}
		if(lieutenant3 == null && position.isOccuped() == false) {
			lieutenant3 = new Lieutenant("lieutenant", position, 2, 1);
			pieces.add(lieutenant3);
			position.setOccuped(true);
			position.setPiece(lieutenant3);
			i++;
			logger.info("Pion add in board : " + lieutenant3.getNom());
		}
	}

	public void putIngenieurP1(Case position) {
		if(ingenieur == null && position.isOccuped() == false) {
			ingenieur = new Ingenieur("ingenieur", position, 1, 1);
			pieces.add(ingenieur);
			position.setOccuped(true);
			position.setPiece(ingenieur);
			logger.info("Pion add in board : " + ingenieur.getNom());


		}
		if(ingenieur2 == null && position.isOccuped() == false) {
			ingenieur2 = new Ingenieur("ingenieur", position, 1, 1);
			pieces.add(ingenieur2);
			position.setOccuped(true);
			position.setPiece(ingenieur2);
			logger.info("Pion add in board : " + ingenieur2.getNom());

		}
		if(ingenieur3 == null && position.isOccuped() == false) {
			ingenieur3 = new Ingenieur("ingenieur", position, 1, 1);
			pieces.add(ingenieur3);
			position.setOccuped(true);
			position.setPiece(ingenieur3);
			logger.info("Pion add in board : " + ingenieur3.getNom());

		}
	}
	public void putBombP1(Case position) {
		if(bomb == null && position.isOccuped() == false) {
			bomb = new Bombe("bombe", position, -5, 1);
			pieces.add(bomb);
			position.setOccuped(true);
			position.setPiece(bomb);
			logger.info("Pion add in board : " + bomb.getNom());
		}
		if(bomb2 == null && position.isOccuped() == false) {
			bomb2 = new Bombe("bombe", position, -5, 1);
			pieces.add(bomb2);
			position.setOccuped(true);
			position.setPiece(bomb2);
			logger.info("Pion add in board : " + bomb2.getNom());
		}
	}
}
