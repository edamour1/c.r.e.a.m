package cream.model;
// Generated Jul 22, 2019 1:47:01 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;

import cream.util.DataTransferObject;


public class SizeS implements java.io.Serializable, DataTransferObject {

	private long sizeId;
	private String sizeName;


	public SizeS() {
	}

	public SizeS(long sizeId, String sizeName) {
		this.sizeId = sizeId;
		this.sizeName = sizeName;
	}

	public SizeS(long sizeId, String sizeName, Set<Product> products) {
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		}

	public long getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(long sizeId) {
		this.sizeId = sizeId;
	}

	
	public String getSizeName() {
		return this.sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
