import org.json.simple.JSONObject;

public class Handler {

	private MainGui mainGui;
	private JSONObject json;

	public Handler(MainGui mainGui) {
		// TODO Auto-generated constructor stub
		this.mainGui = mainGui;
	}

	public void SetId(JSONObject json) {
		this.json = json;
		// mainGui.getListModel().clear();
		 mainGui.getRoomList().getModel().setRowCount(0);
		String arr[] = null;
		String str;
		System.out.println(json.get("userList").toString());

		// str = json.get("userList").toString().replaceAll("\\[", "");
		// str = str.replaceAll("\\]", "");
		// arr = str.split(",");
		// for (int i = 0; i < arr.length; i++)
		// mainGui.getListModel().addElement(arr[i].trim());

		String array[] = null;
		String string;
		
		string = json.get("roomInfo").toString().replaceAll("\\[", "");
		string = string.replaceAll("\\]", "");
		
		if(string.length()>0){
			array = string.split(",");
			
			for(int i=0;i<array.length;i = i+2){
				String arr1 [] = {array[i].trim(),array[i+1].trim()};
				
				mainGui.getRoomList().getModel().addRow(arr1);
				
				
//				mainGui.getRoomList().getUserRow().addElement(array[i].trim());
//				mainGui.getRoomList().getUserRow().addElement(array[i+1].trim());
//
//				mainGui.getRoomList().getModel().addRow(mainGui.getRoomList().getUserRow());
			
			}
			
			
			
		}
		
		
		
		
//		String arr2[] = null;
//		String str2;
//		System.out.println(json.get("roomList").toString());
//
//		str2 = json.get("roomList").toString().replaceAll("\\[", "");
//		str2 = str2.replaceAll("\\]", "");
//
//		System.out.println(str2.length());
//
//		System.out.println(str2);
//
//		if (str2.length() > 0) {
//			arr2 = str2.split(",");
//
//			for (int i = 0; i < arr2.length; i++) {
//
//				mainGui.getRoomList().getUserRow().addElement(arr2[i].trim());
//				mainGui.getRoomList().getUserRow().addElement(arr2[i].trim());
//
//				mainGui.getRoomList().getModel().addRow(mainGui.getRoomList().getUserRow());
//
//			}
//		}
		// mainGui.getTxtRoomChat().append(json.get("check").toString());

	}

	public void SetContext(JSONObject json) {
		this.json = json;
		mainGui.getTxtRoomChat().append(json.get("content").toString());
	}

	public void SetRoomTitle(JSONObject json) {
		this.json = json;


				
		
		String arr[] = {json.get("id").toString(),json.get("roomtitle").toString()};
		
		mainGui.getRoomList().getModel().addRow(arr);

		
		
		ChattingGui chattingGui = new ChattingGui();
		chattingGui.getListModel().addElement(json.get("id").toString());


	}

	public void Exit(JSONObject json) {
		this.json = json;
		mainGui.getListModel().clear();
		mainGui.getTxtRoomChat().append(json.get("content").toString());
		mainGui.getListModel().addElement(json.get("user").toString());

	}

}
