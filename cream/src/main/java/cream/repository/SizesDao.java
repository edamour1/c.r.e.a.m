package cream.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.SizeS;
import cream.util.Dao;

public class SizesDao extends Dao<SizeS>{
	
	private static final String INSERT = "INSERT INTO size_s (\n" + 
			"    size_id,\n" + 
			"    size_name\n" + 
			") VALUES (\n" + 
			"    SIZE_ID.nextval,\n" + 
			"    ? \n" + 
			")";
	
	private static final String UPDATE = "UPDATE size_s\n" + 
			"SET size_name = ?\n" + 
			"WHERE size_id = ?";
	
	private static final String ID = "SELECT * FROM size_s\n" + 
			"WHERE size_id= ?";
	
	private static final String DELETE  = "DELETE FROM size_s WHERE size_id = ?";
	
	private static final String GET_ALL_SIZES = "SELECT * FROM size_s";

	public SizesDao() throws SQLException {
		super();
	}

	@Override
	public SizeS findById(long id) {
		SizeS size = new SizeS();
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				size.setSizeId(rs.getLong("size_id"));
				size.setSizeName(rs.getString("size_name"));
			}//end of while loop

			return size;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public List<SizeS> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_SIZES)){
			SizeS size;
			
			List<SizeS> sizesList =  new ArrayList<SizeS>();
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				size = new SizeS();
				size.setSizeId(rs.getLong("size_id"));
				size.setSizeName(rs.getString("size_name"));
			
				sizesList.add(size);
			}//end of while loop

			return sizesList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public SizeS update(SizeS dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(2, dto.getSizeId());
			statement.setString(1, dto.getSizeName());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public SizeS create(SizeS dto){
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setString(1, dto.getSizeName());
			
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public void delete(long id) {
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
