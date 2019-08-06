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

public class Types implements java.io.Serializable, DataTransferObject {

	private long typeId;
	private long sleeves;
	private String typeName;

	public Types() {
	}

	public Types(long typeId, long sleeves, String typeName) {
		this.typeId = typeId;
		this.sleeves = sleeves;
		this.typeName = typeName;
	}

	public Types(long typeId, long sleeves, String typeName, Set<Product> products) {
		this.typeId = typeId;
		this.sleeves = sleeves;
		this.typeName = typeName;
	}

	public long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public long getSleeves() {
		return this.sleeves;
	}

	public void setSleeves(long sleeves) {
		this.sleeves = sleeves;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
