import uk.ac.warwick.dcs.maze.logic.*;
import uk.ac.warwick.dcs.maze.gui.MazeGridPanel;

import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

import java.awt.Point;
import java.awt.Color;

public class Renderer {

	// The maze to draw
	private Maze maze;

	public Renderer(Maze maze) {
		this.maze = maze;

		try {
			// Set the colors to black and white.
			setStaticFinalField(MazeGridPanel.class.getDeclaredField("BEENBG"), new Color(255, 255, 255));
			setStaticFinalField(MazeGridPanel.class.getDeclaredField("WALLBG"), new Color(0, 0, 0));
			setStaticFinalField(MazeGridPanel.class.getDeclaredField("PASSAGEBG"), new Color(255, 255, 255));
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			// Resize the maze to the desired size.
			Field gridField = maze.getClass().getDeclaredField("grid");
			gridField.setAccessible(true);
			gridField.set(maze, new int[400][432]);

			// Move the green target square off screen.
			Field targetField = maze.getClass().getDeclaredField("finish");
			targetField.setAccessible(true);
			targetField.set(maze, new Point(-1000, -1000));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method to draw a sprite at a specific position. Sprite's pixels should
	 * be a rectangular array
	 */
	public void drawSprite(Sprite sprite, Point position) {

		// If the sprite is null, just draw a blank.
		boolean[][] pixels = (sprite != null) ? sprite.getPixels() : Sprite.blank.getPixels();

		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[0].length; j++) {
				maze.setCellType(position.x + j, position.y + i, pixels[i][j] ? Maze.WALL : Maze.PASSAGE);
			}
		}

	}

	/*
	 * Draws an integer number to the screen at the given position.
	 */
	public void drawNumber(int num, Point position) {
		// Convert our number to a string
		String s = String.valueOf(num);
		// The current width of the drawn number
		int width = 0;

		// For every digit of the number
		for (char c : s.toCharArray()) {
			
			// Get the appropriate sprite based on the digit.
			Sprite charSprite;
			switch (c) {
				case '0':
					charSprite = Sprite.num0;
					break;

				case '1':
					charSprite = Sprite.num1;
					break;

				case '2':
					charSprite = Sprite.num2;
					break;

				case '3':
					charSprite = Sprite.num3;
					break;

				case '4':
					charSprite = Sprite.num4;
					break;

				case '5':
					charSprite = Sprite.num5;
					break;

				case '6':
					charSprite = Sprite.num6;
					break;

				case '7':
					charSprite = Sprite.num7;
					break;

				case '8':
					charSprite = Sprite.num8;
					break;

				case '9':
					charSprite = Sprite.num9;
					break;

				default:
					charSprite = Sprite.blank;
					break;

			}

			// Draw the sprite at the next position along.
			drawSprite(charSprite, new Point(position.x + width, position.y));
			// Add the width of the sprite to the total width of the text,
			// plus 2 for spacing between letters.
			width += charSprite.getPixels()[0].length + 2;

		}
	}

	/*
	 * Method which clears the screen with white.
	 */
	public void clear() {
		
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < 25; j++) {
				drawSprite(Sprite.blank, new Point(j * 16, i * 16));
			}
		}

	}

	/*
	 * This must be called after drawing everything, and it will
	 * update the changes on the screen
	 */
	public void display() {

		EventBus.broadcast(new Event(IEvent.NEW_MAZE, maze));

	}

	/*
	 * Helper method to set a static final field using reflection.
	 */
	private static void setStaticFinalField(Field field, Object value) throws Exception {
		field.setAccessible(true);
		Field modifierField = Field.class.getDeclaredField("modifiers");

		AccessController.doPrivileged(new PrivilegedAction() {
			@Override
			public Object run() {
				modifierField.setAccessible(true);
				return null;
			}
		});

		// Use bitwise operation to remove the final flag.
		modifierField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.set(null, value);
	}



}
