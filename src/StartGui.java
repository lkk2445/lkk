import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartGui {

	private JFrame frame;
	private JButton btn;

	static JTextField field;
	ChattingGui chattingGui;
	ClientSender clientSender;
	private ButtonEvent buttonEvent;
	private Controller controller;

	public StartGui(ClientSender clientSender, ChattingGui chattingGui) {
		this.clientSender = clientSender;
		this.chattingGui = chattingGui;

		frame = new JFrame("√§∆√√¢");
		frame.setLocation(300, 300);
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		// panel.setLayout(null);

		field = new JTextField();
		field.setBounds(20, 20, 245, 30);

		btn = new JButton("START");
		btn.setBounds(110, 80, 80, 30);

		frame.add(field);
		frame.add(btn);

	
		controller = new Controller(chattingGui);
		btn.addActionListener(controller);

		frame.setVisible(true);
	}


	public JFrame getFrame() {
		return frame;
	}

	public JButton getBtn() {
		return btn;
	}

	static public String getId() {
		return field.getText();
	}

	public JTextField getField() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}

	public ChattingGui getChattingGui() {
		return chattingGui;
	}

	public void setChattingGui(ChattingGui chattingGui) {
		this.chattingGui = chattingGui;
	}

}