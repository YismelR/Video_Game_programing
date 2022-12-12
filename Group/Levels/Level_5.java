
import java.awt.Graphics;
import java.util.Random;

public class Level_5 extends GameBase {
	boolean active = false;

	// Parallax Assets for Level 5
	ImageLoader background5a = new ImageLoader(0, 0, "background5.png");
	ImageLoader background5b = new ImageLoader(background5a.x + width, 0, "background5.png");
	ImageLoader midground5a = new ImageLoader(0, 0, "midground5.png");
	ImageLoader midground5b = new ImageLoader(midground5a.x + width, 0, "midground5.png");
	ImageLoader foreground5a = new ImageLoader(0, 0, "foreground5.png");
	ImageLoader foreground5b = new ImageLoader(foreground5a.x + width, 0, "foreground5.png");

	//needs work
	Zombies[] test = { new Zombies(((width) + (width * 1) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 2) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 3) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 4) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 5) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 6) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 7) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 8) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 9) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 10) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 11) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 12) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 13) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 14) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombies(((width) + (width * 15) / 4), height - 200, 27 * 3, 51 * 3), };

	public Level_5(GameBase game) {
		active = false;
	}

	public void inGameLoop() {
	}

	public void draw(Graphics g) {
		// Paint level 5 background
		background5a.draw(g);
		background5b.draw(g);
		midground5a.draw(g);
		midground5b.draw(g);
		foreground5a.draw(g);
		foreground5b.draw(g);

//		//draws the number of Zombiess based on how many Zombiess there are in each level
//		for (int i = 0; i < test.length; i++) {			
//		test[i].draw(g);
//		}

	}

}