package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import engine.data.Player;
import testt.lancement;

public class Winnner extends JFrame{
	private Player p;
	 private JButton relancerBtn;
	 private JButton quitterBtn;

	    public Winnner(Player p) {
	        this.p = p;

	        ImageIcon icon = new ImageIcon("src/images/luffy.png"); // chemin d'accès à une image de votre choix pour l'icône
	        JLabel label = new JLabel("Félicitations, " + p.getName() + " !"); // message qui inclut le nom du joueur
	        label.setFont(new Font("Arial", Font.BOLD, 20)); // changer la police, la taille et le style du texte

	        Object[] options = {"OK"}; // bouton pour fermer la boîte de dialogue

	        JOptionPane.showOptionDialog(
	            null,
	            label,
	            "Partie terminée",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.INFORMATION_MESSAGE,
	            icon,
	            options,
	            options[0]
	        );

	        relancerBtn = new JButton("Relancer");
	        quitterBtn = new JButton("Quitter");
	        relancerBtn.addActionListener(new relancer());
	        quitterBtn.addActionListener(new quitter());
	        JPanel panel = new JPanel();
			panel.add(relancerBtn);
			panel.add(quitterBtn);
			this.add(panel, BorderLayout.SOUTH);
	        this.add(label);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.pack();
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	    }
	private class relancer implements ActionListener{

	    public void actionPerformed(ActionEvent e) {
	    	 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(relancerBtn);
	         frame.dispose();// fermer la fenêtre courante
	         // créer et ajouter le contenu de la nouvelle fenêtre
	         lancement gui = new lancement();
	     
	    }
	}
	private class quitter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
}
