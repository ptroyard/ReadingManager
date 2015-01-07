package dao;

import java.sql.ResultSet;
import java.util.Random;
import java.sql.SQLException;

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

	public UserBean getLogin(UserBean pUser) throws Exception {
		UserBean rUser = new UserBean();
		String sqlRequest = "SELECT MAIL, PASSWORD, NOM, PRENOM, ADDRESS, TEL, CREA_DT, STATUS, ADMIN FROM TUSAGER0 WHERE MAIL = '"
				+ pUser.getMail()
				+ "' AND PASSWORD = '"
				+ pUser.getPassword()
				+ "';";
		System.out.println(sqlRequest);

		ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
		boolean more = resultQuery.next();
		if (more) {
			rUser = this.userBeanRowMapper(resultQuery);
			return rUser;

		} else {
			dataBase.disconnect();
			throw new Exception(
					"Login Failed, user does not exist or incorrect password");
		}

	}

	public void insertUser(UserBean pUser) {
		try {

			int isAdmin = (pUser.isAdmin()) ? 1 : 0 ;
			
			String sqlRequest = "INSERT INTO TUSAGER0 (MAIL, PASSWORD, NOM, PRENOM, ADDRESS, TEL, CREA_DT, STATUS, ADMIN) "
					+ "VALUES('"+ pUser.getMail() +"', '"
							+ this.generatePassword()+"', '"
							+ pUser.getLastName()+"', '"
							+ pUser.getFirstName()+"', '"
							+ pUser.getAdress()+"', '"
							+ pUser.getTel()+"', "
							+ "DATETIME(\"now\") ,"
							+ isAdmin +",1);";
			
			dataBase.getResultOf(sqlRequest);
			System.out.println(sqlRequest);
		} 
		catch (Exception e) 
		{
		}

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
