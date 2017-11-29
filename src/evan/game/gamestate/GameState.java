package evan.game.gamestate;

import java.awt.Graphics;

public abstract class GameState {

	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	
	public abstract void init();
	
	public abstract void update(double delta);
	
	public abstract void render(Graphics g);
	
	public abstract void keyPressed(int k);
	
	public abstract void keyReleased(int k);
}
