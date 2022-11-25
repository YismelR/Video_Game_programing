import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

//Code Legend
/*Formula to automatically generate zombies 
		//for(i=0; i<ZombieCount; i++;)
		//((width)+(width*i)/4)
		//Zombies per Quadrant
		(level 1; i = 15  3 zombies * 5 Quadrants)
		(level 2; i = 21  3 zombies * 7 Quadrants) +6 zombies
		(level 3; i = 27  3 zombies * 9 Quadrants) +6 zombies 
		(level 4; i = 33  3 zombies * 11 Quadrants) +6 zombies
		(level 5; i = 39  3 zombies * 13 Quadrants) +6 zombies
		(level 6; i = 45  3 zombies * 15 Quadrants) +6 zombies */

public class Levels extends GameBase implements KeyListener{
	//public Levels(){
		
	boolean levelEnd=false;
	BadSoldier bad;
	Soldier soldier = new Soldier(width/2, height-117, 27, 51);
	
	//In game Assets
	Door door = new Door(((width)+(width*ZombieCount)/4), height-117, 100, 100);
	ImageLoader GameCompleteScreen = new ImageLoader(0, -35, "Game complete.png");
	ImageLoader MainMenuScreen = new ImageLoader(0, 0, "Main Menu.png");
	ImageLoader LevelCompleteScreen = new ImageLoader(0, -40,"Level Complete.png");
	ImageLoader PauseMenuScreen = new ImageLoader(0, 0,"Pause Menu.png");
	ImageLoader GameOverScreen = new ImageLoader(0, 0,"Game Over Screen.png");
	
	//MainMenu Assets
	Rect StartGame = new Rect(100, 270, 310, 110);
	Rect Credits = new Rect(50, 425, 410, 75);
	Rect MainMenuQuit = new Rect(10, 550, 490, 80);
	
	//Pause Menu Assets
	Rect PauseMenuMainmenu = new Rect(260, 260, 570, 80);
	Rect PauseMenuResume = new Rect(280, 370, 550, 80);
	Rect PauseMenuQuit = new Rect(300, 505, 490, 80);
	
	//Game Over Assets
	Rect playAgain = new Rect(360, 355, 500, 70);
	Rect GameOverMainMenu = new Rect(360, 445, 500, 70);
	Rect GameOverQuit = new Rect(360, 535, 510, 70);
	
	//Level Complete Assets
	Rect LevelMainmenu = new Rect(370, 300, 515, 70);
	Rect LevelPlayAgain = new Rect(370, 390, 515, 70);
	Rect LevelQuit = new Rect(370, 490, 515, 70);
	Rect LevelNextLevel = new Rect(370, 590, 515, 70);
	
	//Game Levels Complete Assets
	Rect CompleteMainmenu = new Rect(365, 375, 510, 70);
	Rect CompletePlayAgain = new Rect(375, 480, 490, 70);
	Rect CompleteQuit = new Rect(375, 590, 490, 70);
	
	//Parallax Assets for Level 1
	ImageLoader background1a = new ImageLoader(0, 0,"background1.png");
	ImageLoader background1b = new ImageLoader(background1a.x+width, 0,"background1.png");
	ImageLoader midground1a = new ImageLoader(0, 0,"midground1.png");
	ImageLoader midground1b = new ImageLoader(midground1a.x+width, 0,"midground1.png");
	ImageLoader foreground1a = new ImageLoader(0, 0, "foreground1.png");
	ImageLoader foreground1b= new ImageLoader(foreground1a.x+width, 0,"foreground1.png");
	
	//Parallax Assets for Level 2
	ImageLoader background2a = new ImageLoader(0,0,"background2.png"); 
	ImageLoader background2b = new ImageLoader(background2a.x+width, 0,"background2.png");
	ImageLoader midground2a  = new ImageLoader(0, 0,"midground2.png");
	ImageLoader midground2b  = new ImageLoader(midground2a.x+width, 0,"midground2.png");
	ImageLoader foreground2a = new ImageLoader(0, 0,"foreground2.png");
	ImageLoader foreground2b = new ImageLoader(foreground2a.x+width, 0,"foreground2.png");
	  
