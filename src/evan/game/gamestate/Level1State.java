package evan.game.gamestate;

import java.awt.Graphics;

import evan.game.entities.Player;

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
	public void update(float delta) {
		player.update(delta);
	}

	@Override
	public void render(Graphics g) {
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
