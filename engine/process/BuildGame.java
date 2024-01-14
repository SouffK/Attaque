package engine.process;


import org.apache.log4j.Logger;

import IA.SetPionsIA;
import configuration.GameConfiguration;
import engine.map.Case;
import engine.map.Plateau;
import engine.mobile.Bateau;
import log.LoggerUtility;

public class BuildGame {
	private static Logger logger = LoggerUtility.getLogger(BuildGame.class, "html");

	
	public static Plateau buildMap() {
		logger.info("Map creation with value in line : " + GameConfiguration.LINE_COUNT + " and in colomn : "+ GameConfiguration.COLUMN_COUNT);
		return new Plateau(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}
	public static MoveAndActionPiece buildInitMobile(Plateau map, SetMapP1 setp1, SetMapP2 setp2, SetPionsIA setIa) {
		MoveAndActionPiece manager = new MoveAndActionPiece(map, setp1, setp2, setIa);
		intializeBateauP1(map, manager);
		intializeBateauP2(map, manager);
		return manager;
	}
	
	private static void intializeBateauP1(Plateau map, MoveAndActionPiece manager) {
		Case block = map.getCase(GameConfiguration.LINE_COUNT - 25, (GameConfiguration.COLUMN_COUNT - 12));
		Bateau bateau = new Bateau("Bateau", block, -10, 1);
		logger.info("Bateau du joueur 1 create set in line : " + (GameConfiguration.LINE_COUNT - 1) + " and in colomn : "+ (GameConfiguration.COLUMN_COUNT - 2));

		manager.setBateau(bateau);
	}
	
	private static void intializeBateauP2(Plateau map, MoveAndActionPiece manager) {
		Case block = map.getCase(GameConfiguration.LINE_COUNT - 1, (GameConfiguration.COLUMN_COUNT - 2));
		Bateau bateaup2 = new Bateau("Bateau", block, -10, 2);
		logger.info("Bateau du joueur 2 create set in line : " + (GameConfiguration.LINE_COUNT - 25) + " and in colomn : "+ (GameConfiguration.COLUMN_COUNT - 12));

		manager.setBateau2(bateaup2);
	}
	
	
}


