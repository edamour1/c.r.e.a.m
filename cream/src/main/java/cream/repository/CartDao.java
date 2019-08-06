package cream.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cream.model.Cart;
import cream.model.User;
import cream.util.Dao;

public class CartDao extends Dao<Cart> {
	
	private static final String INSERT = "INSERT INTO cart (\n" + 
			"    cart_id,\n" + 
			"    user_id\n" + 
			") VALUES (\n" + 
			"    CART_ID.nextval,\n" + 
			"    ?\n" + 
			")";
	
	private static final String UPDATE = "UPDATE cart\n" + 
			"SET\n" + 
			"     user_id = ?\n" + 
			"WHERE\n" + 
			"    cart_id = ?";
	
	private static final String ID = "SELECT * FROM Cart\n" + 
			"WHERE cart_id = ?";
	
	private static final String DELETE  = "DELETE FROM Cart \n" + 
			"WHERE cart_id = ?";
	
	private static final String GET_ALL_CART = "SELECT * FROM cart";
	
	private static final String MAX_ID = "SELECT MAX(cart_id) AS Largest\n" + 
			"FROM cart";
	
	private static final String MIN_ID = "SELECT Min(cart_id) AS Smallest\n" + 
			"FROM cart";
	
	private static final String GET_ALL_CARTS_IN_RANGE = "SELECT * FROM cart\n" + 
			"WHERE cart_id BETWEEN ? AND ?";


	public CartDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cart findById(long id) {
		try(PreparedStatement statement = dcm.getPrepareStatement(ID)){
			Cart cart = new Cart();
			UserDao userDao = new UserDao();
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {;
				cart.setCartId(rs.getLong("CART_ID"));
				cart.setUserId(rs.getLong("USER_ID"));
				cart.setUser(userDao.findById(cart.getUserId()));  
			
			}//end of while loop

			return cart;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public List<Cart> findAll() {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_CART)){
			Cart cart;
			UserDao userDao = new UserDao();
			List<Cart> cartList = new ArrayList<Cart>();
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getLong("CART_ID"));
				cart.setUserId(rs.getLong("USER_ID"));
				cart.setUser(userDao.findById(cart.getUserId()));  
				cartList.add(cart);
				System.out.println(cart.getCartId());
			}//end of while loop

			return cartList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

	@Override
	public Cart update(Cart dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(UPDATE)){
			statement.setLong(2, dto.getCartId());
			statement.setLong(1, dto.getUserId());
					
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public Cart create(Cart dto) {
		try(PreparedStatement statement = dcm.getPrepareStatement(INSERT)){
			statement.setLong(1, dto.getUserId());
					
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
	
	public List<Cart> getdAllCartsInRange(int upperBound, int lowerBound) {
		try(PreparedStatement statement = dcm.getPrepareStatement(GET_ALL_CARTS_IN_RANGE)){
			statement.setLong(1, lowerBound);
			statement.setLong(2, upperBound);
			Cart cart;
			UserDao userDao = new UserDao();
			List<Cart> cartList = new ArrayList<Cart>();
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getLong("CART_ID"));
				cart.setUserId(rs.getLong("USER_ID"));
				cart.setUser(userDao.findById(cart.getUserId()));  
				cartList.add(cart);
			}//end of while loop

			return cartList;

		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}//end of catch block 
	}

}
