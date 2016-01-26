import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener {

	private MainGui mainGui;
	private ButtonEvent buttonEvent;
	private ChattingGui chattingGui;
	private ClickEvent mouseEvent;
	public Controller(MainGui mainGui) {
		// TODO Auto-generated constructor stub
		this.mainGui = mainGui;
		buttonEvent = new ButtonEvent(this);
		mouseEvent = new ClickEvent(this);
	}
	
	public Controller(ChattingGui chattingGui){
		this.chattingGui = chattingGui;
		buttonEvent = new ButtonEvent(this);
		mouseEvent = new ClickEvent(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mainGui.getStartGui().getBtn()){
			buttonEvent.StartButton();
			
		}
		else if(e.getSource() == mainGui.getRoomList().getBtn()){
			buttonEvent.NewRoomButton();
		}
		else if (e.getSource() == mainGui.getCreateRoom().getBtn()){
			buttonEvent.OpenRoomButton();
			
		}
		else if(e.getSource() == chattingGui.getBtnRoomChatSend()){
			buttonEvent.EnterButton();
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getSource();
	}
	
	public MainGui getmainGui() {
		return mainGui;
	}

	public ChattingGui getChattingGui() {
		return chattingGui;
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
