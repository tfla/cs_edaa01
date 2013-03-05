package phonebook;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ViewAllMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public ViewAllMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("View All");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.update();
	}
}
