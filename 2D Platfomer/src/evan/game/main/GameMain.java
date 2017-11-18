package evan.game.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/*
 * Author: Evan Gale
 * Date:   17/11/2017
*/

public class GameMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Platformer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new GamePanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
