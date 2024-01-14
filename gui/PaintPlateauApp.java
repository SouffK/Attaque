package gui;

import java.awt.Color;


import java.awt.Graphics;
import javax.swing.ImageIcon;

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
import engine.process.ReadImage;

public class PaintPlateauApp {
	public void paint(Plateau map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Case[][] blocks = map.getCases();
		//Création des cases à l'aide d'une boucle for.
		for (int lineIndex = 0; lineIndex < map.getNbLignes(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getNbColomnes(); columnIndex++) {
				Case block = blocks[lineIndex][columnIndex];
				int y = block.getLignes();
				int x = block.getColomnes();


				if(((lineIndex==0||lineIndex==24)&&(columnIndex==3 || columnIndex==7))){
					Color c = new Color(128,0,0);
					graphics.setColor(c);
					graphics.fillRect(block.getColomnes() * blockSize, block.getLignes() * blockSize, 2*blockSize, blockSize);

				}
				//Placement des chemins de fer verticales
				else if(((lineIndex==2)||(lineIndex==10)||(lineIndex==14)||(lineIndex==22))&&((columnIndex==2)||(columnIndex==4)||(columnIndex==6)||(columnIndex==8))) {
					graphics.drawImage(ReadImage.readImage("src/images/cdf.png"),x * blockSize, y*  blockSize, blockSize, blockSize, null);
				}
				//Placement des chemins de fer Verticales
				else if((lineIndex!=1)&&(lineIndex!=23)&&((columnIndex==1)||(columnIndex==9))&&(lineIndex%2==1)) {
					graphics.drawImage(ReadImage.readImage("src/images/cdfV.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				else if(((lineIndex==11)||(lineIndex==13))&&(columnIndex==5)){
					graphics.drawImage(ReadImage.readImage("src/images/cdfV.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				else if((columnIndex==0)||columnIndex==10){
					graphics.setColor(Color.BLUE);
					graphics.fillRect(block.getColomnes() * blockSize, block.getLignes() * blockSize, blockSize, blockSize);
				}
				//placement des routes horizontales.
				else if((columnIndex==5)&&(lineIndex %2 ==1)&&(lineIndex!=11)&&(lineIndex!=13)){
					graphics.drawImage(ReadImage.readImage("src/images/roadV.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}

				else if((lineIndex==1)&&((columnIndex==1)||(columnIndex==7)||(columnIndex==9))) {
					graphics.drawImage(ReadImage.readImage("src/images/roadV.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);

				}
				else if((lineIndex==23)&&((columnIndex==1)||(columnIndex==3)||(columnIndex==9))) {
					graphics.drawImage(ReadImage.readImage("src/images/roadV.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);

				}
				else if((columnIndex==3)&&(lineIndex!=1)&&(lineIndex!=11)&&(lineIndex!=13)&&(lineIndex%2==1)) {
					graphics.drawImage(ReadImage.readImage("src/images/roadV.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}

				else if((columnIndex==7)&&(lineIndex!=1)&&(lineIndex!=11)&&(lineIndex!=13)&& (lineIndex!=23)&&(lineIndex%2==1)) {
					graphics.drawImage(ReadImage.readImage("src/images/roadV.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				//placement des routes Horizontales.
				else if((lineIndex==0)&&(columnIndex!=0)&&(columnIndex%2==0)&&(columnIndex!=10)) {
					graphics.drawImage(ReadImage.readImage("src/images/roadH.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				else if(((lineIndex==4)||(lineIndex==6)||(lineIndex==8)||(lineIndex==16)||(lineIndex==18)||(lineIndex==20)||(lineIndex==24))&&((columnIndex==2)||(columnIndex==4)||(columnIndex==6)||(columnIndex==8))) {
					graphics.drawImage(ReadImage.readImage("src/images/roadH.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);

				}
				//Placement des routes diagonales 
				else if(((lineIndex==3)||(lineIndex==7)||(lineIndex==15)||(lineIndex==19))&&((columnIndex==4)||(columnIndex==8))) {
					graphics.drawImage(ReadImage.readImage("src/images/diagE.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				else if(((lineIndex==5)||(lineIndex==9)||(lineIndex==17)||(lineIndex==21))&&((columnIndex==2)||(columnIndex==6))) {
					graphics.drawImage(ReadImage.readImage("src/images/diagE.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				else if(((lineIndex==17)||(lineIndex==21)||(lineIndex==5)||(lineIndex==9))&&((columnIndex==4)||(columnIndex==8))) {
					graphics.drawImage(ReadImage.readImage("src/images/diagO.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				else if(((lineIndex==15)||(lineIndex==19)||(lineIndex==7)||(lineIndex==3))&&((columnIndex==2)||(columnIndex==6))) {
					graphics.drawImage(ReadImage.readImage("src/images/diagO.png"),x * blockSize, y *  blockSize, blockSize, blockSize, null);
				}
				//modélisation des campements
				else if(((lineIndex==4|| lineIndex==8|| lineIndex==16|| lineIndex==20)&&(columnIndex==3 || columnIndex==7))) {
					graphics.setColor(Color.BLACK);
					graphics.fillOval(block.getColomnes() * blockSize, block.getLignes() * blockSize, blockSize, blockSize);
				}
				else if(((lineIndex==6|| lineIndex==18)&&(columnIndex==5))) {
					graphics.setColor(Color.BLACK);
					graphics.fillOval(block.getColomnes() * blockSize, block.getLignes() * blockSize, blockSize, blockSize);
				}
				//modélisation des montagnes
				else if((lineIndex==12)&&(columnIndex==3 || columnIndex==7)) {
					graphics.setColor(Color.GRAY);
					graphics.fillRect(block.getColomnes() * blockSize, block.getLignes() * blockSize, blockSize, blockSize);
				}
				else if((lineIndex==12)&(columnIndex==1 || columnIndex==5 || columnIndex == 9)) {
					graphics.setColor(Color.GREEN);
					graphics.fillRect(block.getColomnes() * blockSize, block.getLignes() * blockSize, blockSize, blockSize);
				}

			}
		}
	}


	public void paint(Marechal marechal, Graphics graphics) {
		Case position = marechal.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLignes();
		int x = position.getColomnes();
		if(marechal.getNom()=="Marechal") {
			graphics.drawImage(ReadImage.readImage("src/images/m.png"), x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
		
	}
	public void paint(General general, Graphics graphics) {
		Case position = general.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLignes();
		int x = position.getColomnes();
		if(general.getNom().equalsIgnoreCase("General")) {
			graphics.drawImage(ReadImage.readImage("src/images/general.jpg"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(Drapeau drapeau, Graphics graphics) {
		Case position = drapeau.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(drapeau.getNom().equalsIgnoreCase("Drapeau")) {
			graphics.drawImage(ReadImage.readImage("src/images/drapeau.png"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(MinesTerrestres mines, Graphics graphics) {
		Case position = mines.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(mines.getNom().equalsIgnoreCase("Mine")) {
			graphics.drawImage(ReadImage.readImage("src/images/mineT.jpg"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(GenerauxDeDivision gdd, Graphics graphics) {
		Case position = gdd.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(gdd.getNom().equalsIgnoreCase("GDD")) {
			ImageIcon icon = new ImageIcon("src/images/gdd.jpg");
			graphics.drawImage(icon.getImage(),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}

	public void paint(Brigadier brigadier, Graphics graphics) {
		Case position = brigadier.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(brigadier.getNom().equalsIgnoreCase("Brigadier")) {
			graphics.drawImage(ReadImage.readImage("src/images/brigadier.jpg"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}

	public void paint(Colonel colonel, Graphics graphics) {
		Case position = colonel.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(colonel.getNom().equalsIgnoreCase("Colonel")) {
			graphics.drawImage(ReadImage.readImage("src/images/colonel.jpg"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}

	public void paint(Commandant commandant, Graphics graphics) {
		Case position = commandant.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(commandant.getNom().equalsIgnoreCase("Commandant")) {
			graphics.drawImage(ReadImage.readImage("src/images/commandant.jpg"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(Capitaine capitaine, Graphics graphics) {
		Case position = capitaine.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(capitaine.getNom().equalsIgnoreCase("Capitaine")) {
			graphics.drawImage(ReadImage.readImage("src/images/luffy.png"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(Lieutenant lieutenant, Graphics graphics) {
		Case position = lieutenant.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(lieutenant.getNom().equalsIgnoreCase("lieutenant")) {
			graphics.drawImage(ReadImage.readImage("src/images/zoro.png"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}

	public void paint(Ingenieur ingenieur, Graphics graphics) {
		Case position = ingenieur.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(ingenieur.getNom().equalsIgnoreCase("ingenieur")) {
			graphics.drawImage(ReadImage.readImage("src/images/itachi.png"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(Bombe bomb, Graphics graphics) {
		Case position = bomb.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(bomb.getNom().equalsIgnoreCase("Bombe")) {
			graphics.drawImage(ReadImage.readImage("src/images/bomb.png"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(Bateau bateau, Graphics graphics) {
		Case position = bateau.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
		if(bateau.getNom().equalsIgnoreCase("Bateau")) {
			graphics.drawImage(ReadImage.readImage("src/images/bateau.jpg"),x * blockSize, y * blockSize, blockSize, blockSize, null);
		}
	}
	public void paint(Canon canon, Graphics graphics) {
		Case position = canon.getPos();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLignes();
		int x = position.getColomnes();
			graphics.drawImage(ReadImage.readImage("src/images/bomb.png"),x * blockSize, y * blockSize, blockSize, blockSize, null);
	}

}
