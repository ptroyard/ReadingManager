package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import beans.EvaluationBean;
import sql.Database;

public class EvaluationDAO 
{
	private Database dataBase;

	public EvaluationDAO() throws Exception 
	{
		// Appel de la base
		dataBase = Database.getConnexionDataBase();
	}

	public void finalize() 
	{
		dataBase.disconnect();
	}
	
	private EvaluationBean evaluationBeanRowMapper(ResultSet rsEvaluation) throws Exception 
	{
		EvaluationBean rEvaluation = new EvaluationBean();
		BookDAO book = new BookDAO();
		UserDAO user = new UserDAO();
		rEvaluation.setId(rsEvaluation.getInt("ID"));
		rEvaluation.setBookTitle(book.getBook(rsEvaluation.getString("TITRE_LIVRE")));
		rEvaluation.setEvaluator(user.getUser(rsEvaluation.getString("EVALUATOR")));
		rEvaluation.setClosestUser(user.getUser(rsEvaluation.getString("CLOSEST_USG")));
		rEvaluation.setFarthestUser(user.getUser(rsEvaluation.getString("FARTHEST_USG")));
		rEvaluation.setCompleted(rsEvaluation.getBoolean("COMPLETED"));
		return rEvaluation;
	}
}
