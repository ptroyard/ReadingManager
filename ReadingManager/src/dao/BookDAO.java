package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.BookNotFoundException;
import sql.Database;
import beans.BookBean;

public class BookDAO {

	private Database dataBase;

	public BookDAO() throws Exception {
		// Appel de la base
		dataBase = Database.getConnexionDataBase();
	}

	public void finalize() {
		dataBase.disconnect();
	}

	private BookBean bookBeanRowMapper(ResultSet rsBook) throws SQLException {
		BookBean rBook = new BookBean();
		rBook.setTitle(rsBook.getString("TITRE"));
		rBook.setAuthor(rsBook.getString("AUTEUR"));
		rBook.setlitteratureGenre(rsBook.getString("GENRE_LITT"));
		rBook.setLivre_desc(rsBook.getString("DESC"));
		return rBook;
	}

	// Get Book by Title
	public BookBean getBook(String title) throws Exception 
	{
		String sqlRequest = "SELECT TITRE, AUTEUR, GENRE_LITT, DESC FROM TLIVRES0 WHERE TITRE='"+title+"';";
		ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
		BookBean rBook = new BookBean();
		boolean more = resultQuery.next();
		if (more) 
		{
			rBook = this.bookBeanRowMapper(resultQuery);
			return rBook;

		} 
		else 
		{
			throw new BookNotFoundException ("This Book doest not exist");
		}
		
	}
	
	//Function to insert a book
	public void insertBook(BookBean pBook) throws Exception{
		
		try{
			this.getBook(pBook.getTitle());
			throw new Exception("This Title is already taken");
		}
		catch(BookNotFoundException ue){
			
			String sqlRequest = "INSERT INTO TLIVRES0 (TITRE, AUTEUR, GENRE_LITT, DESC) "
					+ "VALUES('"+ pBook.getTitle() +"', '"
							+ pBook.getAuthor()+"', '"
							+ pBook.getLitteratureGenre()+"', '"
							+ pBook.getBookDescription()+"'); '";
			System.out.println(sqlRequest);
			dataBase.updateValue(sqlRequest);
		}
		
	}

	//Function to get all the existing books of the database
	public List<BookBean> getAllBooks() throws SQLException
	{
		String sqlRequest = "SELECT TITRE, AUTEUR, GENRE_LITT, DESC FROM TLIVRES0 ORDER BY TITRE;";
		ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
		List<BookBean> bookList = new ArrayList<BookBean>();
		
		while (resultQuery.next()) 
		{
			BookBean book = new BookBean();
			book = this.bookBeanRowMapper(resultQuery);
            bookList.add(book);
        }
		return bookList;

	}
	
	
	//Function to get all the existing books of the database with specific criteria
		public List<BookBean> getBooks(BookBean bookToFind) throws SQLException
		{
			String sqlRequest = "SELECT TITRE, AUTEUR, GENRE_LITT, DESC FROM TLIVRES0 WHERE ";
			boolean needAND=false;
			
			if(bookToFind.getTitle()!="")
			{
				sqlRequest = sqlRequest + "TITRE='"+ bookToFind.getTitle() +"' ";
				needAND=true;
			}
			if(bookToFind.getAuthor()!="")
			{
				if(needAND) sqlRequest=sqlRequest+"AND ";
				sqlRequest = sqlRequest + "AUTEUR='"+ bookToFind.getAuthor() +"' ";
				needAND=true;
			}
			if(bookToFind.getLitteratureGenre()!="")
			{
				if(needAND) sqlRequest=sqlRequest+"AND ";
				sqlRequest = sqlRequest + "GENRE_LITT='"+ bookToFind.getLitteratureGenre() +"' ";
				needAND=true;
			}
			if(bookToFind.getBookDescription()!="")
			{
				if(needAND) sqlRequest=sqlRequest+"AND ";
				sqlRequest = sqlRequest + "DESC='"+ bookToFind.getBookDescription() +"' ";
				needAND=true;
			}
			
			sqlRequest=sqlRequest+";";
			
			ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
			List<BookBean> bookList = new ArrayList<BookBean>();
			
			while (resultQuery.next()) 
			{
				BookBean book = new BookBean();
				book = this.bookBeanRowMapper(resultQuery);
				bookList.add(book);
	        }
			return bookList;

		}
	
	//Function to update a book
	public void updateBook(BookBean pBook) throws Exception
	{
		
		String sqlRequest = "UPDATE TLIVRES0 SET ";
		boolean needAND=false;
		if(pBook.getTitle()=="" || pBook.getAuthor()=="" || pBook.getLitteratureGenre()=="" || pBook.getBookDescription()=="")
		{
			//Gestion des champs vides (pour ne pas ins�rer des 'null'

			if(pBook.getAuthor()!="")
			{
				if(needAND) sqlRequest=sqlRequest+", ";
				sqlRequest= sqlRequest + "AUTEUR = '" + pBook.getAuthor()+"'";
				needAND=true;
			}
			if(pBook.getLitteratureGenre()!="")
			{
				if(needAND) sqlRequest=sqlRequest+", ";
				sqlRequest= sqlRequest + "GENRE_LITT = '" + pBook.getLitteratureGenre()+"'";
				needAND=true;
			}
			if(pBook.getBookDescription()!="")
			{
				if(needAND) sqlRequest=sqlRequest+", ";
				sqlRequest= sqlRequest + "DESC = '" + pBook.getBookDescription()+"'";
				needAND=true;
			}
			sqlRequest=sqlRequest+ " WHERE TITRE= '" + pBook.getTitle() + "';";
		}
		dataBase.updateValue(sqlRequest);
	}

	//Delete a Book
	public void deleteBook(BookBean book)
	{
		
		String sqlRequest = "DELETE FROM TLIVRES0 WHERE TITRE='"+book.getTitle()+"';";
		dataBase.updateValue(sqlRequest);
	}
	


}
