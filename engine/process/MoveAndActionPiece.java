package engine.process;

import java.awt.Graphics;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.text.Position;

import org.apache.log4j.Logger;

import IA.SetPionsIA;
import configuration.GameConfiguration;
import engine.data.Player;
import engine.map.Case;
import engine.map.Plateau;
import engine.mobile.*;
import gui.Stat2;
import log.LoggerUtility;

/**
 * @author noubk
 *
 */
public class MoveAndActionPiece {
	private Plateau map;
	private Bateau bateau;
	private Canon canon;
	private Bateau bateau2;
	private SetMapP1 setP1;
	private SetMapP2 setP2;
	private SetPionsIA setIA;
	private ArrayList<Canon> canons = new ArrayList<>();
	private static Logger logger = LoggerUtility.getLogger(MoveAndActionPiece.class, "html");
	public MoveAndActionPiece(Plateau map, SetMapP1 setP1, SetMapP2 setP2, SetPionsIA setIA) {
		this.map=map;
		this.setP1=setP1;
		this.setP2=setP2;
		this.setIA=setIA;

	}

	public boolean isExist(Piece p) {
		if(setP1.getPieces().contains(p)) {
			return true;
		}
		else if(setP2.getPiecesP2().contains(p)) {
			return true;
		}
		return false;
	}

	public boolean setp1() {
		return setP1.getPieces().size() == 25;
	}
	public boolean setMap() {
		return (setP1.getPieces().size() + setP2.getPiecesP2().size()) == 50;
	}
	public Piece pieceAt(Case position) {
		for (Piece piece : setP1.getPieces()) {
			if(piece.getPos().getColomnes() == position.getColomnes() && piece.getPos().getLignes() == position.getLignes()) {
				return piece;
			}
		}
		for (Piece piece : setP2.getPiecesP2()) {
			if(piece.getPos().getColomnes() == position.getColomnes() && piece.getPos().getLignes() == position.getLignes()) {
				return piece;
			}
		}
		return null;
	}
	private void Collision(Piece p1, Piece p2, Case victoire, Case nul, Case Road, Case Position) {
		if(!p2.isMineTerrestre(p2)){
			if(p1.getRang() < p2.getRang()) {
				if(p1.isDrapeau(p1)) {
					if(setP1.getPieces().contains(p1)) {	
						setP1.getDrapeau().setCaptured(true);
					}
					else {
						setP2.getDrapeauP2().setCaptured(true);

					}
				}
				nul.setPiece(p1);
				p1.setPos(nul);
				if(setP1.getPieces().contains(p1)) {	
					setP1.getPieces().remove(p1);
				}
				else {
					setP2.getPiecesP2().remove(p1);
				}
				Position.setOccuped(false);
				Road.setOccuped(false);
				logger.info("La pièce " + p1.getNom() + " a été éliminé par : " +  p2.getNom());

			}
			else {
				if(p2.isDrapeau(p2)) {
					if(setP1.getPieces().contains(p2)) {	
						setP1.getDrapeau().setCaptured(true);
					}
					else {
						setP2.getDrapeauP2().setCaptured(true);

					}
				}
				nul.setPiece(p2);
				p2.setPos(nul);
				if(setP1.getPieces().contains(p2)) {	
					setP1.getPieces().remove(p2);
				}
				else {
					setP2.getPiecesP2().remove(p2);
				}					
				victoire.setPiece(p1);
				p1.setPos(victoire);
				Position.setOccuped(false);
				Road.setOccuped(false);
				logger.info("La pièce " + p2.getNom() + " a été éliminé par : " +  p1.getNom());

			}
		}
		if(p1.isBombe(p1) || p2.isBombe(p2) || (p1.getRang() == p2.getRang())) {
			nul.setPiece(p1);
			p1.setPos(nul);
			nul.setPiece(p2);
			p2.setPos(nul);
			setP1.getPieces().remove(p1);
			setP2.getPiecesP2().remove(p2);
			Position.setOccuped(false);
			Road.setOccuped(false);
			victoire.setOccuped(false);
			logger.info("une des deux pièces étant une bombe, les pièces " + p1.getNom() + " et " + p2.getNom() + " ont été éliminés");
		}
		else if(p2.isMineTerrestre(p2) && !p1.isIngenieur(p1)) {
			nul.setPiece(p1);
			p1.setPos(nul);
			if(setP1.getPieces().contains(p1)) {	
				setP1.getPieces().remove(p1);
			}
			else {
				setP2.getPiecesP2().remove(p1);
			}
			victoire.setPiece(p2);
			p2.setPos(victoire);
			Position.setOccuped(false);
			Road.setOccuped(false);
			logger.info("La pièce " + p1.getNom() + " a été éliminé par : " +  p2.getNom());
		}
		else if(p1.isIngenieur(p1) && p2.isMineTerrestre(p2) || p1.isBombe(p1) && p2.isMineTerrestre(p2)) {
			nul.setPiece(p2);
			p2.setPos(nul);
			if(setP1.getPieces().contains(p2)) {	
				setP1.getPieces().remove(p2);
			}
			else {
				setP2.getPiecesP2().remove(p2);
			}
			victoire.setPiece(p1);
			p1.setPos(victoire);
			Position.setOccuped(false);
			Road.setOccuped(false);
		}
	}

