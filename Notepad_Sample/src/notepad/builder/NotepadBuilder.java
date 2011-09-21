package notepad.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
abstract class NotepadBuilder extends JFrame {
	protected Notepad notepad;

	public Notepad getNotepad() {
		return notepad;
	}
	
	public void createNewNotepad() {
		notepad = new Notepad();
	}
	
	public abstract void addComponents();
	public abstract void addMenu();
	public abstract void addEvent();
	public abstract void settleNotepad();
}
