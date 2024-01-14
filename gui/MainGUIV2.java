package gui;

import java.awt.BorderLayout;





import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
import IA.SetPionsIA;
import configuration.GameConfiguration;
import engine.data.Player;
import engine.map.Case;
import engine.map.Plateau;
import engine.mobile.Piece;
import engine.process.BuildGame;
import engine.process.MoveAndActionPiece;
import engine.process.SetMapP1;
import engine.process.SetMapP2;
import log.LoggerUtility;

public class MainGUIV2 extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Plateau map;
	public int xstarted, ystarted;
	boolean isMove = false;
	private String message;
	private Case Position;
	private Case NewPos;
	private Case nul;
	private Piece selectedPiece;
	private Player currentPlayer;
	private JLabel currentPlayerLabel;
	private List<Integer> scores1List;
    private List<Integer> scores2List;
	private Player joueur1;
	private Player joueur2;	
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH , GameConfiguration.WINDOW_HEIGHT);
	private MoveAndActionPiece manager;
	private Stat2 stat;
	private Liste liste;
	private SetMapP1 set;
	private SetMapP2 setP2;
	private SetPionsIA setIA;
	private JPanel panel;
	private GameDisplay dashboard;
	int i = 0;

	private static Logger logger = LoggerUtility.getLogger(MoveAndActionPiece.class, "html");


	public MainGUIV2(String title) {
		super(title);
		init();
	}

	private void init() {
		 scores1List = new ArrayList<Integer>();
	     scores2List = new ArrayList<Integer>();
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		Keys keyControls = new Keys();
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);		
		joueur1 = new Player("Joueur 1" , map, 1);	
		joueur2 = new Player("Joueur 2" , map, 2);
		currentPlayer = joueur1;
		currentPlayerLabel = new JLabel("C'est le tour " + i + " et c'est au " + currentPlayer.getName() + " de jouer ");

		map = BuildGame.buildMap();
		set =new SetMapP1(map, manager);
		setP2 = new SetMapP2(map, manager);
		setIA = new SetPionsIA(map, manager);
		manager = BuildGame.buildInitMobile(map, set, setP2, setIA);
		dashboard = new GameDisplay(map, manager, set, setP2, setIA);
		MouseMove mv2 = new MouseMove();
		dashboard.addMouseMotionListener(mv2);
		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);
		dashboard.setPreferredSize(preferredSize);
		stat = new Stat2();
		liste = new Liste();
		stat.setPreferredSize(new Dimension(500, 500));
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		contentPane.add(liste, BorderLayout.WEST);
		contentPane.add(dashboard, BorderLayout.CENTER);
		contentPane.add(stat, BorderLayout.EAST);
		contentPane.add(currentPlayerLabel, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);

	}

	@Override
	public void run() {
        int round = 0;
// TODO Auto-generated method stub
		while (true) {

			if(setP2.getDrapeauP2() != null && setP2.getDrapeauP2().isCaptured() == true) {
				scores1List.add(set.getPieces().size());
                scores2List.add(setP2.getPiecesP2().size());
	            Graphic winnerScreen = new Graphic( scores1List, scores2List);
	            Winnner w = new Winnner(joueur1);
	            dispose();
	            break;
			}
			if(set.getDrapeau() != null && set.getDrapeau().isCaptured() == true) {
				scores1List.add(set.getPieces().size());
                scores2List.add(setP2.getPiecesP2().size());
				Graphic winnerScreen = new Graphic(scores1List, scores2List);
	            Winnner w = new Winnner(joueur2);
				dispose();
	            break;
			}
			dashboard.repaint();
			stat.updateScoreboard(set.getPieces().size(), setP2.getPiecesP2().size());
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED); // Ajoute un petit délai pour éviter une utilisation excessive de la CPU
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private class MouseControls implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub


		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			xstarted = e.getX();
			ystarted = e.getY();
			Position = dashboard.getPiece(xstarted, ystarted);
			if(e.getClickCount()==1) {
				if(!map.isOccuped(Position) && Position.isOccuped()==false && map.ZoneP1(Position)) {
						if(set.getDrapeau() == null && map.isQG(Position)) {
							set.putDrapeauP1(Position);
						}
	
					else if(map.poseMT(Position) &&(set.getMine()==  null || set.getMine2()== null || set.getMine3()== null) && !map.isQG(Position)) {
						set.putMineP1(Position);
					}
						
					else if(set.getMarechal()==null) {
						set.putMarechalP1(Position);
					}
						
					else if(set.getGeneral() == null) {
						set.putGeneralP1(Position);
					}
						
					else if(set.getGdd() == null || set.getGdd2() == null) {
						set.putGDDP1(Position);	
					}
						
					else if(set.getBrigadier() == null || set.getBrigadier2() == null) {
						set.putBrigadierP1(Position);	
					}
						
					else if(set.getColonel() == null || set.getColonel2() == null) {
						set.putColonelP1(Position);	
					}
						
					else if(set.getCommandant() == null || set.getCommandant2() == null) {
						set.putCommandantP1(Position);	
					}
						
					else if(set.getCapitaine() == null || set.getCapitaine2() == null || set.getCapitaine3() == null) {
						set.putCapitaineP1(Position);	
					}
						
					else if(set.getLieutenant() == null || set.getLieutenant2()== null || set.getLieutenant3()== null) {
						set.putLieutenantP1(Position);	
					}

					else if(set.getIngenieur() == null || set.getIngenieur2()== null || set.getIngenieur3()== null) {
						set.putIngenieurP1(Position);	
					}

					else if(set.getBomb() == null || set.getBomb2() == null) {
						set.putBombP1(Position);	

					}
				}

				else if(Position.isOccuped()==true && set.getPieces().size() != 25) {
					logger.warn("Cette case est déja occupé");

				}
				else if(!map.ZoneP1(Position) && set.getPieces().size() != 25){
					JOptionPane.showMessageDialog(null, "Veuillez placer vos pieces sur votre partie du plateau");

				}
				else if(map.isOccuped(Position)){
					logger.warn("Vous ne pouvez pas placer votre pion sur une montagne, route ou un chemin de fer");
				}
			}
			if(e.getClickCount() == 2) {
				selectedPiece = manager.pieceAt(Position);
				if(selectedPiece.getPlayer() == currentPlayer.getJoueur()) {
					Position.setPiece(selectedPiece);
					selectedPiece.setPos(Position);
				}
			}

			//PLAYER2
			if(!map.isOccuped(Position) && Position.isOccuped()==false && map.ZoneP2(Position)&& manager.setp1()) {
				if(setP2.getDrapeauP2() == null && map.isQG(Position)) {
					setP2.putDrapeauP2(Position);
				}
				
				else if(map.poseMT(Position) &&(setP2.getMineP2()==  null || setP2.getMine2P2()== null || setP2.getMine3P2()== null)) {
					setP2.putMineP2(Position);
				}
				
				else if(setP2.getMarechalP2()==null) {
					setP2.putMarechalP2(Position);
				}
				
				else if(setP2.getGeneralP2() == null) {
					setP2.putGeneralP2(Position);
				}

				else if(setP2.getGddP2() == null || setP2.getGdd2P2() == null) {
					setP2.putGDDP2(Position);	
				}
				
				else if(setP2.getBrigadierP2() == null || setP2.getBrigadier2P2() == null) {
					setP2.putBrigadierP2(Position);	
				}
				
				else if(setP2.getColonelP2() == null || setP2.getColonel2P2() == null) {
					setP2.putColonelP2(Position);	
				}
				
				else if(setP2.getCommandantP2() == null || setP2.getCommandant2P2() == null) {
					setP2.putCommandantP2(Position);	
				}
				
				else if(setP2.getCapitaineP2() == null || setP2.getCapitaine2P2() == null || setP2.getCapitaine3P2() == null) {
					setP2.putCapitaineP2(Position);	
				}
				
				else if(setP2.getLieutenantP2() == null || setP2.getLieutenant2P2()== null || setP2.getLieutenant3P2()== null) {
					setP2.putLieutenantP2(Position);	
				}
				
				else if(setP2.getIngenieurP2() == null || setP2.getIngenieur2P2()== null || setP2.getIngenieur3P2()== null) {
					setP2.putIngenieurP2(Position);	
				}

				else if(setP2.getBombP2() == null || setP2.getBomb2P2() == null) {
					setP2.putBombP2(Position);	
				}

				else if(Position.isOccuped()==true) {
					logger.warn("Cette case est déja occupé");

				} 
				
				else{
					logger.warn("Vous ne pouvez pas placer votre pion sur une montagne, route ou un chemin de fer");
				}
			}
			stat.updateScoreboard(set.getPieces().size(), setP2.getPiecesP2().size());
			dashboard.repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			NewPos = dashboard.getPiece(x, y);
			if (selectedPiece != null && selectedPiece.getPlayer() == currentPlayer.getJoueur()) {
				nul = map.getCase(0, GameConfiguration.COLUMN_COUNT -1);
				message = manager.MovePiece(selectedPiece, Position, NewPos, nul, currentPlayer);
				if (currentPlayer == joueur1 && Position != NewPos && !message.equalsIgnoreCase("error")) {
					currentPlayer = joueur2;
				} else if (currentPlayer == joueur2 && Position != NewPos && !message.equalsIgnoreCase("error")) {
					currentPlayer = joueur1;
					i++;
					scores1List.add(set.getPieces().size());
		            scores2List.add(setP2.getPiecesP2().size());
				}
				currentPlayerLabel.setText("C'est le tour " + i + " et c'est au " + currentPlayer.getName() + " de jouer");
				stat.updateScoreboard(set.getPieces().size(), setP2.getPiecesP2().size());
				selectedPiece = null;
				dashboard.repaint();
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}


	}

	private class MouseMove implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if(selectedPiece!=null && selectedPiece.getPlayer() == currentPlayer.getJoueur()) {
				int x=e.getX();
				int y = e.getY();
				Case Position = dashboard.getPiece(x, y);
				selectedPiece.setPos(Position);
				dashboard.repaint();
				dashboard.revalidate();

			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
	private class Keys implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			char keyChar = e.getKeyChar();
			switch (keyChar) {
			case 'a':
				if (currentPlayer.getJoueur() == joueur1.getJoueur()) {
					manager.moveUpBateau(currentPlayer);

					currentPlayer = joueur2;
					
					scores1List.add(set.getPieces().size());
		            scores2List.add(setP2.getPiecesP2().size());
		            
				}
				currentPlayerLabel.setText("C'est le tour " + i + " et c'est au " + currentPlayer.getName() + " de jouer");
				stat.updateScoreboard(set.getPieces().size(), setP2.getPiecesP2().size());

				break;
			case 'b':
				if (currentPlayer.getJoueur() == joueur1.getJoueur()) {
					manager.moveDownBateau(currentPlayer);

					currentPlayer = joueur2;
					
					scores1List.add(set.getPieces().size());
		            scores2List.add(setP2.getPiecesP2().size());
				}
				currentPlayerLabel.setText("C'est le tour " + i + " et c'est au " + currentPlayer.getName() + " de jouer");
				stat.updateScoreboard(set.getPieces().size(), setP2.getPiecesP2().size());
				break;
			case 'q':
				if(i% 5 == 0) {
					if (currentPlayer.getJoueur() == joueur1.getJoueur()) {
						manager.impactBateau();
						currentPlayer = joueur2;
					
						scores1List.add(set.getPieces().size());
			            scores2List.add(setP2.getPiecesP2().size());
					}
					currentPlayerLabel.setText("C'est le tour " + i + " et c'est au " + currentPlayer.getName() + " de jouer");
					stat.updateScoreboard(set.getPieces().size(), setP2.getPiecesP2().size());
					ImageIcon icon = new ImageIcon("src/images/explosion.jpg");
					JOptionPane.showMessageDialog(null, "KABOOOOM", "Missile de guerre du navire", JOptionPane.INFORMATION_MESSAGE, icon);
				}
				break;
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
	


}
