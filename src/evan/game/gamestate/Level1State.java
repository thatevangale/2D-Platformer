package evan.game.gamestate;

import java.awt.Color;
import java.awt.Graphics;

import evan.game.entities.Player;
import evan.game.main.GamePanel;

public class Level1State extends GameState {

	private Player player;
	
	public Level1State(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		player = new Player(32, 32);
	}

	@Override
	public void update(double delta) {
		player.update(delta);
	}

	@Override
	public void render(Graphics g) {
		// Draw background
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// Loop through and draw all of the entities
		player.render(g);
	}

	@Override
	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	@Override
	public void keyReleased(int k) {
		player.keyReleased(k);
	}

}
