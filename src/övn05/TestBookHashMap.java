public class TestBookHashMap {
	public static void main(String[] args) {
		HashMap<String,Book> map = new HashMap<String, Book>();
		map.put("9113013645", new Book("9113013645", "De två tornen", "Tolkien"));
		map.put("9113016482", new Book("9113016482", "Hobbiten", "Tolkien"));

		HashSet<Book> set = new HashSet<Book>();
		set.add(new Book("9113013645", "De två tornen", "Tolkien"));
		set.add(new Book("9113016482", "Hobbiten", "Tolkien"));
	}
}
