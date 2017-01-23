package file_IO;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class File_Reader {
	private List data;
	
	public File_Reader(String name) {
		data = new ArrayList<String>();
		try {
			
			parseData(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void parseData(String name) throws Exception {
		//Parse data to ArrayList
		
		
		BufferedReader reader = new BufferedReader(new FileReader(name));
		
		String line;
		
		while ((line = reader.readLine()) != null) {
			data.add(line);
		}
		reader.close();
	}
	
	public ArrayList<String> getData() {
		return (ArrayList<String>) data;
	}
	
	
}
