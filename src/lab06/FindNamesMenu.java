package phonebook;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.lang.StringBuilder;

@SuppressWarnings("serial")
public class FindNamesMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNamesMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find Name(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String number = JOptionPane.showInputDialog(null, "Enter Number.");
		List<String> names = phoneBook.findNames(number);
		StringBuilder sb = new StringBuilder();
		for (String s : names) {
			sb.append(s + "\n");
		}
		if (sb.length() > 0) {
			gui.view(sb.toString());
		}
		else {
			JOptionPane.showMessageDialog(null, "Search Failed.");
		}
	}
}