	//Parallax Assets for Level 3
	 ImageLoader background3a = new ImageLoader(0,0,"background3.png");
	 ImageLoader background3b = new ImageLoader(background3a.x+width, 0,"background3.png"); 
     ImageLoader midground3a = new ImageLoader(0, 0,"midground3.png");
	 ImageLoader midground3b = new ImageLoader(midground3a.x+width, 0,"midground3.png"); 
	 ImageLoader foreground3a = new ImageLoader(0, 0, "foreground3.png"); 
	 ImageLoader foreground3b= new ImageLoader(foreground3a.x+width, 0,"foreground3.png");
	  	  
	//Parallax Assets for Level 4
	  ImageLoader background4a = new ImageLoader(0,0,"background4.png");
	  ImageLoader background4b = new ImageLoader(background4a.x+width, 0,"background4.png"); 
	  ImageLoader midground4a = new ImageLoader(0, 0,"midground4.png");
	  ImageLoader midground4b = new ImageLoader(midground4a.x+width, 0,"midground4.png"); 
	  ImageLoader foreground4a = new ImageLoader(0, 0, "foreground4.png"); 
	  ImageLoader foreground4b= new ImageLoader(foreground4a.x+width, 0,"foreground4.png");
	  
	//Parallax Assets for Level 5
	  ImageLoader background5a = new ImageLoader(0,0,"background5.png");
	  ImageLoader background5b = new ImageLoader(background5a.x+width, 0,"background5.png"); 
	  ImageLoader midground5a = new ImageLoader(0, 0,"midground5.png");
	  ImageLoader midground5b = new ImageLoader(midground5a.x+width, 0,"midground5.png"); 
	  ImageLoader foreground5a = new ImageLoader(0, 0, "foreground5.png"); 
	  ImageLoader foreground5b= new ImageLoader(foreground5a.x+width, 0,"foreground5.png");
	  
	// Parallax Assets for Level 6
	  ImageLoader background6a = new ImageLoader(0,0,"background6.png");
	  ImageLoader background6b = new ImageLoader(background6a.x+width, 0,"background6.png"); 
	  ImageLoader midground6a = new ImageLoader(0, 0,"midground6.png");
	  ImageLoader midground6b = new ImageLoader(midground6a.x+width, 0,"midground6.png"); 
	  ImageLoader foreground6a = new ImageLoader(0, 0, "foreground6.png"); 
	  ImageLoader foreground6b= new ImageLoader(foreground6a.x+width, 0,"foreground6.png");
	
	//Main menu specs
	public void MainMenu() {
		//if at the main menu
		mainmenu();
		
		
		//start game from main menu
		if(health_status==0 && running==false && KillCount==0 && levelCount==0) {
			startGame();
		}
		
		//Code for Credits
		if(health_status==0 && running==false && KillCount==0 && levelCount==0) {
			startGame();
		}
		
		//Quit game from main menu
		if(health_status==0 && running==false && KillCount==0 && levelCount==0) {
			System.exit(1);
		}
		
	}
	
	//Pause menu specs
	public void PauseMenu() {
	//if you want to pause
	if((!(gameOver==true && health_status==0)) && isPaused==false && running==true && levelPassed==false) {
		if(pressing[ESCAPE]) {
		pauseGame();}
	}
	
	//resume from pause menu
	if((!(gameOver==true && health_status==0) && isPaused==true && pressing[ESCAPE])) {
		 resumeGame();
		 }
	
	//Go to main menu from pause menu
	 if(isPaused==true) {
		 GoToMainMenu();
	  }
	
	 //Exit or Quit game from pause menu
	 if(isPaused==true || running==false || gameOver==true) {
		  if(pressing[_Q]) { System.exit(1);};  
		  }
	}
	
