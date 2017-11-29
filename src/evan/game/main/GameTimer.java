package evan.game.main;

public class GameTimer {
	
    // System time since last loop.
    private long nsLastTime;
    
    // Used for FPS and UPS calculation.
    private double timeCount;

    // Frames per second and counter for FPS calculation.
    private int fps;
    private int fpsCount;
    
    // Updates per second and counter for UPS calculation.
    private int ups;
    private int upsCount;
	
	// Initializes the timer.
    public void init() {
    	nsLastTime = getTime();
    }

    /**
     * Returns the time elapsed since window opened in nanoseconds.
     *
     * @return System time in nanoseconds
     */
    public long getTime() {
        return System.nanoTime();
    }

    /**
     * Returns the time that have passed since the last loop.
     *
     * @return Delta time in seconds
     */
    public double getDelta() {
    	// Calculate delta time
    	long nsCurrentTime = getTime();
    	double nsDeltaTime = nsCurrentTime - nsLastTime;
    	
    	// Running running values
    	nsLastTime = nsCurrentTime;
        timeCount += nsDeltaTime / 1.0e9;
        
        return nsDeltaTime / 1.0e9;
    }
    
    /**
     * Updates the FPS counter.
     */
    public void updateFPS() {
        fpsCount++;
    }
    
    /**
     * Updates the UPS counter.
     */
    public void updateUPS() {
        upsCount++;
    }
    
    /**
     * Resets FPS and UPS if a whole second has passed.
     */
    public void update() {
        if (timeCount > 1.0) {
            fps = fpsCount;
            fpsCount = 0;

            ups = upsCount;
            upsCount = 0;

            timeCount -= 1.0;
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
    
    /**
     * Getter for the UPS.
     *
     * @return Updates per second
     */
	public int getUPS() {
		return ups > 0 ? ups : upsCount;
	}
	
}
