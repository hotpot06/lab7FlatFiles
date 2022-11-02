import java.io.IOException;

import javax.swing.JFrame;


public class mainForFlatFilesWithGUI {

	public static void main(String[] args) throws IOException {
		// set up JFrame
		MyFrame myframe = new MyFrame("Read & Write Files", "/Users/hotpotliu/Desktop/annual.csv");
		myframe.setSize(1000, 400);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setVisible(true);

	}


}
