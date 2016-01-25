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
				System.out.println("��ȭ�濡 �����Ͽ����ϴ�.");
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
//// Ű����� ���۹��ڿ� �Է¹޾� ������ �����ϴ� ������
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
// //Ű����κ��� �о���� ���� ��Ʈ����ü ����
// BufferedReader br=
// new BufferedReader(new InputStreamReader(System.in));
// PrintWriter pw=null;
// try{
// //������ ���ڿ� �����ϱ� ���� ��Ʈ����ü ����
// pw=new PrintWriter(socket.getOutputStream(),true);
// //ù��° �����ʹ� id �̴�. ���濡�� id�� �Բ� �� IP�� �����Ѵ�.
// if(cf.isFirst==true){
// InetAddress iaddr=socket.getLocalAddress();
// String ip = iaddr.getHostAddress();
// getId();
// System.out.println("ip:"+ip+"id:"+id);
// str = "["+id+"] �� �α��� ("+ip+")";
// }else{
// str= "["+id+"] "+cf.txtF.getText();
// }
// //�Է¹��� ���ڿ� ������ ������
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
//// ������ ������ ���ڿ��� ���۹޴� ������
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
// //�����κ��� ���۵� ���ڿ� �о���� ���� ��Ʈ����ü ����
// br=new BufferedReader(
// new InputStreamReader(socket.getInputStream()));
// while(true){
// //�������κ��� ���ڿ� �о��
// String str=br.readLine();
// if(str==null){
// System.out.println("������ ������");
// break;
// }
// //���۹��� ���ڿ� ȭ�鿡 ���
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
// System.out.println("���Ἲ��!");
// cf = new ClientFrame(socket);
// new ReadThread(socket, cf).start();
// }catch(IOException ie){
// System.out.println(ie.getMessage());
// }
// }
// }
