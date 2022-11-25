import java.awt.Graphics;
import java.util.Random;

/*we will replace this code with the zombies
*/

public class BadSoldier extends Soldier {
	public BadSoldier(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void chase(Soldier soldier)
	{
		if (x > soldier.x)   moveLeft(10);
		else
		if (x < soldier.x)   moveRight(10);
		else                       setVelocity(0, 0);
	}
	
}