import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.simple.JSONObject;

public class ButtonEvent{

	private MainGui mainGui;
	private Controller controller;
	private ChattingGui chattingGui;
//	private JSONObject json;

	public ButtonEvent(Controller controller) {
		this.controller = controller;
		this.mainGui = controller.getmainGui();
		this.chattingGui = controller.getChattingGui();
	}
	
	

	public void StartButton() {
		
		mainGui.setId(mainGui.getStartGui().getField().getText().toString());
		JSONObject json = new JSONObject();
		json.put("Code", "1111");//start 는 1
		json.put("id", mainGui.getId());
		mainGui.getClientSender().sendMsg(json.toJSONString());
		mainGui.isFirst = false;
		// mainGui.listModel.addElement(field.getText().toString());
		
		mainGui.getRoomList().getFrame().setVisible(true);
//		mainGui.getFrame().setVisible(true);
		mainGui.getStartGui().getFrame().dispose();

	}

	public void EnterButton() {

		// 전송버튼 눌렀을 경우
		// 메세지 입력없이 전송버튼만 눌렀을 경우
		if (chattingGui.getTxtRoomChatWrite().getText().equals("")) {
			return;
		}
		else{
			String msg = ('(' + mainGui.getStartGui().field.getText().toString() + ')' + mainGui.getTxtRoomChatWrite().getText().toString() + '\n');
			
			System.out.println(msg);
			JSONObject json = new JSONObject();
			json.put("Code", "2222"); //내용 보내는건 2222
			json.put("content", msg);
			
			mainGui.getClientSender().sendMsg(json.toJSONString());
			mainGui.getTxtRoomChatWrite().setText("");
		}
		

	}
	
	public void NewRoomButton(){
//		JSONObject json = new JSONObject();
//		
//		json.put("Code", "3333"); // 방제목은 3333
//		json.put("roomtitle", mainGui.getCreateRoom().getField().getText().toString());
		
//		mainGui.getClientSender().sendMsg(json.toJSONString());
		mainGui.getCreateRoom().getFrame().setVisible(true);
		
		}
	
	public void OpenRoomButton(){
		JSONObject json = new JSONObject();
		
		json.put("Code", "3333"); // 방제목은 3333
		json.put("id", mainGui.getStartGui().getField().getText().toString());
		json.put("roomtitle", mainGui.getCreateRoom().getField().getText().toString());
		
		mainGui.getClientSender().sendMsg(json.toJSONString());
		mainGui.getCreateRoom().getFrame().dispose();	
		
		
//		mainGui.getFrame().setVisible(true);
		
//		mainGui.getRoomList().getUserRow().addElement(mainGui.getStartGui().getField().getText().toString());
//		mainGui.getRoomList().getUserRow().addElement(mainGui.getCreateRoom().getField().getText().toString());
//		mainGui.getRoomList().getModel().addRow(mainGui.getRoomList().getUserRow());
		
				
	}
	
	

}