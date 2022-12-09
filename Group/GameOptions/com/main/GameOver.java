package com.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameOver extends GameBase implements MouseListener{
	
	boolean active = false;
	boolean reset = false;
	
	BufferedImage img;
	int imgW; 
	int imgH;
	int imgX;
	int imgY;
	
	public Image background() {
       try {
           img = ImageIO.read(new File("Game Over Screen.png"));
       } catch (IOException e) { }
 
        imgW = img.getWidth(null);
        imgH = img.getHeight(null); 
        imgX = (width/2 - imgW/2);
    	imgY = (height/2 - imgH/2);
        return img;
	}

	public GameOver(GameBase game) {
	active = false;
	}
	
	//draw gameover
	public void draw(Graphics g) {
		g.drawImage(background(), imgX, imgY, imgW, imgH, null);
	}

	public void mouseMoved(MouseEvent e) { }

	//controls where you click and what they do
	public void mouseClicked(MouseEvent e) {
		int MouseX=e.getX();
		int MouseY=e.getY();
		
		if(active) {
		//Play again from GameOver screen
		if(MouseX >= imgX + (imgW/4) && MouseX <= imgX + (imgW/4)+imgW/2 && MouseY >= imgY + (imgH/8 * 5)-25 && MouseY <= imgY + (imgH/8 * 5)-25+imgH/8) {overPlayAgain=true; } 
		else {overPlayAgain=false; } 
		
	    //From game over screen go to Main menu
		if(MouseX >= imgX + (imgW/4) && MouseX <= imgX + (imgW/4)+imgW/2 && MouseY >= imgY +(imgH/8 *6)-15 && MouseY <= imgY +(imgH/8 *6)-15+imgH/8) { overMainMenu=true; } 	
		else { overMainMenu=false; }
		
		//From game over screen Quit game
		if(MouseX >= imgX + (imgW/4) && MouseX <= imgX + (imgW/4)+imgW/2 && MouseY >= imgY +(imgH/8 *7)-6 && MouseY <= imgY +(imgH/8 *7)-6+imgH/8) { overQuitGame=true; } 
		else { overQuitGame=false; }
		
		if (overPlayAgain) {
		active = false;
		playAgain();
		reset=true;
		System.out.println("Gameover play again"); }
	
		if(overMainMenu) {
		active=false; 
		mainmenu.active=true;
		reset=true;
		GoToMainMenu();
		System.out.println("Gameover main Menu"); }
		
		if (overQuitGame) {
		ExitGame();
		System.out.println("Gameover quit"); }
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {  }

	@Override
	public void mouseReleased(MouseEvent e) {	}

	@Override
	public void mouseEntered(MouseEvent e) {	}

	@Override
	public void mouseExited(MouseEvent e) {		}

	@Override
	public void inGameLoop() {		}
	

}