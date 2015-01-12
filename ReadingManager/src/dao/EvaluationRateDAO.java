package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.EvaluationBean;
import beans.EvaluationRateBean;
import sql.Database;

public class EvaluationRateDAO 
{
	private Database dataBase;

	public EvaluationRateDAO() throws Exception 
	{
		// Appel de la base
		dataBase = Database.getConnexionDataBase();
	}

	public void finalize() 
	{
		dataBase.disconnect();
	}
	
	private EvaluationRateBean bookBeanRowMapper(ResultSet rsEvaluationRate) throws Exception 
	{
		EvaluationRateBean rEvaluationRate = new EvaluationRateBean();
		EvaluationDAO evaluation = new EvaluationDAO();
		QuestionDAO question = new QuestionDAO();
		rEvaluationRate.setId(rsEvaluationRate.getInt("ID"));
		rEvaluationRate.setRate(rsEvaluationRate.getInt("NOTE"));
		//TODO : functions to get eval and question
		//rEvaluationRate.set(question.get(rsEvaluationRate.getString("TITRE_LIVRE")));
		//rEvaluationRate.setEvaluator(evaluation.get(rsEvaluationRate.getString("EVALUATOR")));
		return rEvaluationRate;
		
	}
}
