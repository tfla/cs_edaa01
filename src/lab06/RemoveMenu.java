package phonebook;
import javax.swing.*;
import java.awt.event.*;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(null, "Enter name to remove.");
		if (phoneBook.remove(name)) {
			JOptionPane.showMessageDialog(null, "Successfully removed entry.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Removing entry failed.");
		}
		gui.update();
	}
}
