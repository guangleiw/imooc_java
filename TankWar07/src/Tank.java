import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {

	private static final int XSPEED = 5;
	private static final int YSPEED = 5;

	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;

	int x, y;

	enum Direction {
		L, LU, U, UR, R, RD, D, DL, STOP
	};

	private Direction dir;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		locateDirection();
		move();
	}
	
	public void move(){
		switch (dir) {
		case L:
			x-=XSPEED;
			break;
		case LU:
			x-=XSPEED;
			y-=YSPEED;
			break;
		case U:
			y-=XSPEED;
			break;
		case UR:
			x+=XSPEED;
			y-=YSPEED;
			break;
		case R:
			x+=XSPEED;
			break;
		case RD:
			x+=XSPEED;
			y+=YSPEED;
			break;
		case D:
			y+=XSPEED;
			break;
		case DL:
			x-=XSPEED;
			y+=YSPEED;
			break;
		case STOP:
			break;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
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
