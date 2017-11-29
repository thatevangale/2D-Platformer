package evan.game.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import evan.game.gamestate.GameStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private Thread thread;
	private volatile boolean isRunning = false;
	
	public static final int TARGET_FPS = 75; // NOT CURRENTLY WORKING!?
    public static final int TARGET_UPS = 60;
    
    public static final float WORLD_WIDTH = 2.0f;
    public static final float WORLD_HEIGHT = 2.0f;
    
    public static final float SCREEN_WIDTH = WIDTH - 1.0f;
    public static final float SCREEN_HEIGHT = HEIGHT - 1.0f;
    
    public static final float SX = SCREEN_WIDTH / WORLD_WIDTH;
    public static final float SY = SCREEN_HEIGHT / WORLD_HEIGHT;
    
    public static final float TX = SCREEN_WIDTH / 2.0f;
    public static final float TY = SCREEN_HEIGHT / 2.0f;
	
	protected GameStateManager gsm;
	protected GameTimer timer;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		addKeyListener(this);
		setFocusable(true);
		
		timer = new GameTimer();
		gsm = new GameStateManager();
		
		start();
	}
	
	private void start() {
		timer.init();
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		double delta, alpha, acc = 0.0, interval = 1.0 / TARGET_UPS;
		
		while (isRunning) {
			// Get delta time
            delta = timer.getDelta();
            acc += delta;
            
            // Handle input
            input();
			
            // Update game and timer UPS if enough time has passed
            while (acc >= interval) {
            	update(delta);
            	timer.updateUPS();
            	acc -= interval;
            }
			
            // Calculate alpha value for interpolation
            alpha = acc / interval;
            
            // Render game and update timer FPS
            render(alpha);
            timer.updateFPS();
            
            // Update timer
            timer.update();
		}
	}
	
	private void input() {}
	
	
	public void update(double delta) {
		gsm.update(delta);
	}
	
	private void render(double alpha) {
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.drawString("FPS: " + timer.getFPS() + " | UPS: " + timer.getUPS(), 20, 20);
		
		// Matrix3x3f viewport = 
		
		gsm.render(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
}
