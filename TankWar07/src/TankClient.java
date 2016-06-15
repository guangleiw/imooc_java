import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankClient extends Frame {

	public static final int GAMEWIDTH = 800;
	public static final int GAMEHEIGH = 600;

	public static final int SPEED = 5;

	int x = 50, y = 50;
	Image offScreenImage = null;

	private Tank myTank = new Tank(x, y,this);
	public Missile misile = null;

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if (null == offScreenImage) {
			offScreenImage = this.createImage(GAMEWIDTH, GAMEHEIGH);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GRAY);
		gOffScreen.fillRect(0, 0, GAMEWIDTH, GAMEHEIGH);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public void paint(Graphics g) {
		myTank.draw(g);
		if (misile != null)
			misile.draw(g);
	}

	public void lunchFrame() {
		this.setLocation(400, 300);
		this.setSize(GAMEWIDTH, GAMEHEIGH);
		this.setTitle("TankWar");

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setResizable(false);
		this.setBackground(Color.GRAY);

		this.addKeyListener(new KeyMonitor());

		this.setVisible(true);

		new Thread(new PaintThread()).start();
	}

	private class PaintThread implements Runnable {
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private class KeyMonitor extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			myTank.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankClient tc = new TankClient();
		tc.lunchFrame();
	}

}
