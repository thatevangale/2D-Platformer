package evan.game.entities;

import evan.game.main.Vector2f;

public abstract class Entity {
	
	protected Vector2f previousPosition;
    protected Vector2f currentPosition;

    //protected final AABB aabb;

    protected final float speed;
    protected Vector2f direction;

    /*protected final Color color;
    protected final Texture texture;*/

    protected final int width;
    protected final int height;

    protected final int tx;
    protected final int ty;
    
    public Entity(float x, float y, float speed, int width, int height, int tx, int ty) {
    	previousPosition = new Vector2f(x, y);
    	currentPosition = new Vector2f(x, y);
    	
    	this.speed = speed;
    	direction = new Vector2f();
    	
    	this.width = width;
        this.height = height;

        this.tx = tx;
        this.ty = ty;
    }
    
    public abstract void input(Entity entity);

	/**
     * Updates the entity.
     *
     * @param delta Time difference in seconds
     */
    public void update(float delta) {
    	
        previousPosition = new Vector2f(currentPosition.x, currentPosition.y);
        
        if (direction.length() != 0) {
            direction = direction.normalize();
        }
        
        Vector2f velocity = direction.scale(speed);
        currentPosition = currentPosition.add(velocity.scale(delta));

        /*aabb.min.x = position.x;
        aabb.min.y = position.y;
        aabb.max.x = position.x + width;
        aabb.max.y = position.y + height;*/
    }
    
    /*public void render(Renderer renderer, float alpha) {
        Vector2f interpolatedPosition = previousPosition.lerp(position, alpha);
        float x = interpolatedPosition.x;
        float y = interpolatedPosition.y;
        renderer.drawTextureRegion(texture, x, y, tx, ty, width, height, color);
    }*/
	
}
