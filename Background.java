//import java.awt.*;
//
//public abstract class Background extends GameBase
//{
//	Image [] tile; = new Image[3];
//	
//	int tilecount;
//	
//	  
//	  Image background1;
//	  
//	  Image background2; 
//	  Image background3; 
//	  Image background4;
//	  Image background5; 
//	  Image background6; 
//	  Image[] background = {background1};
//	
//	
//	public Background(int x, int y, int w, int h, String tilefile)
//	{
//	
//		
//		//for(int i = 0; i < tile; i++)
//		
//			//tile = Toolkit.getDefaultToolkit().getImage(tilefile + ".png");		
//			
//			int currentLevel = 4;
//		    switch (currentLevel) {
//		    	//if level 1 switch background
//		      case 1:
//		        System.out.println("Monday");
//		        break;
//		      case 2:
//		    	//if level 2 switch background 2
//		        System.out.println("Tuesday");
//		        break;
//		      case 3:
//		    	//if level 3 switch background 3
//		        System.out.println("Wednesday");
//		        break;
//		      case 4:
//		    	//if level 4 switch background 4
//		        System.out.println("Thursday");
//		       break;
//		      case 5:
//		    	//if level 5 switch background 5
//		        System.out.println("Friday");
//		        break;
//		      case 6:
//		    	//if last level 6 switch background 6
//		        System.out.println("Saturday");
//		        break;
//		    }
//		  }
//	
//	public void draw(Graphics g)
//	{
//		g.drawImage(tile, x, y, w, h, null);
//
//	   //for(int i = 1; i < tilecount - 1; i++)
//	   	
//	   	g.drawImage(tile, x , y, w, h, null);
//	   
//		g.drawImage(tile, x , y, w, h, null);	   
//	}
//
//}