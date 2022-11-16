
public class BadSoldier extends Soldier
{
	public BadSoldier(int x, int y, int w, int h)
	{
		super(x, y, w, h);
	}
	
	
	
	public void chase(Soldier soldier)
	{
		if (x > soldier.x - 200)   moveLeft(2);
		else
		if (x < soldier.x + 200)   moveRight(2);
		else                       setVelocity(0, 0);
	}
	
	

}