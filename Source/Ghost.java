import java.awt.Point;
import java.util.ArrayList;

public class Ghost extends Entity {
	
	// A 'pointer' to the player, so we can determine where to move based on
	// their position.
	private Player player;
	// The value that will be added to our position each frame.
	private Point velocity;
	private int respawnTimer; // How long until the ghost respawns.
	private GhostState state; // See GhostState enum
	private Type type; // See Type enum

	// Used to determine what the ghost should be doing. Normally they will
	// chase the player, but when the player is supercharged they should run.
	// The ghosts also 'die' when eaten by the player.
	private enum GhostState {
		Chase,
		Run,
		Dead
	}

	// What type of AI the ghost should be using:
	public enum Type {
		Follow, // Moves to the square that gets it closest to the player
		Predict, // Moves to the square the player is heading for.
		// Performs like follow, but when within a certain radius of the
 		// player it goes to a random corner.
		Random
	}

	// The time a ghost takes to respawn.
	private static final int respawnDuration = 25;

	// Constructor to initialise variables.
	public Ghost(Point position, Type type, Player player) {
		super(position, Sprite.ghost, 4);

		this.player = player;
		this.velocity = new Point(0, 0);
		this.type = type;
		state = GhostState.Chase; // Initially chase.
		respawnTimer = 0;
	}

	// Method used by the player to kill a ghost.
	public void kill() {
		// Go dead state 
		state = GhostState.Dead;
		// Respawn timer is the flat repsawn duration, plus a random extra
		// so if multiple ghosts are eaten simultaenously they dont spawn
		// at the same time.
		respawnTimer = respawnDuration + ((int)(Math.random() * 15));
	}

	@Override
	public boolean shouldDraw() {
		return ((state != GhostState.Dead) && !(state == GhostState.Run && player.getSuperchargeDuration() < 18 && player.getSuperchargeDuration() % 2 == 0));
	}

	@Override
	public void update(Sprite[][] map, ArrayList<Entity> entities) {

		boolean playerSupercharged = player.isSupercharged();

		// If we're dead, decrease respawn timer.
		if (state == GhostState.Dead) {
			if (respawnTimer > 0) {
				respawnTimer--;
				return;
			}

			// We have revived, so set our position to the center.
			position.x = 12 * 16;
			position.y = 12 * 16;
		}

		// If the player is supercharged, run away with lower speed.
		if (playerSupercharged) {
			state = GhostState.Run;
			speed = 2;
		} else {
			// Make sure that the posiiton is a multiple of 4. Otherwise
			// the position won't 'line up' with the map and we can't get
			// around corners.
			position.x -= position.x % 4;
			position.y -= position.y % 4;
			
			// Set our state to chase, and speed to 4.
			state = GhostState.Chase;
			speed = 4;
		}


		// List of all the directions which won't cause a collision.
		ArrayList<Point> possibleDirections = new ArrayList<Point>();

		// Check if eahc of the directions do not cause a collision, by
		// checking if that tile in the maze is a wall.

		// Up
		if (!(map[(position.y - speed) / 16][(position.x) / 16] instanceof Wall) && !(map[(position.y - speed) / 16][(position.x + 15) / 16] instanceof Wall))
			possibleDirections.add(new Point(0, -speed));

		// Down
		if (!(map[(position.y + 15 + speed) / 16][(position.x) / 16] instanceof Wall) && !(map[(position.y + 15 + speed) / 16][(position.x + 15) / 16] instanceof Wall))
			possibleDirections.add(new Point(0, speed));

		// Right
		if (!(map[(position.y) / 16][(position.x + 15 + speed) / 16] instanceof Wall) && !(map[(position.y + 15) / 16][(position.x + 15 + speed) / 16] instanceof Wall))
			possibleDirections.add(new Point(speed, 0));

		// Left
		if (!(map[(position.y) / 16][(position.x - speed) / 16] instanceof Wall) && !(map[(position.y + 15) / 16][(position.x - speed) / 16] instanceof Wall))
			possibleDirections.add(new Point(-speed, 0));


		// Remove the direction which is backwards to the way we were going
		{	
			int velX = (int)Math.signum(velocity.x);
			int velY = (int)Math.signum(velocity.y);

			for (int i = 0; i < possibleDirections.size(); i++) {
				Point dir = possibleDirections.get(i);

				int dirX = (int)Math.signum(dir.x);
				int dirY = (int)Math.signum(dir.y);

				if ((dirX == -velX) && (dirY == -velY)) {
					possibleDirections.remove(i);
					break;
				}

			}
		}
	

		// If we are not completely blocked in (which should never happen)
		if (!possibleDirections.isEmpty()) {

			Point target;
			Point playerPos = new Point(player.getPosition().x, player.getPosition().y);
			
			// Depending on our ghost's type, calculate the target position.
			switch (type) {
				case Follow:
					target = new Point(playerPos.x, playerPos.y);
					break;

				case Predict:
					Point playerVel = player.getVelocity();
					// target is where the player would be in 16 frames, if
					// they kept moving in the same direction.
					target = new Point(playerPos.x + (Integer.signum(playerVel.x) * 64), playerPos.y + (Integer.signum(playerVel.y) * 64));
					break;

				case Random:
					// When we get near the player:
					if (playerPos.distance(position) < 120) {
						
						// Pick a random corner as the target.
						switch ( (int)(Math.random() * 4 ) ) {
							case 1:
								target = new Point(0, 0);
								break;

							case 2:
								target = new Point(400, 0);
								break;

							case 3:
								target = new Point(0, 400);
								break;

							default:
								target = new Point(400, 400);
								break;
						}

					} else {
						// Otherwise we are quite far from the player, so move
						// closer.
						target = new Point(playerPos.x, playerPos.y);
					}
					break;

				default:
					target = new Point(0, 0);

			}

			// To store the index of the direction which gets us cloest to the target. 
			int index = -1; 			
			// The closest we've got so far.
			double currentShortest = target.distance(position);

			// For every non-colliding direction, check if it gets us closer 
			// to the target. If it does, make it our new best direction.
			for (int i = 0; i < possibleDirections.size(); i++) {
				Point direction = possibleDirections.get(i);

				Point projectedPosition = new Point(position.x + direction.x, position.y + direction.y);
				double distance = target.distance(projectedPosition);

				// If we are in run state, we want to move away. So we actually
				// pick the direction which puts the largest distance between
				// us and the target.
				if ((distance < currentShortest) != (state == GhostState.Run)) {
					currentShortest = distance;
					index = i;
				}
			}

			// If none of the directions get us any closer to the target, pick
			// one at random.
			if (index == -1)
				velocity = possibleDirections.get((int)(Math.random() * possibleDirections.size()));
			else
				// Otherwise pick the best one.
				velocity = possibleDirections.get(index);

			// Move the ghost by its velocity.
			position.translate(velocity.x, velocity.y);

		}


		// If at left teleporter
		if (position.x < 16) {
			// Teleport to the right teleporter. Not directly on it, otherwise
			// we'd teleport back again next frame.
			position.x = 400 - 32;
		} else if (position.x > 400 - 32) { // Same for right teleporter.
			position.x = 16;
		}
	
	}

}