	public boolean endGame(Drapeau p) {
		if(p.isDrapeau(p)) {
			if(p.isCaptured() == true) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public Player nextTurn(Player currentPlayer, Player joueur1, Player joueur2, Case dep, Case NewPos, int nbTour) {
		if (currentPlayer == joueur1 && dep != NewPos) {
			currentPlayer = joueur2;
		} else {
			currentPlayer = joueur2;
		}
		nbTour++;
		return currentPlayer;
	}
	public String MovePiece(Piece selectedPiece, Case Position, Case Road, Case nul, Player joueur) {
		String msg ="";
		if(joueur.getJoueur() == selectedPiece.getPlayer()) {
			int x = Road.getLignes() - Position.getLignes() ;
			int y = Road.getColomnes() - Position.getColomnes() ;
			if ((selectedPiece.isMineTerrestre(selectedPiece)) || selectedPiece.isDrapeau(selectedPiece)) {
				Position.setPiece(selectedPiece);
				selectedPiece.setPos(Position);
				Position.setOccuped(true);
				logger.error("Impossible de deplacer la piece : " + Position.getPiece().getNom());
				msg = "error";
				return msg;
			}
			else if(map.isQG(Position)) {
				Position.setPiece(selectedPiece);
				selectedPiece.setPos(Position);
				Position.setOccuped(true);
				logger.error("Impossible de deplacer la piece : " + selectedPiece.getNom() + " car elle est rentré dans le QG et ne peux donc plus bouger");
				msg = "error";
				return msg;
			}
			//deplacement a droite
			else if(x==0 && y == 1 && (map.isRoadforMove(Road))) {
				Case NewPos = map.getCase(Position.getLignes(), Position.getColomnes() + 2);
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos)) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);
				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers la droite");

				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";
				}		
				return msg;
			}
			//deplacement a gauche
			else if(x==0 && y == -1 && (map.isRoadforMove(Road))) {
				Case NewPos = map.getCase(Position.getLignes(), Position.getColomnes() - 2);
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos) ) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);

				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers la gauche");

				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";
				}
				return msg;

			}
			//deplacement en bas
			else if(x== 1 && y == 0 && (map.isRoadforMove(Road))) {
				Case NewPos = map.getCase(Position.getLignes() + 2, Position.getColomnes());
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos) ) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);

				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers le bas");

				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";
				}

				if(map.isLDF(NewPos)) {
					Case arrived = map.getCase(Position.getLignes() + 4, Position.getColomnes());
					if(arrived.isOccuped()==true && selectedPiece.getPlayer() != arrived.getPiece().getPlayer()) {
						Collision(selectedPiece, arrived.getPiece(), arrived, nul, Road, Position);

					}
					else if(arrived.isOccuped() == false) {
						arrived.setPiece(selectedPiece);
						selectedPiece.setPos(arrived);
						arrived.setOccuped(true);
						Position.setOccuped(false);
						Road.setOccuped(false);
						logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 4 cases vers le bas");

					}
					else {
						Position.setPiece(selectedPiece);
						selectedPiece.setPos(Position);
						Position.setOccuped(true);
						msg = "error";
					}
					return msg;

				}
				return msg;
			}
			//deplacement en haut
			else if(x== -1 && y == 0 && (map.isRoadforMove(Road))) {
				Case NewPos = map.getCase(Position.getLignes() -2, Position.getColomnes());
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos)) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);

				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers le haut");

				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";
				}
				if(map.isLDF(NewPos)) {
					Case arrived = map.getCase(Position.getLignes() - 4, Position.getColomnes());
					if(arrived.isOccuped()==true && selectedPiece.getPlayer() != arrived.getPiece().getPlayer()) {
						Collision(selectedPiece, arrived.getPiece(), arrived, nul, Road, Position);
					}
					else if(arrived.isOccuped() == false) {
						arrived.setPiece(selectedPiece);
						selectedPiece.setPos(arrived);
						arrived.setOccuped(true);
						Position.setOccuped(false);
						Road.setOccuped(false);
						logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 4 cases vers le haut");
					}
					else {
						Position.setPiece(selectedPiece);
						selectedPiece.setPos(Position);
						Position.setOccuped(true);
						msg = "error";

					}
					return msg;

				}
				return msg;
			}
			//deplacement en bas à droite
			else if( x == 1 && y == 1 && (map.isRouteDiagO(Road))) {
				Case NewPos = map.getCase(Position.getLignes() + 2, Position.getColomnes() + 2);
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos)) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);

				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers le bas-droite");

				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";
				}
				return msg;

			}
			//deplacement en haut à droite
			else if( x == -1 && y == 1 && (map.isRouteDiagE(Road))) {
				Case NewPos = map.getCase(Position.getLignes() - 2, Position.getColomnes() + 2);
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos)) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);

				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers la droite-Est");

				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";

				}	
				return msg;

			}

			//deplacement en bas à gauche
			else if( x == 1 && y == -1 && (map.isRouteDiagE(Road))) {
				Case NewPos = map.getCase(Position.getLignes() + 2, Position.getColomnes() - 2);
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos)) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);

				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers le bas-gauche");
				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";
				}
				return msg;

			}

			//deplacement en haut à gauche
			else if( x == -1 && y == -1 && (map.isRouteDiagO(Road))) {
				Case NewPos = map.getCase(Position.getLignes() - 2, Position.getColomnes() - 2);
				Road.setPiece(selectedPiece);
				selectedPiece.setPos(Road);
				if(NewPos.isOccuped()==true && selectedPiece.getPlayer() != NewPos.getPiece().getPlayer() && !map.isCampement(NewPos)) {
					Collision(selectedPiece, NewPos.getPiece(), NewPos, nul, Road, Position);

				}
				else if(NewPos.isOccuped() == false) {
					NewPos.setPiece(selectedPiece);
					selectedPiece.setPos(NewPos);
					NewPos.setOccuped(true);
					Position.setOccuped(false);
					Road.setOccuped(false);
					logger.info("La pièce " + selectedPiece.getNom() + " a effectué un deplacement de 2 cases vers la droite");

				}
				else {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
					Position.setOccuped(true);
					msg = "error";
				}
				return msg;

			}

			else {
				Position.setPiece(selectedPiece);
				selectedPiece.setPos(Position);
				Position.setOccuped(true);
				msg = "error";
				logger.error("Deplacement impossible car il n'y a pas une route sur le chemin, " + selectedPiece.getNom() + " revient à sa position initiale");
			}
			return msg;

		}
		else {
			logger.error("C'est au joueur " + joueur.getName() + " de jouer");
			Position.setPiece(selectedPiece);
			selectedPiece.setPos(Position);
			msg = "error";
		}
		return msg;

	}
	public void moveUpBateau(Player p) {
		Case position = bateau.getPos();
		if (position.getLignes() > 0 && bateau.getPlayer() == 1) {
			Case newPosition = map.getCase(position.getLignes() - 2, position.getColomnes());
			bateau.setPos(newPosition);
			newPosition.setPiece(bateau);
			logger.info("deplacement de 2 cases vers le haut");
		}
		else {
			logger.error("Limite atteinte, le bateau ne plus se deplacer vers le haut");
		}

	}

	public void moveDownBateau(Player p) {
		Case position = bateau.getPos();

		if (!map.isOnBottom(position) && bateau.getPlayer() == 1) {
			Case newPosition = map.getCase(position.getLignes() + 2, position.getColomnes());
			bateau.setPos(newPosition);
			logger.info("deplacement de 2 cases vers le bas");
		}
		else {
			logger.error("Limite atteinte, le bateau ne plus se deplacer vers le bas");
		}

	}
	public void impactBateau() {
		Case position = bateau.getPos();
		Case impactPos = map.getCase(position.getLignes(), position.getColomnes() + 1);
		if(impactPos.getPiece() != null && impactPos.getPiece().getPlayer() == 2) {
			Case nul = map.getCase(0, GameConfiguration.COLUMN_COUNT - 1);
			nul.setPiece(impactPos.getPiece());
			impactPos.getPiece().setPos(nul);	
		}
	}

	public List<Case> legalMoves(Plateau map, Player joueur) {
		List<Case> legalMoves = new ArrayList<>();

		// Itérer sur chaque case du plateau de jeu
		for (int i = 0; i < map.getNbLignes(); i++) {
			for (int j = 0; j < map.getNbColomnes(); j++) {
				// Vérifier si la case contient une pièce appartenant au joueur actuel
				Case pos = map.getCase(i, j);
				if (pos.getPiece().getPlayer() == joueur.getJoueur()) {
					if(map.isRoadforMove(map.getCase(pos.getLignes(), pos.getColomnes() + 1))) {
						Case NewPos = map.getCase(pos.getLignes(), pos.getColomnes() + 2);
						legalMoves.add(NewPos);
					}
					else if(map.isRoadforMove(map.getCase(pos.getLignes(), pos.getColomnes() - 1))) {
						Case NewPos = map.getCase(pos.getLignes(), pos.getColomnes() - 2);
						legalMoves.add(NewPos);
					}
					else if(map.isRoadforMove(map.getCase(pos.getLignes() + 1, pos.getColomnes()))) {
						Case NewPos = map.getCase(pos.getLignes() + 2, pos.getColomnes());
						legalMoves.add(NewPos);
						if(map.isLDF(NewPos)) {
							Case arrived = map.getCase(pos.getLignes() + 4, pos.getColomnes());
							legalMoves.add(arrived);
						}

					}
					//deplacement en haut
					else if(map.isRoadforMove(map.getCase(pos.getLignes() - 1, pos.getColomnes()))) {
						Case NewPos = map.getCase(pos.getLignes() -2, pos.getColomnes());
						legalMoves.add(NewPos);
						if(map.isLDF(NewPos)) {
							Case arrived = map.getCase(pos.getLignes() - 4, pos.getColomnes());
							legalMoves.add(arrived);
						}
					}
					//deplacement en bas à droite
					else if(map.isRoadforMove(map.getCase(pos.getLignes() + 1, pos.getColomnes() + 1))) {
						Case NewPos = map.getCase(pos.getLignes() + 2, pos.getColomnes() + 2);
						legalMoves.add(NewPos);
					}
					//deplacement en haut à droite
					else if(map.isRoadforMove(map.getCase(pos.getLignes() - 1, pos.getColomnes() + 1))) {
						Case NewPos = map.getCase(pos.getLignes() - 2, pos.getColomnes() + 2);
						legalMoves.add(NewPos);
					}

					//deplacement en bas à gauche
					else if(map.isRoadforMove(map.getCase(pos.getLignes() + 1, pos.getColomnes() - 1))) {
						Case NewPos = map.getCase(pos.getLignes() + 2, pos.getColomnes() - 2);
						legalMoves.add(NewPos);
					}

					//deplacement en haut à gauche
					else if(map.isRoadforMove(map.getCase(pos.getLignes() -1 , pos.getColomnes() - 1))) {
						Case NewPos = map.getCase(pos.getLignes() - 2, pos.getColomnes() - 2);
						legalMoves.add(NewPos);
					}
				}
			}
		}
		return legalMoves;
	}

	public void generateCanon() {
		Case pos = bateau.getPos();
		Canon canon = new Canon(pos);
		canons.add(canon);
	}

	public Piece selectPiece() {
		Piece selectP = null;
		for (Piece p : setP2.getPiecesP2()) {
			if(p.getPos().getLignes() < selectP.getPos().getLignes()) {
				selectP = p;
			}
		}
		System.out.println(selectP.getPos().toString());
		return selectP;
	}

	public void MoveDown(Piece p) {
		Case Position = p.getPos();
		if(Position.getLignes() < GameConfiguration.LINE_COUNT - 1 && (map.isRoadforMove(map.getCase(Position.getLignes() + 1, Position.getColomnes())))) {
			Case newPos = map.getCase(Position.getLignes() + 2, Position.getColomnes());
			p.setPos(newPos);
			newPos.setPiece(p);

		}
	}

	public void MoveUp(Piece p) {
		Case Position = p.getPos();
		if(Position.getLignes() > 0 && (map.isRoadforMove(map.getCase(Position.getLignes() - 1, Position.getColomnes())))) {
			Case newPos = map.getCase(Position.getLignes() - 2, Position.getColomnes());
			p.setPos(newPos);
			newPos.setPiece(p);

		}
	}

	public void MoveLeft(Piece p) {
		Case Position = p.getPos();
		if(Position.getColomnes() > 0 && (map.isRoadforMove(map.getCase(Position.getLignes(), Position.getColomnes() - 1)))) {
			Case newPos = map.getCase(Position.getLignes(), Position.getColomnes() - 2);
			p.setPos(newPos);
			newPos.setPiece(p);

		}
	}
	public void MoveRight(Piece p) {
		Case Position = p.getPos();
		if(Position.getColomnes() < GameConfiguration.COLUMN_COUNT - 2 && (map.isRoadforMove(map.getCase(Position.getLignes(), Position.getColomnes() + 1)))) {
			Case newPos = map.getCase(Position.getLignes(), Position.getColomnes() + 2);
			p.setPos(newPos);
			newPos.setPiece(p);

		}
	}

	public void randomDirection() {
		for (Piece p : setP2.getPiecesP2()) {
			p =selectPiece();
			int move = SetPionsIA.getRandomNumber(1, 4);
			if(move == 1) {
				MoveDown(p);
			}
			if(move == 2) {
				MoveLeft(p);
			}
			if(move == 3) {
				MoveRight(p);
			}
			if(move == 4) {
				MoveUp(p);
			}
		}
	}

	public Bateau getBateau(){
		return bateau;
	}
	public ArrayList<Canon> getCanons(){
		return canons;
	}
	public Bateau getBateau2(){
		return bateau2;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public void setBateau2(Bateau bateau2) {
		this.bateau2 = bateau2;
	}



}
