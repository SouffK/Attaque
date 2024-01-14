package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Stat2 extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel j1;
    private JLabel nbTotal1;

    private JLabel j2;
    private JLabel nbTotal2;

    private JButton pause;
    private JButton btnRegles;

    public Stat2() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(200, 200));

        // Label pour le joueur 1
        this.j1 = new JLabel("Joueur 1", SwingConstants.CENTER);
        this.j1.setAlignmentX(CENTER_ALIGNMENT);
        this.j1.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(this.j1);

        // Nombre total de pièces restantes pour le joueur 1
        this.nbTotal1 = new JLabel("Nombre de pièces totales restantes : 25");
        this.nbTotal1.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalStrut(10));
        this.add(this.nbTotal1);

        // Label pour le joueur 2
        this.add(Box.createVerticalStrut(20));
        this.j2 = new JLabel("Joueur 2", SwingConstants.CENTER);
        this.j2.setAlignmentX(CENTER_ALIGNMENT);
        this.j2.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(this.j2);

        // Nombre total de pièces restantes pour le joueur 2
        this.nbTotal2 = new JLabel("Nombre de pièces totales restantes : 25");
        this.nbTotal2.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalStrut(10));
        this.add(this.nbTotal2);

        // Boutons pause et règles
        this.add(Box.createVerticalStrut(20));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        this.pause = new JButton("Pause");
        this.btnRegles = new JButton("Règles");
        buttonPanel.add(this.pause);
        buttonPanel.add(this.btnRegles);
        this.add(buttonPanel);

        // Ecouteurs de boutons
        this.btnRegles.addActionListener(new Regles());
        this.pause.addActionListener(new Pause());
    }

    public void updateScoreboard(int blackPieces, int whitePieces) {
        this.nbTotal1.setText("Nombre de pièces totales restantes : " + blackPieces);
        this.nbTotal2.setText("Nombre de pièces totales restantes : " + whitePieces);
    }
}
