package com.main;
import java.awt.*;

public class Coin extends Rect{
	int vx;
	int vy;
	
	int ax; 
	int ay;
	
	Animation [] anim;
	
	static final int SP = 0;
	
	boolean moving = false;
	
	public Coin(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		anim = new Animation[1];
		
		String [] pose = {"sp"};
		
		for(int i = 0; i < anim.length; i++) {
			anim[i] = new Animation("coin_" + pose[i] + "_", 9, ".GIF", 5);
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(anim[SP].currentImage(), x - Camera.x, y, 128, 128, null);
	}
}
