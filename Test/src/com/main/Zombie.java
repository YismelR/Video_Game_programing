package com.main;
import java.awt.Graphics;
import java.util.Random;

/*we will replace this code with the zombies
*/

public class Zombie extends Soldier {
	public Zombie(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void chase(Soldier soldier) { 
		if(Math.abs(x - soldier.x) < 300 ) {
			
		if (x > soldier.x)   moveLeft(2);
		else
		if (x < soldier.x)   moveRight(2);
		
		}
		
		else
		setVelocity(0, 0);   
		
	}
	

}