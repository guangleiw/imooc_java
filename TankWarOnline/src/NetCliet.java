import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetCliet {

	public void connect(String ip,int port){
		try {
			Socket s =new Socket(ip,port);
			System.out.println("connected to server!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
