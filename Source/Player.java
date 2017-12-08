import java.awt.event.*;
import java.awt.Point;
import java.util.ArrayList;

public class Player extends Entity {

	private Point velocity; // Added to the position each frame.
	// The user can press a direction in advance, and the player will move
	// in that direction when available. This variables stores that directon.
	private Point queuedVelocity;

	// the right sprite is store as 'sprite' inherited from Entity.
	private Sprite leftSprite;
	private Sprite upSprite;
	private Sprite downSprite;

	// How long is remaining in super charge mode.
	int superChargeDuration;
	boolean caught; // True if the player has been caught by a ghost.

	
	public Player(Point position) {
		super(position, Sprite.player, 4);

		velocity = new Point(speed, 0);
		queuedVelocity = new Point(speed, 0);
		superChargeDuration = 0;
		caught = false;
		
		boolean[][] pixels = sprite.getPixels();
		
		// Caclualte leftSprite by flipping horizontally.	
		boolean[][] leftPixels = new boolean[16][16];
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < 8; j++) {
				leftPixels[i][15-j] = pixels[i][j];
				leftPixels[i][j] = pixels[i][15-j];
			}
		}
		leftSprite = new Sprite(leftPixels);


		// Calculate downSprite by flipping x and y
		boolean[][] downPixels = new boolean[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				downPixels[j][i] = pixels[i][j];
			}
		}
		downSprite = new Sprite(downPixels);


		// Calculate upSprite byfliiping downSprite vertically
		boolean[][] upPixels = new boolean[16][16];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 16; j++) {
				upPixels[15-i][j] = downPixels[i][j];
				upPixels[i][j] = downPixels[15-i][j];
			}
		}
		upSprite = new Sprite(upPixels);


	}

	public boolean isSupercharged() {
		return (superChargeDuration > 0);
	}

	public int getSuperchargeDuration() {
		return superChargeDuration;
	}

	public boolean isCaught() {
		return caught;
	}

	@Override
	public boolean shouldDraw() {
		return !caught;
	}

	@Override
	public void update(Sprite[][] map, ArrayList<Entity> entities) {

		
		// If we're in supercharge mode, decrease the duration by 1 each frame.
		if (superChargeDuration > 0) {
			superChargeDuration--;
		}
		
		// Move based on the walls.
		ArrayList<Point> testPoints = new ArrayList<Point>();
		Point topLeft = new Point(position.x + queuedVelocity.x, position.y + queuedVelocity.y);

		// The four corners of the player that we need to check for collisions.
		// This is for checking our queued velocity.
		testPoints.add(topLeft);
		testPoints.add(new Point(topLeft.x + 15, topLeft.y + 15));
		testPoints.add(new Point(topLeft.x + 15, topLeft.y));
		testPoints.add(new Point(topLeft.x, topLeft.y + 15));

		// If any of the corners results in a collisions, it's not valid.
		boolean collision = false;
		for (Point p : testPoints) {
			if (map[p.y / 16][p.x / 16] instanceof Wall) {
				collision = true;
				break;
			}

		}
		
		if (!collision) {
			// If there was no collision, we can go in that direction.
			velocity.x = queuedVelocity.x;
			velocity.y = queuedVelocity.y;
			position.translate(velocity.x, velocity.y);
		} else {
			// Otherwise, continue the way we were going.
			// If that causes a collision, just stop.
			collision = false;

			testPoints = new ArrayList<Point>();
			topLeft = new Point(position.x + velocity.x, position.y + velocity.y);

			testPoints.add(topLeft);
			testPoints.add(new Point(topLeft.x + 15, topLeft.y + 15));
			testPoints.add(new Point(topLeft.x + 15, topLeft.y));
			testPoints.add(new Point(topLeft.x, topLeft.y + 15));

			for (Point p : testPoints) {
				if (map[p.y / 16][p.x / 16] instanceof Wall) {
					collision = true;
					break;
				}

			}


			if (!collision)
				position.translate(velocity.x, velocity.y);

		}
		
		
		for (Point p : testPoints) {

			if (map[p.y / 16][p.x / 16] == Sprite.pacDot) {

				map[p.y / 16][p.x / 16] = Sprite.blank;
				Pacman.score += 5;

			} else if (map[p.y / 16][p.x / 16] == Sprite.fruit) {
				
				superChargeDuration = 60;
				map[p.y / 16][p.x / 16] = Sprite.blank;

			}

		}

		// If at left teleporter
		if (position.x < 16) {
			position.x = 400 - 32;
		} else if (position.x > 400 - 32) {
			position.x = 16;
		}

		
		for (Entity e : entities) {
			if (e instanceof Ghost && colliding(e)) {
				// If we collided with a ghost, kill it if we're
				// supercharged, otherwise we get caught.
				if (superChargeDuration > 0) {

					((Ghost)e).kill();
					Pacman.score += 50;
					
				} else {
					
					caught = true;

				}

			}
		}


	}

	@Override
	public Sprite getSprite() {

		// Depending on the direction we are going, draw a different sprite.
		if (velocity.y == -speed) {
			return upSprite;
		} else if (velocity.y == speed) {
			return downSprite;
		} else if (velocity.x == -speed) {
			return leftSprite;
		} else {
			return sprite;
		}

	}

	public Point getVelocity() {
		return velocity;
	}

	// Called when the user clicks a direction key.
	public void setDirection(Point dir) {
		queuedVelocity.x = dir.x * speed;
		queuedVelocity.y = dir.y * speed;
	}

	// Sets the ghost back to it's original position.
	public void reset() {
		caught = false;
		position.x = 128;
		position.y = 128;
	}

}
