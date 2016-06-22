import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatClient extends Frame {

	Socket s;

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	DataOutputStream dos = null;
	DataInputStream dis = null;
	private boolean bCon = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().lunchFrame();
	}

	public void lunchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		add(tfTxt, BorderLayout.SOUTH);
		add(taContent, BorderLayout.NORTH);
		pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				disconnect();
				System.exit(0);
			}
		});
		tfTxt.addActionListener(new tfListener());
		this.setVisible(true);

		connect();
		new Thread(new RecvThread()).start();
	}

	private void connect() {
		try {
			s = new Socket("127.0.0.1", 8710);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			System.out.println("connected!");
			bCon = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			bCon = false;
			dos.close();
			dis.close();
			s.close();
			System.out.println("close");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private class tfListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText();
//			taContent.setText(str);
			tfTxt.setText("");
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private class RecvThread implements Runnable {
		public void run() {
			try {
				while (bCon) {
					String str;
					str = dis.readUTF();
					taContent.setText(taContent.getText()+ " "+str);
					System.out.println(str);
				}
			}catch (SocketException e){
//				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				bCon = false;
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
