import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class SuperObj {
	public Image image;
	
	public String name;
	
	public boolean collision = false;
	
	public int worldx;
	
	public int worldy;
	
	public void draw(Graphics2D g2, Panel p) {
		int screenx = worldx - p.r.worldx + p.r.sx;
		int screeny = worldy - p.r.worldy + p.r.sy;
		if	(worldx + p.tSize > p.r.worldx - p.r.sx && 
			 worldx - p.tSize < p.r.worldx + p.r.sx && 
			 worldy + p.tSize > p.r.worldy - p.r.sy && 
			 worldy - p.tSize < p.r.worldy + p.r.sy) {
			g2.drawImage(image, screenx, screeny, null);
		}
	}
}
