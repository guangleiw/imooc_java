import java.awt.Frame;

public class TankClient extends Frame{
	
	
	public void lunchFrame(){
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankClient tc = new TankClient();
		tc.lunchFrame();
	}

}
