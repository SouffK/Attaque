package engine.process;

import java.util.ArrayList;
import java.util.List;

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

public class SetMapP2 {
	private static Logger logger = LoggerUtility.getLogger(MoveAndActionPiece.class, "html");
	private Marechal marP2 = null;
	private Drapeau drapeauP2 = null;
	private MinesTerrestres minesP2 = null;
	private MinesTerrestres mines2P2 = null;
	private MinesTerrestres mines3P2 = null;
	private General generalP2 = null;
	private GenerauxDeDivision gddP2 = null;
	private GenerauxDeDivision gdd2P2 = null;
	private Brigadier brigadierP2 = null;
	private Brigadier brigadier2P2 = null;
	private Colonel colonelP2 = null;
	private Colonel colonel2P2 = null;
	private Commandant commandantP2 = null;
	private Commandant commandant2P2 = null;
	private Capitaine capitaineP2 = null;
	private Capitaine capitaine2P2 = null;
	private Capitaine capitaine3P2 = null;
	private Lieutenant lieutenantP2 = null;
	private Lieutenant lieutenant2P2 = null;
	private Lieutenant lieutenant3P2 = null;
	private Ingenieur ingenieurP2 = null;
	private Ingenieur ingenieur2P2 = null;
	private Ingenieur ingenieur3P2 = null;
	private Bombe bombP2 = null;
	private Bombe bomb2P2 = null;
	private ArrayList<Piece> piecesP2 = new ArrayList<Piece>(); 
	private Plateau map;
	private MoveAndActionPiece manager;
	public SetMapP2(Plateau map, MoveAndActionPiece manager) {
		this.map=map;
		this.manager=manager;
	}
	
