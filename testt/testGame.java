package testt;
import gui.MainGUIV2;
public class testGame {
	public static void main(String[] args) {

		MainGUIV2 gameMainGUI = new MainGUIV2("Luzhanqi game");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}

}