import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private ChattingGui chattingGui;
	private ButtonEvent buttonEvent;
	
	public Controller(ChattingGui chattingGui) {
		// TODO Auto-generated constructor stub
		this.chattingGui = chattingGui;
		buttonEvent = new ButtonEvent(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == chattingGui.getStartGui().getBtn()){
			buttonEvent.StartButton();
			
		}
		else if(e.getSource() == chattingGui.getBtnRoomChatSend()){
			buttonEvent.EnterButton();
			
		}
		
	}

	public ChattingGui getChattingGui() {
		return chattingGui;
	}

}