	public void putMarechalP2(Case position) {
		if(marP2 == null && position.isOccuped() == false) {
			marP2 = new Marechal("Marechal", position, 9, 2);
			piecesP2.add(marP2);
			position.setOccuped(true);
			position.setPiece(marP2);
			logger.info("Pion add in board : " + marP2.getNom());
		}
	}
	public void putDrapeauP2(Case position) {
		if(drapeauP2 == null && position.isOccuped() == false) {
			drapeauP2 = new Drapeau("Drapeau", position, 0, 2);
			piecesP2.add(drapeauP2);
			position.setOccuped(true);
			position.setPiece(drapeauP2);
			logger.info("Pion add in board : " + drapeauP2.getNom());
		}

	}
	public void putMineP2(Case position) {
		if(minesP2 == null && position.isOccuped() == false) {
			minesP2 = new MinesTerrestres("Mine", position, -5, 2);
			piecesP2.add(minesP2);
			position.setOccuped(true);
			position.setPiece(minesP2);
			logger.info("Pion add in board : " + minesP2.getNom());
		}
		if(mines2P2 == null && position.isOccuped() == false) {
			mines2P2 = new MinesTerrestres("Mine", position, -5, 2);
			piecesP2.add(mines2P2);
			position.setOccuped(true);
			position.setPiece(mines2P2);
			logger.info("Pion add in board : " + mines2P2.getNom());
		}
		if(mines3P2 == null && position.isOccuped() == false) {
			mines3P2 = new MinesTerrestres("Mine", position, -5, 2);
			piecesP2.add(mines3P2);
			position.setOccuped(true);
			position.setPiece(mines3P2);
			logger.info("Pion add in board : " + mines3P2.getNom());
		}
	}
	public void putGeneralP2(Case position) {
		if(generalP2 == null && position.isOccuped() == false) {
			generalP2 = new General("general", position, 8, 2);
			piecesP2.add(generalP2);
			position.setOccuped(true);
			position.setPiece(generalP2);
			generalP2.setPos(position);
			logger.info("Pion add in board : " + generalP2.getNom());
		}
	}
	public void putGDDP2(Case position) {
		if(gddP2 == null && position.isOccuped() == false) {
			gddP2 = new GenerauxDeDivision("GDD", position, 7, 2);
			piecesP2.add(gddP2);
			position.setOccuped(true);
			position.setPiece(gddP2);
			logger.info("Pion add in board : " + gddP2.getNom());
		}
		if(gdd2P2 == null && position.isOccuped() == false) {
			gdd2P2 = new GenerauxDeDivision("GDD", position, 7, 2);
			piecesP2.add(gdd2P2);
			position.setOccuped(true);
			position.setPiece(gdd2P2);
			logger.info("Pion add in board : " + gdd2P2.getNom());
		}

	}
	public void putBrigadierP2(Case position) {
		if(brigadierP2 == null && position.isOccuped() == false) {
			brigadierP2 = new Brigadier("Brigadier", position, 6, 2);
			piecesP2.add(brigadierP2);
			position.setOccuped(true);
			position.setPiece(brigadierP2);
			logger.info("Pion add in board : " + brigadierP2.getNom());
		}
		if(brigadier2P2 == null && position.isOccuped() == false) {
			brigadier2P2 = new Brigadier("Brigadier", position, 6, 2);
			piecesP2.add(brigadier2P2);
			position.setOccuped(true);
			position.setPiece(brigadier2P2);
			logger.info("Pion add in board : " + brigadier2P2.getNom());
		}
	}
	public void putColonelP2(Case position) {
		if(colonelP2 == null && position.isOccuped() == false) {
			colonelP2 = new Colonel("colonel", position, 5, 2);
			piecesP2.add(colonelP2);
			position.setOccuped(true);
			position.setPiece(colonelP2);
			logger.info("Pion add in board : " + colonelP2.getNom());
		}
		if(colonel2P2 == null && position.isOccuped() == false) {
			colonel2P2 = new Colonel("colonel", position, 5, 2);
			piecesP2.add(colonel2P2);
			position.setOccuped(true);
			position.setPiece(colonel2P2);
			logger.info("Pion add in board : " + colonel2P2.getNom());
		}
	}
	public void putCommandantP2(Case position) {
		if(commandantP2 == null && position.isOccuped() == false) {
			commandantP2 = new Commandant("Commandant", position, 4, 2);
			piecesP2.add(commandantP2);
			position.setOccuped(true);
			position.setPiece(commandantP2);
			logger.info("Pion add in board : " + commandantP2.getNom());
		}
		if(commandant2P2 == null && position.isOccuped() == false) {
			commandant2P2 = new Commandant("Commandant", position, 4, 2);
			piecesP2.add(commandant2P2);
			position.setOccuped(true);
			position.setPiece(commandant2P2);
			logger.info("Pion add in board : " + commandant2P2.getNom());
		}
	}
	public void putCapitaineP2(Case position) {
		if(capitaineP2 == null && position.isOccuped() == false) {
			capitaineP2 = new Capitaine("capitaine", position, 3, 2);
			piecesP2.add(capitaineP2);
			position.setOccuped(true);
			position.setPiece(capitaineP2);
			logger.info("Pion add in board : " + capitaineP2.getNom());
		}
		if(capitaine2P2 == null && position.isOccuped() == false) {
			capitaine2P2 = new Capitaine("capitaine", position, 3, 2);
			piecesP2.add(capitaine2P2);
			position.setOccuped(true);
			position.setPiece(capitaine2P2);
			logger.info("Pion add in board : " + capitaine2P2.getNom());
		}
		if(capitaine3P2 == null && position.isOccuped() == false) {
			capitaine3P2 = new Capitaine("capitaine", position, 3, 2);
			piecesP2.add(capitaine3P2);
			position.setOccuped(true);
			position.setPiece(capitaine3P2);
			logger.info("Pion add in board : " + capitaine3P2.getNom());
		}
	}
	public void putLieutenantP2(Case position) {
		if(lieutenantP2 == null && position.isOccuped() == false) {
			lieutenantP2 = new Lieutenant("lieutenant", position, 2, 2);
			piecesP2.add(lieutenantP2);
			position.setOccuped(true);
			position.setPiece(lieutenantP2);
			logger.info("Pion add in board : " + lieutenantP2.getNom());
		}
		if(lieutenant2P2 == null && position.isOccuped() == false) {
			lieutenant2P2 = new Lieutenant("lieutenant", position, 2, 2);
			piecesP2.add(lieutenant2P2);
			position.setOccuped(true);
			position.setPiece(lieutenant2P2);
			logger.info("Pion add in board : " + lieutenant2P2.getNom());
		}
		if(lieutenant3P2 == null && position.isOccuped() == false) {
			lieutenant3P2 = new Lieutenant("lieutenant", position, 2, 2);
			piecesP2.add(lieutenant3P2);
			position.setOccuped(true);
			position.setPiece(lieutenant3P2);
			logger.info("Pion add in board : " + lieutenant3P2.getNom());
		}
	}

