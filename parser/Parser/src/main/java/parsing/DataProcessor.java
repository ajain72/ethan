package parsing;


import java.util.List;
import java.util.ArrayList;

import org.json.simple.JSONArray;
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
			obj.put("Name", name);
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
		String fullName = input.substring(0, index).trim();
		String[] splitName = fullName.split(",");
		if (splitName.length == 1) return fullName;
		
		String finalName = splitName[1] + " " + splitName[0];
		
		return finalName;
	}
	
	private String parseDOB(String input) { 
		int index = 0;
		while (!Character.isDigit(input.charAt(index))) {
			index++;
		}
		
		String date = input.substring(index,input.length()-9);
		String month, day, year;
		year = date.substring(date.length()-4); //Assume valid year
		date = date.substring(0,date.length()-4);
		//Handle month and day, assuming error only involves no leading zeroes
		if (date.length() == 4) {
			month = date.substring(0, 2);
			day = date.substring(2);
		} else if (date.length() == 2) {
			month = "0"+date.charAt(0);
			day = "0"+date.charAt(1);
		} else {
			if (date.charAt(0) != '1') {
				month = "0"+date.charAt(0);
				day = date.substring(1);
			} else {
				month = date.substring(0,2);
				day = "0"+date.charAt(2);
			}
		}
		
		date = month + "-" + day + "-" + year;
		
		return date;
	}
	
	private String parseSSN(String input) {
		String SSN = input.substring(input.length()-9);
		SSN = SSN.substring(0,3)+"-"+SSN.substring(3,5)+"-"+SSN.substring(5);
		return SSN;
	}
	
	
}
