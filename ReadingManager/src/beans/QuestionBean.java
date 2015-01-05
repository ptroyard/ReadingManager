package beans;

import java.io.Serializable;

public class QuestionBean implements Serializable {

	private int id;
	private String questionDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntituleQuestion() {
		return questionDescription;
	}

	public void setIntituleQuestion(String questionDescription) {
		this.questionDescription = questionDescription;
	}

}