	public void putIngenieurP2(Case position) {
		if(ingenieurP2 == null && position.isOccuped() == false) {
			ingenieurP2 = new Ingenieur("ingenieur", position, 1, 2);
			piecesP2.add(ingenieurP2);
			position.setOccuped(true);
			position.setPiece(ingenieurP2);
			logger.info("Pion add in board : " + ingenieurP2.getNom());

		}
		if(ingenieur2P2 == null && position.isOccuped() == false) {
			ingenieur2P2 = new Ingenieur("ingenieur", position, 1, 2);
			piecesP2.add(ingenieur2P2);
			position.setOccuped(true);
			position.setPiece(ingenieur2P2);
			logger.info("Pion add in board : " + ingenieur2P2.getNom());

		}
		if(ingenieur3P2 == null && position.isOccuped() == false) {
			ingenieur3P2 = new Ingenieur("ingenieur", position, 1, 2);
			piecesP2.add(ingenieur3P2);
			position.setOccuped(true);
			position.setPiece(ingenieur3P2);
			logger.info("Pion add in board : " + ingenieur3P2.getNom());

		}
	}
	public void putBombP2(Case position) {
		if(bombP2 == null && position.isOccuped() == false) {
			bombP2 = new Bombe("bombe", position, -5, 2);
			piecesP2.add(bombP2);
			position.setOccuped(true);
			position.setPiece(bombP2);
			logger.info("Pion add in board : " + bombP2.getNom());
		}
		if(bomb2P2 == null && position.isOccuped() == false) {
			bomb2P2 = new Bombe("bombe", position, -5, 2);
			piecesP2.add(bomb2P2);
			position.setOccuped(true);
			position.setPiece(bomb2P2);
			logger.info("Pion add in board : " + bomb2P2.getNom());
		}
	}

	public static Logger getLogger() {
		return logger;
	}
	
	public Marechal getMarP2() {
		return marP2;
	}

	public Marechal getMarechalP2() {
		return marP2;
	}

	public GenerauxDeDivision getGddP2() {
		return gddP2;
	}
	public GenerauxDeDivision getGdd2P2() {
		return gdd2P2;
	}

	public Commandant getCommandantP2() {
		return commandantP2;
	}
	public Commandant getCommandant2P2() {
		return commandant2P2;
	}

	public Colonel getColonelP2() {
		return colonelP2;
	}
	public Colonel getColonel2P2() {
		return colonel2P2;
	}

	public Brigadier getBrigadierP2() {
		return brigadierP2;
	}
	public Brigadier getBrigadier2P2() {
		return brigadier2P2;
	}

	public Capitaine getCapitaineP2() {
		return capitaineP2;
	}
	public Capitaine getCapitaine2P2() {
		return capitaine2P2;
	}
	public Capitaine getCapitaine3P2() {
		return capitaine3P2;
	}

	public General getGeneralP2() {
		return generalP2;
	}

	public Drapeau getDrapeauP2() {
		return drapeauP2;
	}

	public Bombe getBombP2() {
		return bombP2;
	}
	public Bombe getBomb2P2() {
		return bomb2P2;
	}

	public Ingenieur getIngenieurP2() {
		return ingenieurP2;
	}
	public Ingenieur getIngenieur2P2() {
		return ingenieur2P2;
	}
	public Ingenieur getIngenieur3P2() {
		return ingenieur3P2;
	}

	public Lieutenant getLieutenantP2() {
		return lieutenantP2;
	}
	public Lieutenant getLieutenant2P2() {
		return lieutenant2P2;
	}
	public Lieutenant getLieutenant3P2() {
		return lieutenant3P2;
	}

	public MinesTerrestres getMineP2() {
		return minesP2;
	}
	public MinesTerrestres getMine2P2() {
		return mines2P2;
	}
	public MinesTerrestres getMine3P2() {
		return mines3P2;
	}

	public ArrayList<Piece> getPiecesP2() {
		return piecesP2;
	}

}
