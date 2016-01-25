import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class ChattingGui {

	private JFrame frame;
	private JButton btnRoomChatSend;
	private JPanel contentPane;
	private JTextArea txtRoomChat;
	private TextField txtRoomChatWrite;
	private ButtonEvent buttonEvent;
	
	private Controller controller;

	private Socket socket;
	public Socket getSocket() {
		return socket;
	}

	public ClientSender getClientSender() {
		return clientSender;
	}

	boolean isFirst = true;
	public StartGui getStartGui() {
		return startGui;
	}

	private DefaultListModel listModel;

	private ClientSender clientSender;
	private StartGui startGui;
	private String id;


	public boolean isFirst() {
		return isFirst;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public ChattingGui(Socket socket) {
		this.socket = socket;
		clientSender = new ClientSender(this);

		startGui = new StartGui(clientSender, this);

		frame = new JFrame("√§∆√√¢");
		frame.setBounds(100, 100, 530, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 43, 336, 383);
		contentPane.add(panel);
		panel.setLayout(null);

		txtRoomChat = new JTextArea();
		txtRoomChat.setEditable(false);
		txtRoomChat.setBounds(0, 0, 336, 334);
		panel.add(txtRoomChat);

		txtRoomChatWrite = new TextField();
		txtRoomChatWrite.setBounds(10, 340, 241, 33);
		panel.add(txtRoomChatWrite);

		btnRoomChatSend = new JButton("send");
		btnRoomChatSend.setBounds(259, 344, 65, 29);

		panel.add(btnRoomChatSend);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel1.setBounds(348, 0, 166, 426);
		contentPane.add(panel1);
		panel1.setLayout(null);

		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.setBounds(12, 47, 142, 369);
		panel1.add(list);

		controller = new Controller(this);
		btnRoomChatSend.addActionListener(controller);

		// frame.setVisible(true);

	}


	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getBtnRoomChatSend() {
		return btnRoomChatSend;
	}

	public JTextArea getTxtRoomChat() {
		return txtRoomChat;
	}

	public TextField getTxtRoomChatWrite() {
		return txtRoomChatWrite;
	}


}
