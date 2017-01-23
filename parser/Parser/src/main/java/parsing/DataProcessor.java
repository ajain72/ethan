package parsing;


import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class DataProcessor {
	private List JSONList = new ArrayList<JSONObject>();
	
	public DataProcessor(String[] input) {
		parseData(input);
	}
	
	public List<JSONObject> getObjectList() {
		return JSONList;
	}
	
	public void parseData(String[] input) {
		//Pull name, DOB, SSN from input strings and add each object to list
	}
	
	private String parseName(String input) {
		
		return null;
	}
	
	private String parseDOB(String input) {
		
		return null;
	}
	
	private String parseSSN(String input) {
		
		return null;
	}
	
	
}
