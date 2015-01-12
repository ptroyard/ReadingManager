package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BookBean;
import beans.QuestionBean;
import sql.Database;

public class QuestionDAO 
{
	private Database dataBase;

	public QuestionDAO() throws Exception 
	{
		// Appel de la base
		dataBase = Database.getConnexionDataBase();
	}

	public void finalize() 
	{
		dataBase.disconnect();
	}
	
	private QuestionBean questionBeanRowMapper(ResultSet rsQuestion) throws SQLException 
	{
		QuestionBean rQuestion = new QuestionBean();
		rQuestion.setId(rsQuestion.getInt("ID"));
		rQuestion.setIntituleQuestion(rsQuestion.getString("INT_QST"));
		return rQuestion;
	}
	
}
