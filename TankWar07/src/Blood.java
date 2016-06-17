import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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

	private int pos[][] = { { 350, 300 }, { 360, 300 },{ 375, 275 }, { 400, 200 }, { 360, 270},{ 365, 290}, { 340, 280 }};

	public Blood() {
		x = pos[0][0];
		y = pos[0][1];
	}

	public void draw(Graphics g) {
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
