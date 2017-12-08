import java.awt.Rectangle;

public class Sprite {
	
	// A class which is drawable to the screen. It represents a
	// black and white image, drawn by drawing walls to the screen.

	// 2D Array of all the pixels.
	// true = black, false = white.
	private boolean[][] pixels;
	// Bounds relative to the position of the sprite. Some objects
	// will want a bounding box smaller than the actual sprite,
	// which this allows us to do.
	private Rectangle bounds;

	public Sprite(boolean[][] pixels) {
		this(pixels, new Rectangle(0, 0, 16, 16));
	}

	public Sprite(boolean[][] pixels, Rectangle bounds) {
		this.pixels = pixels;
		this.bounds = bounds;
	}

	public boolean[][] getPixels() {
		return pixels;
	}

	public void setPixels(boolean[][] pixels) {
		this.pixels = pixels;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	/*
	 * These are a bunch of static sprites. They include various things from
	 * the player's sprite, the walls, etc.
	 *
	 * Ideally these would be specified in a different file and loaded in at
	 * run time, but this is not possible since we are only allowed to
	 * submit one file.
	 */

	public static Sprite blank = new Sprite(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});

	public static Sprite teleporter = new Sprite(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});


	public static Sprite fruit = new Sprite(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	true,	true,		true,	true,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	true,	true,	true,		true,	true,	true,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	true,	true,	true,	true,		true,	true,	true,	true,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	true,	true,	true,	true,		true,	true,	true,	true,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	true,	true,	true,	true,		true,	true,	true,	true,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	true,	true,	true,	true,		true,	true,	true,	true,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	true,	true,	true,		true,	true,	true,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	true,	true,		true,	true,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	}, new Rectangle(5, 5, 6, 6));




	public static Sprite player = new Sprite(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false,	},
		{	false,	false,	false,	false,	false,	false,	true,	true,		true,	true,	true,	false,	false,	false,	false,	false,	},
		{	false,	false,	false,	false,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	false,	},
		{	false,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false,	},
		{	false,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false,	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	false,	false,	false,	false,	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	false,	false,	false,	false,	false,	false,	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		false,	false,	false,	false,	false,	false,	false,	false,	},

		{	false,	false,	true,	true,	true,	true,	true,	true,		false,	false,	false,	false,	false,	false,	false,	false,	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	false,	false,	false,	false,	false,	false,	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	false,	false,	false,	false,	},
		{	false,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false,	},
		{	false,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false,	},
		{	false,	false,	false,	false,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	false,	},
		{	false,	false,	false,	false,	false,	false,	true,	true,		true,	true,	true,	false,	false,	false,	false,	false,	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false,	},

	});
	

	public static Sprite ghost = new Sprite(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	true,	true,		true,	true,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	true,	true,	true,	true,		true,	true,	true,	true,	false,	false,	false,	false	},
		{	false,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	false	},
		{	false,	false,	true,	true,	false,	true,	true,	true,		true,	false,	true,	true,	true,	true,	false,	false	},
		{	false,	false,	true,	false,	false,	false,	true,	true,		false,	false,	false,	true,	true,	true,	false,	false	},
		{	false,	false,	true,	false,	false,	false,	true,	true,		false,	false,	false,	true,	true,	true,	false,	false	},
		{	false,	true,	true,	true,	false,	true,	true,	true,		true,	false,	true,	true,	true,	true,	true,	false	},
		{	false,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	false	},
		{	false,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	false	},
		{	false,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	false	},
		{	false,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	false	},
		{	false,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	false	},
		{	false,	true,	true,	false,	true,	true,	true,	false,		false,	true,	true,	true,	false,	true,	true,	false	},
		{	false,	true,	false,	false,	false,	true,	true,	false,		false,	true,	true,	false,	false,	false,	true,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	}
	});


	public static Sprite pacDot = new Sprite(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	true,	true,		true,	true,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	true,	false,	false,		false,	false,	true,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	true,	false,	false,		false,	false,	true,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	true,	false,	false,		false,	false,	true,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	true,	false,	false,		false,	false,	true,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	true,	true,		true,	true,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	}, new Rectangle(5, 5, 6, 6));


	public static Sprite topLeftWall = new Wall(new boolean[][] {
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});
	
	
	public static Sprite topRightWall = new Wall(new boolean[][] {
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
	});
	
	
	public static Sprite bottomRightWall = new Wall(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false	},
	});

	
	public static Sprite bottomLeftWall = new Wall(new boolean[][] {
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
	});
	
	
	public static Sprite leftWall = new Wall(new boolean[][] {
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});
	
	
	public static Sprite rightWall = new Wall(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
	});

	
	public static Sprite bottomWall = new Wall(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
	});
	
	
	public static Sprite topWall = new Wall(new boolean[][] {
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});

	
	public static Sprite topLeftBorder = new Wall(new boolean[][] {
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});

	public static Sprite topRightBorder = new Wall(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});

	
	public static Sprite bottomLeftBorder = new Wall(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
	});



	public static Sprite bottomRightBorder = new Wall(new boolean[][] {
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},

		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
	});



	public static Sprite topBottomWall = new Wall(new boolean[][] {
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},

	});

	
	public static Sprite rightCapWall = new Wall(new boolean[][] {
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	true	},
		{	false,	false,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	false	},
		{	true,	true,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false	},

	});


	public static Sprite leftCapWall = new Wall(new boolean[][] {
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	true,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},
		{	false,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	false,	false	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	true,	true	},

	});

	public static Sprite leftRightWall = new Wall(new boolean[][] {
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},

		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
	});


	public static Sprite bottomCapWall = new Wall(new boolean[][] {
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},

		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	true	},
		{	false,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	false	},
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	false	},
	});

	
	public static Sprite topCapWall = new Wall(new boolean[][] {
		{	false,	false,	true,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	true,	false,	true	},
		{	false,	true,	false,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	false,	true,	true	},
		{	true,	false,	false,	true,	true,	true,	true,	true,		true,	true,	true,	true,	true,	false,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},

		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
		{	true,	false,	true,	false,	false,	false,	false,	false,		false,	false,	false,	false,	false,	true,	false,	true	},
	});

	public static Sprite num0 = new Sprite(new boolean[][] {
		{false,true,true,true,false},
		{true,false,false,false,true},
		{true,false,false,true,true},
		{true,false,true,false,true},
		{true,true,false,false,true},
		{true,false,false,false,true},
		{false,true,true,true,false}
	});

	public static Sprite num1 = new Sprite(new boolean[][] {
		{false,true,false},
		{true,true,false},
		{false,true,false},
		{false,true,false},
		{false,true,false},
		{false,true,false},
		{true,true,true}

	});

	public static Sprite num2 = new Sprite(new boolean[][] {
		{false,true,true,true,false},
		{true,false,false,false,true},
		{false,false,false,false,true},
		{false,false,false,true,false},
		{false,false,true,false,false},
		{false,true,false,false,false},
		{true,true,true,true,true}
	});

	public static Sprite num3 = new Sprite(new boolean[][] {
		{true,true,true,true,true},
		{false,false,false,true,false},
		{false,false,true,false,false},
		{false,false,false,true,false},
		{false,false,false,false,true},
		{true,false,false,false,true},
		{false,true,true,true,false}
	});

	public static Sprite num4 = new Sprite(new boolean[][] {
		{false,false,false,true,false},
		{false,false,true,true,false},
		{false,true,false,true,false},
		{true,false,false,true,false},
		{true,true,true,true,true},
		{false,false,false,true,false},
		{false,false,false,true,false}
	});

	public static Sprite num5 = new Sprite(new boolean[][] {
		{true,true,true,true,true},
		{true,false,false,false,false},
		{true,true,true,true,false},
		{false,false,false,false,true},
		{false,false,false,false,true},
		{true,false,false,false,true},
		{false,true,true,true,false}
	});

	public static Sprite num6 = new Sprite(new boolean[][] {
		{false,false,true,true,false},
		{false,true,false,false,false},
		{true,false,false,false,false},
		{true,true,true,true,false},
		{true,false,false,false,true},
		{true,false,false,false,true},
		{false,true,true,true,false}
	});

	public static Sprite num7 = new Sprite(new boolean[][] {
		{true,true,true,true,true},
		{false,false,false,false,true},
		{false,false,false,true,false},
		{false,false,true,false,false},
		{false,true,false,false,false},
		{false,true,false,false,false},
		{false,true,false,false,false},
	});

	public static Sprite num8 = new Sprite(new boolean[][] {
		{false,true,true,true,false},
		{true,false,false,false,true},
		{true,false,false,false,true},
		{false,true,true,true,false},
		{true,false,false,false,true},
		{true,false,false,false,true},
		{false,true,true,true,false}
	});

	public static Sprite num9 = new Sprite(new boolean[][] {
		{false,true,true,true,false},
		{true,false,false,false,true},
		{true,false,false,false,true},
		{false,true,true,true,true},
		{false,false,false,false,true},
		{false,false,false,true,false},
		{false,true,true,false,false}
	});


	public static Sprite scoreText = new Sprite(new boolean[][] {
		{false,true,true,true,true,false,false,true,true,true,false,false,false,true,true,true,false,false,true,true,true,true,false,false,true,true,true,true,true,false,false},
		{true,false,false,false,false,false,true,false,false,false,true,false,true,false,false,false,true,false,true,false,false,false,true,false,true,false,false,false,false,false,true},
		{true,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,true,false,true,false,false,false,true,false,true,false,false,false,false,false,false},
		{false,true,true,true,false,false,true,false,false,false,false,false,true,false,false,false,true,false,true,true,true,true,false,false,true,true,true,true,false,false,false},
		{false,false,false,false,true,false,true,false,false,false,false,false,true,false,false,false,true,false,true,false,true,false,false,false,true,false,false,false,false,false,false},
		{false,false,false,false,true,false,true,false,false,false,true,false,true,false,false,false,true,false,true,false,false,true,false,false,true,false,false,false,false,false,true},
		{true,true,true,true,false,false,false,true,true,true,false,false,false,true,true,true,false,false,true,false,false,false,true,false,true,true,true,true,true,false,false}
	});

	public static Sprite highText = new Sprite(new boolean[][] {
		{true,false,false,false,true,false,true,true,true,false,false,true,true,true,false,false,true,false,false,false,true},
		{true,false,false,false,true,false,false,true,false,false,true,false,false,false,false,false,true,false,false,false,true},
		{true,false,false,false,true,false,false,true,false,false,true,false,false,false,false,false,true,false,false,false,true},
		{true,true,true,true,true,false,false,true,false,false,true,false,false,false,false,false,true,true,true,true,true},
		{true,false,false,false,true,false,false,true,false,false,true,false,false,true,true,false,true,false,false,false,true},
		{true,false,false,false,true,false,false,true,false,false,true,false,false,false,true,false,true,false,false,false,true},
		{true,false,false,false,true,false,true,true,true,false,false,true,true,true,false,false,true,false,false,false,true}
	});




}
