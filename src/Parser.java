import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

	private JSONObject json;
	private String code;
	private Handler handler;
	private MainGui mainGui;
	private JSONParser parser;
	
	public Parser(MainGui mainGui, String str){
		this.mainGui = mainGui;
		handler = new Handler(mainGui);
		parser = new JSONParser();
		try {
			json = (JSONObject)parser.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		code = json.get("Code").toString();
		
		if(code.equals("1111")){
			handler.SetId(json);
		}
		else if(code.equals("2222")){
			handler.SetContext(json);
		
		}
		else if(code.equals("3333")){
			handler.SetRoomTitle(json);
		}
		else if(code.equals("9999")){
			handler.Exit(json);
		}
		
		
		
		
		
	}
	
}
