import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu extends GameBase implements MouseListener {
	
	boolean active = false;
	boolean reset = false;

	BufferedImage img; 
	int imgW; 
	int imgH;
	int imgX;
	int imgY;
	
	public Image background() {
       try {
           img = ImageIO.read(new File("Main Menu.png"));
       } catch (IOException e) { }
       
        imgW = img.getWidth(null);
        imgH = img.getHeight(null); 
        imgX = 0;
    	imgY = 0;
        return img;
	}

	public MainMenu(GameBase game) {
	active = true;
	mainmenu();
	game.start();	
	}
	
	public void draw(Graphics g) {
		g.drawImage(background(), 0, 0, width, height, null);
	}
	
	public void mouseClicked(MouseEvent e) {
		
		int MouseX=e.getX();
		int MouseY=e.getY();
		
		if(active) {
		//From main menu start Game
		if(MouseX >= imgX+200 && MouseX <= imgX+200 + imgW/8 && MouseY >= imgY + (imgH/6)+100 && MouseY <= imgY + (imgH/6)+100 + imgH/10) { menuStartGame=true; }
		else  { menuStartGame=false; }	

		//From main menu Credits
		if(MouseX >= imgX+170 && MouseX <= imgX+170 + imgW/6 && MouseY >= imgY + (imgH/6 *2) +40 && MouseY <= imgY + (imgH/6 *2) + 40 + imgH/15) { menuCredits=true; }
		else { menuCredits=false; }
		
        //From main menu quit Game
		if(MouseX >= imgX+130 && MouseX <= imgX+130 + imgW/5 && MouseY >= imgY + (imgH/7 *3) +35 && MouseY <= imgY + (imgH/7 *3) + 35 + imgH/15) { menuQuitGame=true; }
		else { menuQuitGame=false; }
		
		if (menuStartGame) {
		active=false;
		startGame();
		reset=true;
		System.out.println("Main menu StartGame");}
		
		if (menuQuitGame) {
		ExitGame();
		System.out.println("Main menu Quit");}
		
		else if(menuCredits) {
		System.out.println("Main menu Credits");}
		}

		
	}
	
	public void mouseMoved(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {  }

	@Override
	public void mouseReleased(MouseEvent e) {  }

	@Override
	public void mouseEntered(MouseEvent e) {  }

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void inGameLoop() {	}
	

}