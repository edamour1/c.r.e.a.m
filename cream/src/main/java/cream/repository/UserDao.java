package cream.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Product;
import cream.model.User;
import cream.util.Dao;
import cream.util.DataTransferObject;

public class UserDao extends Dao<User>{
	
	private static final String INSERT = "INSERT INTO user_ (\n" + 
			"    user_id,\n" + 
			"    first_name,\n" + 
			"    last_name,\n" + 
			"    email,\n" + 
			"    phone_number,\n" + 
			"    is_admin,\n" + 
			"    username,\n" + 
			"    password_\n" + 
			") VALUES (\n" + 
			"    USER_ID.nextval,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?\n" + 
			")";
	
	private static final String LOGIN = "SELECT * FROM User_\n" + 
	"WHERE username= ? AND password_= ?";
	
	private static final String ID = "SELECT * FROM User_\n" + 
			"WHERE user_id = ?";
	
	private static final String UPDATE = "UPDATE User_\n" + 
			"SET FIRST_NAME = ?, \n" + 
			"LAST_NAME = ?, \n" + 
			"EMAIL = ?, \n" + 
			"phone_number = ?, \n" + 
			"is_admin = ?, \n" + 
			"username = ?, \n" + 
			"password_ = ?\n" + 
			"WHERE user_id = ?";
	
	private static final String DELETE  = "DELETE FROM User_ \n" + 
	"WHERE user_id = ?";
	
	private static final String GET_ALL_USERS = "SELECT * FROM User_";  
	
	private static final String GET_ALL_USERS_IN_RANGE = "SELECT * FROM User_\n" + 
			"WHERE user_id BETWEEN ? AND ?";
	
	private static final String GET_USER = "SELECT username FROM user_\n" + 
			"\n" + 
			"WHERE username= ?";
	
	private static final String MAX_ID  = "SELECT max(user_id) AS Largest\n" + 
			"FROM user_";
	
	private static final String MIN_ID = "SELECT min(user_id) AS Smallest\n" + 
			"FROM user_";

	public UserDao() throws SQLException {
		super();
	}

	@Override
	public User findById(long id) {
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			User user = new User();
			statement.setLong(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getLong("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getLong("phone_number"));
				user.setIsAdmin(rs.getLong("is_admin"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password_"));
			}//end of while loop

			return user;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}
	
	public User login(String username, String password) throws SQLException {
		try(PreparedStatement statement = dcm.getPrepareStatement(LOGIN)){
			User user = new User();
		
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getLong("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getLong("phone_number"));
				user.setIsAdmin(rs.getLong("is_admin"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password_"));
			}//end of while loop
				
					return user;
				
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
				
	}

	@Override
	public List<User> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_USERS)){
			User user;
			
			List<User> userList =  new ArrayList<User>();
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getLong("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getLong("phone_number"));
				user.setIsAdmin(rs.getLong("is_admin"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password_"));
				
				userList.add(user);
			}//end of while loop

			return userList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 

	}

	@Override
	public User update(User dto) {

		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
		
		
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(8, dto.getUserId());
			statement.setString(1, dto.getFirstName());
			statement.setString(2, dto.getLastName());
			statement.setString(3, dto.getEmail());
			statement.setLong(4, dto.getPhoneNumber());
			statement.setLong(5, dto.getIsAdmin());
			statement.setString(6, dto.getUserName());
			statement.setString(7, dto.getPassword());
			statement.execute();
			dcm.commit();
		}catch(SQLException e){
			try{
				dcm.rollback();
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new RuntimeException(sqle);
			}//end of catch block 
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
				dcm.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end of catch block
		}//end of finally block 
		return null;
	}

	@Override
	public User create(User dto) {
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
	
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setString(1, dto.getFirstName());
			statement.setString(2, dto.getLastName());
			statement.setString(3, dto.getEmail());
			statement.setLong(4, dto.getPhoneNumber());
			statement.setLong(5, dto.getIsAdmin());
			statement.setString(6, dto.getUserName());
			statement.setString(7, dto.getPassword());
			statement.execute();
			dcm.commit();
		}catch(SQLException e){
			try{
				dcm.rollback();
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new RuntimeException(sqle);
			}//end of catch block 
	
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
				dcm.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end of catch block
		}//end of finally block 
		return null;
	}

	@Override
	public void delete(long id) {
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
		
		try(PreparedStatement statement = dcm.getPrepareStatement(DELETE)){
			statement.setLong(1,id);
			statement.execute();
			dcm.commit();
			
		}catch(SQLException e){
			try{
				dcm.rollback();
				
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new RuntimeException(sqle);
			}//end of catch block 
			
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}finally {
			try {
				dcm.closeConnection();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end of catch block
		}//end of finally block 
		
	}

	@Override
	public long getMaxId() {
		try(PreparedStatement statement = dcm.getPrepareStatement(MAX_ID)){
			ResultSet rs = statement.executeQuery();
			long max = 0;
			
			while(rs.next()) {
				max = rs.getLong("Largest");
			}//end of while loop

			return max;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public long getMinId() {
		try(PreparedStatement statement = dcm.getPrepareStatement(MIN_ID)){
			ResultSet rs = statement.executeQuery();
			long min = 0;
			
			while(rs.next()) {
				min = rs.getLong("Smallest");
			}//end of while loop

			return min;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}
	
	public List<User> getUsersInrange(int upperBound, int lowerBound){
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_USERS_IN_RANGE)){
			User user;
			
			List<User> userList =  new ArrayList<User>();
			statement.setLong(1, lowerBound);
			statement.setLong(2, upperBound);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getLong("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getLong("phone_number"));
				user.setIsAdmin(rs.getLong("is_admin"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password_"));
				
				userList.add(user);
			}//end of while loop

			return userList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	public boolean usernameExist(String username) {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_USER)){
		
			statement.setString(1, username);
		
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				return true;
			}//end of while loop

		

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 

		
		return false;
	}

}//end of UserDao class
