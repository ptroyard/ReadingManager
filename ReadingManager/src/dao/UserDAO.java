package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







import classes.UserNotFoundException;
import sql.Database;
import beans.UserBean;

public class UserDAO {

	private Database dataBase;

	public UserDAO() throws Exception {
		// Appel de la base
		dataBase = Database.getConnexionDataBase();
	}

	public void finalize() {
		dataBase.disconnect();
	}

	private UserBean userBeanRowMapper(ResultSet rsUser) throws SQLException {
		UserBean rUser = new UserBean();
		rUser.setMail(rsUser.getString("MAIL"));
		rUser.setPassword(rsUser.getString("PASSWORD"));
		rUser.setLastName(rsUser.getString("NOM"));
		rUser.setFirstName(rsUser.getString("PRENOM"));
		rUser.setAdress(rsUser.getString("ADDRESS"));
		rUser.setTel(rsUser.getString("TEL"));
		rUser.setCreationDate(rsUser.getString("CREA_DT"));
		rUser.setStatus(rsUser.getBoolean("STATUS"));
		rUser.setAdmin(rsUser.getBoolean("ADMIN"));
		return rUser;
	}

	//Function to check user to log him
	public UserBean getLogin(UserBean pUser) throws Exception {
		UserBean rUser = new UserBean();
		String sqlRequest = "SELECT MAIL, PASSWORD, NOM, PRENOM, ADDRESS, TEL, CREA_DT, STATUS, ADMIN FROM TUSAGER0 WHERE MAIL = '"
				+ pUser.getMail()
				+ "' AND PASSWORD = '"
				+ pUser.getPassword()
				+ "';";

		ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
		boolean more = resultQuery.next();
		if (more) {
			rUser = this.userBeanRowMapper(resultQuery);
			return rUser;
			

		} else {
			throw new Exception(
					"Login Failed, user does not exist or incorrect password");
		}

	}

	//Function to insert a user
	public void insertUser(UserBean pUser) throws Exception{
		
		try{
			this.getUser(pUser.getMail());
			throw new Exception("This email adress is already taken");
		}
		catch(UserNotFoundException ue){
			int isAdmin = (pUser.isAdmin()) ? 1 : 0 ;
			pUser.setPassword(this.generatePassword());
			String sqlRequest = "INSERT INTO TUSAGER0 (MAIL, PASSWORD, NOM, PRENOM, ADDRESS, TEL, CREA_DT, STATUS, ADMIN) "
					+ "VALUES('"+ pUser.getMail() +"', '"
							+ pUser.getPassword()+"', '"
							+ pUser.getLastName()+"', '"
							+ pUser.getFirstName()+"', '"
							+ pUser.getAdress()+"', '"
							+ pUser.getTel()+"', "
							+ "DATETIME(\"now\") ,"
							+ "0 ,"+ isAdmin + ");";
			dataBase.updateValue(sqlRequest);
		}
		
	}

	//Function to get all the existing users of the database
	public List<UserBean> getAllUser() throws SQLException
	{
		String sqlRequest = "SELECT MAIL, PASSWORD, NOM, PRENOM, ADDRESS, TEL, CREA_DT, STATUS, ADMIN FROM TUSAGER0 WHERE STATUS=1 ORDER BY MAIL;";
		ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
		List<UserBean> userList = new ArrayList<UserBean>();
		
		while (resultQuery.next()) 
		{
			UserBean user = new UserBean();
			user = this.userBeanRowMapper(resultQuery);
            userList.add(user);
        }
		return userList;

	}
	
	
	//Function to delete a user
	public void deleteUser(String user) throws SQLException
	{
		String sqlRequest = "DELETE FROM TUSAGER0 WHERE MAIL='"+user+"';";
		dataBase.updateValue(sqlRequest);
	}
	
	// Get user by mail
	public UserBean getUser(String user) throws Exception 
	{
		String sqlRequest = "SELECT MAIL, PASSWORD, NOM, PRENOM, ADDRESS, TEL, CREA_DT, STATUS, ADMIN FROM TUSAGER0 WHERE MAIL='"+user+"';";
		ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
		UserBean rUser = new UserBean();
		boolean more = resultQuery.next();
		if (more) 
		{
			rUser = this.userBeanRowMapper(resultQuery);
			return rUser;

		} 
		else 
		{
			throw new UserNotFoundException ("This user doest not exist");
		}
		
	}
	
	//Function to update a user
	public void updateUser(UserBean user) throws Exception
	{
		
		if(user.getLastName()=="" || user.getFirstName()=="" || user.getAdress()=="" || user.getTel()=="")
		{
			//Gestion des champs vides (pour ne pas ins�rer des 'null'
			UserBean userInDB = new UserBean();
			userInDB=this.getUser(user.getMail());
			if(user.getLastName()=="")
			{
				user.setLastName(userInDB.getLastName());
			}
			if(user.getFirstName()=="")
			{
				user.setFirstName(userInDB.getFirstName());
			}
			if(user.getAdress()=="")
			{
				user.setAdress(userInDB.getAdress());
			}
			if(user.getTel()=="")
			{
				user.setTel(userInDB.getTel());
			}
		}
		
		//Update
		String sqlRequest = "UPDATE TUSAGER0 SET "
				+ "NOM = '" + user.getLastName()
				+ "', PRENOM = '" + user.getFirstName()
				+ "', ADDRESS = '" + user.getAdress()
				+ "', TEL = '" + user.getTel()
				+ "' WHERE MAIL='" + user.getMail() +"';";
		dataBase.updateValue(sqlRequest);
	}
	
	//Delete a user
	public void updateStatus(UserBean user)
	{
		int status;
		if(!user.isStatus()) status=0;
		else status=1;
		String sqlRequest = "UPDATE TUSAGER0 SET STATUS = "+status+" WHERE MAIL='"+user.getMail()+"';";
		dataBase.updateValue(sqlRequest);
	}
	
	//Function to generate a random string via getRandomNumber
	private String generatePassword()
	{
	String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	int RANDOM_STRING_LENGTH = 10;
		     
	StringBuffer randStr = new StringBuffer();
	for(int i=0; i<RANDOM_STRING_LENGTH; i++)
	{
		int number = this.getRandomNumber();
		char ch = CHAR_LIST.charAt(number);
		randStr.append(ch);
	}
	String password = randStr.toString();
	return password;
	}
		     
	//Function to generate a random number
	private int getRandomNumber() 
	{
		String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) 
		{
		    return randomInt;
		} 
		else 
		{
		    return randomInt - 1;
		}

	}


}
