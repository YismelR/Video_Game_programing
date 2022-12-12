import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameComplete extends GameBase implements MouseListener{
	
	boolean active = false;
	boolean reset = false;
	
	BufferedImage img;
	int imgW; 
	int imgH;
	int imgX;
	int imgY;
	
	public Image background() {
       try {
           img = ImageIO.read(new File("Game complete.png"));
       } catch (IOException e) { }
 
        imgW = img.getWidth(null);
        imgH = img.getHeight(null); 
        imgX = (width/2 - imgW/2);
    	imgY = (height/2 - imgH/2);
        return img;
	}

	public GameComplete(GameBase game) {
	active = false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(background(), imgX, imgY, imgW, imgH, null);
	}


	public void mouseMoved(MouseEvent e) { }

	public void mouseClicked(MouseEvent e) {
		int MouseX=e.getX();
		int MouseY=e.getY();
			
		if(active) {
		//From game complete screen, go to main menu
		if(MouseX >= imgX + (imgW/4)-25 && MouseX <= imgX + (imgW/4)-25+imgW/2+40 && MouseY >= imgY + (imgH/8 * 5)-35 && MouseY <= imgY + (imgH/8 * 5)-35 + imgH/8) { completePlayAgain=true; } 
		else { completePlayAgain=false; } 
		
		//from game complete screen, play again
		if(MouseX >= imgX + (imgW/4)-25 && MouseX <= imgX + (imgW/4)-25+imgW/2+40 && MouseY >= imgY +(imgH/8 *6)-20 && MouseY <= imgY +(imgH/8 *6)-20 + imgH/8) { completeMainMenu=true; } 
		else { completeMainMenu=false;} 		
		
        //From game complete screen, quit Game
		if(MouseX >= imgX + (imgW/4)-25 && MouseX <= imgX + (imgW/4)-25+imgW/2+40 && MouseY >= imgY +(imgH/8 *7)-6 && MouseY <= imgY +(imgH/8 *7)-6 + imgH/8) { completeQuit=true; }
		else { completeQuit=false; }
		
		//Point p = e.getPoint ();
		if (completePlayAgain) {
		active = false; 
		playAgain();
		System.out.println("gamecomplete playagain");}
		
		if(completeMainMenu) {
		active=false;
		mainmenu.active=true;
		GoToMainMenu();
		System.out.println("gamecomplete mainmenu");}
		
		if (completeQuit) {
		ExitGame();
		System.out.println("gamecomplete quit");}
		
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {  }

	@Override
	public void mouseReleased(MouseEvent e) {  }

	@Override
	public void mouseEntered(MouseEvent e) {  }

	@Override
	public void mouseExited(MouseEvent e) {	 }

	@Override
	public void inGameLoop() {	}
	

}
