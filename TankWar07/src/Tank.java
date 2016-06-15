import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {

	private static final int XSPEED = 5;
	private static final int YSPEED = 5;
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;

	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;

	private Missile misile = null;
	private Direction dir;
	private TankClient tc = null;
	
	int x, y;

	enum Direction {
		L, LU, U, UR, R, RD, D, DL, STOP
	};

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Tank(int x,int y,TankClient tc){
		this(x,y);
		this.tc = tc;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		locateDirection();
		move();
	}

	public void move() {
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

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_CONTROL:
			tc.misile = fire();
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		default:
			break;
		}
	}

	public Missile fire() {
		int x = this.x+Tank.WIDTH/2- Missile.WIDTH/2;
		int y = this.y+Tank.HEIGHT/2 - Missile.HEIGHT/2;
		return new Missile(x, y, dir);
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		default:
			break;
		}
	}

	private void locateDirection() {
		if (bL && !bU && !bR && !bD)
			dir = Direction.L;
		else if (bL && bU && !bR && !bD)
			dir = Direction.LU;
		else if (!bL && bU && !bR && !bD)
			dir = Direction.U;
		else if (!bL && bU && bR && !bD)
			dir = Direction.UR;
		else if (!bL && !bU && bR && !bD)
			dir = Direction.R;
		else if (!bL && !bU && bR && bD)
			dir = Direction.RD;
		else if (!bL && !bU && !bR && bD)
			dir = Direction.D;
		else if (bL && !bU && !bR && bD)
			dir = Direction.DL;
		else if (!bL && !bU && !bR && !bD)
			dir = Direction.STOP;
	}

}
