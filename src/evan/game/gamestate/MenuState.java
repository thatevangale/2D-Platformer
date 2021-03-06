package evan.game.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import evan.game.main.GamePanel;

public class MenuState extends GameState {

	private String[] options = { "Start", "Help", "Quit" };
	private int currentSelection = 0;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {}

	@Override
	public void update(double delta) {}

	@Override
	public void render(Graphics g) {
		
		g.setColor(new Color(100, 50, 200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		for (int i = 0; i < options.length; i++) {
			
			if (i == currentSelection) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.BLACK);
			}
			
			g.setFont(new Font("Arial", Font.PLAIN, 72));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 75, 100 + i * 150);
		}
		
	}

	@Override
	public void keyPressed(int k) {
		
		if (k == KeyEvent.VK_DOWN) {
			currentSelection++;
		} else if (k == KeyEvent.VK_UP) {
			currentSelection--;
		}
		
		if (currentSelection < 0) {
			currentSelection = options.length - 1;
		} else if (currentSelection >= options.length) {
			currentSelection = 0;
		}
		
		if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_Z) {
			switch (currentSelection) {
				case 0: gsm.states.push(new Level1State(gsm));
						break;
				case 1: // help
						break;
				case 2: System.exit(0);
						break;
			}
		}
		
	}

	@Override
	public void keyReleased(int k) {}

}
