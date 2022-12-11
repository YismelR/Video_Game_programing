import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Obj_Coin extends SuperObj {
	public Obj_Coin() {
		name = "p2";
		
		try {
			image = new ImageIcon(new URL("file:///C:/Users/kyky0/Downloads/coin.gif")).getImage();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
