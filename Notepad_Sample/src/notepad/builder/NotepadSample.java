package notepad.builder;

import javax.swing.JFrame;

public class NotepadSample {
	public static void main(String[] args) {
		User user = new User();
		NotepadBuilder myNotepad = new MyNotepad();
		
		user.setNotepadBuilder(myNotepad);
		user.constructNotepad();
		
		Notepad notepad = user.getNotepad();
	}

}
