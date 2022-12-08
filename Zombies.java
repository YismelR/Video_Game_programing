import java.awt.Graphics;
import java.util.Random;

public class Zombies extends Soldier{
	int vx;
	int vy;
	
	int ax; 
	int ay;
	
	Animation [] anim;
	
	/*static final int UP = 0;
	static final int DN = 1;
	static final int LT = 2;
	static final int RT = 3;
	
	int pose = RT;
	
	boolean moving = false;*/
	
	public Zombies(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		String [] pose = {"walk"};
		
		for(int i = 0; i < anim.length; i++) {
			anim[i] = new Animation("fz_" + pose[i] + "_", 10, ".GIF", 15);
		}
	}
	
	public boolean dead(){
		if(health < 0) {
			return true;
		}
		return false;
	}
	
	public boolean attack(){
		if(x <= 10) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		if(!(dead())) {
			g.drawImage(anim[WALK].currentImage(), x, y, w/2, h/2, null);
			if(attack()) 
				g.drawImage(anim[ATTACK].currentImage(), x, y, w/2, h/2, null);
		}
		if(dead()) g.drawImage(anim[DEAD].currentImage(), x, y, w/2, h/2, null);
	}
