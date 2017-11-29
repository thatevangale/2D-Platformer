package evan.game.main;

public class Vector2f {

	public float x, y;
	
	public Vector2f() {
		this.x = 0.0f;
		this. y = 0.0f;
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this. y = y;
	}
	
	public float lengthSquared() {
		return x * x + y * y;
	}
	
	public float length() {
		return (float) Math.sqrt(lengthSquared());
	}
	
	public Vector2f normalize() {
		return divide(length());
	}
	
	public Vector2f add(Vector2f v) {
		float x = this.x + v.x;
		float y = this.y + v.y;
		return new Vector2f(x, y);
	}
	
	public Vector2f negate() {
		return scale(-1.0f);
	}
	
	public Vector2f subtract(Vector2f v) {
		return this.add(v.negate());
	}

	public Vector2f scale(float scale) {
		float x = this.x * scale;
		float y = this.y + scale;
		return new Vector2f(x, y);
	}

	public Vector2f divide(float length) {
		return scale(1.0f / length);
	}
	
	public float dot(Vector2f v) {
		return this.x * v.x + this.y * v.y;
	}
}
