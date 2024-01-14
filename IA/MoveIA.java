package IA;

import configuration.GameConfiguration;
import engine.data.Player;
import engine.map.Case;
import engine.map.Plateau;
import engine.mobile.Piece;
import engine.process.MoveAndActionPiece;
import engine.process.SetMapP1;

public class MoveIA {
	private SetPionsIA setIA;
	private MoveAndActionPiece manager;
	private SetMapP1 set;
	private Plateau map;
	private int profondeurMax = 3;

	public MoveIA(Plateau map, SetMapP1 set, SetPionsIA setIA, MoveAndActionPiece manager) {
		this.map=map;
		this.setIA = setIA;
		this.manager = manager;
		this.set=set;
	}
	 public void jouerCoup(Plateau grille,Player p) {
	        Piece piece = choisirPiece(grille);
	        Case destination = choisirDestination(piece, grille, p);
	        Case nul = grille.getCase(0, GameConfiguration.COLUMN_COUNT - 1);
	        manager.MovePiece(piece, piece.getPos(), destination, nul, p);
	    }
	private Piece choisirPiece(Plateau map) {
	    int distanceMin = Integer.MAX_VALUE;
	    Piece meilleurePiece = null;
	    for (Piece piece : setIA.getpiecesIA()) {
	    	for (Case c : map.getBaseEnnemie()) {
	    		int distance = calculerDistance(piece, c);
		        if (distance < distanceMin) {
		            distanceMin = distance;
		            meilleurePiece = piece;
		        }
			}
	    }
	    return meilleurePiece;
	}
	private Case choisirDestination(Piece piece, Plateau grille, Player p) {
        // Algorithme Minimax avec élagage alpha-bêta pour choisir la case de destination
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
        Case destination = null;
        int meilleurScore = Integer.MIN_VALUE;
        for (Case caseDest : manager.legalMoves(grille, p)) {
            int score = minimax(grille, caseDest, alpha, beta, 1, profondeurMax, false, p);
            if (score > meilleurScore) {
                meilleurScore = score;
                destination = grille.getCase(caseDest.getLignes(), caseDest.getColomnes());
            }
            alpha = Math.max(alpha, meilleurScore);
            if (alpha >= beta) {
                break;
            }
        }
        return destination;
    }

	private int calculerDistance(Piece piece, Case baseEnnemie) {
	    int dx = piece.getPos().getLignes() - baseEnnemie.getLignes();
	    int dy = piece.getPos().getColomnes() - baseEnnemie.getColomnes();
	    return (int) Math.sqrt(dx*dx + dy*dy);
	}
	private int evaluerGrille(Plateau map) {
	    int score = 0;

	    // On parcourt toutes les pièces de la grille
	    for (int i = 0; i < map.getNbLignes(); i++) {
			for (int j = 0; j < map.getNbColomnes(); j++) {
				Case c = map.getCase(i, j);
				for (Case adv : map.getBaseEnnemie()) {
					// Si la pièce appartient à l'IA, on ajoute son score à notre score
					
			        if (c.getPiece().getPlayer() == 3) {
			            score += evaluerPiece(c.getPiece(), adv);
			        }
			        // Si la pièce appartient au joueur, on soustrait son score à notre score
			        else {
			            score -= evaluerPiece(c.getPiece(), adv);
			        }
				}
			}
	    }

	    return score;
	}
	    private int evaluerPiece(Piece piece, Case c) {
	        int score = 0;
	        int distanceToBaseEnnemie = calculerDistance(piece, c);
	        
	        // On ajoute des points en fonction de la proximité de la pièce de la base ennemie ennemie
	        if (distanceToBaseEnnemie >= 2) {
	            score += 10;
	        }
	        else if (distanceToBaseEnnemie >= 5) {
	            score += 5;
	        }
	        return score;
	    }
	private int minimax(Plateau grille, Case caseDest, int alpha, int beta, int profondeur, int profondeurMax, boolean estMaximisant, Player player) {
	    // Si on atteint la profondeur maximale ou si la partie est terminée, on évalue la grille de jeu
	    if (profondeur == profondeurMax) {
	        return evaluerGrille(grille);
	    }
	    // Si c'est au tour de l'IA, on cherche le coup avec le meilleur score
	    if (estMaximisant) {
	        int meilleurScore = Integer.MIN_VALUE;
	        for (Piece piece : setIA.getpiecesIA()) {
	            for (Case caseDepart : manager.legalMoves(grille, player)) {
	            	Case nul = grille.getCase(0, GameConfiguration.COLUMN_COUNT - 1);
	                manager.MovePiece(piece, caseDepart, caseDest, nul, player);
	                int score = minimax(grille, caseDest, alpha, beta, profondeur+1, profondeurMax, false, player);
	                meilleurScore = Math.max(meilleurScore, score);
	                alpha = Math.max(alpha, meilleurScore);
	                if (alpha >= beta) {
	                    break;
	                }
	            }
	        }
	        return meilleurScore;
	    }
	    // Si c'est au tour du joueur, on cherche le coup avec le plus mauvais score (car l'IA cherche à minimiser ce score)
	    else {
	        int pireScore = Integer.MAX_VALUE;
	        for (Piece piece : set.getPieces()) {
	            for (Case caseDepart : manager.legalMoves(grille, player)) {
	            	Case nul = grille.getCase(0, GameConfiguration.COLUMN_COUNT - 1);
	                manager.MovePiece(piece, caseDepart, caseDest, nul, player);
	                int score = minimax(grille, caseDest, alpha, beta, profondeur+1, profondeurMax, true, player);
	                pireScore = Math.min(pireScore, score);
	                beta = Math.min(beta, pireScore);
	                if (alpha >= beta) {
	                    break;
	                }
	            }
	        }
	        return pireScore;
	    }
	}
	
	
	public Piece selectPiece() {
		Piece selectP = null;
		for (Piece p : setIA.getpiecesIA()) {
			if(p.getPos().getLignes() < selectP.getPos().getLignes()) {
				selectP = p;
			}
		}
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
		for (Piece p : setIA.getpiecesIA()) {
			int move = setIA.getRandomNumber(1, 4);
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
	
}
