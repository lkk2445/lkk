import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class MultiChatClient {

	private Client client;

	public MultiChatClient() {
		client = new Client();
	}

}

class ClientReceiver extends Thread {
	Socket socket;
	DataInputStream input;
	ObjectInputStream inputuser;
	ChattingGui chattingGui;
	
	public ClientReceiver(Socket socket, ChattingGui chattingGui) {
		this.socket = socket;
		this.chattingGui = chattingGui;
		try {
			input = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {

		}

	}

	@Override
	public void run() {

		while (true) {
			try {
				String str = input.readUTF();
				if (str.startsWith("[")) {
					chattingGui.getListModel().clear();
					String[] arr = null;

					str = str.replaceAll("\\[", "");
					str = str.replaceAll("\\]", "");
					arr = str.split(",");

					for (int i = 0; i < arr.length; i++)
						chattingGui.getListModel().addElement(arr[i].trim());

				} else
					chattingGui.getTxtRoomChat().append(str);

			} catch (IOException e) {

			}
		}

	}
}

class ClientSender {
	Socket socket;
	DataOutputStream output= null;
	ChattingGui chattingGui;

	public ClientSender(ChattingGui chattingGui) {
		this.socket = chattingGui.getSocket();
		this.chattingGui = chattingGui;

	}

	public void sendMsg() {

		String msg = "";
		try {
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (chattingGui.isFirst == true) {

			try {
				output.writeUTF(chattingGui.getStartGui().field.getText().toString());
				System.out.println("대화방에 입장하였습니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {

				msg = chattingGui.getTxtRoomChatWrite().getText().toString();
				if (msg.equals("exit")) {
					chattingGui.getListModel().removeElement(chattingGui.getStartGui().field.getText().toString());
					System.exit(0);
				} else
					output.writeUTF("(" + chattingGui.getStartGui().field.getText().toString() + ")" + msg + "\n");
			} catch (IOException e) {

			}

		}

	}
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
// import java.net.InetAddress;
// import java.net.Socket;
//// 키보드로 전송문자열 입력받아 서버로 전송하는 스레드
// class WriteThread{
// Socket socket;
// ClientFrame cf;
// String str;
// String id;
// public WriteThread(ClientFrame cf) {
// this.cf = cf;
// this.socket= cf.socket;
// }
// public void sendMsg() {
// //키보드로부터 읽어오기 위한 스트림객체 생성
// BufferedReader br=
// new BufferedReader(new InputStreamReader(System.in));
// PrintWriter pw=null;
// try{
// //서버로 문자열 전송하기 위한 스트림객체 생성
// pw=new PrintWriter(socket.getOutputStream(),true);
// //첫번째 데이터는 id 이다. 상대방에게 id와 함께 내 IP를 전송한다.
// if(cf.isFirst==true){
// InetAddress iaddr=socket.getLocalAddress();
// String ip = iaddr.getHostAddress();
// getId();
// System.out.println("ip:"+ip+"id:"+id);
// str = "["+id+"] 님 로그인 ("+ip+")";
// }else{
// str= "["+id+"] "+cf.txtF.getText();
// }
// //입력받은 문자열 서버로 보내기
// pw.println(str);
//
// }catch(IOException ie){
// System.out.println(ie.getMessage());
// }finally{
// try{
// if(br!=null) br.close();
// //if(pw!=null) pw.close();
// //if(socket!=null) socket.close();
// }catch(IOException ie){
// System.out.println(ie.getMessage());
// }
// }
// }
// public void getId(){
// id = Id.getId();
// }
// }
//// 서버가 보내온 문자열을 전송받는 스레드
// class ReadThread extends Thread{
// Socket socket;
// ClientFrame cf;
// public ReadThread(Socket socket, ClientFrame cf) {
// this.cf = cf;
// this.socket=socket;
// }
// public void run() {
// BufferedReader br=null;
// try{
// //서버로부터 전송된 문자열 읽어오기 위한 스트림객체 생성
// br=new BufferedReader(
// new InputStreamReader(socket.getInputStream()));
// while(true){
// //소켓으로부터 문자열 읽어옴
// String str=br.readLine();
// if(str==null){
// System.out.println("접속이 끊겼음");
// break;
// }
// //전송받은 문자열 화면에 출력
// //System.out.println("[server] " + str);
// cf.txtA.append(str+"\n");
// }
// }catch(IOException ie){
// System.out.println(ie.getMessage());
// }finally{
// try{
// if(br!=null) br.close();
// if(socket!=null) socket.close();
// }catch(IOException ie){}
// }
// }
// }
// public class MultiChatClient {
// public static void main(String[] args) {
// Socket socket=null;
// ClientFrame cf;
// try{
// socket=new Socket("165.194.17.187",3000);
// System.out.println("연결성공!");
// cf = new ClientFrame(socket);
// new ReadThread(socket, cf).start();
// }catch(IOException ie){
// System.out.println(ie.getMessage());
// }
// }
// }
