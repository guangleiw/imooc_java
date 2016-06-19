import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Missile {
	private int x, y;
	private static final int XSPEED = 12;
	private static final int YSPEED = 12;

	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private boolean live = true;

	private Direction dir;
	private TankClient tc = null;

	private boolean good;

	public Missile(int x, int y, boolean good, Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc = tc;
		this.good = good;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		if(good){
			g.setColor(Color.RED);
		}else {
			g.setColor(Color.BLACK);
		}
//		g.setColor(Color.black);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();

		if (x < 0 || y < 0 || x > TankClient.GAMEWIDTH || y > TankClient.GAMEHEIGH) {
			live = false;
		}
		hitWall(tc.w1);
		hitWall(tc.w2);
		if (!live)
			this.tc.missiles.remove(this);
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

	public boolean hitTank(Tank t) {
		if (this.live && t.isLive() && getRect().intersects(t.getRect()) && t.isGood() != this.good) {

			if (t.isGood()) {
				t.setLife(t.getLife() - 20);
				if (t.getLife() <= 0) {
					t.setLive(false);
				}
			} else {
				t.setLive(false);
			}

			Explode e = new Explode(x, y, tc);
			tc.explodes.add(e);
			this.live = false;

			return true;
		}
		return false;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean hitTanks(List<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			if (hitTank(tanks.get(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean hitWall(Wall w) {
		if (live && getRect().intersects(w.getRect())) {
			live = false;
			return true;
		}
		return false;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
