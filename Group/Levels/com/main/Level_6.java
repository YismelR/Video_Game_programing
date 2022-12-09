package com.main;

import java.awt.Graphics;

public class Level_6 extends GameBase {
	boolean active = false;

	// Parallax Assets for Level 6
	ImageLoader background6a = new ImageLoader(0, 0, "background6.png");
	ImageLoader background6b = new ImageLoader(background6a.x + width, 0, "background6.png");
	ImageLoader midground6a = new ImageLoader(0, 0, "midground6.png");
	ImageLoader midground6b = new ImageLoader(midground6a.x + width, 0, "midground6.png");
	ImageLoader foreground6a = new ImageLoader(0, 0, "foreground6.png");
	ImageLoader foreground6b = new ImageLoader(foreground6a.x + width, 0, "foreground6.png");

	//needs work
	Zombie[] test = { new Zombie(((width) + (width * 1) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 2) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 3) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 4) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 5) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 6) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 7) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 8) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 9) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 10) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 11) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 12) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 13) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 14) / 4), height - 200, 27 * 3, 51 * 3),
			new Zombie(((width) + (width * 15) / 4), height - 200, 27 * 3, 51 * 3), };

	public Level_6(GameBase game) {
		active = false;

	}

	public void inGameLoop() { }

	public void draw(Graphics g) {
		// Paint level 6 background
		background6a.draw(g);
		background6b.draw(g);
		midground6a.draw(g);
		midground6b.draw(g);
		foreground6a.draw(g);
		foreground6b.draw(g);


//		//draws the number of zombies based on how many zombies there are in each level
//		for (int i = 0; i < test.length; i++) {			
//		test[i].draw(g);
//		}

	}

}