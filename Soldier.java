import java.awt.*;

public class Soldier extends Rect
{
	int vx = 0;
	int vy = 0;
	
	int ax = 0;
	int ay = 0;
	Animation[] anim;
	
	//Screen Dimensions specifications are below
	Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
	// width will store the width of the screen in the 
	//setSize function in the init() method
	int width = (int)size.getWidth();
	// height will store the height of the screen in the 
	//setSize function in the init() method
	int height = (int)size.getHeight();
	
	static final int UP = 0;
	static final int DN = 1;
	static final int LT = 2;
	static final int RT = 3;
	
	int pose = RT;
	
   boolean moving = false;
	
	
	public Soldier(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		anim = new Animation[4];
		
		String[] pose = {"up", "dn", "lt", "rt"};
		
		for(int i = 0; i < anim.length; i++)
		{
			anim[i] = new Animation("g_" + pose[i] +"_", 5, ".gif", 10);
		}	
	}

	public void move()
	{
		this.vy = -vy;
	}
	
	public void jump(int vy)
	{
		this.vy = -vy;
	}
	
	public void setVelocity(int vx, int vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	
	public void setAcceleration(int ax, int ay)
	{
		this.ax = ax;
		this.ay = ay;
	}
	
	
	public void moveBasedOnPhysics()
	{
		x += vx;
		y += vy;
		
		vx += ax;
		vy += ay;
	}
	
	public void moveLeft(int dx)
	{
		vx = -dx;
		//x -= dx;
		
		pose = LT;
		
		moving = true;
	}
	
	public void moveRight(int dx)
	{
		vx = dx;
		//x += dx;
		
		pose = RT;
		
		moving = true;
	}

	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	public void moveUp(int dy)
	{
		y -= dy;
		
		pose = UP;
		
		moving = true;
	}
	
	public void moveDown(int dy)
	{
		y += dy;
		
		pose = DN;
		
		moving = true;
	}
	
	public boolean overlapLeftPanel() {
		return (x + vx < 0);	
	}
	
	public boolean overlapRightPanel() {
		return (x + vx > width-20);
	}
	public boolean overlapTopPanel() {
		return(y < 5);	
	}
	
	public boolean overlapBottomPanel() {
	    return (y > height-117);
	}
	
	public int stopatLeftPanel() {
		return (x = 0);	
	}
	
	public int stopatRightPanel() {
		return (x = width-20-1); 
	}
	public int stopatTopPanel() {
		return y = 5; 	
	}
	
	public int stopatBottomPanel() {
		setVelocity(0, 0);
		return (y = height-117);
	}	
	
	public void draw(Graphics g)
	{
		if(moving)		g.drawImage(anim[pose].currentImage(), x-Camera.x, y-Camera.y, null);
		
		else           g.drawImage(anim[pose].stillImage(), x-Camera.x, y-Camera.y, null);
		
		moving = false;
		//g.drawRect(x, y, w, h);
	}
}