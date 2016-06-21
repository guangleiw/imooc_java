import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	static ServerSocket ss;
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean started = false;
		try {
			ss = new ServerSocket(8710);
			started = true;
			while (started) {
				boolean bConnected = false;
				Socket s = ss.accept();
				bConnected  = true;
				DataInputStream dis = new DataInputStream(s.getInputStream());
				while(bConnected){
					String str  = dis.readUTF();
					System.out.println(str);
				}
				dis.close();
//				System.out.println(dis.readUTF());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A client is connected!");
	}

}
