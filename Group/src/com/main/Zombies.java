import java.awt.Graphics;
import java.util.Random;

public class Zombies extends Soldier{
	private static final int WALK = 0;
	private static final int ATTACK = 0;
	private static final int DEAD = 0;
	int pose = WALK;
	
	int vx;
	int vy;
	
	int ax; 
	int ay;
	
	Soldier soldier;
	Animation [] anim;
	
	int health = 5;
	
	public Zombies(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		String [] pose = {"walk"};
		
		for(int i = 0; i < anim.length; i++) {
			anim[i] = new Animation("fz_" + pose[i] + "_", 10, ".GIF", 15);
		}
	}
	
	public void chase(Soldier soldier) {
		int xdiff = Math.abs(x - soldier.x) ; 
		int ydiff = Math.abs(y - soldier.y) ; 
		
		if(xdiff < 200) {
			if(xdiff > 10) {
	      		if (x < soldier.x)   moveRight(4);
	   		}
		}
	}
	
	public boolean dead(){
		if(health <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean attack(){
		if(x <= soldier.x) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		if(!(dead())) {
			g.drawImage(anim[pose].currentImage(), x - Camera.x, y - Camera.y, w/2, h/2, null);
			if(attack()) {
				g.drawImage(anim[ATTACK].currentImage(), x - Camera.x, y - Camera.y, w/2, h/2, null);
			}
		}
		if(dead()) g.drawImage(anim[DEAD].currentImage(), x - Camera.x, y - Camera.y, w/2, h/2, null);
	}
}
