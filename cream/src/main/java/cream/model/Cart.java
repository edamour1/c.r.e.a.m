package cream.model;
// Generated Jul 22, 2019 1:47:01 PM by Hibernate Tools 5.2.12.Final


import cream.util.DataTransferObject;

public class Cart implements java.io.Serializable, DataTransferObject {

	private long userId;
	private User user;
	private long cartId;

	public Cart() {
	}

	public Cart(User user, long cartId) {
		this.user = user;
		this.cartId = cartId;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCartId() {
		return this.cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
