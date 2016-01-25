import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEvent {

	private ChattingGui chattingGui;
	private Controller controller;

	public ButtonEvent(Controller controller) {
		this.controller = controller;
		this.chattingGui = controller.getChattingGui();

	}

	public void StartButton() {
		chattingGui.getClientSender().sendMsg();
		chattingGui.isFirst = false;
		// chattingGui.listModel.addElement(field.getText().toString());
		chattingGui.getFrame().setVisible(true);
		chattingGui.getStartGui().getFrame().dispose();

	}

	public void EnterButton() {

		// 전송버튼 눌렀을 경우
		// 메세지 입력없이 전송버튼만 눌렀을 경우
		if (chattingGui.getTxtRoomChatWrite().getText().equals("")) {
			return;
		}
		chattingGui.getClientSender().sendMsg();
		chattingGui.getTxtRoomChatWrite().setText("");

	}

}