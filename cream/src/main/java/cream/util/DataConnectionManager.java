 package cream.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DataConnectionManager {
	
	//Declare Connection and Statement objects
	private Connection myConnection = null;
	private Statement myStatement = null;
	private ResultSet set;	
	
	public DataConnectionManager() throws SQLException {
		try{//initialize Connection and Statement objects
		myConnection = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.56.105:1521:xe",
				"cream",
				"cream");
		
		myStatement = myConnection.createStatement();
		}catch(SQLException ex){
			ex.getMessage();
		}//end of catch block
		
	}//end of constructor method
	
	public ResultSet executeQuery(String query) {
		
		try {
			set = myStatement.executeQuery(query);
			
			return set;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of catch block 
		
		return null;
	}//end of getMyStatement method
	
	public PreparedStatement getPrepareStatement(String INSERT) throws SQLException {
		
		return myConnection.prepareStatement(INSERT);
		}
	
	public void closeConnection() throws SQLException {
		myStatement.close();
	}
	
	
	
}//end of DataConnectionManager class 
