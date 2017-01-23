package main;

import java.io.File;

import org.json.simple.JSONObject;

import file_IO.File_Reader;
import parsing.DataProcessor;

public class Main {

	public static void main(String[] args) {
		//Use FileReader to get data
		File_Reader reader = new File_Reader("data_file.txt");
		//Use DataProcessor to parse into JSON objects
		DataProcessor processor = new DataProcessor(reader.getData());
		for (JSONObject obj : processor.getObjectList()) {
			System.out.println(obj);
		}
	}

}
