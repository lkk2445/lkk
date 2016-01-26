import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RoomList extends MouseAdapter {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollpane;
	private JPanel panel;
	private Vector<String> userColumn = new Vector<String>();
	private DefaultTableModel model;
	private JButton btn = new JButton("�游���");
	private Controller controller;
	private MainGui mainGui;
	
	public RoomList(MainGui mainGui){
		
		this.mainGui = mainGui;
		
		frame = new JFrame("ä�ù� ���");
		frame.setSize(530, 464);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userColumn.addElement("����");
		userColumn.addElement("������");
		
		
		model = new DefaultTableModel(userColumn,0);
		table = new JTable(model);
		
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		scrollpane = new JScrollPane(table);
		panel.add(scrollpane,"Center");
		panel.add(btn, "South");
		
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(JLabel.CENTER);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(230);
		
		table.getColumnModel().getColumn(0).setCellRenderer(render);
//		table.getColumnModel().getColumn(1).setCellRenderer(render);
//		table.getColumn("������").setWidth(8);
		
		frame.add(panel);
		
		
		controller = new Controller(mainGui);
		btn.addActionListener(controller);
		
		
		table.addMouseListener(controller);
		
		
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//	        public void valueChanged(ListSelectionEvent event) {
//	            // do some actions here, for example
//	            // print first column value from selected row
//	        	ChattingGui chattingGui = new ChattingGui();
//	            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
//	        }
//	    });
		
		
		
//		frame.setVisible(true);
		
		
		
	}
	
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		super.mousePressed(e);
//		ChattingGui chattingGui = new ChattingGui();
//	}



	public DefaultTableModel getModel() {
		return model;
	}


	public JButton getBtn() {
		return btn;
	}

	public JFrame getFrame() {
		return frame;
	}
}
