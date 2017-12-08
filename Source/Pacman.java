import uk.ac.warwick.dcs.maze.logic.*;
import uk.ac.warwick.dcs.maze.gui.MazeGridPanel;

import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

// The main game class
public class Pacman {

	// Swing elements for the input window.
	private JFrame window;
	private JPanel windowContent;
	private JLabel textLabel;

	private Renderer r; // Used to draw to the maze
	private Maze maze; // The actual maze
	private int steps; // A counter incremented each game tick
	public static int score; // The current score
	public static int highScore; // The highest score so far
	private Screen currentScreen; // The active screen

	public Pacman() {
		
		// Initialise Variables
		steps = 0;
		score = 0;
		highScore = 0;

		// Setup Input Window
		window = new JFrame("Input Window");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setVisible(true);
		window.setFocusable(true);
		window.setLayout(new FlowLayout());

		textLabel = new JLabel("");

		window.add(textLabel);

		// Set the initial screen to be the menu
		setScreen(new MenuScreen(this));


	}

	public void controlRobot(IRobot robot) {

		if (steps == 0) {
			// At the start, get the maze using refleciton
			try {
				Field mazeField = robot.getClass().getDeclaredField("maze");
				mazeField.setAccessible(true);
				maze = (Maze)mazeField.get(robot);

				// Create our renderer
				r = new Renderer(maze);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Clear Screen, update, and draw new screen.
		r.clear();
		currentScreen.update();
		currentScreen.render(r);
		r.display();

		// Draw the elements on the input window.
		drawUI();

	}

	private void drawUI() {
		
		// Set the text in the input window based on what the current screen wants.
		textLabel.setText(currentScreen.getWindowText());

	}

	public void setScreen(Screen s) {

		// Add the screen as a key listener, so it can recieve key events.
		window.addKeyListener(s);
		// Then set it to the current screen.
		currentScreen = s;	
	}

}
