package phonebook;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public AddMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Add");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(null, "Enter Name.");
		String number = JOptionPane.showInputDialog(null, "Enter Number.");
		int size = phoneBook.size();
		phoneBook.put(name, number);
		if (size < phoneBook.size()) {
			JOptionPane.showMessageDialog(null, "Successfully added entry.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Adding entry failed.");
		}
		gui.update();
	}
}
