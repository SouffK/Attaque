package engine.map;

import java.util.ArrayList;
import java.util.List;

import configuration.GameConfiguration;

public class Plateau {
	private Case[][] cases;
	private int nbLignes;
	private int nbColomnes;
	public Plateau(int nbLignes, int nbColomnes) {
		this.nbLignes = nbLignes;
		this.nbColomnes = nbColomnes;
		cases = new Case[nbLignes][nbColomnes];
		
		for (int i = 0; i < nbLignes; i++) {
			for (int j = 0; j < nbColomnes; j++) {
				cases[i][j] = new Case(i, j, false);
			}
		}
	}
	public Case[][] getCases() {
		return cases;
	}
	public int getNbLignes() {
		return nbLignes;
	}
	public int getNbColomnes() {
		return nbColomnes;
	}
	public Case getCase(int line, int column) {
		return cases[line][column];
	}
	public boolean isOnTop(Case block) {
		int line = block.getLignes();
		return line == 0;
	}

	public boolean isOnBottom(Case block) {
		int line = block.getLignes();
		return line == nbLignes - 1;
	}

	public boolean isOnLeftBorder(Case block) {
		int column = block.getColomnes();
		return column == 0;
	}

	public boolean isOnRightBorder(Case block) {
		int column = block.getColomnes();
		return column == nbColomnes - 1;
	}

