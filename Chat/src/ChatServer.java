import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	static ServerSocket ss;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ss = new ServerSocket(8710);
			while (true) {
				Socket s = ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A client is connected!");
	}

}
