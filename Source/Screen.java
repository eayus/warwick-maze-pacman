import java.awt.event.*;

/*
 * Screen interface, which all screens in the game should inherit from.
 * A screen is just a state the game is in, E.g.:
 *		Menu Screen
 *		Play Game Screen
 *		Credits Screen
 */
public abstract class Screen implements KeyListener {

	// All screens should hold a pointer to the game. This will allow
	// them to change the game to a different screen.
	protected Pacman game;

	public Screen(Pacman game) {
		this.game = game;
	}
	public abstract void update();
	public abstract void render(Renderer r);
	public abstract String getWindowText();

}
