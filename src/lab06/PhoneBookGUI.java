package phonebook;
import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.Locale;
import java.awt.BorderLayout;

public class PhoneBookGUI extends JFrame {
	private PhoneBook phoneBook;
	private JTextArea messageArea;
		
	public PhoneBookGUI(PhoneBook pb) {
		super("PhoneBook");
		phoneBook = pb;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Locale.setDefault(new Locale("en"));
		/* To avoid hardcoded Swedish text on OptionPane dialogs */
		UIManager.put("OptionPane.cancelButtonText","Cancel");
		
		setLayout(new BorderLayout());
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		editMenu.add(new AddMenu(phoneBook,this));
		editMenu.add(new RemoveMenu(phoneBook,this));
		JMenu findMenu = new JMenu("Find");
		menubar.add(findMenu);
		findMenu.add(new FindNamesMenu(phoneBook,this));
		findMenu.add(new FindNumbersMenu(phoneBook,this));
		JMenu viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		viewMenu.add(new ViewAllMenu(phoneBook,this));
		
		JPanel southPanel = new JPanel();
		messageArea = new JTextArea(4,25);
		messageArea.setEditable(false);
		southPanel.add(new JScrollPane(messageArea));
		southPanel.add(new QuitButton(phoneBook,this));
		southPanel.add(new SaveButton(phoneBook,this));
		add(southPanel,BorderLayout.CENTER);

		update();
		pack();
		setVisible(true);
	}

	public void update() {
		messageArea.setText("");
		Set<String> names = phoneBook.names();
        for (String name : names) {
            messageArea.append(name);
            List<String> numbers = phoneBook.findNumber(name);
            for (String number : numbers) {
                messageArea.append("\t" + number + "\n");
            }
        }
	}

	public void view(String s) {
		messageArea.setText(s);
	}
}
