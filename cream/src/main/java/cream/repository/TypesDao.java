package cream.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Types;
import cream.util.Dao;

public class TypesDao extends Dao<Types>{
	
	private static final String INSERT = "INSERT INTO type_s (\n" + 
			"    type_id,\n" + 
			"    type_name,\n" + 
			"    sleeve_type\n" + 
			") VALUES (\n" + 
			"    TYPES_ID.nextval,\n" + 
			"    ?,\n" + 
			"    ?\n" + 
			")";
	
	private static final String UPDATE = "UPDATE Type_s\n" + 
			"SET type_name = ?, sleeve_type = ?\n" + 
			"WHERE type_id = ?";
	
	private static final String ID = "Select * FROM type_s\n" + 
			"WHERE type_id = ?";
	
	private static final String DELETE  = "DELETE FROM type_s WHERE type_id=?";
	
	private static final String GET_ALL_SLEEVES = "Select * FROM type_s";


	public TypesDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Types findById(long id) {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_SLEEVES)){
			Types type = new Types();
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				type = new Types();
				type.setTypeId(rs.getLong("TYPE_ID"));
				type.setTypeId(rs.getLong("SLEEVE_TYPE"));
				type.setTypeName(rs.getString("TYPE_NAME"));
			
			}//end of while loop

			return type;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public List<Types> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_SLEEVES)){
			Types type;
			
			List<Types> typesList =  new ArrayList<Types>();
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				type = new Types();
				
				type.setTypeId(rs.getLong("TYPE_ID"));
				type.setTypeId(rs.getLong("SLEEVE_TYPE"));
				type.setTypeName(rs.getString("TYPE_NAME"));
				typesList.add(type);
			}//end of while loop

			return typesList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public Types update(Types dto) {
		
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
		
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(2, dto.getSleeves());
			statement.setString(1, dto.getTypeName());
			statement.setLong(3, dto.getTypeId());
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
	public Types create(Types dto) {
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
		
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setString(1, dto.getTypeName());
			statement.setLong(2, dto.getSleeves());
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getMinId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
