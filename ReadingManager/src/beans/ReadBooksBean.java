package beans;

import java.io.Serializable;

public class ReadBooksBean implements Serializable {

	private int id;
	private UserBean reader;
	private BookBean book;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserBean getReader() {
		return reader;
	}
	public void setReader(UserBean reader) {
		this.reader = reader;
	}
	public BookBean getBook() {
		return book;
	}
	public void setBook(BookBean book) {
		this.book = book;
	}
	
	
}
