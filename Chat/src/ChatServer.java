import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	ServerSocket ss;
	// static Socket s = null;
	DataInputStream dis = null;
	boolean started = false;

	List<Client> clients = new ArrayList<Client>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatServer().start();
	}

	public void start() {
		try {
			ss = new ServerSocket(8710);
		} catch (BindException b) {
			System.out.println("port is used");
			System.out.println("Please close the server application before start!");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			started = true;
			while (started) {
				Socket s = ss.accept();
				Client c = new Client(s);
				new Thread(c).start();
				clients.add(c);
				// dis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class Client implements Runnable {
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		boolean bConnected = false;

		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void send(String str) {
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				clients.remove(this);
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// Client c = null;
			try {
				while (bConnected) {
					String str = dis.readUTF();
					System.out.println(str);
					for (int i = 0; i < clients.size(); i++) {
						Client c = clients.get(i);
						c.send(str);
					}
				}
			} catch (EOFException e) {
				System.out.println("Closed");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != dis)
						dis.close();
					if (null != dos)
						dos.close();
					if (null != s)
						s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			clients.remove(this);
		}
	}

}
