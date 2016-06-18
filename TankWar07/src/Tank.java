import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Tank {

	private static final int XSPEED = 8;
	private static final int YSPEED = 8;

	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;

	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;

	private boolean good = true;
	private int life = 100;

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	private Direction dir;
	private Direction barrelDir = Direction.D;
	private TankClient tc = null;
	private boolean live = true;
	int x, y, oldx, oldy;

	enum Direction {
		L, LU, U, UR, R, RD, D, DL, STOP
	};

	private BloodBar bb = new BloodBar();

	public static Random r = new Random();
	private int step = r.nextInt(12) + 3;

	public Tank(int x, int y, boolean good) {
		this.x = x;
		this.y = y;
		this.setGood(good);
	}

	public Tank(int x, int y, TankClient tc, boolean good, Direction dir) {
		this(x, y, good);
		this.tc = tc;
		this.dir = dir;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();

		if (!isLive()) {
			tc.tanks.remove(this);
			return;
		}

		if (isGood()) {
			g.setColor(Color.WHITE);
			bb.draw(g);
		} else {
			g.setColor(Color.BLUE);
		}
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		// locateDirection();

		switch (barrelDir) {
		case L:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y + HEIGHT / 2);
			break;
		case LU:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y);
			break;
		case U:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y);
			break;
		case UR:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y);
			break;
		case R:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y + HEIGHT / 2);
			break;
		case RD:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y + HEIGHT);
			break;
		case D:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y + HEIGHT);
			break;
		case DL:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y + HEIGHT / 2);
			break;
		case STOP:
			break;
		}

		if (this.dir != Direction.STOP) {
			this.barrelDir = this.dir;
		}

		if (!isGood()) {
			if (r.nextInt(30) == 0) {
				this.fire();
			}

			Direction[] dirs = Direction.values();

			if (step == 0) {
				int rn = r.nextInt(dirs.length);
				this.dir = dirs[rn];
				step = r.nextInt(12) + 3;
			}
			step--;
		}
		oldx = x;
		oldy = y;
		move();

		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		if (x + Tank.WIDTH > TankClient.GAMEWIDTH)
			x = TankClient.GAMEWIDTH - Tank.WIDTH;
		if (y + Tank.HEIGHT > TankClient.GAMEHEIGH)
			y = TankClient.GAMEHEIGH - Tank.HEIGHT;

	}

	public void move() {
		// System.out.println("move");
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

	public boolean eat(Blood b) {
		if (live && b.isLive() && getRect().intersects(b.getRect())) {
			this.setLife(100);
			b.setLive(false);
			return true;
		}
		return false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_CONTROL:
			fire();
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
		case KeyEvent.VK_A:
			superFire();
			break;
		}
		locateDirection();
	}

	public void fire() {
		if (!live)
			return;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;

		tc.missiles.add(new Missile(x, y, this.good, this.barrelDir, this.tc));
	}

	public void fire(Direction dir) {
		if (!live)
			return;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;

		tc.missiles.add(new Missile(x, y, this.good, dir, this.tc));
	}

	public void superFire() {
		Direction dirs[] = Direction.values();
		for (int i = 0; i < dirs.length; i++) {
			fire(dirs[i]);
		}
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
		else if (!bL && !bU && !bR && bD) {
			// System.out.println(y);
			dir = Direction.D;
		} else if (bL && !bU && !bR && bD)
			dir = Direction.DL;
		else if (!bL && !bU && !bR && !bD)
			dir = Direction.STOP;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

	public void collidesWithWalls(Wall w) {
		if (this.getRect().intersects(w.getRect())) {
			stay();
		}
	}

	public void collidesWithTanks(java.util.List<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			Tank t = tanks.get(i);
			if (t != this && this.getRect().intersects(t.getRect())) {
				stay();
			}
		}
	}

	private void stay() {
		x = oldx;
		y = oldy;
	}

	private class BloodBar {
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(x, y - 10, WIDTH, 10);
			int w = WIDTH * life / 100;
			g.fillRect(x, y - 10, w, 10);
			g.setColor(c);
		}
	}

}
