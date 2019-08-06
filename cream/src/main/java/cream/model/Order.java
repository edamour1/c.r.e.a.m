package cream.model;
// Generated Jul 22, 2019 1:47:01 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cream.util.DataTransferObject;


public class Order implements java.io.Serializable, DataTransferObject {

	private long orderId;
	private Product product;
	private long productId;
	private long qty;
	private long cartId;
	private int shipped;
	
	public int getShipped() {
		return shipped;
	}

	public void setShipped(int shipped) {
		this.shipped = shipped;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	
	

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Order() {
	}

	public Order(long orderId, Product product, long qty) {
		this.orderId = orderId;
		this.product = product;
		this.qty = qty;
	}

	public Order(long orderId, Product product, long qty, Set<OrderHistory> orderHistories) {
		this.orderId = orderId;
		this.product = product;
		this.qty = qty;

	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQty() {
		return this.qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}



}
