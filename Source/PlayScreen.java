import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Point;
import javax.swing.JFrame;

public class PlayScreen extends Screen {

	// The map of the maze.
	Sprite[][] walls = new Sprite[][] {
			{	Sprite.bottomRightBorder, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomLeftBorder, Sprite.blank, Sprite.bottomRightBorder, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomLeftBorder	},

			{	Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.fruit, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.fruit, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.fruit, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.topLeftWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.topWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.leftRightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.bottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.bottomCapWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.bottomWall	},
	/*Mid*/	{	Sprite.teleporter, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.blank, Sprite.blank, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.blank, Sprite.blank, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.teleporter	},
			{	Sprite.topWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.topCapWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.leftRightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.topBottomWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftCapWall, Sprite.bottomWall, Sprite.rightCapWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.topLeftWall, Sprite.topWall, Sprite.topRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.bottomLeftWall, Sprite.bottomWall, Sprite.bottomRightWall, Sprite.pacDot, Sprite.leftWall	},
			{	Sprite.rightWall, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall, Sprite.blank, Sprite.rightWall, Sprite.fruit, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.pacDot, Sprite.leftWall	},
			
			{	Sprite.topRightBorder, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topLeftBorder, Sprite.blank, Sprite.topRightBorder, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topWall, Sprite.topLeftBorder	},
		};


	// The text which reads 'LIVES'
	private Sprite livesText = new Sprite(new boolean[][] {
		{true,false,false,false,false,false,true,true,true,false,true,false,false,false,true,false,true,true,true,true,true,false,false,true,true,true,true},
		{true,false,false,false,false,false,false,true,false,false,true,false,false,false,true,false,true,false,false,false,false,false,true,false,false,false,false},
		{true,false,false,false,false,false,false,true,false,false,true,false,false,false,true,false,true,false,false,false,false,false,true,false,false,false,false},
		{true,false,false,false,false,false,false,true,false,false,true,false,false,false,true,false,true,true,true,true,false,false,false,true,true,true,false},
		{true,false,false,false,false,false,false,true,false,false,false,true,false,true,false,false,true,false,false,false,false,false,false,false,false,false,true},
		{true,false,false,false,false,false,false,true,false,false,false,true,false,true,false,false,true,false,false,false,false,false,false,false,false,false,true},
		{true,true,true,true,true,false,true,true,true,false,false,false,true,false,false,false,true,true,true,true,true,false,true,true,true,true,false}
	});


	// List of all entities, including player
	private ArrayList<Entity> entities;
	// Separate pointer to player entity for easy access
	private Player player;
	// Number of remaining lives.
	private int lives;

	public PlayScreen(Pacman game) {
		super(game);

		player = new Player(new Point(128, 128));

		entities = new ArrayList<Entity>();
		entities.add(player);
		// Add 3 ghosts in different positions with different AIs
		entities.add(new Ghost(new Point(16, 16), Ghost.Type.Follow, player));
		entities.add(new Ghost(new Point(400 - 32, 16), Ghost.Type.Predict, player));
		entities.add(new Ghost(new Point(400 - 32, 400 - 32), Ghost.Type.Random, player));

		// Start with 3 lives
		lives = 3;

	}
	
	@Override
	public void update() {
		
		for (Entity e : entities) {
			e.update(walls, entities);
		}


		// If we get caught, decrease lives and reset ghosts and the player.
		if (player.isCaught()) {
			lives--;

			player.reset(); 
			entities.clear();
			entities.add(player);
			entities.add(new Ghost(new Point(16, 16), Ghost.Type.Follow, player));
			entities.add(new Ghost(new Point(400 - 32, 16), Ghost.Type.Predict, player));
			entities.add(new Ghost(new Point(400 - 32, 400 - 32), Ghost.Type.Random, player));

			// If we've ran out of lives
			if (lives == 0) {
				// If our score is better than the high score, make it the new high score.
				if (Pacman.score >= Pacman.highScore)
					Pacman.highScore = Pacman.score;

				// Go back to the main menu
				Pacman.score = 0;
				game.setScreen(new MenuScreen(game));
			}

		}

	}

	@Override
	public void render(Renderer r) {

		// Draw the maze
		for (int i = 0; i < walls.length; i++) {
			for (int j = 0; j < walls[0].length; j++) {
				r.drawSprite(walls[i][j], new Point(j * 16, 32 + (i * 16)));
			}

		}

		// Draw Entities
		for (Entity e : entities) {
			if (e.shouldDraw()) {
				Point pos = e.getPosition();
				r.drawSprite(e.getSprite(), new Point(pos.x, pos.y + 32));
			}
		}


		// Draw Status Bar
		
		// Draw our lives
		r.drawSprite(livesText, new Point(16, 12));
		for (int i = 0; i < lives; i++) {
			// For each life, draw a pacman sprite, spaced equally.
			r.drawSprite(Sprite.player, new Point(48 + (i * 20), 8));
		}

		// Draw our score
		r.drawSprite(Sprite.scoreText, new Point(175, 12));
		r.drawNumber(Pacman.score, new Point(210, 12));

		// Draw our high score
		r.drawSprite(Sprite.highText, new Point(300, 12));
		r.drawSprite(Sprite.scoreText, new Point(300 + 24 ,12));
		r.drawNumber(Pacman.highScore, new Point(300+35+24, 12));

	}

	@Override
	public String getWindowText() {

		// Display the score, lives and whether we are supercharged. All is visible in the
		// actual game, just for clarity.
		return "<html><br><br><span style='font-size: 24px;'>Mode: " + ((player.isSupercharged()) ? "SUPERCHARGED!" : "Normal") + "<br><br><b>Score:</b> " + game.score + "<br><br>Lives: " + lives + "</span></html>";

	}

	@Override
	public void keyPressed(KeyEvent e) {

		// If the user presses a key, move the player in the appropriate
		// direction.
		switch (e.getKeyCode()) {
			
			case KeyEvent.VK_W:
				player.setDirection(new Point(0, -1));
				break;

			case KeyEvent.VK_A:
				player.setDirection(new Point(-1, 0));
				break;

			case KeyEvent.VK_D:
				player.setDirection(new Point(1, 0));
				break;

			case KeyEvent.VK_S:
				player.setDirection(new Point(0, 1));

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
