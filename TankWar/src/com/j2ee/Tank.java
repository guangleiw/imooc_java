package com.j2ee;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * 坦克类 
 * @author wangguanglei1
 *
 */

public class Tank {

	private static final int XSPEED = 8;
	private static final int YSPEED = 8;



	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;

	private boolean good = true;
	private int life = 100;

	private Direction dir;
	private Direction barrelDir = Direction.D;//炮管方向
	private TankClient tc = null;
	private boolean live = true;
	int x, y, oldx, oldy;

	private BloodBar bb = new BloodBar();

	public static Random r = new Random();
	private int step = r.nextInt(12) + 3;

	private static Toolkit tk = Toolkit.getDefaultToolkit();

	private static Map<String, Image> hashImages = new HashMap<String, Image>();
	private static Image imgs[] = null;

	static {
		imgs = new Image[] { tk.getImage(Tank.class.getClassLoader().getResource("images/tankL.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankLU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankRU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankR.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankRD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankLD.gif")) };

		hashImages.put("L", imgs[0]);
		hashImages.put("LU", imgs[1]);
		hashImages.put("U", imgs[2]);
		hashImages.put("RU", imgs[3]);
		hashImages.put("R", imgs[4]);
		hashImages.put("RD", imgs[5]);
		hashImages.put("D", imgs[6]);
		hashImages.put("LD", imgs[7]);
	}
//	private static final int WIDTH = imgs[0].getWidth(null);
//	private static final int HEIGHT = imgs[0].getHeight(null);
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

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
		// Color c = g.getColor();

		if (!isLive()) {
			tc.tanks.remove(this);
			return;
		}

		if (isGood()) {
			bb.draw(g);
		}
		if (this.dir != Direction.STOP) {
			this.barrelDir = this.dir;
		}

		switch (barrelDir) {
		case L:
			g.drawImage(hashImages.get("L"), x, y, null);
			break;
		case LU:
			g.drawImage(hashImages.get("LU"), x, y, null);
			break;
		case U:
			g.drawImage(hashImages.get("U"), x, y, null);
			break;
		case UR:
			g.drawImage(hashImages.get("RU"), x, y, null);
			break;
		case R:
			g.drawImage(hashImages.get("R"), x, y, null);
			break;
		case RD:
//			System.out.println("hashImages:"+hashImages.get("RD").toString());
			g.drawImage(hashImages.get("RD"), x, y, null);
			break;
		case D:
			
			g.drawImage(hashImages.get("D"), x, y, null);
			break;
		case DL:
			g.drawImage(hashImages.get("DL"), x, y, null);
			break;
		case STOP:
			break;
		}

		/**
		 * 如果是敌军坦克,
		 * 开火间隔不能太短
		 * 运动轨迹不能完全随机
		 */
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
//		if (!isGood())
//			System.out.println(barrelDir);
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

	/**
	 * 键盘控制方向 key决定 dir,dir决定坐标
	 */
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
		case KeyEvent.VK_F2:
			if (!this.live) {
				this.setLive(true);
				this.setLife(100);
			}
			break;
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
	/**
	 * 向八方方向发射超级炮弹
	 */
	public void superFire() {
		Direction dirs[] = Direction.values();
		for (int i = 0; i < dirs.length; i++) {
			if (dirs[i] != Direction.STOP)
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
//		System.out.println("");
		return new Rectangle(x, y, imgs[0].getWidth(null), imgs[1].getHeight(null));
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

	/**
	 * 撞到墙 之后 要停留
	 */
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
