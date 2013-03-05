package phonebook;

import java.util.Random;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
	public static void main(String[] args) {	
		PhoneBook pb = new PhoneBook();

		File f = new File(args[0]);
		pb.open(f);

//		try {
//			ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
//			pb = (PhoneBook) in.readObject();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			System.exit(1);
//		}

		new PhoneBookGUI(pb);

		/** Everything below this line is OLD! */
		/** Fyll katalogen lite. */
//		for (int i = 0; i < 100; i++) {
//			String name = randName();
//			String number  = randNumber();
//			pb.put(name, number);
			/** Testa dubletter. */
//			pb.put(name, number);
//		}

		/** Testa storlek. */
//		System.out.println("Size: " + pb.size());

		/** Lägg in några nummer som vi har koll på. */
//		pb.put("Nina Dedre", "0768474359");
//		pb.put("Nina Dedre", "0708114885");
//		pb.put("Nina Dedre", "0709164885");
//		pb.put("John Doeeo", "0768474359");
		
		/** Testa findNames(). */
//		List<String> names = pb.findNames("0768474359");
//		System.out.println("Names with number 0768474359:");
//		for (String s : names) {
//			System.out.println(s);
//		}

		/** Testa findNumber. */
//		List<String> numbers = pb.findNumber("Nina Dedre");
//		System.out.println("Numbers with name Nina Dedre:");
//		for (String s : numbers) {
//			System.out.println(s);
//		}
		
	}

	private static String randName() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		int fnLength = 2+rand.nextInt(2);
		int lnLength = 4+rand.nextInt(2);

		sb.append((char) (65+rand.nextInt(25)));
		for (int i = 0; i < fnLength; i++) {
			sb.append((char) (97+rand.nextInt(25)));
		}
		sb.append(" " + (char) (65+rand.nextInt(25)));
		for (int i = 0; i < lnLength; i++) {
			sb.append((char) (97+rand.nextInt(25)));
		}
		return sb.toString();
	}

	private static String randNumber() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();

		sb.append("07");
		sb.append((char) 3*rand.nextInt(2));
		for (int i = 0; i < 7; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}

}