	public boolean isOnBorder(Case block) {
		return isOnTop(block) || isOnBottom(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}
	
	public boolean isSea(Case block) {
		int column = block.getColomnes();
		if(column == 0 || column == 10) {
			return true;
		}
		return false;
	}
	
	//Si la case est un campement
		public boolean isCampement(Case block) {
			int row= block.getLignes();
			int cols=block.getColomnes();
			if(((row==4||row==8||row==16||row==20)&&(cols==3 || cols==7))|| ((cols == 5)&& (row == 6 || row == 18))) {
				return true;
			}
			else {
				return false;
			}
		}
		//Si la case est une ligne de front 
		public boolean isLDF(Case block) {
			int row= block.getLignes();
			int cols=block.getColomnes();
			if((row==12) &&(cols==1 || cols==5 || cols==9 )) {
				return true;
			}
			else {
				return false;
			}
		}

		//Si la case est une montagne
		public boolean isMountain(Case block) {
			int row= block.getLignes();
			int cols=block.getColomnes();
			if((row==12)&&(cols==3 || cols==7)) {
				return true;
			}
			else {
				return false;
			}
		}
		//Si la case est un Quartier General
		public boolean isQG(Case block) {
			int row= block.getLignes();
			int cols=block.getColomnes();
			if((row==0 ||row==24)&&(cols==3 || cols==7)) {
				return true;
			}
			else {
				return false;
			}
		}
		//les mines terrestres ne se posent qu'au 5eme et 6eme rang
		public boolean poseMT(Case block) {
			int row= block.getLignes();
			int cols=block.getColomnes();
			if((row==8 ||row== 10 || row == 14  || row == 16 )&&(cols!=0 || cols!=3 || cols!=7 || cols!=10)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		//la case est-elle un chemin de fer?
		public boolean isCDFHor(Case c) {
			int lineindex= c.getLignes();
			int columnindex = c.getColomnes();
			if(((lineindex==2)||(lineindex==10)||(lineindex==14)||(lineindex==22))&&(columnindex%2==0)&&((columnindex!=0)||(columnindex!=10))) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean isInaccesible(Case c) {
			int lineindex= c.getLignes();
			int columnindex = c.getColomnes();
			if((lineindex==1 || lineindex == 11 || lineindex == 13)&&(columnindex==2 || columnindex == 3|| columnindex == 4 || columnindex == 6 || columnindex == 7 || columnindex == 8)) {
				return true;
			}
			else if((lineindex==23)&&(columnindex==2 || columnindex == 4 || columnindex == 6 || columnindex == 7 || columnindex == 8)) {
				return true;
			}
			else if(columnindex == GameConfiguration.COLUMN_COUNT - 1) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean isCDFVer(Case c) {
			int lineindex= c.getLignes();
			int columnindex = c.getColomnes();
			if(((lineindex==3)||(lineindex==5)||(lineindex==7)||(lineindex==9)||(lineindex==15)||(lineindex==17)||(lineindex==19)||(lineindex==21))&&((columnindex==1)||(columnindex==9))) {
				return true;
			}
			else if(((lineindex==11)||(lineindex==13))&&((columnindex==1)||(columnindex==5) || (columnindex==9))) {
				return true;
			}
			else {
				return false;
			}
		}
		//la case est-elle une route?
		public boolean isRoadV(Case c) {
			int lineindex= c.getLignes();
			int columnindex = c.getColomnes();
			if((lineindex==1) &&( columnindex==1 || columnindex == 5 || columnindex == 7 || columnindex == 9 )) {
				return true;
			}
			else if((lineindex==23)&&(columnindex==1 || columnindex == 3 || columnindex == 5 || columnindex == 9)) {
				return true;
			}
			else if((lineindex == 3 || lineindex == 5 || lineindex == 7 || lineindex == 9 || lineindex == 15 || lineindex == 17 || lineindex == 19 || lineindex == 21) && ( columnindex == 3 || columnindex == 5 || columnindex ==7 )) {
				return true;
			}
			else {
				return false;
			}
		}
		public boolean isRoadH(Case c) {
			int lineindex= c.getLignes();
			int columnindex = c.getColomnes();
			if(((lineindex==0)||(lineindex==4)||(lineindex==6)||(lineindex==8)||(lineindex==16)||(lineindex==18)||(lineindex==20)||(lineindex==24))&&((columnindex==2)||(columnindex==4)||(columnindex==6)||(columnindex==8))) {
				return true;
			}
			else if(((lineindex==3)||(lineindex==5)||(lineindex==7)||(lineindex==9)||(lineindex==15)||(lineindex==17)||(lineindex==19)||(lineindex==21))&&((columnindex==3)||(columnindex==5)||(columnindex==7))) {
				return true;
			}
			else {
				return false;
			}
		}

		//La case est-elle une route diagonale?
		public boolean isRouteDiagO(Case c) {
			int lineIndex=c.getLignes();
			int columnIndex=c.getColomnes();

			if(((lineIndex==17)||(lineIndex==21)||(lineIndex==5)||(lineIndex==9))&&((columnIndex==4)||(columnIndex==8))) {
				return true;
			}
			else if(((lineIndex==15)||(lineIndex==19)||(lineIndex==7)||(lineIndex==3))&&((columnIndex==2)||(columnIndex==6))) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isRouteDiagE(Case c) {
			int lineIndex=c.getLignes();
			int columnIndex=c.getColomnes();
			if(((lineIndex==3)||(lineIndex==7)||(lineIndex==15)||(lineIndex==19))&&((columnIndex==4)||(columnIndex==8))) {
				return true;
			}
			else if(((lineIndex==5)||(lineIndex==9)||(lineIndex==17)||(lineIndex==21))&&((columnIndex==2)||(columnIndex==6))) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean isOccuped(Case c) {
			return isSea(c) || isCDFHor(c) || isCDFVer(c) || isCampement(c) || isLDF(c) || isMountain(c) || isRoadH(c) || isRoadV(c) || isRouteDiagE(c) || isRouteDiagO(c) || isInaccesible(c);
		}
		
		public boolean isRoad(Case c) {
			return isRoadH(c)|| isRoadV(c)|| isRouteDiagE(c)||isRouteDiagO(c); 
		}
		public boolean isRailRoad(Case c) {
			return isCDFHor(c)|| isCDFVer(c);
		}
		
		public boolean isRoadforMove(Case c) {
			return isRoadH(c)|| isRoadV(c)|| isRouteDiagE(c)||isRouteDiagO(c) || isCDFHor(c)|| isCDFVer(c);
		}
		
		public boolean ZoneP1(Case c) {
			int lineIndex=c.getLignes();
			return (lineIndex < 12);
		}
		public boolean ZoneP2(Case c) {
			int lineIndex=c.getLignes();
			return (lineIndex > 12);
		}
		
		public List<Case> getBaseEnnemie() {
		    List<Case> casesBaseEnnemie = new ArrayList<>();
		    for (int ligne = 0; ligne < this.getNbLignes(); ligne++) {
		        for (int colonne = 0; colonne < this.getNbColomnes(); colonne++) {
		            Case currentCase = this.getCase(ligne, colonne);
		            if (currentCase.getPiece() != null) {
		                if (ligne >= 0 && ligne <= 10) {
		                    casesBaseEnnemie.add(currentCase);
		                }
		            }
		        }
		    }
		    return casesBaseEnnemie;
		}
	
}
