package cream.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao <T extends DataTransferObject>{
	
	//Coinnection for jdbc
	protected final DataConnectionManager dcm;
/*	protected static final String MAX_ID = "SELECT MAX(?) AS Largest\n" + 
			"FROM ?";
	
	protected static final String MIN_ID = "SELECT Min(?) AS Smallest\n" + 
			"FROM ?";*/
	
	public Dao() throws SQLException {
		super();
		dcm = new DataConnectionManager();
	}//end of constructor
	
	public abstract T findById(long id);
	public abstract List<T> findAll();
	public abstract T update(T dto);
	public abstract T create(T dto);
	public abstract void delete(long id);
	public abstract long getMaxId();
	public abstract long getMinId();
	
	
	
	

}
