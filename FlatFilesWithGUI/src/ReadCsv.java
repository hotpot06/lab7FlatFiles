import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadCsv {

	private BufferedReader br;
	public ReadCsv(String title) {
		try {
			br = new BufferedReader(new FileReader(title));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String printLines(int row) throws IOException {
		String lines = null;
		int index = 0;
		String filelines = "";
		while((lines = br.readLine()) != null) {
			String[] line = lines.split(",");
			if(index < row){
				String str = line[0] + ", " + line[1] + ", " + line[2]+ "\n";
				filelines += str;
			}
			index++;
		}
 		return filelines;
		
	}
}
