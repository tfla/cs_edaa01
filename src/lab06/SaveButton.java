package phonebook;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SaveButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	private JFileChooser fc;

	public SaveButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Save");
		this.phoneBook = phoneBook;
		this.gui = gui;
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setDialogTitle("Select a file to save.");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int i = fc.showSaveDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			phoneBook.save(f);
		}
	}
}
