import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static Client uniqueInstance = new Client();
	
	private Socket socket = null;
	private MainGui mainGui;
	private RoomList roomList;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Socket getSocket() {
		return socket;
	}
	
	public static Client getInstance(){
		return uniqueInstance;
	}

	private Client(){
		try {
			socket = new Socket("165.194.17.187", 7777);
			System.out.println("서버와 연결되었습니다. 대화명을 입력하세요 : ");
//			roomList = new RoomList();
			mainGui = new MainGui(socket);
			new ClientReceiver(socket, mainGui).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
