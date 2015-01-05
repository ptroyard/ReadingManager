package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import sql.Database;
import beans.UserBean;

public class UserDAO {
	
	private Database dataBase;
	
	public UserDAO() throws Exception
	{
		//Appel de la base
		dataBase = Database.getConnexionDataBase();
	}
	
	private UserBean userBeanRowMapper(ResultSet rsUser) throws SQLException
	{
		UserBean rUser=new UserBean();
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
	
	public UserBean getLogin(UserBean pUser) throws Exception
	{
		UserBean rUser=new UserBean();
		String sqlRequest = "SELECT MAIL, PASSWORD, NOM, PRENOM, ADDRESS, TEL, CREA_DT, STATUS, ADMIN FROM TUSAGER0 WHERE MAIL = '"+ pUser.getMail()+
							"' AND PASSWORD = '"+ pUser.getPassword()+"';";
		System.out.println(sqlRequest);
		
		ResultSet resultQuery = dataBase.getResultOf(sqlRequest);
		boolean more=resultQuery.next();
		if(more)
		{
			rUser = this.userBeanRowMapper(resultQuery);
			dataBase.disconnect();
			return rUser;
			
		} 
		else
		{
			dataBase.disconnect();
			throw new Exception("Login Failed, user does not exist or incorrect password");
		}
		
		
	}
	
	

}
