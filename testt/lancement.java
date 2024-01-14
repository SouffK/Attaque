package testt;

import javax.imageio.ImageIO;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import gui.MainGUIApp;
import gui.MainGUIV2;

public class lancement extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton jouer = new JButton("Jouer !");
	private JButton apprentissage = new JButton("Mode Apprentissage");

	public lancement() {
		super("Bienvenue sur Attaque !");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.add(jouer);
		panel.add(apprentissage);
		this.add(panel, BorderLayout.SOUTH);

		jouer.addActionListener(new Jouer());
		apprentissage.addActionListener(new Apprendre());
		
		ImageIcon icone = new ImageIcon("src/images/LogoAttaque.png");
		JLabel image = new JLabel(icone);
		this.add(image, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	public class Jouer implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			MainGUIV2 gameMainGUI = new MainGUIV2("Joueur vs Ordinateur");

			Thread gameThread = new Thread(gameMainGUI);
			gameThread.start();
		}
	}

	public class Apprendre implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			MainGUIApp gameMainGUIApp = new MainGUIApp("Joueur 1 vs Joueur 2");

			Thread gameThread = new Thread(gameMainGUIApp);
			gameThread.start();
		}
	}

	public static void main(String[] args) {
		new lancement();
	}
}
