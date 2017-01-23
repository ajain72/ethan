package file_IO;


import java.io.File;

public class FileReader {
	private String[] data;
	
	public FileReader(File file) {
		parseData(file);
	}
	
	private void parseData(File file) {
		//Parse data to string array
		
	}
	
	public String[] getData() {
		return data;
	}
	
	
}
