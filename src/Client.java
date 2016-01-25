import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket = null;
	private ChattingGui chattingGui;
	
	public Socket getSocket() {
		return socket;
	}

	public Client(){
		try {
			socket = new Socket("165.194.17.187", 7777);
			System.out.println("서버와 연결되었습니다. 대화명을 입력하세요 : ");
			chattingGui = new ChattingGui(socket);
			new ClientReceiver(socket, chattingGui).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
