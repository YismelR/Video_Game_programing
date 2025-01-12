package com.main;
import java.awt.Graphics;
import java.util.Random;

public class Zombies extends Soldier{
	int vx;
	int vy;
	
	int ax; 
	int ay;
	
	Animation [] anim;
	
	static final int WALK = 0;
	static final int DEAD = 1;
	static final int ATTACK = 2;
	
	int pose = WALK;

	int health_status = 100;
	
	Soldier s;
	
	public Zombies(int x, int y, int w, int h) {
		super(x, y, w, h);

		anim = new Animation[3];
		
		String [] pose = {"walk", "dead", "attack"};
		
		for(int i = 0; i < anim.length; i++) {
			anim[i] = new Animation("femalez-" + pose[i] + "-", 12, ".GIF", 10);
		}
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
	
	//Just a heads up, "health_status" should be used in-place of health
	//but, because neither zombies.java or soldier.java extends gamebase,
	//which contains "health_status", it wont work here. Rather, create this
	//constructor in GameF22 instead for better results
	
	public boolean dead(){
		if(health_status == 0) {
			return true;
		}
		return false;
	}

	public boolean attack(){
		if(s.x < 10) {
			return true;
		}
		return false;
	}
}
