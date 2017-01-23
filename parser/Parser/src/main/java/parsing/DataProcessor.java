package parsing;


import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class DataProcessor {
	private List JSONList;
	
	public DataProcessor(ArrayList<String> input) {
		JSONList = new ArrayList<JSONObject>();
		parseData(input);
	}
	
	public List<JSONObject> getObjectList() {
		return JSONList;
	}
	
	public void parseData(ArrayList<String> input) {
		//Pull name, DOB, SSN from input strings and add each object to list
		for (String line : input) {
			
			String name = parseName(line.trim());
			String date = parseDOB(line.trim());
			String number = parseSSN(line.trim());
			
			JSONObject obj = new JSONObject();
			obj.put("name", name);
			obj.put("DOB", date);
			obj.put("SSN", number);
			
			JSONList.add(obj);
		}
	}
	
	private String parseName(String input) {
		int index = 0;
		while (!Character.isDigit(input.charAt(index))) {
			index++;
		}
		String name = input.substring(0, index);
		
		
		return name.trim();
	}
	
	private String parseDOB(String input) { //TODO: add incomplete data checking
		String date = input.substring(input.length()-17,input.length()-9);
		return date;
	}
	
	private String parseSSN(String input) {
		String SSN = input.substring(input.length()-9);
		
		return SSN;
	}
	
	
}
