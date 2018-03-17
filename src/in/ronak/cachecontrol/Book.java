package in.ronak.cachecontrol;

public class Book {

	int id;
	String bookname;

	public Book(int id, String bookname) {
		this.id = id;
		this.bookname = bookname;
	}

	public static Book getBookFromDB(long id) {
		// TODO Auto-generated method stub
		return new Book(1, "my book");
	}
}
