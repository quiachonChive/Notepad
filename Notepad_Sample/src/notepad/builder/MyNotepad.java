package notepad.builder;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyNotepad extends NotepadBuilder implements ActionListener {
	
	private JTextArea textArea;
	private JScrollPane scroll;
	protected JFileChooser fileOpen = 
			new JFileChooser();
	protected FileNameExtensionFilter filter =
			new FileNameExtensionFilter("Text/Java files", "txt", "java");
	protected JMenuItem saveFile;
	protected JMenuItem openFile;
	int ret = 0;
	
	@Override
	public void addComponents() {
		textArea = new JTextArea(6, 20);
		scroll = new JScrollPane(textArea);
		add(scroll);
	}

	@Override
	public void addMenu() {
		JMenu fileMenu = new JMenu();
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		saveFile = new JMenuItem();
		openFile = new JMenuItem();
		
		fileMenu = new JMenu("File");
		menu.add(fileMenu);
		
		openFile = new JMenuItem("Open");
		saveFile = new JMenuItem("Save");
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
	}
	
	@Override
	public void addEvent() {
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		
	}

	public void openFile() {
		fileOpen.setFileFilter(filter);
		ret = fileOpen.showOpenDialog(getParent());
		if(ret == JFileChooser.OPEN_DIALOG) {
			String filePath = fileOpen.getSelectedFile().getPath();
			File file = new File(filePath);
			FileReader input;
			try {
				input = new FileReader(file);
				textArea.read(input, file.toString());
				input.close();
			} catch (Exception e) {}
		}
	}

	public void saveFile() {
		fileOpen.setFileFilter(filter);
		ret = fileOpen.showSaveDialog(getParent());
		if(ret == JFileChooser.APPROVE_OPTION) {
			String textAreaString = textArea.getText();
			String filePath = fileOpen.getSelectedFile().getPath();
			File file = new File(filePath);
			Writer output;
			try {
				output = new BufferedWriter(new FileWriter(file));
				output.write(textAreaString);
				output.close();
			} catch (IOException e) {}
		}
	}
	
	public void settleNotepad() {
		this.setTitle("My Notepad");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openFile) {
			openFile();
		} else if (e.getSource() == saveFile) {
			saveFile();
		}	
	}

	
}
