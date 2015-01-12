package dao;

import java.sql.ResultSet;

import beans.EvaluationBean;
import beans.ReadBooksBean;
import sql.Database;

public class ReadBooksDAO 
{
	private Database dataBase;

	public ReadBooksDAO() throws Exception 
	{
		// Appel de la base
		dataBase = Database.getConnexionDataBase();
	}

	public void finalize() 
	{
		dataBase.disconnect();
	}
	
	private ReadBooksBean readBooksBeanRowMapper(ResultSet rsEvaluation) throws Exception 
	{
		ReadBooksBean rReadBook = new ReadBooksBean();
		BookDAO book = new BookDAO();
		UserDAO user = new UserDAO();
		rReadBook.setId(rsEvaluation.getInt("ID"));
		rReadBook.setBook(book.getBook(rsEvaluation.getString("LIVRE")));
		rReadBook.setReader(user.getUser(rsEvaluation.getString("LECTEUR")));
		return rReadBook;
	}
	
}
