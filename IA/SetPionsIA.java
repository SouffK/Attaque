package IA;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

import engine.map.Case;
import engine.map.Plateau;
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
import engine.process.MoveAndActionPiece;
import log.LoggerUtility;

public class SetPionsIA {
	private static Logger logger = LoggerUtility.getLogger(MoveAndActionPiece.class, "html");
	private Marechal marIA = null ;
	private Drapeau drapeauIA = null ;
	private MinesTerrestres minesIA = null ;
	private MinesTerrestres mines2IA = null ;
	private MinesTerrestres mines3IA = null ;
	private General generalIA = null ;
	private GenerauxDeDivision gddIA = null ;
	private GenerauxDeDivision gdd2IA = null ;
	private Brigadier brigadierIA = null ;
	private Brigadier brigadier2IA = null ;
	private Colonel colonelIA = null ;
	private Colonel colonel2IA = null ;
	private Commandant commandantIA = null ;
	private Commandant commandant2IA = null ;
	private Capitaine capitaineIA = null ;
	private Capitaine capitaine2IA = null ;
	private Capitaine capitaine3IA = null ;
	private Lieutenant lieutenantIA = null ;
	private Lieutenant lieutenant2IA = null ;
	private Lieutenant lieutenant3IA = null ;
	private Ingenieur ingenieurIA = null ;
	private Ingenieur ingenieur2IA = null ;
	private Ingenieur ingenieur3IA = null ;
	private Bombe bombIA = null ;
	private Bombe bomb2IA = null ;
	private ArrayList<Piece> piecesIA = new ArrayList<Piece>(); 
	private Plateau map;
	private MoveAndActionPiece manager;
	public SetPionsIA(Plateau map, MoveAndActionPiece manager) {
		this.map=map;
		this.manager=manager;
	}
	public static int getNombrePair() {
		Random rand = new Random();
		int nombre = rand.nextInt(6) * 2; // génère un nombre entre 0 et 5, puis le double pour obtenir un nombre pair
		return nombre;
	}
	public static int getNombreImpair() {
		Random rand = new Random();
		int nombre = rand.nextInt(5) * 2 + 1; // génère un nombre entre 0 et 4, puis le double et ajoute 1 pour obtenir un nombre impair entre 1 et 9 inclus
		return nombre;
	}
	public void putMarechalIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);
		if(marIA == null && p.isOccuped() == false) {
			Case position = new Case(randomLine, randomColumn, true);
			marIA = new Marechal("Marechal", position, 9, 2);
			piecesIA.add(marIA);
			position.setOccuped(true);
			position.setPiece(marIA);
			logger.info("Pion add in board : " + marIA.getNom());
		}
	}
	public void putDrapeauIA(Plateau map) {
		if(drapeauIA == null) {
			Case position = new Case(0, getRandomNumber(3, 7), true);
			drapeauIA = new Drapeau("Drapeau", position, 0, 2);
			piecesIA.add(drapeauIA);
			position.setOccuped(true);
			position.setPiece(drapeauIA);
			drapeauIA.setCaptured(false);
			logger.info("Pion add in board : " + drapeauIA.getNom());
		}

	}
	public void putMineIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);
		if(minesIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			minesIA = new MinesTerrestres("Mine", position, -5, 2);
			piecesIA.add(minesIA);
			position.setOccuped(true);
			position.setPiece(minesIA);
			logger.info("Pion add in board : " + minesIA.getNom());
		}
		if(mines2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			mines2IA = new MinesTerrestres("Mine", position, -5, 2);
			piecesIA.add(mines2IA);
			position.setOccuped(true);
			position.setPiece(mines2IA);
			logger.info("Pion add in board : " + mines2IA.getNom());
		}
		if(mines3IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			mines3IA = new MinesTerrestres("Mine", position, -5, 2);
			piecesIA.add(mines3IA);
			position.setOccuped(true);
			position.setPiece(mines3IA);
			logger.info("Pion add in board : " + mines3IA.getNom());
		}
	}
	public void putGeneralIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);

		if(generalIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			generalIA = new General("general", position, 8, 2);
			piecesIA.add(generalIA);
			position.setOccuped(true);
			position.setPiece(generalIA);
			generalIA.setPos(position);
			logger.info("Pion add in board : " + generalIA.getNom());
		}
	}
	public void putGDDIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);

		if(gddIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			gddIA = new GenerauxDeDivision("GDD", position, 7, 2);
			piecesIA.add(gddIA);
			position.setOccuped(true);
			position.setPiece(gddIA);
			logger.info("Pion add in board : " + gddIA.getNom());
		}
		if(gdd2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			gdd2IA = new GenerauxDeDivision("GDD", position, 7, 2);
			piecesIA.add(gdd2IA);
			position.setOccuped(true);
			position.setPiece(gdd2IA);
			logger.info("Pion add in board : " + gdd2IA.getNom());
		}

	}
	public void putBrigadierIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);

		if(brigadierIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			brigadierIA = new Brigadier("Brigadier", position, 6, 2);
			piecesIA.add(brigadierIA);
			position.setOccuped(true);
			position.setPiece(brigadierIA);
			logger.info("Pion add in board : " + brigadierIA.getNom());
		}
		if(brigadier2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			brigadier2IA = new Brigadier("Brigadier", position, 6, 2);
			piecesIA.add(brigadier2IA);
			position.setOccuped(true);
			position.setPiece(brigadier2IA);
			logger.info("Pion add in board : " + brigadier2IA.getNom());
		}
	}
	public void putColonelIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);

		if(colonelIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			colonelIA = new Colonel("colonel", position, 5, 2);
			piecesIA.add(colonelIA);
			position.setOccuped(true);
			position.setPiece(colonelIA);
			logger.info("Pion add in board : " + colonelIA.getNom());
		}
		if(colonel2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			colonel2IA = new Colonel("colonel", position, 5, 2);
			piecesIA.add(colonel2IA);
			position.setOccuped(true);
			position.setPiece(colonel2IA);
			logger.info("Pion add in board : " + colonel2IA.getNom());
		}
	}
	public void putCommandantIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);

		if(commandantIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			commandantIA = new Commandant("Commandant", position, 4, 2);
			piecesIA.add(commandantIA);
			position.setOccuped(true);
			position.setPiece(commandantIA);
			logger.info("Pion add in board : " + commandantIA.getNom());
		}
		if(commandant2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			commandant2IA = new Commandant("Commandant", position, 4, 2);
			piecesIA.add(commandant2IA);
			position.setOccuped(true);
			position.setPiece(commandant2IA);
			logger.info("Pion add in board : " + commandant2IA.getNom());
		}
	}
	public void putCapitaineIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);

		if(capitaineIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			capitaineIA = new Capitaine("capitaine", position, 3, 2);
			piecesIA.add(capitaineIA);
			position.setOccuped(true);
			position.setPiece(capitaineIA);
			logger.info("Pion add in board : " + capitaineIA.getNom());
		}
		if(capitaine2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			capitaine2IA = new Capitaine("capitaine", position, 3, 2);
			piecesIA.add(capitaine2IA);
			position.setOccuped(true);
			position.setPiece(capitaine2IA);
			logger.info("Pion add in board : " + capitaine2IA.getNom());
		}
		if(capitaine3IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			capitaine3IA = new Capitaine("capitaine", position, 3, 2);
			piecesIA.add(capitaine3IA);
			position.setOccuped(true);
			position.setPiece(capitaine3IA);
			logger.info("Pion add in board : " + capitaine3IA.getNom());
		}
	}
	public void putLieutenantIA(Case position) {
		if(lieutenantIA == null && position.isOccuped() == false) {
				lieutenantIA = new Lieutenant("lieutenant", position, 2, 2);
				piecesIA.add(lieutenantIA);
				position.setOccuped(true);
				position.setPiece(lieutenantIA);
				logger.info("Pion add in board : " + lieutenantIA.getNom());
			
		}
		if(lieutenant2IA == null && position.isOccuped() == false) {
				lieutenant2IA = new Lieutenant("lieutenant", position, 2, 2);
				piecesIA.add(lieutenant2IA);
				position.setOccuped(true);
				position.setPiece(lieutenant2IA);
				logger.info("Pion add in board : " + lieutenant2IA.getNom() + " " + lieutenant2IA.getPos().isOccuped());
			
		}
		if(lieutenant3IA == null && position.isOccuped() == false) {
				lieutenant3IA = new Lieutenant("lieutenant", position, 2, 2);
				piecesIA.add(lieutenant3IA);
				position.setOccuped(true);
				position.setPiece(lieutenant3IA);
				logger.info("Pion add in board : " + lieutenant3IA.getNom());
			}
		
	}

	public void putIngenieurIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);

		if(ingenieurIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			ingenieurIA = new Ingenieur("ingenieur", position, 1, 2);
			piecesIA.add(ingenieurIA);
			position.setOccuped(true);
			position.setPiece(ingenieurIA);

		}
		if(ingenieur2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			ingenieur2IA = new Ingenieur("ingenieur", position, 1, 2);
			piecesIA.add(ingenieur2IA);
			position.setOccuped(true);
			position.setPiece(ingenieur2IA);

		}
		if(ingenieur3IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			ingenieur3IA = new Ingenieur("ingenieur", position, 1, 2);
			piecesIA.add(ingenieur3IA);
			position.setOccuped(true);
			position.setPiece(ingenieur3IA);

		}
	}
	public void putBombIA(Plateau map) {
		int randomLine = getNombrePair();
		int randomColumn = getNombreImpair();
		Case p = map.getCase(randomLine, randomColumn);
		if(bombIA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			bombIA = new Bombe("bombe", position, -5, 2);
			piecesIA.add(bombIA);
			position.setOccuped(true);
			position.setPiece(bombIA);
			logger.info("Pion add in board : " + bombIA.getNom());
		}
		if(bomb2IA == null && p.isOccuped() == false){
			Case position = new Case(randomLine, randomColumn, true);
			bomb2IA = new Bombe("bombe", position, -5, 2);
			piecesIA.add(bomb2IA);
			position.setOccuped(true);
			position.setPiece(bomb2IA);
			logger.info("Pion add in board : " + bomb2IA.getNom());
		}
	}
	public static int getRandomNumber(int a, int b) {
		Random random = new Random();
		int[] values = {a, b};
		int index = random.nextInt(values.length);
		return values[index];
	}
	public void setIA(Plateau map) {
		putBombIA(map);
		putBrigadierIA(map);
		putCapitaineIA(map);
		putColonelIA(map);
		putCommandantIA(map);
		putDrapeauIA(map);
		putGDDIA(map);
		putGeneralIA(map);
		putIngenieurIA(map);
		putMarechalIA(map);
		putMineIA(map);
		putMineIA(map);
		putMineIA(map);		
	}

	public static Logger getLogger() {
		return logger;
	}

	public Marechal getMarIA() {
		return marIA;
	}

	public Marechal getMarechalIA() {
		return marIA;
	}

	public GenerauxDeDivision getGddIA() {
		return gddIA;
	}
	public GenerauxDeDivision getGdd2IA() {
		return gdd2IA;
	}

	public Commandant getCommandantIA() {
		return commandantIA;
	}
	public Commandant getCommandant2IA() {
		return commandant2IA;
	}

	public Colonel getColonelIA() {
		return colonelIA;
	}
	public Colonel getColonel2IA() {
		return colonel2IA;
	}

	public Brigadier getBrigadierIA() {
		return brigadierIA;
	}
	public Brigadier getBrigadier2IA() {
		return brigadier2IA;
	}

	public Capitaine getCapitaineIA() {
		return capitaineIA;
	}
	public Capitaine getCapitaine2IA() {
		return capitaine2IA;
	}
	public Capitaine getCapitaine3IA() {
		return capitaine3IA;
	}

	public General getGeneralIA() {
		return generalIA;
	}

	public Drapeau getDrapeauIA() {
		return drapeauIA;
	}

	public Bombe getBombIA() {
		return bombIA;
	}
	public Bombe getBomb2IA() {
		return bomb2IA;
	}

	public Ingenieur getIngenieurIA() {
		return ingenieurIA;
	}
	public Ingenieur getIngenieur2IA() {
		return ingenieur2IA;
	}
	public Ingenieur getIngenieur3IA() {
		return ingenieur3IA;
	}

	public Lieutenant getLieutenantIA() {
		return lieutenantIA;
	}
	public Lieutenant getLieutenant2IA() {
		return lieutenant2IA;
	}
	public Lieutenant getLieutenant3IA() {
		return lieutenant3IA;
	}

	public MinesTerrestres getMineIA() {
		return minesIA;
	}
	public MinesTerrestres getMine2IA() {
		return mines2IA;
	}
	public MinesTerrestres getMine3IA() {
		return mines3IA;
	}

	public ArrayList<Piece> getpiecesIA() {
		return piecesIA;
	}
}
