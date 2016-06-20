package com.j2ee;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * 这个类的作用是为坦克加血
 * @author wangguanglei1
 *
 */
public class Blood {
	int x, y, w = 15, h = 15;
	TankClient tc;
	int step = 0;
	boolean live = true;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	//指明血块运动的轨迹, 由pos中各个点构成
	private int pos[][] = { { 350, 300 }, { 360, 300 },{ 375, 275 }, { 400, 200 }, { 360, 270},{ 365, 290}, { 340, 280 }};

	public Blood() {
		x = pos[0][0];
		y = pos[0][1];
	}

	public void draw(Graphics g) {
		
		if(!isLive()) return;
		
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, w, h);
		g.setColor(c);
	
		move();		
	}

	private void move() {
		step ++;
		if(step  == pos.length){
			step = 0;
		}
		x = pos[step][0];
		y = pos[step][1];
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, w, h);
	}
}
