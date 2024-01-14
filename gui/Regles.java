package gui;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Regles implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Voici les règles du Luzhanqi et le déroulement du jeu :\n\n"
                                          + "- Le jeu se joue sur un plateau de 25x11 cases.\n"
                                          +"Le plateau du Luzhanqi a différentes cases et chemins qui affectent le mouvement des pièces :\r\n"
                                          + "\r\n"
                                          + "    Postes : représentés par des rectangles sur le plateau. Les pièces peuvent se déplacer sur ces espaces à volonté, et peuvent être attaquées et capturées dedans.\r\n"
                                          + "    Routes : généralement marquées par de fines lignes sur le terrain. Une pièce ne peut parcourir qu'un seul espace sur une route à la fois.\r\n"
                                          + "    Chemins de fer : généralement marqués par des lignes épaisses sur le plateau, une pièce peut parcourir n'importe quel nombre d'espaces\n le long d'un chemin de fer en ligne droite, tant que son chemin n'est pas obstrué par une autre pièce.\r\n"
                                          + "    Campements : représentés par des cercles sur le plateau, il y en a 4 sur le territoire de chaque joueur.\n Une pièce sur un campement ne peut pas être attaquée.\r\n"
                                          + "    Montagnes : les pièces ne peuvent pas se déplacer sur ces deux espaces.\r\n"
                                          + "    Lignes de front : ces trois espaces sont les seuls points par lesquels une pièce peut entrer sur le territoire de l'adversaire.\n Les pièces ne restent pas sur ces cases, elles passent par dessus.\r\n"
                                          + "    Quartiers généraux : positionnés de deux côtés de l'axe central au sixième et dernier rang, du territoire de chaque joueur,\n le drapeau doit être placé sur l'un de ces deux espaces.\n Toute pièce qui a été placée ou qui est entrée dans un quartier général ne peut plus bouger.\n"
                                          + "- Chaque joueur possède un ensemble de pièces, qui sont placées sur leur côté du plateau.\n"
                                          + "- Le but du jeu est de capturer le drapeau de l'adversaire.\n"
                                          + "- Les pièces se déplacent d'une case à la fois, sauf pour le chariot qui peut se déplacer de deux cases.\n"
                                          + "- Les pièces sont capturées en les attaquant sur une case adjacente. Le chariot peut attaquer à distance.\n"
                                          + "- Certaines pièces ont des pouvoirs spéciaux, comme le pouvoir de sauter par-dessus les autres pièces.\n"
                                          + "- Les pièces ne peuvent pas se déplacer sur les cases marquées par un X.\n"
                                          + "- Le joueur qui capture le drapeau adverse gagne la partie.\n\n"
                                          + "Déroulement du jeu :\n\n"
                                          + "- Les joueurs placent leurs pièces sur leur côté du plateau.\n"
                                          + "- Les joueurs jouent tour à tour en déplaçant une de leurs pièces.\n"
                                          + "- Si une pièce attaque une pièce adverse, la pièce attaquée est capturée et retirée du plateau.\n"
                                          + "- Si une pièce atteint la ligne d'arrivée de l'adversaire, elle peut être promue en une pièce plus puissante.\n"
                                          + "- Le joueur qui capture le drapeau adverse gagne la partie.\n");
    }
}

