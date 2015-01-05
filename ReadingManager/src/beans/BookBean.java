package beans;

import java.io.Serializable;

public class BookBean implements Serializable {
	
	private String title;
	private String author;
	private String litteratureGenre;
	private String bookDescription;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLitteratureGenre() {
		return litteratureGenre;
	}
	public void setlitteratureGenre(String litteratureGenre) {
		this.litteratureGenre = litteratureGenre;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setLivre_desc(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	
	
}
