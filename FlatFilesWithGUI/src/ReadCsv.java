import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;



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
	
	public void copyLines(String newTitle) throws IOException {
		FileWriter fw = new FileWriter(newTitle);
		BufferedWriter bw1 = new BufferedWriter(fw);
		String lines = null;
		while((lines = br.readLine()) != null) {
			String[] line = lines.split(",");
			String str = line[0] + ", " + line[1] + ", " + line[2];
			bw1.write(str);
			bw1.newLine();
			bw1.flush();
		}
		br.close();
		bw1.close();
	}
	
}
