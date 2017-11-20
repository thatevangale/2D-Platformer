package evan.game.main;

public class Timer {
	
    // System time since last loop.
    private double lastLoopTime;
    
    // Used for FPS and UPS calculation.
    private float timeCount;

    // Frames per second.
    private int fps;
    
    // Counter for the FPS calculation.
    private int fpsCount;
	
	// Initializes the timer.
    public void init() {
        lastLoopTime = getTime();
    }

    /**
     * Returns the time elapsed since <code>glfwInit()</code> in seconds.
     *
     * @return System time in seconds
     */
    public double getTime() {
        return System.nanoTime() / 1000000000.0;
    }

    /**
     * Returns the time that have passed since the last loop.
     *
     * @return Delta time in seconds
     */
    public float getDelta() {
    	double time = getTime();
        float delta = (float) (time - lastLoopTime);
        lastLoopTime = time;
        timeCount += delta;
        return delta;
    }
    
    /**
     * Updates the FPS counter.
     */
    public void updateFPS() {
        fpsCount++;
    }
    
    /**
     * Updates FPS and UPS if a whole second has passed.
     */
    public void update() {
        if (timeCount > 1f) {
            fps = fpsCount;
            fpsCount = 0;

            //ups = upsCount;
            //upsCount = 0;

            timeCount -= 1f;
        }
    }
    
    /**
     * Getter for the FPS.
     *
     * @return Frames per second
     */
    public int getFPS() {
        return fps > 0 ? fps : fpsCount;
    }
	
}
