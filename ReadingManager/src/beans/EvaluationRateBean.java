package beans;

public class EvaluationRateBean {

	private int id;
	private int rate;
	private EvaluationBean evaluator;
	private QuestionBean question;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public EvaluationBean getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(EvaluationBean evaluator) {
		this.evaluator = evaluator;
	}
	public QuestionBean getQuestion() {
		return question;
	}
	public void setQuestion(QuestionBean question) {
		this.question = question;
	}
	
	
}