	//game over specs
	public void GameOver() {
		//if game is over
		if(health_status==0) {
			gameOver();  
		}
		
		//Play game again from GameOver screen
	    if(health_status==0 && gameOver==true) {
	    	playAgain();
		 }
	    
		//go to main menu from game over screen
		 if(isPaused==true) {
			 GoToMainMenu();
		  }
		
		//Exit or Quit game from Game Over screen
		 if(isPaused==true || running==false || gameOver==true) {
			  if(pressing[_Q]) { ExitGame();};  
		  } 
	}
	
	//level complete specs
	public void LevelComplete() {
		//if level is complete
		 if(!(health_status == 0 && gameOver==true)) {
			 if(KillCount==ZombieCount) {
			levelComplete(); }
		 }
		 
		 //go to main menu from level complete screen
		 if(isPaused==true) {
			 GoToMainMenu();
		  }
		 
		//Exit or Quit game from level complete screen
		 if(isPaused==true || running==false || gameOver==true) {
			  if(pressing[_Q]) {System.exit(1);};  
		  }
		 
		//Go to next level from level complete screen
	    if(levelPassed) {
	 	 NextLevel(); 
	     }
		 
		//Play game again from level complete screen
	    if((!(levelCount==6)) && health_status==0 && gameOver==true) {
	    	playAgain();
		 }
	}
	
	//game complete specs
	public void GameComplete() {
		//if Game complete
		 if((!(health_status == 0 && gameOver==true)) && levelCount==6 && KillCount==ZombieCount) {
			 GameComplete();
		  }
		 
		//go to main menu from game complete screen
		 if(isPaused==true) {
			 GoToMainMenu();
		  }
		 
		//Exit or Quit game from Game complete screen
		 if(isPaused==true || running==false || gameOver==true) {
			  if(pressing[_Q]) { System.exit(1);};  
		  }
		 
		//Play game again from Game complete screen
		    if(levelCount==6 && health_status==0 && levelPassed==true) {
		    	playAgain();
			 }
	}
	
	
	  
	public void LevelOne() {	
		
		//Play again
		 if(health_status==0 && gameOver==true) {
			 
			 playAgain(); }
		    //move to the next level
		 if(KillCount==ZombieCount && soldier.overlaps(door)) {
		    	NextLevel();
		    	update(offscreen_g); }
		 
		 
		 
		}
	
	
	public void LevelTwo() {
		//Play again
		 if(health_status==0 && gameOver==true) {
			 
			 playAgain(); }
		    //move to the next level
		 if(KillCount==ZombieCount && soldier.overlaps(door)) {
		    	NextLevel();
		    	update(offscreen_g); }
		
	}
	
	public void LevelThree() {
		//Play again
		 if(health_status==0 && gameOver==true) {
			 playAgain(); }
		    //move to the next level
		 if(KillCount==ZombieCount && soldier.overlaps(door)) {
		    	NextLevel();
		    	update(offscreen_g); }
			  
		}
	
	public void LevelFour() {
		//Play again
		 if(health_status==0 && gameOver==true) {
			 playAgain(); }
		    //move to the next level
		 if(KillCount==ZombieCount && soldier.overlaps(door)) {
		    	NextLevel();
		    	update(offscreen_g); }
		 
	}
	
	public void LevelFive() {
		//Play again
		 if(health_status==0 && gameOver==true) {
			 playAgain(); }
		    //move to the next level
		 if(KillCount==ZombieCount && soldier.overlaps(door)) {
		    	NextLevel();
		    	update(offscreen_g); }
			  
	}
	
	public void LevelSix() {
		//Play again
		 if(health_status==0 && gameOver==true) {
			 playAgain(); }
		    //move to the next level
		 if(KillCount==ZombieCount && soldier.overlaps(door)) {
		    	NextLevel();
		    	update(offscreen_g); }
		 
	}
	
