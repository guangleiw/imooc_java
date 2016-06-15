import java.awt.Color;
import java.awt.Graphics;

public class Missile {
	private int x,y;
	private static final int XSPEED = 10;
	private static final int YSPEED = 10;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private boolean live = true;
	
	Tank.Direction dir;
	private TankClient tc = null;

	
	public boolean isLive() {
		return live;
	}

	public Missile(int x, int y, Tank.Direction dir,TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc = tc;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
		
		if(x<0 || y<0 || x>TankClient.GAMEWIDTH||y>TankClient.GAMEHEIGH){
//			System.out.println("x:"+x+"y:"+y);
			live = false;
			this.tc.missiles.remove(this);
			
		}
	}
	
	public void move(){
		switch (dir) {
		case L:
			x -= XSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case U:
			y -= XSPEED;
			break;
		case UR:
			x += XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RD:
			x += XSPEED;
			y += YSPEED;
			break;
		case D:
			y += XSPEED;
			break;
		case DL:
			x -= XSPEED;
			y += YSPEED;
			break;
		case STOP:
			break;
		}
	}
	
}
