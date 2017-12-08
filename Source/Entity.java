import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

// A class from which all movable objects will inherit.
public abstract class Entity {
	
	protected Point position; // The position of the object.
	protected Sprite sprite; // The object's 'sprite' (the image that will be drawn).
	protected int speed; // How many pixels the object can move each frame.


	/*
	 * Constructor for the Entity class. Initialises the variables passed to the
	 * constructor.
	 *
	 * @param position The Entity's position
	 * @param sprite The Entity's sprite
	 * @param speed The amount of pixels the Entity can move each frame.
	 */
	public Entity(Point position, Sprite sprite, int speed) {
		this.position = position;
		this.sprite = sprite;
		this.speed = speed;
	}

	/*
	 * Returns the current position of the Entity.
	 *
	 * @return A Point object which is the position of the Entity.
	 */
	public Point getPosition() {
		return position;
	}

	/*
	 * Returns the Entity's Sprite.
	 *
	 * @return A Sprite object which is the Entity's Sprite.
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/*
	 * Returns a rectangle which should be used for detecting collision. The
	 * rectangle is relative to the Maze space.
	 *
	 * @return A Rectangle object which contains the position and dimensions
	 * of the Entity's bounding box.
	 */
	public Rectangle getBoundingBox() {
		Rectangle sprBounds = sprite.getBounds();
		return new Rectangle(position.x + sprBounds.x, position.y + sprBounds.y, sprBounds.width, sprBounds.height);
	}

	/*
	 * Determines whether two entities are colliding, based on whether their
	 * bounding boxes overlap.
	 *
	 * @return A boolean which is true if they are colliding, false if not.
	 */
	public boolean colliding(Entity other) {
		
		return colliding(other.getBoundingBox());

	}

	/*
	 * Determines whether an entity collides with a rectangle, based on the
	 * Entity's bounding box.
	 *
	 * @return A boolean which is true if they are colliding, false if not.
	 */
	public boolean colliding(Rectangle rect) {
		
		return (getBoundingBox().intersects(rect));

	}

	/*
	 * Should be called every frame. Updates the Entity's position, and
	 * anything else it wants to do every frame. To do this it requires
	 * information about the maze, and the other entities.
	 *
	 * @param map A 2D array of sprites which represents the maze.
	 * @param entities An ArrayList of all of the entities in the game.
	 */
	public abstract void update(Sprite[][] map, ArrayList<Entity> entities);

	/*
	 * Determines whether an entity should be drawn.
	 *
	 * @return A boolean which is true if the entity should be drawn, else false.
	 */
	public abstract boolean shouldDraw();

}
