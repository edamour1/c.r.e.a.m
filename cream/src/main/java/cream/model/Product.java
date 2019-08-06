package cream.model;
// Generated Jul 22, 2019 1:47:01 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
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

public class Product implements java.io.Serializable, DataTransferObject {

	private long productId;
	private long colors;
	private long sizeS;
	private long typeS;
	private BigDecimal price;
	private long qty;
	private String pictureFilePath;

	public Product() {
	}

	public Product(long productId, long colors, long sizeS, long typeS, BigDecimal price, long qty,
			String pictureFilePath) {
		this.productId = productId;
		this.colors = colors;
		this.sizeS = sizeS;
		this.typeS = typeS;
		this.price = price;
		this.qty = qty;
		this.pictureFilePath = pictureFilePath;
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getColors() {
		return this.colors;
	}

	public void setColors(long colors) {
		this.colors = colors;
	}

	public long getSizeS() {
		return this.sizeS;
	}

	public void setSizeS(long sizeS) {
		this.sizeS = sizeS;
	}

	public long getTypeS() {
		return this.typeS;
	}

	public void setTypeS(long typeS) {
		this.typeS = typeS;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getQty() {
		return this.qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public String getPictureFilePath() {
		return this.pictureFilePath;
	}

	public void setPictureFilePath(String pictureFilePath) {
		this.pictureFilePath = pictureFilePath;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
