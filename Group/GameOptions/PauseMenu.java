
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PauseMenu extends GameBase implements MouseListener, KeyListener {
	
	boolean active = false;
	boolean pausenow = false;
	boolean reset = false;
	
	BufferedImage img;
	int imgW; 
	int imgH;
	int imgX;
	int imgY;
	
	public Image background() {
       try {
           img = ImageIO.read(new File("Pause Menu.png"));
       } catch (IOException e) { }
 
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
        imgX = (width/2 - imgW/2);
    	imgY = (height/2 - imgH/2);
		return img; 
	}

	public PauseMenu(GameBase game) {
	active = false;
	}
	
	//toggle pause state
	public void pause() {
		pausenow=!pausenow;
	}
	
	//draw pause menu
	public void draw(Graphics g) {
		g.drawImage(background(), imgX, imgY, imgW, imgH, null);
	}


	public void mouseMoved(MouseEvent e) { }

	//controls where you click and what they do
	public void mouseClicked(MouseEvent e) {
		int MouseX=e.getX();
		int MouseY=e.getY();
		
		//works only if active
		if(active) {
			
		//from pause Menu, go to main menu
		if(MouseX >= imgX && MouseX <= imgX+imgW && MouseY >= imgY && MouseY <= imgY+imgH/3) { pauseResumeGame=true; } 
		else {pauseResumeGame=false; } 
		
		//From pause menu resume Game
		if(MouseX >= imgX && MouseX <= imgX+imgW && MouseY >= imgY+(imgH/3) && MouseY <= imgY+(imgH/3)+imgH/3) { pauseMainMenu=true; } 
		else { pauseMainMenu=false; } 
		
        //From pause menu quit Game
		if(MouseX >= imgX && MouseX <= imgX+imgW && MouseY >= imgY+(imgH/3 *2) && MouseY <= imgY+(imgH/3* 2)+imgH/3) { pauseQuitGame=true; } 
		else { pauseQuitGame=false; }  
		
		//resume game
		if(pauseResumeGame) {
		active = false;
		resumeGame();
		System.out.println("pause Resume"); }
		
		//go to main menu
		if(pauseMainMenu) {
		active=false;
		mainmenu.active=true;
		reset=true;
		GoToMainMenu();
		System.out.println("pause Main menu"); }
		
		//quit
		if(pauseQuitGame) {
		ExitGame();
		System.out.println("pause menu Quit"); }
		
		}
	}
	

	public void keyPressed(KeyEvent e) {
		int Keys = e.getKeyCode();
		//controls when pause is activated
		if( isPaused==false && running==true && levelcomplete.active==false && 
		gamecomplete.active==false && gameover.active==false ) 
		if(Keys == KeyEvent.VK_ESCAPE) {
			pauseGame();
			active=true;
			pause();
			return;
		}
		
	}

	public void keyReleased(KeyEvent e) {	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}
	
	@Override
	public void inGameLoop() {	}
	

}