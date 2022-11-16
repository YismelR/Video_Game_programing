import java.awt.*;

public class ImageLayer
{
	Image image;
	
	int depth;
	
	
	static double zoom = 1;
	
	int w = 400;
	int h = 300;
	static int x;
	int y;
	
	public ImageLayer(String filename, int depth)
	{
		this.image = Toolkit.getDefaultToolkit().getImage(filename);
		
		this.depth = depth;
	}
	
	public void PlayerFocus(double f) {
		zoom = f;
	}
	public static void zoomIn(double dzoom)
	{
		zoom *= 1 + dzoom;
	}
		
	public static void zoomOut(double dzoom)
	{
		zoom /= 1 + dzoom;
	}
	
		
	
	public void draw(Graphics g)
	{
		//Don't use. This is just experimental
		//g.drawImage(image, (int)((0 + i*240 - Camera.x / depth) * zoom), 0-Camera.y, (int)(w*zoom), (int)(h*zoom),  null);
		
		
		for(int i = 0; i < 1; i++)
		
			g.drawImage(image, (int)((0 + i*720 - Camera.x / depth) * zoom), 0-Camera.y, (int)(w*zoom), (int)(h*zoom),  null);

			
			//g.drawImage(image, 0 + i*720 - Camera.x / depth, 0-Camera.y, null);
	}

   }
