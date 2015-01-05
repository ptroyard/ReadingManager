package beans;

import java.io.Serializable;

public class EvaluationBean implements Serializable {

	private int id;
	private UserBean evaluator; 
	private BookBean bookTitle; 
	private UserBean closestUser;
	private UserBean farthestUser;
	private boolean completed;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserBean getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(UserBean evaluator) {
		this.evaluator = evaluator;
	}
	public BookBean getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(BookBean bookTitle) {
		this.bookTitle = bookTitle;
	}
	public UserBean getClosestUser() {
		return closestUser;
	}
	public void setClosestUser(UserBean closestUser) {
		this.closestUser = closestUser;
	}
	public UserBean getFarthestUser() {
		return farthestUser;
	}
	public void setFarthestUser(UserBean farthestUser) {
		this.farthestUser = farthestUser;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
