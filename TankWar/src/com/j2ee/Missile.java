package com.j2ee;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 炮弹类 用来生成炮弹
 * @author wangguanglei1
 *
 */
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
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	private static Map<String, Image> hashImages = new HashMap<String, Image>();
	private static Image imgs[] = null;
	/*
	 * 读取每个方向炮弹图片 
	 */
	static {
		imgs = new Image[] { tk.getImage(Missile.class.getClassLoader().getResource("images/missileL.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileLU.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileU.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileRU.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileR.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileRD.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileD.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileLD.gif")) };

		hashImages.put("L", imgs[0]);
		hashImages.put("LU", imgs[1]);
		hashImages.put("U", imgs[2]);
		hashImages.put("RU", imgs[3]);
		hashImages.put("R", imgs[4]);
		hashImages.put("RD", imgs[5]);
		hashImages.put("D", imgs[6]);
		hashImages.put("LD", imgs[7]);
	}

	public Missile(int x, int y, boolean good, Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc = tc;
		this.good = good;
	}

	public void draw(Graphics g) {
//		Color c = g.getColor();
//		if(good){
//			g.setColor(Color.RED);
//		}else {
//			g.setColor(Color.BLACK);
//		}
		switch (dir){
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
			g.drawImage(hashImages.get("RD"), x, y, null);
			break;
		case D:			
			g.drawImage(hashImages.get("D"), x, y, null);
			break;
		case DL:
			g.drawImage(hashImages.get("LD"), x, y, null);
			break;
		case STOP:
			break;
		}
		
		move();
		//出界判断
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

	/**
	 * 撞击坦克
	 * @param t 坦克
	 * @return 撞上 返回true
	 */
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

	/**
	 * 撞墙
	 * @param w 墙
	 * @return 撞上返回 true
	 */
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
