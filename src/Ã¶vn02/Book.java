public class Book {
	private String isbn;
	private String title;
	private String author;
	private SingleLinkedList<String> list = new SingleLinkedList<String>();

	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		list.addFirst(isbn);
	}
	
	public boolean removeBook(String isbn) {
		return list.remove(isbn);
	}

	public boolean searchBook(String isbn) {
		return list.contains(isbn);
	}
}
