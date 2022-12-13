package com.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelComplete extends GameBase implements MouseListener{
	
	boolean active = false;
	boolean reset = false;
	boolean level = false;
	
	BufferedImage img;
	int imgW; 
	int imgH;
	int imgX;
	int imgY;
	
	public Image background() {
       try {
           img = ImageIO.read(new File("Level Complete.png"));
       } catch (IOException e) { }
 
        imgW = img.getWidth(null);
        imgH = img.getHeight(null);
        imgX = (width/2 - imgW/2);
    	imgY = (height/2 - imgH/2);
        return img;
	}
	
	public LevelComplete(GameBase game) {
	active = false;
	}
	
	public void levelcompleted() {
	level =! level;
	}
		
	public void draw(Graphics g) {
		g.drawImage(background(), imgX, imgY, imgW, imgH, null);
	}

	public void mouseMoved(MouseEvent e) { }

	public void mouseClicked(MouseEvent e) {
		int MouseX=e.getX();
		int MouseY=e.getY();
		
		if(active) {
		//From level complete screen go to Main menu
		if(MouseX >= imgX+(imgW/4) && MouseX <= imgX + (imgW/4)+imgW/2 && MouseY >= imgY + (imgH/8 *4)-8 && MouseY <= imgY + (imgH/8 *4)-8 +imgH/8) { levelNextLevel=true; } 
		else { levelNextLevel=false; } 
	
		//From level complete screen play again
		if(MouseX >= imgX+(imgW/4) && MouseX <= imgX+(imgW/4)+imgW/2 && MouseY >= imgY + (imgH/8 * 5)-6 && MouseY <= imgY + (imgH/8 * 5)-6 +imgH/8) { levelPlayAgain=true; } 
		else { levelPlayAgain=false; } 
		
		//From level complete screen Quit
		if(MouseX >= imgX+(imgW/4) && MouseX <= imgX+(imgW/4)+imgW/2 && MouseY >= imgY +(imgH/8 *6)-4 && MouseY <= imgY +(imgH/8 *6)-4 +imgH/8) { levelMainMenu=true; } 
		else { levelMainMenu=false; }
		
		//if below level 6, from level complete screen, go to next level
		if(MouseX >= imgX+(imgW/4) && MouseX <= imgX+(imgW/4)+imgW/2 && MouseY >= imgY +(imgH/8 *7) && MouseY <= imgY +(imgH/8 *7)+imgH/8) { levelQuitGame=true; } 
		else { levelQuitGame=false; } 
			
		if(levelPlayAgain) {
		active = false;
		playAgain();
		System.out.println("levelcomplete playAgain"); }
		
		if(levelNextLevel) {
		active=false;
		levelComplete();
		NextLevel();
		System.out.println("levelcount = "+levelCount);
		System.out.println("levelcomplete next level"); }
		
		//go to main menu from the level complete screen
		if(levelMainMenu) {
		active=false;
		mainmenu.active=true;
		GoToMainMenu();
		System.out.println("levelcomplete main menu"); }
		
		if(levelQuitGame) {
		ExitGame();
		System.out.println("levelcomplete exit Game"); }
		}

	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void inGameLoop() {	}
	

}