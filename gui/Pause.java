package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Pause implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        // Afficher un message de pause avec les options "Reprendre" et "Quitter"
        int choice = JOptionPane.showOptionDialog(null,
                "Vous êtes en pause",
                "Pause",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Reprendre", "Quitter"},
                "Reprendre");
        // Traiter le choix de l'utilisateur
        if (choice == JOptionPane.NO_OPTION) {
            // Quitter l'application si l'utilisateur a choisi "Quitter"
            System.exit(0);
        }
    }
}
