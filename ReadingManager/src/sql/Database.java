package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AppConfigDAO;

 
/**
 * Cette classe fait l'interface avec la base de donn�es.
 * @author Leucistic
 *
 */
public class Database
 
{
    private String      dbName;
    public  Connection  connection;
    private Statement   requete;
     
    //Instancie et connecte � la base
    public static Database getConnexionDataBase() throws Exception
    {
    	AppConfigDAO acdao = new AppConfigDAO();
    	String databasepath = acdao.getDatabasePath();
    	Database db = new Database(databasepath);		
	    db.connect();
	    return db;
    	
    	
    }
    
    /**
     * Constructeur de la classe Database
     * @param dbName Le nom de la base de donn�es
     */
    public Database (String dbName)
    {
        // Charge le driver sqlite JDBC en utilisant le class loader actuel
        
    	try
        {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e1)
        {
        	System.out.println("DRIVER ERROR ! " + e1.getMessage());
        }
 
        this.dbName     = dbName;
        this.connection = null;
        
    }
     
    /**
     * Ouvre la base de donn�es sp�cifi�e
     * @return True si la connection � �t� r�ussie. False sinon.
     */
    public boolean connect ()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.dbName);
            requete = connection.createStatement();             
            requete.executeUpdate("PRAGMA synchronous = OFF;");
            requete.setQueryTimeout(30);    
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
     
    /**
     * Ferme la connection � la base de donn�es
     * @return True si la connection a bien �t� ferm�e. False sinon.
     */
    public boolean disconnect ()
    {
        try
        {
        	if(requete!=null)
        		requete.close();
            if(connection != null)
                connection.close();
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
     
    /**
     * Permet de faire une requ�te SQL
     * @param requete La requ�te SQL (avec un ";" � la fin)
     * @return Un ResultSet contenant le r�sultat de la requ�te
     */
    public ResultSet getResultOf(String requete)
    {
        try
        {
            return this.requete.executeQuery(requete);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
         
        return null;
    }
 
    /**
     * Permet de modifier une entr�e de la base de donn�es.</br>
     * @param requete La requete SQL de modification
     */
    public void updateValue(String requete)
    {
        try
        {
            this.requete.executeUpdate(requete);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}