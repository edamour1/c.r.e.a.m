package cream.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Product;
import cream.util.Dao;

public class ProductDao extends Dao<Product>{
	
	private static final String INSERT = "INSERT INTO product (\n" + 
			"    product_id,\n" + 
			"    type_,\n" + 
			"    size_,\n" + 
			"    color,\n" + 
			"    price,\n" + 
			"    qty,\n" + 
			"    picture_file_path\n" + 
			") VALUES (\n" + 
			"    PRODUCT_ID.nextval,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?\n" + 
			")";
	
	private static final String UPDATE = "UPDATE product\n" + 
			"SET\n" + 
			"    type_ = ?,\n" + 
			"    size_ = ?,\n" + 
			"    color = ?,\n" + 
			"    price = ?,\n" + 
			"    qty = ?,\n" + 
			"    picture_file_path = ?\n" + 
			"WHERE\n" + 
			"    product_id = ?";
	
	private static final String ID = "SELECT * FROM Product\n" + 
			"WHERE product_id = ?\n";
	
	private static final String DELETE  = "DELETE FROM product\n" + 
			"WHERE\n" + 
			"    product_id = ?";
	
	private static final String GET_ALL_PRODUCTS = "SELECT * FROM Product";
	
	private static final String GET_ALL_PRODUCTS_IN_RANGE = "SELECT * FROM product\n" + 
			"WHERE \n" + 
			"product_id >= ? AND \n" + 
			"      type_ = ? AND \n" + 
			"   product_id <= ?";
	
	private static final String MAX_ID  = "SELECT max(product_id) AS Largest\n" + 
			"FROM product";
	
	private static final String MIN_ID = "SELECT min(product_id) AS Smallest\n" + 
			"FROM product";

	


	public ProductDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product findById(long id) {
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			Product product = new Product();
			
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getLong("PRODUCT_ID"));
				product.setTypeS(rs.getLong("TYPE_"));
				product.setSizeS(rs.getLong("SIZE_"));
				product.setColors(rs.getLong("COLOR"));
				product.setPrice(rs.getBigDecimal("PRICE"));
				product.setQty(rs.getLong("QTY"));
				product.setPictureFilePath(rs.getString("PICTURE_FILE_PATH"));
			
			}//end of while loop

			return product;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public List<Product> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_PRODUCTS)){
			Product product = new Product();
			List <Product> productList = new ArrayList<Product>();
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getLong("PRODUCT_ID"));
				product.setTypeS(rs.getLong("TYPE_"));
				product.setSizeS(rs.getLong("SIZE_"));
				product.setColors(rs.getLong("COLOR"));
				product.setPrice(rs.getBigDecimal("PRICE"));
				product.setQty(rs.getLong("QTY"));
				product.setPictureFilePath(rs.getString("PICTURE_FILE_PATH"));
				
				productList.add(product);
			
			}//end of while loop

			return productList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public Product update(Product dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(7, dto.getProductId());
			statement.setLong(1, dto.getTypeS());
			statement.setLong(2, dto.getSizeS());
			statement.setLong(3, dto.getColors());
			statement.setBigDecimal(4, dto.getPrice());
			statement.setLong(5, dto.getQty());
			statement.setString(6,dto.getPictureFilePath());
					
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Product create(Product dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setLong(1, dto.getTypeS());
			statement.setLong(2, dto.getSizeS());
			statement.setLong(3, dto.getColors());
			statement.setBigDecimal(4, dto.getPrice());
			statement.setLong(5, dto.getQty());
			statement.setString(6,dto.getPictureFilePath());
					
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
	
	public List<Product> getProductsInrange(int upperBound, int lowerBound, int typeId){
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_PRODUCTS_IN_RANGE)){
			Product product = new Product();
			List <Product> productList = new ArrayList<Product>();
			
			statement.setLong(1, lowerBound);
			statement.setLong(2, typeId);
			statement.setLong(3, upperBound);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getLong("PRODUCT_ID"));
				product.setTypeS(rs.getLong("TYPE_"));
				product.setSizeS(rs.getLong("SIZE_"));
				product.setColors(rs.getLong("COLOR"));
				product.setPrice(rs.getBigDecimal("PRICE"));
				product.setQty(rs.getLong("QTY"));
				product.setPictureFilePath(rs.getString("PICTURE_FILE_PATH"));
				
				productList.add(product);
			
			}//end of while loop

			return productList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
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
	
}
