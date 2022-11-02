import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	JTextField readingFile = new JTextField(100);
	JTextField writingFile = new JTextField(100);
	JTextArea readingLines = new JTextArea();
	JTextArea writingLines = new JTextArea();
	
	public MyFrame(String title, String defaultFile) {
		super(title);
		
		// set up the container (panel)
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		// add the label for reading file
		JLabel label1 = new JLabel("Reading File Name");
		label1.setForeground(Color.blue);
		panel.add(label1);
		label1.setBounds(0, 0, 450, 30);
		
		readingFile.setForeground(Color.blue);
		readingFile.setText(defaultFile);
		panel.add(readingFile);
		readingFile.setBounds(0, 35, 450, 30);
		
		// button for reading files
		JButton button1 = new JButton("Click to Read from File");
		
		button1.setForeground(Color.blue);
		button1.setOpaque(true);
		button1.setBackground(new Color(255, 0, 0));
		panel.add(button1);
		button1.setBounds(0, 80, 450, 30);
		
		// textArea for reading files
		JLabel label2 = new JLabel("First five lines: ");
		label2.setForeground(Color.blue);
		panel.add(label2);
		label2.setBounds(0, 115, 450, 30);
		
		readingLines.setLineWrap(true);
		panel.add(readingLines);
		readingLines.setWrapStyleWord(true);
		readingLines.setBounds(0, 150, 450, 150);
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String reading = readingFiles();
					readingLines.setText(reading);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		// add the label for reading file
		JLabel label3 = new JLabel("File Name to Write");
		label3.setForeground(Color.blue);
		panel.add(label3);
		label3.setBounds(500, 0, 450, 30);
		
		writingFile.setForeground(Color.blue);
		panel.add(writingFile);
		writingFile.setBounds(500, 35, 450, 30);
		
		// button for reading files
		JButton button2 = new JButton("Click to Write to File");
		
		button2.setForeground(Color.blue);
		button2.setOpaque(true);
		button2.setBackground(new Color(255, 0, 0));
		panel.add(button2);
		button2.setBounds(500, 80, 450, 30);
		
		// textArea for reading files
		JLabel label4 = new JLabel("First five lines of new file: ");
		label4.setForeground(Color.blue);
		panel.add(label4);
		label4.setBounds(500, 115, 450, 30);
		
		writingLines.setLineWrap(true);
		panel.add(writingLines);
		writingLines.setWrapStyleWord(true);
		writingLines.setBounds(500, 150, 450, 150);
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String writing = readingFiles();
					writingLines.setText(writing);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
	}
	
	public String readingFiles() throws IOException {
		String filename = readingFile.getText();
		ReadCsv rc;
		rc = new ReadCsv(filename);
		String l = rc.printLines(5);
		return l;
	}
}