	public void inGameLoop() {
		
		//LevelSix();
		
	}
	
	
	public void paint(Graphics g) {
	
        //Paint method for main menu
		if(levelCount==0) {
		g.setColor (Color.white);
		//Paint main menu screen
		MainMenuScreen.draw(g);
		mainmenu();
		StartGame.draw(g);
		Credits.draw(g);
		MainMenuQuit.draw(g);
	
		
	  }
				
		//Paint method for level 1
		if(levelCount==1) {
		//Paint level 1 background
		background1a.draw(g);
		background1b.draw(g);
		midground1a.draw(g);
		midground1b.draw(g);
		foreground1a.draw(g);
		foreground1b.draw(g);
		door.draw(g);
		soldier.draw(g);
		for(int i=0; i<ZombieCount; i++) {
			bad = new BadSoldier(((width)+(width*i)/4), height-117, 27, 51);
			bad.draw(g); }
		
	  }
		
		//Paint method for level 2
		if(levelCount==2) {
		//Paint level 2 background
		background2a.draw(g); 
		background2b.draw(g);
		midground2a.draw(g);
		midground2b.draw(g);
		foreground2a.draw(g);	
		foreground2b.draw(g); 
		soldier.draw(g);
		for(int i=0; i<ZombieCount;i++) {
		bad = new BadSoldier(((width)+(width*i)/4), height-117, 27,51);
		bad.draw(g); }
		door.draw(g);
	  } 
		
		//Paint method for level 3
		if(levelCount==3) {
		//Paint level 3 background
		background3a.draw(g);
		background3b.draw(g);
		midground3a.draw(g); 
		midground3b.draw(g);
		foreground3a.draw(g);
		foreground3b.draw(g); 
		soldier.draw(g);
		for(int i=0; i<ZombieCount; i++) {
		bad = new BadSoldier(((width)+(width*i)/4), height-117, 27, 51);
		bad.draw(g); }
		door.draw(g);
       }
		
		//Paint method for level 4
		if(levelCount==4) {
		//Paint level 4 background
		background4a.draw(g);
		background4b.draw(g);
		midground4a.draw(g); 
		midground4b.draw(g);
		foreground4a.draw(g);
		foreground4b.draw(g);
		soldier.draw(g);
		for(int i=0; i<ZombieCount; i++) {
		bad = new BadSoldier(((width)+(width*i)/4), height-117, 27, 51);
		bad.draw(g); }
		door.draw(g);
	  }
		
		//Paint method for level 5
		if(levelCount==5) {
		//Paint level 5 background
		background5a.draw(g);
		background5b.draw(g);
		midground5a.draw(g); 
		midground5b.draw(g);
		foreground5a.draw(g);
		foreground5b.draw(g); 
		soldier.draw(g);
		for(int i=0; i<ZombieCount; i++) 
		{ bad = new BadSoldier(((width)+(width*i)/4), height-117, 27, 51);
		bad.draw(g); } 
		door.draw(g);
		}
		
		//Paint method for level 6
		if(levelCount==6) {
		//Paint level 6 background
		background6a.draw(g);
		background6b.draw(g);
		midground6a.draw(g); 
		midground6b.draw(g);
		foreground6a.draw(g);
		foreground6b.draw(g); 
		soldier.draw(g);
		for(int i=0; i<ZombieCount; i++) 
		{ bad = new BadSoldier(((width)+(width*i)/4), height-117, 27, 51);
		bad.draw(g); }
		door.draw(g);
	  }
   }
	
		@Override
		public void mousePressed(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
		@Override
		public void mouseExited(MouseEvent e) {	}
		@Override
		public void mouseEntered(MouseEvent e) { }
		@Override
		public void mouseMoved(MouseEvent e) { }
		@Override
		public void mouseClicked(MouseEvent e) { }	
	
}



	