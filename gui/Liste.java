package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Liste extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel Op = new JLabel("Ordre de placement des pions du rang le plus fort au plus faible :     ");
	private JLabel Mar = new JLabel(" \n\r 1) Marechal : Rang 9    ");
	private JLabel Ge = new JLabel(" \n\r 2) General : Rang 8   ");
	private JLabel Gd = new JLabel(" \n\r 3) Genereaux de division : Rang 7     ");
	private JLabel Bg = new JLabel(" \n\r 4) Brigadiers généreaux : Rang 6    ");
	private JLabel Col = new JLabel(" \n\r 5) Colonels : Rang 5    ");
	private JLabel Com = new JLabel(" \n\r 6) Commandants : Rang 4     ");
	private JLabel Cap = new JLabel(" \n\r 7) Capitaines : Rang 3   ");
	private JLabel Lieu = new JLabel(" \n\r 7) Lieutenants : Rang 2    ");
	private JLabel Ing = new JLabel(" \n\r 8) Ingenieurs : Rang 1   ");
	private JLabel Drap = new JLabel(" \n\r 9) Drapeau si on clique sur la case du QG : Rang 0    ");
	private JLabel Bom = new JLabel(" \n\r 10) Bombes : Rang -5    ");
	private JLabel Mt = new JLabel(" \n\r 11) Mines Terrestres : Placez les sur les deux premières lignes  : Rang -5     ");
	

	public Liste() {
		JPanel Panel= new JPanel();
		Panel.add(Op);
		Panel.add(Mar);
		Panel.add(Ge);
		Panel.add(Gd);
		Panel.add(Bg);
		Panel.add(Col);
		Panel.add(Com);
		Panel.add(Cap);
		Panel.add(Lieu);
		Panel.add(Ing);
		Panel.add(Drap);
		Panel.add(Bom);
		Panel.add(Mt);
		Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
		this.add(Panel);
		
		
	}


}