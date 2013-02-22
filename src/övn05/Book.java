public class Book {
	private String isbn;
	private String title;
	private String author;

	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public boolean equals(Object rhs) {
		if (rhs instanceof Book) {
			return isbn.equals(((Book) rhs).isbn);
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return isbn.hashCode();
	}

}
