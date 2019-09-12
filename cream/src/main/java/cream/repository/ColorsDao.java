package cream.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Colors;
import cream.util.Dao;

public class ColorsDao extends Dao<Colors>{
	
	private static final String INSERT = "INSERT INTO colors (\n" + 
			"    color_id,\n" + 
			"    color\n" + 
			") VALUES (\n" + 
			"    COLOR_ID.nextval,\n" + 
			"    ? \n" + 
			")";
	private static final String UPDATE = "UPDATE Colors\n" + 
			"SET Color = ?\n" + 
			"WHERE color_id = ?";
	
	private static final String ID = "SELECT * FROM Colors\n" + 
			"WHERE color_id  = ?";
	
	private static final String DELETE  = "DELETE FROM colors\n" + 
			"WHERE\n" + 
			"    color_id = ?"; 
	
	private static final String GET_ALL_COLORS = "SELECT * FROM colors";
	
		protected static final String MAX_ID = "SELECT MAX(COLOR_ID) AS Largest\n" + 
	"FROM colors";

		protected static final String MIN_ID = "SELECT Min(COLOR_ID) AS Smallest\n" + 
	"FROM colors";
	
	
			
	public ColorsDao() throws SQLException {
		super();
	}

	@Override
	public Colors findById(long id) {
		Colors color = new Colors();
		
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				color.setColorId(rs.getLong("color_id"));
				color.setColor(rs.getString("color"));
			}//end of while loop

			return color;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 

	}

	@Override
	public List<Colors> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_COLORS)){
			Colors color;
			
			List<Colors> colorList =  new ArrayList<Colors>();
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				color = new Colors();
				color.setColorId(rs.getLong("color_id"));
				color.setColor(rs.getString("color"));
			
				
				colorList.add(color);
			}//end of while loop

			return colorList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public Colors update(Colors dto) {
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
		
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(2, dto.getColorId());
			statement.setString(1, dto.getColor());
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
	public Colors create(Colors dto) {
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
		
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setString(1, dto.getColor());
	
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
			
			long max = -1;
			
			ResultSet rs = statement.executeQuery();
			
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
			
			long min = -1;
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				min = rs.getLong("smallest");
			}//end of while loop

			return min;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

}
