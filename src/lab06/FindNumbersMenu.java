package phonebook;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.lang.StringBuilder;

@SuppressWarnings("serial")
public class FindNumbersMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNumbersMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find Number(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(null, "Enter Name.");
        List<String> numbers = phoneBook.findNumber(name);
        StringBuilder sb = new StringBuilder();
		if (numbers != null) {
			for (String s : numbers) {
        	    sb.append(s + "\n");
        	}
        	if (sb.length() > 0) {
        	    gui.view(sb.toString());
        	}
		}
        else {
            JOptionPane.showMessageDialog(null, "Search Failed.");
        }
	}
}
