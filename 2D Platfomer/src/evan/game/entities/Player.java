package evan.game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import evan.game.main.GamePanel;

public class Player {
	
	private boolean right = false, left = false, jumping = false, falling = false;
	
	private double x, y;
	private int width, height;
	
	// Old
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;

	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}
	
	public void update() {
		
		if (right) {
			x += 4;
		}
		
		if (left) {
			x -= 4;
		}
		
		if (jumping) {
			y -= currentJumpSpeed;
			currentJumpSpeed -= 0.1;
			
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		
		if (falling) {
			y += currentFallSpeed;
			
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.1;
			}
		} else if (!falling) {
			currentFallSpeed = 0.1;
		}
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	public void keyPressed(int k) {
		
		if (k == KeyEvent.VK_RIGHT) {
			right = true;
		}
		
		if (k == KeyEvent.VK_LEFT) {
			left = true;
		}
		
		if (k == KeyEvent.VK_UP) {
			jumping = true;
		}
		
	}
	
	public void keyReleased(int k) {
		
		if (k == KeyEvent.VK_RIGHT) {
			right = false;
		}
		
		if (k == KeyEvent.VK_LEFT) {
			left = false;
		}
		
	}
	
}
