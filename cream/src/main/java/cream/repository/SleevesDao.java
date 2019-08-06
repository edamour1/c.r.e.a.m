package cream.repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Colors;
import cream.model.SizeS;
import cream.model.Sleeves;
import cream.util.Dao;

public class SleevesDao extends Dao<Sleeves> {
	private static final String INSERT = "INSERT INTO sleeves (\n" + 
			"    sleeve_id,\n" + 
			"    sleeve_name\n" + 
			") VALUES (\n" + 
			"    SLEEVES_ID.nextval,\n" + 
			"    ?\n" + 
			")";
	
	private static final String UPDATE = "UPDATE sleeves\n" + 
			"SET\n" + 
			"     sleeve_name = ?\n" + 
			"WHERE\n" + 
			"    sleeve_id = ?";
	
	private static final String ID = "SELECT * FROM sleeves\n" + 
			"WHERE sleeve_id = ?";
	
	private static final String DELETE  = "DELETE FROM SLEEVES WHERE sleeve_id = ?";
	
	private static final String GET_ALL_SLEEVES = "SELECT * FROM sleeves";


	public SleevesDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sleeves findById(long id) {
		Sleeves sleeve = new Sleeves();
		
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				sleeve.setSleeveId(rs.getLong("SLEEVE_ID"));
				sleeve.setSleeveName(rs.getString("SLEEVE_NAME"));
			}//end of while loop

			return sleeve;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public List<Sleeves> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_SLEEVES)){
			Sleeves sleeve;
			
			List<Sleeves> sleeveList =  new ArrayList<Sleeves>();
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				sleeve = new Sleeves();
				sleeve.setSleeveId(rs.getLong("sleeve_id"));
				sleeve.setSleeveName(rs.getString("sleeve_name"));
			
				sleeveList.add(sleeve);
			}//end of while loop

			return sleeveList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public Sleeves update(Sleeves dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(2, dto.getSleeveId());
			statement.setString(1, dto.getSleeveName());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Sleeves create(Sleeves dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setString(1, dto.getSleeveName());
			
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public void delete(long id){
		try(PreparedStatement statement = dcm.getPrepareStatement(DELETE)){
			statement.setLong(1,id);
			statement.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
		
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
