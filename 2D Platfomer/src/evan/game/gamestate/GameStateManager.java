package evan.game.gamestate;

import java.awt.Graphics;
import java.util.Stack;

public class GameStateManager {
	
	public Stack<GameState> states;

	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new MenuState(this));
	}
	
	public void update(float delta) {
		states.peek().update(delta);
	}
	
	public void render(Graphics g) {
		states.peek().render(g);
	}
	
	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k) {
		states.peek().keyReleased(k);
	}
	
}
