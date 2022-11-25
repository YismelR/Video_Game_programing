import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public abstract class GameBase extends Applet implements Runnable, KeyListener, MouseListener
{
	//Screen Dimensions specifications are below
	Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
	// width will store the width of the screen 
	int width = (int)size.getWidth();
	// height will store the height of the screen 
	int height = (int)size.getHeight();
		
	Thread t;
	
	Image    offscreen_Image;
	Graphics offscreen_g;
	
	int health_status = 100; //health of player
	int ZombieCount = 15; //3 zombies per Quadrant, increment by 6 as player progresses
	int KillCount = 0; //Kill count must equal zombie count to progress
	int levelCount = 0; //keeping count of current level
	
	//Note, players can't choose which levels to play in, they only need to 
	//win the current level, excluding level 6, to progress to next level
	//Game Options global variables
	boolean running = false; // check if game is currently playing
	boolean gameOver = false; // check if game is over or player lost
	boolean isPaused = false; // check if game is paused
	boolean levelPassed = false; //check if current level is passed
	
	//MainMenu screen options check
	boolean menuStartGame = false;
	boolean menuCredits = false;
	boolean menuQuitGame = false;
	
	//Pause menu screen options check
	boolean pauseResumeGame = false;
	boolean pauseMainMenu = false;
	boolean pauseQuitGame = false;
	
	//Game Over screen options check
	boolean overPlayAgain = false;
	boolean overQuitGame = false;
	boolean overMainMenu = false;
	
	//level complete screen options check
	boolean levelPlayAgain = false;
	boolean levelQuitGame = false;
	boolean levelMainMenu = false;
	boolean levelNextLevel = false;
	
	//game complete screen options check
	boolean completeMainMenu = false;
	boolean completeQuit = false;
	boolean completePlayAgain = false;
	
	boolean[] pressing = new boolean[1024];	
	
	public static final int UP          = KeyEvent.VK_UP;
	public static final int DN          = KeyEvent.VK_DOWN;
	public static final int LT          = KeyEvent.VK_LEFT;
	public static final int RT          = KeyEvent.VK_RIGHT;
	
	public static final int _A          = KeyEvent.VK_A;
	public static final int _B          = KeyEvent.VK_B;
	public static final int _C          = KeyEvent.VK_C;
	public static final int _D          = KeyEvent.VK_D;
	public static final int _E          = KeyEvent.VK_E;
	public static final int _F          = KeyEvent.VK_F;
	public static final int _G          = KeyEvent.VK_G;
	public static final int _H          = KeyEvent.VK_H;
	public static final int _I          = KeyEvent.VK_I;
	public static final int _J          = KeyEvent.VK_J;
	public static final int _K          = KeyEvent.VK_K;
	public static final int _L          = KeyEvent.VK_L;
	public static final int _M          = KeyEvent.VK_M;
	public static final int _N          = KeyEvent.VK_N;
	public static final int _O          = KeyEvent.VK_O;
	public static final int _P          = KeyEvent.VK_P;
	public static final int _Q          = KeyEvent.VK_Q;
	public static final int _R          = KeyEvent.VK_R;
	public static final int _S          = KeyEvent.VK_S;
	public static final int _T          = KeyEvent.VK_T;
	public static final int _U          = KeyEvent.VK_U;
	public static final int _V          = KeyEvent.VK_V;
	public static final int _W          = KeyEvent.VK_W;
	public static final int _X          = KeyEvent.VK_X;
	public static final int _Y          = KeyEvent.VK_Y;
	public static final int _Z          = KeyEvent.VK_Z;

	public static final int _1          = KeyEvent.VK_1;
	public static final int _2          = KeyEvent.VK_2;
	public static final int _3          = KeyEvent.VK_3;
	public static final int _4          = KeyEvent.VK_4;
	public static final int _5          = KeyEvent.VK_5;
	public static final int _6          = KeyEvent.VK_6;
	public static final int _7          = KeyEvent.VK_7;
	public static final int _8          = KeyEvent.VK_8;
	public static final int _9          = KeyEvent.VK_9;
	
	public static final int CTRL        = KeyEvent.VK_CONTROL;
	public static final int SHFT        = KeyEvent.VK_SHIFT;
	public static final int ALT         = KeyEvent.VK_ALT;
	
	public static final int SPACE       = KeyEvent.VK_SPACE;
	
	public static final int COMMA       = KeyEvent.VK_COMMA;
	public static final int PERIOD      = KeyEvent.VK_PERIOD;
	public static final int SLASH       = KeyEvent.VK_SLASH;
	public static final int SEMICOLON   = KeyEvent.VK_SEMICOLON;
	public static final int COLON       = KeyEvent.VK_COLON;
	public static final int QUOTE       = KeyEvent.VK_QUOTE;
	public static final int ESCAPE      = KeyEvent.VK_ESCAPE;
	
	public static final int F1          = KeyEvent.VK_F1;
	public static final int F2          = KeyEvent.VK_F2;
	public static final int F3          = KeyEvent.VK_F3;
	public static final int F4          = KeyEvent.VK_F4;
	public static final int F5          = KeyEvent.VK_F5;
	public static final int F6          = KeyEvent.VK_F6;
	public static final int F7          = KeyEvent.VK_F7;
	public static final int F8          = KeyEvent.VK_F8;
	public static final int F9          = KeyEvent.VK_F9;
	public static final int F10         = KeyEvent.VK_F10;
	public static final int F11         = KeyEvent.VK_F11;
	public static final int F12         = KeyEvent.VK_F12;
	
	public void init()
	{
		//setSize to (width, height);
		setSize(width, height);
		
		offscreen_Image = createImage(width, height);
		offscreen_g     = offscreen_Image.getGraphics();

		requestFocus();
		
		addKeyListener(this);
		addMouseListener(this);
		
		t = new Thread(this);
		t.start();
	} 
	 
	//if player dies or completes the
	//level, and wants to play again
	 public void playAgain() {
		 health_status=100;
		 running = true;
		 gameOver=false;
		 isPaused=false;
		 KillCount=0;
		 ZombieCount=ZombieCount;
		 levelPassed=false;
	 }
	 
	 //from main menu, start game
	 public void startGame() {
		 health_status=100;
		 running=true;
		 KillCount=0;
	     ZombieCount=15;
	     levelCount=1;
	     levelPassed=false;
		  
	 }
	 
	 //switches for main menu
	 public void mainmenu() {
	  health_status=0;
	  running=false;
	  KillCount=0;
	  ZombieCount=15;
	  levelCount=0;
	  levelPassed=false;
	 }
	 
	 //switches for level complete
	 public void levelComplete() {
			 running=false;
			 levelPassed=true;	 
	 }
	 
	 //switches for exit game
	 public void ExitGame( )
	 {
	  System.exit(1);
	 } 
	 
	 //switches for pause game
	 public void pauseGame() {
		  running = false;
		  isPaused = true; 
	 }
	 
	 //switches for resume game
	 public void resumeGame( ) {
		 isPaused = false;
		 running = true;
	 }
	 
	 //switches for go to main menu
	 public void GoToMainMenu() {
		 running  = false;
		 levelCount=0;
		 health_status=0;
		 KillCount=0;
		 ZombieCount=0;
		 levelPassed=false;
	 }
	 
	 //switches foe game complete
	 public void GameComplete() {
		 running  = false;
		 levelPassed=true;
	 }

	 //switches for game over
	 public void gameOver() {
		 gameOver = true;
		 running = false;
		 levelPassed=false;
		 KillCount=0;
		 levelPassed=false;
	 } 
	 
	 //switches for next level
	 public void NextLevel() {
		 health_status=100;
		 running=true;
		 KillCount=0;
		 levelPassed=false;
		 ZombieCount+=6;
	     levelCount+=1;
	 }
	 
	public abstract void inGameLoop();
	
	public void run()
	{	
		while(true)
		{
			
			inGameLoop();

			repaint();
			
   		try
   		{
   			t.sleep(15);
   		}
   		catch(Exception x) {};
		}
	}
	
	public void update(Graphics g)
	{
		offscreen_g.clearRect(0, 0, width, height);
		
		paint(offscreen_g);
		
		g.drawImage(offscreen_Image, 0, 0, null);
	}
	
	
	public void keyPressed(KeyEvent e)
	{
		pressing[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e)
	{
		pressing[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e)  {	}

	int MouseX;
	int MouseY;
	
	//Mouse Events from all Option screens
	public void mousePressed(MouseEvent e) {
		MouseX=e.getX();
		MouseY=e.getY();
		
	/*############################################ MAIN MENU #################################################*/
		//Mouse Events from the Main Menu
		if(levelCount==0) {
		//From main menu start Game
		if(MouseX >= 100 && MouseX <= 100+310 && MouseY >= 270 && MouseY <= 270+110)  { menuStartGame=true; }
		if(MouseX <= 100 || MouseX >= 100+310 || MouseY <= 270 || MouseY >= 270+110)  { menuStartGame=false; }	

		
		//From main menu Credits
		if(MouseX >= 50 && MouseX <= 50+410 && MouseY >= 425 && MouseY <= 425+75) { menuCredits=true; }
		if(MouseX <= 50 || MouseX >= 50+410 || MouseY <= 425 || MouseY >= 425+75) { menuCredits=false; }
		
        //From main menu quit Game
		if(MouseX >= 10 && MouseX <= 10+490 && MouseY >= 550 && MouseY <= 550+80) { menuQuitGame=true; }
		if(MouseX <= 10 || MouseX >= 10+490 || MouseY <= 550 || MouseY >= 550+80) { menuQuitGame=false; }
		
		} 
		
		
	/*############################################ LEVEL 1 #####################################################*/
		
		
	    //Mouse Events from pause menu
		if(levelCount==1) {
		//Go to pause menu from in-game play
		if((!(gameOver==true && health_status==0)) && isPaused==false && running==true && levelPassed==false) {
			if(pressing[ESCAPE]) {
			//isPaused == true, do something, paint the pause screen in paint
			pauseGame();}
		
		//from pause Menu, go to main menu
		if(MouseX >= 260 && MouseX <= 260+570 && MouseY >= 260 && MouseY <= 260+80) { pauseMainMenu=true; } 
		if(MouseX <= 260 || MouseX >= 260+570 && MouseY <= 260 && MouseY >= 260+80) { pauseMainMenu=false; } 
		
		//From pause menu resume Game
		if(MouseX >= 280 && MouseX <= 280+550 && MouseY >= 370 && MouseY <= 370+80) { pauseResumeGame=true; } 
		if(MouseX <= 280 || MouseX >= 280+550 || MouseY <= 370 || MouseY >= 370+80) { pauseResumeGame=false; } 
		
        //From pause menu quit Game
		if(MouseX >= 300 && MouseX <= 300+490 && MouseY >= 505 && MouseY <= 505+80) { pauseQuitGame=true; } 
		if(MouseX <= 300 || MouseX >= 300+490 || MouseY <= 505 || MouseY >= 505+80) { pauseQuitGame=false; } 
		}
		
		
		//Game over screen options
		if(health_status==0) {
			gameOver();  
		//Play again from GameOver screen
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 355 && MouseY <= 355+70) {overPlayAgain=true; } 
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 355 || MouseY >= 355+70) {overPlayAgain=false; } 
	
		//From game over screen Quit game
		if(MouseX >= 360 && MouseX <= 360+510 && MouseY >= 535 && MouseY <= 535+70) { overQuitGame=true; } 
		if(MouseX <= 360 || MouseX >= 360+510 || MouseY <= 535 || MouseY >= 535+70) { overQuitGame=false; } 
		
        //From game over screen go to Main menu
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 445 && MouseY <= 445+70) { overMainMenu=true; } 	
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 445 || MouseY >= 445+70) { overMainMenu=false; } 	
		}

		
		//Level complete options
		if(!(health_status == 0 && gameOver==true)) {
			 if(KillCount==ZombieCount) {
			//And Soldier overlaps door
			levelComplete(); 
		//if below level 6, from level complete screen, go to next level
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 590 && MouseY <= 590+70) {levelNextLevel=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 590 || MouseY >= 590+70) {levelNextLevel=false; } 
	
		//From level complete screen play again
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 390 && MouseY <= 390+70) { levelPlayAgain=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 390 || MouseY >= 390+70) { levelPlayAgain=false; } 

        //From level complete screen go to Main menu
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 300 && MouseY <= 300+70) { levelMainMenu=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 300 || MouseY >= 300+70) { levelMainMenu=false; } 
		
		 //From level complete screen Quit
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 490 && MouseY <= 490+70) { levelQuitGame=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 490 || MouseY >= 490+70) { levelQuitGame=false; } } 
		}
		}
		
		
	/*######################################## LEVEL 2 ########################################################*/
		
		
		//Mouse Events from the main menu
		if(levelCount==2) {
		if((!(gameOver==true && health_status==0)) && isPaused==false && running==true && levelPassed==false) {
			if(pressing[ESCAPE]) {
			//isPaused == true, do something, paint the pause screen in paint
			pauseGame();}
		
		//from pause Menu, go to main menu
		if(MouseX >= 260 && MouseX <= 260+570 && MouseY >= 260 && MouseY <= 260+80) { pauseMainMenu=true; } 
		if(MouseX <= 260 || MouseX >= 260+570 || MouseY <= 260 || MouseY >= 260+80) { pauseMainMenu=false; } 
		
		//From pause menu resume Game
		if(MouseX >= 280 && MouseX <= 280+550 && MouseY >= 370 && MouseY <= 370+80) { pauseResumeGame=true; } 
		if(MouseX <= 280 || MouseX >= 280+550 || MouseY <= 370 || MouseY >= 370+80) { pauseResumeGame=false; } 
		
        //From pause menu quit Game
		if(MouseX >= 300 && MouseX <= 300+490 && MouseY >= 505 && MouseY <= 505+80) { pauseQuitGame=true; } 
		if(MouseX <= 300 || MouseX >= 300+490 || MouseY <= 505 || MouseY >= 505+80) { pauseQuitGame=false; }
		}
		
		
		//Game over screen options
		if(health_status==0) {
			gameOver();  
		//Play again from GameOver screen
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 355 && MouseY <= 355+70) {overPlayAgain=true; } 
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 355 || MouseY >= 355+70) {overPlayAgain=false; } 
	
		//From game over screen Quit game
		if(MouseX >= 360 && MouseX <= 360+510 && MouseY >= 535 && MouseY <= 535+70) { overQuitGame=true; } 
		if(MouseX <= 360 || MouseX >= 360+510 || MouseY <= 535 || MouseY >= 535+70) { overQuitGame=false; } 
		
        //From game over screen go to Main menu
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 445 && MouseY <= 445+70) { overMainMenu=true; } 	
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 445 || MouseY >= 445+70) { overMainMenu=false; }	
		}
			
		
		//Level complete options
		if(!(health_status == 0 && gameOver==true)) {
			 if(KillCount==ZombieCount) {
			//And Soldier overlaps door
			levelComplete(); 
		//if below level 6, from level complete screen, go to next level
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 590 && MouseY <= 590+70) {levelNextLevel=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 590 || MouseY >= 590+70) {levelNextLevel=false; } 
	
		//From level complete screen play again
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 390 && MouseY <= 390+70) { levelPlayAgain=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 390 || MouseY >= 390+70) { levelPlayAgain=false; } 

        //From level complete screen go to Main menu
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 300 && MouseY <= 300+70) { levelMainMenu=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 300 || MouseY >= 300+70) { levelMainMenu=false; } 
		
		 //From level complete screen Quit
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 490 && MouseY <= 490+70) { levelQuitGame=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 490 || MouseY >= 490+70) { levelQuitGame=false; } } 
		}
		}
		
		
	/*################################################# LEVEL 3 ####################################################*/
		
		
		//Mouse Events from the main menu
		if(levelCount==3) {
		//Pause menu options
		if((!(gameOver==true && health_status==0)) && isPaused==false && running==true && levelPassed==false) {
			if(pressing[ESCAPE]) {
			//isPaused == true, do something, paint the pause screen in paint
			pauseGame();}
		//from pause Menu, go to main menu
		if(MouseX >= 260 && MouseX <= 260+570 && MouseY >= 260 && MouseY <= 260+80) { pauseMainMenu=true; } 
		if(MouseX <= 260 || MouseX >= 260+570 || MouseY <= 260 || MouseY >= 260+80) { pauseMainMenu=false; } 
		
		//From pause menu resume Game
		if(MouseX >= 280 && MouseX <= 280+550 && MouseY >= 370 && MouseY <= 370+80) { pauseResumeGame=true; } 
		if(MouseX <= 280 || MouseX >= 280+550 || MouseY <= 370 || MouseY >= 370+80) { pauseResumeGame=false; } 
		
        //From pause menu quit Game
		if(MouseX >= 300 && MouseX <= 300+490 && MouseY >= 505 && MouseY <= 505+80) { pauseQuitGame=true; } 
		if(MouseX <= 300 || MouseX >= 300+490 || MouseY <= 505 || MouseY >= 505+80) { pauseQuitGame=false; }
		}
			
		
		//Game over screen options
		if(health_status==0) {
			gameOver();  
		//Play again from GameOver screen
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 355 && MouseY <= 355+70) {overPlayAgain=true; } 
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 355 || MouseY >= 355+70) {overPlayAgain=false; } 
	
		//From game over screen Quit game
		if(MouseX >= 360 && MouseX <= 360+510 && MouseY >= 535 && MouseY <= 535+70) { overQuitGame=true; } 
		if(MouseX <= 360 || MouseX >= 360+510 || MouseY <= 535 || MouseY >= 535+70) { overQuitGame=false; } 
		
        //From game over screen go to Main menu
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 445 && MouseY <= 445+70) { overMainMenu=true; } 	
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 445 || MouseY >= 445+70) { overMainMenu=false; }	
		}
		
		
		//Level complete options
		if(!(health_status == 0 && gameOver==true)) {
			 if(KillCount==ZombieCount) {
			//And Soldier overlaps door
			levelComplete(); 
		//if below level 6, from level complete screen, go to next level
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 590 && MouseY <= 590+70) {levelNextLevel=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 590 || MouseY >= 590+70) {levelNextLevel=false; } 
	
		//From level complete screen play again
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 390 && MouseY <= 390+70) { levelPlayAgain=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 390 || MouseY >= 390+70) { levelPlayAgain=false; } 

        //From level complete screen go to Main menu
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 300 && MouseY <= 300+70) { levelMainMenu=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 300 || MouseY >= 300+70) { levelMainMenu=false; } 
		
		 //From level complete screen Quit
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 490 && MouseY <= 490+70) { levelQuitGame=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 490 || MouseY >= 490+70) { levelQuitGame=false; } } 
		}
		}
		
		
	/*########################################### LEVEL 4 #######################################################*/
		
		
		//Mouse Events from the main menu
		if(levelCount==4) {
		if((!(gameOver==true && health_status==0)) && isPaused==false && running==true && levelPassed==false) {
			if(pressing[ESCAPE]) {
			//isPaused == true, do something, paint the pause screen in paint
			pauseGame();}
		//from pause Menu, go to main menu
		if(MouseX >= 260 && MouseX <= 260+570 && MouseY >= 260 && MouseY <= 260+80) { pauseMainMenu=true; } 
		if(MouseX <= 260 || MouseX >= 260+570 || MouseY <= 260 || MouseY >= 260+80) { pauseMainMenu=false; } 
		
		//From pause menu resume Game
		if(MouseX >= 280 && MouseX <= 280+550 && MouseY >= 370 && MouseY <= 370+80) { pauseResumeGame=true; } 
		if(MouseX <= 280 || MouseX >= 280+550 || MouseY <= 370 || MouseY >= 370+80) { pauseResumeGame=false; } 
		
        //From pause menu quit Game
		if(MouseX >= 300 && MouseX <= 300+490 && MouseY >= 505 && MouseY <= 505+80) { pauseQuitGame=true; } 
		if(MouseX <= 300 || MouseX >= 300+490 || MouseY <= 505 || MouseY >= 505+80) { pauseQuitGame=false; }
		}
		
		
		//Game over screen options
		if(health_status==0) {
			gameOver();  
		//Play again from GameOver screen
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 355 && MouseY <= 355+70) {overPlayAgain=true; } 
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 355 || MouseY >= 355+70) {overPlayAgain=false; } 
	
		//From game over screen Quit game
		if(MouseX >= 360 && MouseX <= 360+510 && MouseY >= 535 && MouseY <= 535+70) { overQuitGame=true; } 
		if(MouseX <= 360 || MouseX >= 360+510 || MouseY <= 535 || MouseY >= 535+70) { overQuitGame=false; } 
		
        //From game over screen go to Main menu
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 445 && MouseY <= 445+70) { overMainMenu=true; } 	
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 445 || MouseY >= 445+70) { overMainMenu=false; }	}
		
		
		//Level complete options
		if(!(health_status == 0 && gameOver==true)) {
			 if(KillCount==ZombieCount) {
			//And Soldier overlaps door
			levelComplete(); 
		//if below level 6, from level complete screen, go to next level
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 590 && MouseY <= 590+70) {levelNextLevel=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 590 || MouseY >= 590+70) {levelNextLevel=false; } 
	
		//From level complete screen play again
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 390 && MouseY <= 390+70) { levelPlayAgain=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 390 || MouseY >= 390+70) { levelPlayAgain=false; } 

        //From level complete screen go to Main menu
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 300 && MouseY <= 300+70) { levelMainMenu=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 300 || MouseY >= 300+70) { levelMainMenu=false; } 
		
		 //From level complete screen Quit
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 490 && MouseY <= 490+70) { levelQuitGame=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 490 || MouseY >= 490+70) { levelQuitGame=false; } } 
		}
		}
		
		
	/*############################################ LEVEL 5 #######################################################*/
		
		
		//Mouse Events from level 5
		if(levelCount==5) {
		//Go to main menu
		if((!(gameOver==true && health_status==0)) && isPaused==false && running==true && levelPassed==false) {
			if(pressing[ESCAPE]) {
			//isPaused == true, do something, paint the pause screen in paint
			pauseGame();}
		//from pause Menu, go to main menu
		if(MouseX >= 260 && MouseX <= 260+570 && MouseY >= 260 && MouseY <= 260+80) { pauseMainMenu=true; } 
		if(MouseX <= 260 || MouseX >= 260+570 || MouseY <= 260 || MouseY >= 260+80) { pauseMainMenu=false; } 
		
		//From pause menu resume Game
		if(MouseX >= 280 && MouseX <= 280+550 && MouseY >= 370 && MouseY <= 370+80) { pauseResumeGame=true; } 
		if(MouseX <= 280 || MouseX >= 280+550 || MouseY <= 370 || MouseY >= 370+80) { pauseResumeGame=false; } 
		
        //From pause menu quit Game
		if(MouseX >= 300 && MouseX <= 300+490 && MouseY >= 505 && MouseY <= 505+80) { pauseQuitGame=true; } 
		if(MouseX <= 300 || MouseX >= 300+490 || MouseY <= 505 || MouseY >= 505+80) { pauseQuitGame=false; }  
		}
			
		
		//Game over screen options
		if(health_status==0) {
			gameOver();  
		//Play again from GameOver screen
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 355 && MouseY <= 355+70) {overPlayAgain=true; } 
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 355 || MouseY >= 355+70) {overPlayAgain=false; } 
	
		//From game over screen Quit game
		if(MouseX >= 360 && MouseX <= 360+510 && MouseY >= 535 && MouseY <= 535+70) { overQuitGame=true; } 
		if(MouseX <= 360 || MouseX >= 360+510 || MouseY <= 535 || MouseY >= 535+70) { overQuitGame=false; } 
		
        //From game over screen go to Main menu
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 445 && MouseY <= 445+70) { overMainMenu=true; } 	
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 445 || MouseY >= 445+70) { overMainMenu=false; }
		}
		
		
		//Level complete options
		if(!(health_status == 0 && gameOver==true)) {
			 if(KillCount==ZombieCount) {
			//And Soldier overlaps door
			levelComplete(); 
		//if below level 6, from level complete screen, go to next level
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 590 && MouseY <= 590+70) {levelNextLevel=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 590 || MouseY >= 590+70) {levelNextLevel=false; } 
	
		//From level complete screen play again
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 390 && MouseY <= 390+70) { levelPlayAgain=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 390 || MouseY >= 390+70) { levelPlayAgain=false; } 

        //From level complete screen go to Main menu
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 300 && MouseY <= 300+70) { levelMainMenu=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 300 || MouseY >= 300+70) { levelMainMenu=false; } 
		
		 //From level complete screen Quit
		if(MouseX >= 370 && MouseX <= 370+515 && MouseY >= 490 && MouseY <= 490+70) { levelQuitGame=true; } 
		if(MouseX <= 370 || MouseX >= 370+515 || MouseY <= 490 || MouseY >= 490+70) { levelQuitGame=false; } }
		}
		}
		
		
	/*################################################ LEVEL 6 ################################################*/
		
		
		//Mouse Events from the main menu
		if(levelCount==6) {
		//pause game from in=game play
		if((!(gameOver==true && health_status==0)) && isPaused==false && running==true && levelPassed==false) {
			if(pressing[ESCAPE]) {
			//isPaused == true, do something, paint the pause screen in paint
			pauseGame(); }
		//from pause Menu, go to main menu
		if(MouseX >= 260 && MouseX <= 260+570 && MouseY >= 260 && MouseY <= 260+80) { pauseMainMenu=true; } 
		if(MouseX <= 260 || MouseX >= 260+570 || MouseY <= 260 || MouseY >= 260+80) { pauseMainMenu=false; } 
		
		//From pause menu resume Game
		if(MouseX >= 280 && MouseX <= 280+550 && MouseY >= 370 && MouseY <= 370+80) { pauseResumeGame=true; } 
		if(MouseX <= 280 || MouseX >= 280+550 || MouseY <= 370 || MouseY >= 370+80) { pauseResumeGame=false; } 
		
        //From pause menu quit Game
		if(MouseX >= 300 && MouseX <= 300+490 && MouseY >= 505 && MouseY <= 505+80) { pauseQuitGame=true; } 
		if(MouseX <= 300 || MouseX >= 300+490 || MouseY <= 505 || MouseY >= 505+80) { pauseQuitGame=false; }	
		}
		
		
		//Game over screen options
		if(health_status==0) {
			gameOver();  
		//Play again from GameOver screen
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 355 && MouseY <= 355+70) {overPlayAgain=true; } 
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 355 || MouseY >= 355+70) {overPlayAgain=false; } 
	
		//From game over screen Quit game
		if(MouseX >= 360 && MouseX <= 360+510 && MouseY >= 535 && MouseY <= 535+70) { overQuitGame=true; } 
		if(MouseX <= 360 || MouseX >= 360+510 || MouseY <= 535 || MouseY >= 535+70) { overQuitGame=false; } 
		
        //From game over screen go to Main menu
		if(MouseX >= 360 && MouseX <= 360+500 && MouseY >= 445 && MouseY <= 445+70) { overMainMenu=true; } 	
		if(MouseX <= 360 || MouseX >= 360+500 || MouseY <= 445 || MouseY >= 445+70) { overMainMenu=false; }
		}
		
		
		//Game complete options 
		if((!(health_status == 0 && gameOver==true)) && levelCount==6 && KillCount==ZombieCount) {
			 GameComplete();
			 
		 //from game complete screen, play again
		 if(MouseX >= 375 && MouseX <= 375+490 && MouseY >= 480 && MouseY <= 480+70) { completePlayAgain=true; } 
		 if(MouseX <= 375 || MouseX >= 375+490 || MouseY <= 480 || MouseY >= 480+70) { completePlayAgain=false; } 
			
		//From game complete screen, go to main menu
		if(MouseX >= 365 && MouseX <= 365+510 && MouseY >= 375 && MouseY <= 375+70) { completeMainMenu=true; } 
		if(MouseX <= 365 || MouseX >= 365+510 || MouseY <= 375 || MouseY >= 375+70) { completeMainMenu=false; } 
		
        //From game complete screen, quit Game
		if(MouseX >= 375 && MouseX <= 375+490 && MouseY >= 590 && MouseY <= 590+70) { completeQuit=true; }
		if(MouseX <= 375 || MouseX >= 375+490 || MouseY <= 590 || MouseY >= 590+70) { completeQuit=false; } }
		}
		
	}
	
	
	public void mouseReleased(MouseEvent e) { }

	public void mouseExited(MouseEvent e) {	}

	public void mouseEntered(MouseEvent e) { }
	
	public void mouseMoved(MouseEvent e) { }

	public void mouseClicked(MouseEvent e) { }
	
}