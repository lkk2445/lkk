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

		// ���۹�ư ������ ���
		// �޼��� �Է¾��� ���۹�ư�� ������ ���
		if (chattingGui.getTxtRoomChatWrite().getText().equals("")) {
			return;
		}
		chattingGui.getClientSender().sendMsg();
		chattingGui.getTxtRoomChatWrite().setText("");

	}

}