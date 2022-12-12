
import java.awt.Graphics;
import java.util.Random;

public class Level_3 extends GameBase {
	boolean active = false;

	// Parallax Assets for Level 3
	ImageLoader background3a = new ImageLoader(0, 0, "background3.png");
	ImageLoader background3b = new ImageLoader(background3a.x + width, 0, "background3.png");
	ImageLoader midground3a = new ImageLoader(0, 0, "midground3.png");
	ImageLoader midground3b = new ImageLoader(midground3a.x + width, 0, "midground3.png");
	ImageLoader foreground3a = new ImageLoader(0, 0, "foreground3.png");
	ImageLoader foreground3b = new ImageLoader(foreground3a.x + width, 0, "foreground3.png");

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

	public Level_3(GameBase game) {
		active = false;
	}

	public void inGameLoop() {
	}

	public void draw(Graphics g) {
		// Paint level 3 background
		background3a.draw(g);
		background3b.draw(g);
		midground3a.draw(g);
		midground3b.draw(g);
		foreground3a.draw(g);
		foreground3b.draw(g);

//		//draws the number of Zombiess based on how many Zombiess there are in each level
//		for (int i = 0; i < test.length; i++) {			
//		test[i].draw(g);
//		}

	}

}