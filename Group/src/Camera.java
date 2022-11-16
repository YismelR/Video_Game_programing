import java.awt.*;

public class Camera
{
	static double WindowHeightcenter;
	static double WindowWidthcenter;
	
	static int x;
	static int y;
	static int z = 1;
	
	
	
	//Experimental code below, it doesn't work
	public static void WindowSize() { 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  screenSize.getHeight(); 
		  screenSize.getWidth();}
	  
	 
	
	public static void moveUp(int dy)
	{
		y -= dy;
	}
	
	public static void moveDown(int dy)
	{
		y += dy;
	}
	
	public static void moveLeft(int dx)
	{
		x -= dx;
	}
	
	public static void moveRight(int dx)
	{
		x += dx;
	}
	
	public static void moveIn(int dz)
	{
		z -= dz;
	}
	
	public static void moveOut(int dz)
	{
		z += dz;
	}
	
	

}