package cream.repository;

import cream.util.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Order;
import cream.model.OrderHistory;
import cream.model.Product;


public class OrderDao extends Dao<Order>{
	
	private static final String INSERT = "INSERT INTO order_ (\n" + 
			"    order_id,\n" + 
			"    product_id,\n" + 
			"    qty,\n" + 
			"    cart_id,\n" + 
			"    shipped\n" + 
			") VALUES (\n" + 
			"    ORDER_ID.nextval ,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?\n" + 
			")";
	
	private static final String UPDATE = "UPDATE order_\n" + 
			"SET product_id = ?, cart_id = ?, qty = ?, shipped = ? \n" + 
			"WHERE order_id = ?";
	
	private static final String ID = "SELECT * FROM order_\n" + 
			"WHERE order_id = ?";
	
	private static final String DELETE  = "DELETE FROM order_ WHERE order_id = ?";
	
	private static final String GET_ALL_ORDERS = "SELECT * FROM order_";

	private static final String MAX_ID  = "SELECT Max(order_ID) AS Largest\n" + 
			"FROM order_";
	
	private static final String MIN_ID = "SELECT Min(order_ID) AS Smallest\n" + 
			"FROM order_";
	
	private static final String GET_ALL_ORDERS_IN_RANGE = "SELECT * FROM order_\n" + 
			"WHERE order_id BETWEEN ? AND ?";

	public OrderDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Order findById(long id) {
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			Order order = new Order();
			Product product;
			ProductDao productDao = new ProductDao();
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				order.setOrderId(rs.getLong("ORDER_ID"));
				order.setCartId(rs.getLong("CART_ID"));
				order.setProductId(rs.getLong("PRODUCT_ID"));
				order.setQty(rs.getLong("QTY"));
				order.setShipped(rs.getInt("SHIPPED"));
				order.setProduct(productDao.findById(order.getProductId()));
			
			}//end of while loop

			return order;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public List<Order> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_ORDERS)){
			Order order;
			Product product;
			ProductDao productDao = new ProductDao();
			List<Order> orderList = new ArrayList<Order>();
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				order = new Order();
				order.setOrderId(rs.getLong("ORDER_ID"));
				order.setCartId(rs.getLong("CART_ID"));
				order.setProductId(rs.getLong("PRODUCT_ID"));
				order.setQty(rs.getLong("QTY"));
				order.setShipped(rs.getInt("SHIPPED"));
				order.setProduct(productDao.findById(order.getProductId()));
				orderList.add(order);
			}//end of while loop

			return orderList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public Order update(Order dto) {
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
		
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(2, dto.getCartId());
			statement.setLong(1, dto.getProductId());
			statement.setLong(3, dto.getQty());
			statement.setInt(4, dto.getShipped());
			statement.setLong(5, dto.getOrderId());
					
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
	public Order create(Order dto) {
		try{
			dcm.setAutoCommitFalse();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block
		
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setLong(1, dto.getProductId());
			statement.setLong(2, dto.getQty());
			statement.setLong(3, dto.getCartId());
			statement.setInt(4, dto.getShipped());
			
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
	
	public List<Order> getAllOrdersInRangeint(int upperBound, int lowerBound){
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_ORDERS_IN_RANGE)){
			statement.setLong(1, lowerBound);
			statement.setLong(2, upperBound);
			Order order;
			Product product;
			ProductDao productDao = new ProductDao();
			List<Order> orderList = new ArrayList<Order>();
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				order = new Order();
				order.setOrderId(rs.getLong("ORDER_ID"));
				order.setCartId(rs.getLong("CART_ID"));
				order.setProductId(rs.getLong("PRODUCT_ID"));
				order.setQty(rs.getLong("QTY"));
				order.setShipped(rs.getInt("SHIPPED"));
				order.setProduct(productDao.findById(order.getProductId()));
				orderList.add(order);
			}//end of while loop

			return orderList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

}
