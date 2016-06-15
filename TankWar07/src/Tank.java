import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	
	private static final int SPEED = 5;
	
	int x, y;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			y -= SPEED;
			break;
		case KeyEvent.VK_DOWN:
			y += SPEED;
			break;
		case KeyEvent.VK_LEFT:
			x -= SPEED;
			break;
		case KeyEvent.VK_RIGHT:
			x += SPEED;
			break;
		default:
			break;
		}
	}

}
