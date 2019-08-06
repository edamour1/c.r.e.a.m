package cream.repository;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Order;
import cream.model.OrderHistory;
import cream.model.Product;
import cream.model.User;
import cream.util.Dao;

public class OrderHistoryDao extends Dao<OrderHistory>{
	
	private static final String INSERT = "INSERT INTO order_history (\n" + 
			"    order_history_id,\n" + 
			"    cart_id,\n" + 
			"    date_,\n" + 
			"    street_address,\n" + 
			"    city,\n" + 
			"    state_,\n" + 
			"    zip_code\n" + 
			") VALUES (\n" + 
			"    ORDER_HISTORY_ID.nextval,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?,\n" + 
			"    ?\n" + 
			")";
	
	private static final String GET_ORDERS_BASED_OFF_CARTID = "SELECT * FROM order_\n" + 
			"WHERE cart_id = ?";
	
	private static final String UPDATE = "UPDATE order_history\n" + 
			"SET\n" + 
			"    cart_id =?,\n" + 
			"    date_ =?,\n" + 
			"    street_address =?,\n" + 
			"    city =?,\n" + 
			"    state_ =?,\n" + 
			"    zip_code =?\n" + 
			"WHERE\n" + 
			"    order_history_id =?";
	
	private static final String ID = "SELECT * FROM order_history\n" + 
			"WHERE order_history_id = ?";
	
	private static final String DELETE  = "DELETE FROM order_history \n" + 
			"WHERE order_history_id = ?";
	
	private static final String GET_ALL_ORDER_HISTORIES = "SELECT * FROM order_history";
	
	private static final String MAX_ID  = "SELECT max(order_history_id) AS Largest\n" + 
			"FROM order_history";
	
	private static final String MIN_ID = "SELECT Min(order_history_id) AS Smallest\n" + 
			"FROM order_history";
	
	private static final String GET_ALL_ORDER_HISTORIES_IN_RANGE = "SELECT * FROM order_history\n" + 
			"WHERE order_history_id BETWEEN ? AND ?";

	public OrderHistoryDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrderHistory findById(long id) {
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			OrderHistory orderHistory = new OrderHistory();
			
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				orderHistory.setOrderHistoryId(rs.getLong("ORDER_HISTORY_ID"));
				orderHistory.setCartId(rs.getLong("CART_ID"));
				orderHistory.setDate(rs.getDate("DATE_"));
				orderHistory.setStreetAddress(rs.getString("STREET_ADDRESS"));
				orderHistory.setCity(rs.getString("CITY"));
				orderHistory.setState("STATE_");
				orderHistory.setZipcode("ZIP_CODE");
			}//end of while loop

			return orderHistory;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public List<OrderHistory> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_ORDER_HISTORIES)){
			OrderHistory orderHistory;
			OrderDao orderDao = new OrderDao();
			List<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();
			 
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				orderHistory = new OrderHistory();
				orderHistory.setOrderHistoryId(rs.getLong("ORDER_HISTORY_ID"));
				orderHistory.setCartId(rs.getLong("CART_ID"));
				orderHistory.setDate(rs.getDate("DATE_"));
				orderHistory.setStreetAddress(rs.getString("STREET_ADDRESS"));
				orderHistory.setCity(rs.getString("CITY"));
				orderHistory.setState("STATE_");
				orderHistory.setZipcode("ZIP_CODE");
				orderHistory.setOrderList(getOrders(orderHistory.getCartId()));
				
				orderHistoryList.add(orderHistory);
			}//end of while loop

			return orderHistoryList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
		
	}
	
	public List<Order> getOrders(long cartId) {
		List<Order> orderList = new ArrayList<Order>();
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ORDERS_BASED_OFF_CARTID)){
			OrderHistory orderHistory = new OrderHistory();
			Order order;
			OrderDao orderDao = new OrderDao();
			statement.setLong(1, cartId);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				order = new Order();
				order = orderDao.findById(rs.getLong("ORDER_ID"));
				orderList.add(order);
			}//end of while loop

			return orderList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
		
	}

	@Override
	public OrderHistory update(OrderHistory dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(7, dto.getOrderHistoryId());
			statement.setLong(1, dto.getCartId());
			statement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			statement.setString(3, dto.getStreetAddress());
			statement.setString(4, dto.getCity());
			statement.setString(5, dto.getState());
			statement.setString(6, dto.getZipcode());
					
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public OrderHistory create(OrderHistory dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setLong(1, dto.getCartId());
			statement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			statement.setString(3, dto.getStreetAddress());
			statement.setString(4, dto.getCity());
			statement.setString(5, dto.getState());
			statement.setString(6, dto.getZipcode());
			
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
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
	
	public List<OrderHistory> getOrderHistoriesInrange(int upperBound, int lowerBound){
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_ORDER_HISTORIES_IN_RANGE)){
			OrderHistory orderHistory;
			statement.setLong(1, lowerBound);
			statement.setLong(2, upperBound);
			OrderDao orderDao = new OrderDao();
			List<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();
			 
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				orderHistory = new OrderHistory();
				orderHistory.setOrderHistoryId(rs.getLong("ORDER_HISTORY_ID"));
				orderHistory.setCartId(rs.getLong("CART_ID"));
				orderHistory.setDate(rs.getDate("DATE_"));
				orderHistory.setStreetAddress(rs.getString("STREET_ADDRESS"));
				orderHistory.setCity(rs.getString("CITY"));
				orderHistory.setState("STATE_");
				orderHistory.setZipcode("ZIP_CODE");
				orderHistory.setOrderList(getOrders(orderHistory.getCartId()));
				
				orderHistoryList.add(orderHistory);
			}//end of while loop

			return orderHistoryList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}
	
	

}
