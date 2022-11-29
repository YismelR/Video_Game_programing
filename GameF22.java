package com.main;
/*Note, the backgrounds needs a little bit of work, i'll take care of that, just add your sections to this code
 * whoever is working on the main character sprite can refactor or rename the soldier class
 * to whatever, like "maincharacter" or something, i don't know. Bad soldier should also be refactored to 
 * Zombies.*/
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;
public class GameF22 extends GameBase {
	// Health icon is void for now
	ImageIcon health = new ImageIcon("Health.png");
	Image image = health.getImage();
	Levels levels = new Levels();

	public void inGameLoop() {
		// Controls for Level 1
		if (levelCount == 1) {
			levels.soldier.setAcceleration(0, 1);
			levels.soldier.moveBasedOnPhysics();

			// stop when he overlaps the ground/bottom the screen
			if (levels.soldier.overlapBottomPanel()) {
				levels.soldier.stopatBottomPanel();
				if (pressing[UP])
					levels.soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (levels.soldier.overlapTopPanel()) {
				levels.soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				levels.soldier.moveDown(5); 

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				levels.soldier.moveRight(5);
				levels.background1a.moveLeft(3);
				levels.midground1a.moveLeft(5);
				levels.foreground1a.moveLeft(7);
				levels.background1b.moveLeft(3);
				levels.midground1b.moveLeft(5);
				levels.foreground1b.moveLeft(7);
			}

			// Move Left, Keep soldier static(but still animated)
			if (pressing[LT]) {
				Camera.moveLeft(5);
				levels.soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				levels.background1a.moveRight(3);
				levels.midground1a.moveRight(5);
				levels.foreground1a.moveRight(7);
				levels.background1b.moveRight(3);
				levels.midground1b.moveRight(5);
				levels.foreground1b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (levels.background1a.x < 0 - width) {
				Random r = new Random();
				levels.background1a.x = width - r.nextInt(1);
			}
			if (levels.midground1a.x < 0 - width) {
				Random r = new Random();
				levels.midground1a.x = width - r.nextInt(1);
			}
			if (levels.foreground1a.x < 0 - width) {
				Random r = new Random();
				levels.foreground1a.x = width - r.nextInt(1);
			}
			if (levels.background1b.x < 0 - width) {
				Random r = new Random();
				levels.background1b.x = width - r.nextInt(1);
			}
			if (levels.midground1b.x < 0 - width) {
				Random r = new Random();
				levels.midground1b.x = width - r.nextInt(1);
			}
			if (levels.foreground1b.x < 0 - width) {
				Random r = new Random();
				levels.foreground1b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (levels.background1a.x > 0 + width) {
				Random r = new Random();
				levels.background1a.x = -width + r.nextInt(1);
			}
			if (levels.midground1a.x > 0 + width) {
				Random r = new Random();
				levels.midground1a.x = -width + r.nextInt(1);
			}
			if (levels.foreground1a.x > 0 + width) {
				Random r = new Random();
				levels.foreground1a.x = -width + r.nextInt(1);
			}
			if (levels.background1b.x > 0 + width) {
				Random r = new Random();
				levels.background1b.x = -width + r.nextInt(1);
			}
			if (levels.midground1b.x > 0 + width) {
				Random r = new Random();
				levels.midground1b.x = -width + r.nextInt(1);
			}
			if (levels.foreground1b.x > 0 + width) {
				Random r = new Random();
				levels.foreground1b.x = -width + r.nextInt(1);
			}
		}

		// Controls for Level 2
		if (levelCount == 2) {
			levels.soldier.setAcceleration(0, 1);
			levels.soldier.moveBasedOnPhysics();

			// stop when he overlaps the ground/bottom the screen
			if (levels.soldier.overlapBottomPanel()) {
				levels.soldier.stopatBottomPanel();
				if (pressing[UP])
					levels.soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (levels.soldier.overlapTopPanel()) {
				levels.soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				levels.soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				levels.soldier.moveRight(5); // soldier.setVelocity(0, 0);
				levels.background2a.moveLeft(3);
				levels.midground2a.moveLeft(5);
				levels.foreground2a.moveLeft(7);
				levels.background2b.moveLeft(3);
				levels.midground2b.moveLeft(5);
				levels.foreground2b.moveLeft(7);
			}

			// Move Left, Keep soldier static(but still animated)
			if (pressing[LT]) {
				Camera.moveLeft(5);
				levels.soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				levels.background2a.moveRight(3);
				levels.midground2a.moveRight(5);
				levels.foreground2a.moveRight(7);
				levels.background2b.moveRight(3);
				levels.midground2b.moveRight(5);
				levels.foreground2b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (levels.background2a.x < 0 - width) {
				Random r = new Random();
				levels.background2a.x = width - r.nextInt(1);
			}
			if (levels.midground2a.x < 0 - width) {
				Random r = new Random();
				levels.midground2a.x = width - r.nextInt(1);
			}
			if (levels.foreground2a.x < 0 - width) {
				Random r = new Random();
				levels.foreground2a.x = width - r.nextInt(1);
			}
			if (levels.background2b.x < 0 - width) {
				Random r = new Random();
				levels.background2b.x = width - r.nextInt(1);
			}
			if (levels.midground2b.x < 0 - width) {
				Random r = new Random();
				levels.midground2b.x = width - r.nextInt(1);
			}
			if (levels.foreground2b.x < 0 - width) {
				Random r = new Random();
				levels.foreground2b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (levels.background2a.x > 0 + width) {
				Random r = new Random();
				levels.background2a.x = -width + r.nextInt(1);
			}
			if (levels.midground2a.x > 0 + width) {
				Random r = new Random();
				levels.midground2a.x = -width + r.nextInt(1);
			}
			if (levels.foreground2a.x > 0 + width) {
				Random r = new Random();
				levels.foreground2a.x = -width + r.nextInt(1);
			}
			if (levels.background2b.x > 0 + width) {
				Random r = new Random();
				levels.background2b.x = -width + r.nextInt(1);
			}
			if (levels.midground2b.x > 0 + width) {
				Random r = new Random();
				levels.midground2b.x = -width + r.nextInt(1);
			}
			if (levels.foreground2b.x > 0 + width) {
				Random r = new Random();
				levels.foreground2b.x = -width + r.nextInt(1);
			}
		}

		// Controls for Level 3
		if (levelCount == 3) {
			levels.soldier.setAcceleration(0, 1);
			levels.soldier.moveBasedOnPhysics();

			// stop when he overlaps the ground/bottom the screen
			if (levels.soldier.overlapBottomPanel()) {
				levels.soldier.stopatBottomPanel();
				if (pressing[UP])
					levels.soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (levels.soldier.overlapTopPanel()) {
				levels.soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				levels.soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				levels.soldier.moveRight(5); // soldier.setVelocity(0, 0);
				levels.background3a.moveLeft(7);
				levels.midground3a.moveLeft(3);
				levels.foreground3a.moveLeft(7);
				levels.background3b.moveLeft(7);
				levels.midground3b.moveLeft(3);
				levels.foreground3b.moveLeft(7);
			}

			// Move Left, Keep soldier static(but still animated)
			if (pressing[LT]) {
				Camera.moveLeft(5);
				levels.soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				levels.background3a.moveRight(3);
				levels.midground3a.moveRight(5);
				levels.foreground3a.moveRight(7);
				levels.background3b.moveRight(3);
				levels.midground3b.moveRight(5);
				levels.foreground3b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (levels.background3a.x < 0 - width) {
				Random r = new Random();
				levels.background3a.x = width - r.nextInt(1);
			}
			if (levels.midground3a.x < 0 - width) {
				Random r = new Random();
				levels.midground3a.x = width - r.nextInt(1);
			}
			if (levels.foreground3a.x < 0 - width) {
				Random r = new Random();
				levels.foreground3a.x = width - r.nextInt(1);
			}
			if (levels.background3b.x < 0 - width) {
				Random r = new Random();
				levels.background3b.x = width - r.nextInt(1);
			}
			if (levels.midground3b.x < 0 - width) {
				Random r = new Random();
				levels.midground3b.x = width - r.nextInt(1);
			}
			if (levels.foreground3b.x < 0 - width) {
				Random r = new Random();
				levels.foreground3b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (levels.background3a.x > 0 + width) {
				Random r = new Random();
				levels.background3a.x = -width + r.nextInt(1);
			}
			if (levels.midground3a.x > 0 + width) {
				Random r = new Random();
				levels.midground3a.x = -width + r.nextInt(1);
			}
			if (levels.foreground3a.x > 0 + width) {
				Random r = new Random();
				levels.foreground3a.x = -width + r.nextInt(1);
			}
			if (levels.background3b.x > 0 + width) {
				Random r = new Random();
				levels.background3b.x = -width + r.nextInt(1);
			}
			if (levels.midground3b.x > 0 + width) {
				Random r = new Random();
				levels.midground3b.x = -width + r.nextInt(1);
			}
			if (levels.foreground3b.x > 0 + width) {
				Random r = new Random();
				levels.foreground3b.x = -width + r.nextInt(1);
			}
		}

		// Controls for Level 4
		if (levelCount == 4) {
			levels.soldier.setAcceleration(0, 1);
			levels.soldier.moveBasedOnPhysics();

			// stop when he overlaps the ground/bottom the screen
			if (levels.soldier.overlapBottomPanel()) {
				levels.soldier.stopatBottomPanel();
				if (pressing[UP])
					levels.soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (levels.soldier.overlapTopPanel()) {
				levels.soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				levels.soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				levels.soldier.moveRight(5); // soldier.setVelocity(0, 0);
				levels.background4a.moveLeft(3);
				levels.midground4a.moveLeft(5);
				levels.foreground4a.moveLeft(7);
				levels.background4b.moveLeft(3);
				levels.midground4b.moveLeft(5);
				levels.foreground4b.moveLeft(7);
			}

			// Move Left, Keep soldier static(but still animated)
			if (pressing[LT]) {
				Camera.moveLeft(5);
				levels.soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				levels.background4a.moveRight(3);
				levels.midground4a.moveRight(5);
				levels.foreground4a.moveRight(7);
				levels.background4b.moveRight(3);
				levels.midground4b.moveRight(5);
				levels.foreground4b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (levels.background4a.x < 0 - width) {
				Random r = new Random();
				levels.background4a.x = width - r.nextInt(1);
			}
			if (levels.midground4a.x < 0 - width) {
				Random r = new Random();
				levels.midground4a.x = width - r.nextInt(1);
			}
			if (levels.foreground4a.x < 0 - width) {
				Random r = new Random();
				levels.foreground4a.x = width - r.nextInt(1);
			}
			if (levels.background4b.x < 0 - width) {
				Random r = new Random();
				levels.background4b.x = width - r.nextInt(1);
			}
			if (levels.midground4b.x < 0 - width) {
				Random r = new Random();
				levels.midground4b.x = width - r.nextInt(1);
			}
			if (levels.foreground4b.x < 0 - width) {
				Random r = new Random();
				levels.foreground4b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (levels.background4a.x > 0 + width) {
				Random r = new Random();
				levels.background4a.x = -width + r.nextInt(1);
			}
			if (levels.midground4a.x > 0 + width) {
				Random r = new Random();
				levels.midground4a.x = -width + r.nextInt(1);
			}
			if (levels.foreground4a.x > 0 + width) {
				Random r = new Random();
				levels.foreground4a.x = -width + r.nextInt(1);
			}
			if (levels.background4b.x > 0 + width) {
				Random r = new Random();
				levels.background4b.x = -width + r.nextInt(1);
			}
			if (levels.midground4b.x > 0 + width) {
				Random r = new Random();
				levels.midground4b.x = -width + r.nextInt(1);
			}
			if (levels.foreground4b.x > 0 + width) {
				Random r = new Random();
				levels.foreground4b.x = -width + r.nextInt(1);
			}
		}

		// Controls for Level 5
		if (levelCount == 5) {
			levels.soldier.setAcceleration(0, 1);
			levels.soldier.moveBasedOnPhysics();

			// stop when he overlaps the ground/bottom the screen
			if (levels.soldier.overlapBottomPanel()) {
				levels.soldier.stopatBottomPanel();
				if (pressing[UP])
					levels.soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (levels.soldier.overlapTopPanel()) {
				levels.soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				levels.soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				levels.soldier.moveRight(5); // soldier.setVelocity(0, 0);
				levels.background5a.moveLeft(3);
				levels.midground5a.moveLeft(5);
				levels.foreground5a.moveLeft(7);
				levels.background5b.moveLeft(3);
				levels.midground5b.moveLeft(5);
				levels.foreground5b.moveLeft(7);
			}

			// Move Left, Keep soldier static(but still animated)
			if (pressing[LT]) {
				Camera.moveLeft(5);
				levels.soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				levels.background5a.moveRight(3);
				levels.midground5a.moveRight(5);
				levels.foreground5a.moveRight(7);
				levels.background5b.moveRight(3);
				levels.midground5b.moveRight(5);
				levels.foreground5b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (levels.background5a.x < 0 - width) {
				Random r = new Random();
				levels.background5a.x = width - r.nextInt(1);
			}
			if (levels.midground5a.x < 0 - width) {
				Random r = new Random();
				levels.midground5a.x = width - r.nextInt(1);
			}
			if (levels.foreground5a.x < 0 - width) {
				Random r = new Random();
				levels.foreground5a.x = width - r.nextInt(1);
			}
			if (levels.background5b.x < 0 - width) {
				Random r = new Random();
				levels.background5b.x = width - r.nextInt(1);
			}
			if (levels.midground5b.x < 0 - width) {
				Random r = new Random();
				levels.midground5b.x = width - r.nextInt(1);
			}
			if (levels.foreground5b.x < 0 - width) {
				Random r = new Random();
				levels.foreground5b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (levels.background5a.x > 0 + width) {
				Random r = new Random();
				levels.background5a.x = -width + r.nextInt(1);
			}
			if (levels.midground5a.x > 0 + width) {
				Random r = new Random();
				levels.midground5a.x = -width + r.nextInt(1);
			}
			if (levels.foreground5a.x > 0 + width) {
				Random r = new Random();
				levels.foreground5a.x = -width + r.nextInt(1);
			}
			if (levels.background5b.x > 0 + width) {
				Random r = new Random();
				levels.background5b.x = -width + r.nextInt(1);
			}
			if (levels.midground5b.x > 0 + width) {
				Random r = new Random();
				levels.midground5b.x = -width + r.nextInt(1);
			}
			if (levels.foreground5b.x > 0 + width) {
				Random r = new Random();
				levels.foreground5b.x = -width + r.nextInt(1);
			}
		}

		// Controls for Level 6
		if (levelCount == 6) {
			levels.soldier.setAcceleration(0, 1);
			levels.soldier.moveBasedOnPhysics();

			// stop when he overlaps the ground/bottom the screen
			if (levels.soldier.overlapBottomPanel()) {
				levels.soldier.stopatBottomPanel();
				if (pressing[UP])
					levels.soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (levels.soldier.overlapTopPanel()) {
				levels.soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				levels.soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				levels.soldier.moveRight(5); // soldier.setVelocity(0, 0);
				levels.background6a.moveLeft(3);
				levels.midground6a.moveLeft(5);
				levels.foreground6a.moveLeft(7);
				levels.background6b.moveLeft(3);
				levels.midground6b.moveLeft(5);
				levels.foreground6b.moveLeft(7);
			}

			// Move Left, Keep soldier static(but still animated)
			if (pressing[LT]) {
				Camera.moveLeft(5);
				levels.soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				levels.background6a.moveRight(3);
				levels.midground6a.moveRight(5);
				levels.foreground6a.moveRight(7);
				levels.background6b.moveRight(3);
				levels.midground6b.moveRight(5);
				levels.foreground6b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (levels.background6a.x < 0 - width) {
				Random r = new Random();
				levels.background6a.x = width - r.nextInt(1);
			}
			if (levels.midground6a.x < 0 - width) {
				Random r = new Random();
				levels.midground6a.x = width - r.nextInt(1);
			}
			if (levels.foreground6a.x < 0 - width) {
				Random r = new Random();
				levels.foreground6a.x = width - r.nextInt(1);
			}
			if (levels.background6b.x < 0 - width) {
				Random r = new Random();
				levels.background6b.x = width - r.nextInt(1);
			}
			if (levels.midground6b.x < 0 - width) {
				Random r = new Random();
				levels.midground6b.x = width - r.nextInt(1);
			}
			if (levels.foreground6b.x < 0 - width) {
				Random r = new Random();
				levels.foreground6b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (levels.background6a.x > 0 + width) {
				Random r = new Random();
				levels.background6a.x = -width + r.nextInt(1);
			}
			if (levels.midground6a.x > 0 + width) {
				Random r = new Random();
				levels.midground6a.x = -width + r.nextInt(1);
			}
			if (levels.foreground6a.x > 0 + width) {
				Random r = new Random();
				levels.foreground6a.x = -width + r.nextInt(1);
			}
			if (levels.background6b.x > 0 + width) {
				Random r = new Random();
				levels.background6b.x = -width + r.nextInt(1);
			}
			if (levels.midground6b.x > 0 + width) {
				Random r = new Random();
				levels.midground6b.x = -width + r.nextInt(1);
			}
			if (levels.foreground6b.x > 0 + width) {
				Random r = new Random();
				levels.foreground6b.x = -width + r.nextInt(1);
			}
		}

	}
	
	
	

	public void paint(Graphics g) {
		levels.paint(g);
		
		// Health bar
		Integer health = new Integer(health_status);
		String val;
		val = health.toString();
		g.drawImage(image, 15, 15, 10, 10, null);
		g.drawString(val, 30, 24);
		// bs.draw(g);
	}

}
