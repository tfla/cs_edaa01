package phonebook;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class PhoneBook implements Serializable {
	private TreeMap<String,LinkedList<String>> phoneBook;
	private int size;
	
	public PhoneBook() {
		phoneBook = new TreeMap<String,LinkedList<String>>();
	}
	
	
	/** 
	 * Associates the specified number with the specified 
	 * name in this phone book. 
	 * post: If the specified name is not present in this phone book,
	 *        the specified name is added and associated  with
	 *  	  the specified number. Otherwise the specified 
	 *  	  number is added to the set of number associated with name.
	 * @param name The name for which a phone number is to be added
	 * @param number The number associated with the specified name
	 */
	public void put(String name, String number) {
		if (phoneBook.containsKey(name)) {
			phoneBook.get(name).add(number);
		} else {
			LinkedList<String> numbers = new LinkedList<String>();
			numbers.add(number);
			size++;
			phoneBook.put(name, numbers);
		}
	}
	
	
	/**
	 * Removes the the specified name from this phone book.
	 * post: If the specified name is present in this phone book,
	 * 		 it is removed. Otherwise this phone book is
	 * 		 unchanged.
	 * @param name The name to be removed.
	 * @return true if the specified name was present.
	 */
	public boolean remove(String name) {
		return phoneBook.remove(name) != null;
	}
	
	/**
	 * Retrieves a list of phone numbers for the specified name. If the 
	 * specified name is not present in this phone book an empty list is 
	 * returned.
	 * @param name The name whose associated phone numbers are to be returned  
	 * @return The phone numbers associated with the specified name
	 */
	public List<String> findNumber(String name) {
		return phoneBook.get(name);
	}
	
	/**
	 * Retrieves a list of names associated with the specified phone number. 
	 * If the specified number is not present in this phone book an empty 
	 * list is returned.
	 * @param number The number for which the set of associated
	 * names is to be returned.
	 * @return The list of names associated with the specified number.
	 */
	public List<String> findNames(String number) {
		LinkedList<String> names = new LinkedList<String>();
		for (String s : phoneBook.keySet()) {
			if (phoneBook.get(s).contains(number)) {
				names.add(s);
			}
		}
		return names;
	}
	
	/**
	 * Retrieves the set of all names present in this phone book.
	 * The set's iterator will return the names in ascending order
	 * @return The set of all names present in this phone book
	 */
	public Set<String> names() {
		return phoneBook.keySet();
	}
	
	/**
	 * Returns true if this phone book is empty
	 * @return true if this phone book is empty
	 */	
	public boolean isEmpty() {
		return phoneBook.isEmpty();
	}
	
	/**
	 * Returns the number of names in this phone book
	 * @return The number of names in this phone book
	 */
	public int size() {
		return size;
	}

	public void save(File f) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(phoneBook);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void open(File f) {
		try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            phoneBook = (TreeMap<String,LinkedList<String>>) in.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
	}
}
