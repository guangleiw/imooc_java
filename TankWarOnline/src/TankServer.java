import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TankServer {

	public static final int TCP_PORT = 8876;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(TCP_PORT);
			while(true){
				Socket s = ss.accept();
				System.out.println("A client connect! Addr:"+s.getInetAddress()+":"+s.getPort());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
