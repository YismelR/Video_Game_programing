import java.applet.Applet;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;

//Only thing missing from this code which i'm still working on is the
//Camera following the player. If it doesn't work, we'll swith try other ideas.

/*1. You should have a version of GameBase, Soldier, Rect, ImageLayer,
Camera with you. I dont think you'll need them all, just GameBase maybe*/

public class GameF22 extends GameBase
{
		
	Soldier soldier = new Soldier(100, 600, 20, 50);

	// sample Background "room1.png"
	ImageLayer room1 = new ImageLayer("room1.png", 1);

  	//loaded up the health symbol
	ImageIcon health = new ImageIcon("Health.png");{
	Image image = health.getImage();}
	
	//2. Health at 100%. See 4. for implementation
	int health_status = 100;
	BadSoldier bs = new BadSoldier(600, 850, 20, 50);
	
      //Sample platform for testing
	Platform[] platform = 
	{
	   new Platform(700, 100, 10, "winter"),
	   new Platform(600, 200, 10, "winter"),
	   new Platform(500, 300, 10, "winter"),
	   new Platform(400, 400, 10, "winter"),
	   new Platform(300, 500, 10, "winter"),
	   new Platform(0, 580,  15, "winter"),
	   new Platform(0, 650,  200, "winter"),
  	};
	
      //sample tests for zombie collison
	Rect test = new Rect(290, 590, 20, 50);
	
  	//this is straight forward
	public void inGameLoop()
	{				
   	soldier.setAcceleration(0, 1);
   
	  //3. Soldier movements
	  if(pressing[UP]) soldier.moveUp(5);
	  if(pressing[DN]) soldier.moveDown(5);
	  if(pressing[LT]) soldier.moveLeft(5); 
	  if(pressing[RT]) soldier.moveRight(5);
	 
		
		soldier.moveBasedOnPhysics();
		
		for(int i = 0; i < platform.length; i++)
		{
		   if(soldier.overlaps(platform[i]))
		   {	
		      soldier.setVelocity(0, 0);
		   
		      soldier.setY(platform[i].y-soldier.h);
		   	
		      if(pressing[UP])  soldier.jump(10);   
		   }
		}
		
		//4. Health of Soldier, may/may not need optimizing
		if (health_status > 0)
            {
		if(soldier.overlaps(test)) 
            {
	      soldier.setVelocity(0, 0);
	      soldier.setX(test.x-soldier.h);
	      health_status=health_status-10;
	      System.out.println(health_status);
	      }
          }
		
        // Trial and testing code, do disregard
		//if(soldier.overlaps(top))  soldier.setY(240); 
		
		bs.chase(soldier);
		
		bs.moveBasedOnPhysics();	
	}
	
  	//straight forward as well
	public void paint(Graphics g)
	{	 
		 //room_1.draw(g);
		Integer health = new Integer(health_status);
		String val;
		val = health.toString();
		soldier.draw(g);
		test.draw(g);
		//g.drawImage(map, 0, 0, 800, 600, null);
		//g.drawImage(image, 10, 10, 10, 10, null);
		g.drawString(val, 25, 25);
		//bs.draw(g);
				
		  for(int i = 0; i < platform.length; i++) { platform[i].draw(g); } 
	}
	
}