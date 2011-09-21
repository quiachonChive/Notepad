package notepad.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User {
	private NotepadBuilder notepadBuilder;

	public void setNotepadBuilder(NotepadBuilder nb) {
		notepadBuilder = nb;
	}
	
	public Notepad getNotepad() {
		return notepadBuilder.getNotepad();
	}
	
	public void constructNotepad() {
		notepadBuilder.createNewNotepad();
		notepadBuilder.addComponents();
		notepadBuilder.addMenu();
		notepadBuilder.addEvent();
		notepadBuilder.settleNotepad();
	}
}
