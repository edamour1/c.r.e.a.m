package cream.model;
// Generated Jul 22, 2019 1:47:01 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import cream.util.DataTransferObject;


public class Sleeves implements java.io.Serializable, DataTransferObject {

	private long sleeveId;
	private String sleeveName;

	public Sleeves() {
	}

	public Sleeves(long sleeveId, String sleeveName) {
		this.sleeveId = sleeveId;
		this.sleeveName = sleeveName;
	}

	public Sleeves(long sleeveId, String sleeveName, Set<Types> typeSs) {
		this.sleeveId = sleeveId;
		this.sleeveName = sleeveName;
	}

	public long getSleeveId() {
		return this.sleeveId;
	}

	public void setSleeveId(long sleeveId) {
		this.sleeveId = sleeveId;
	}

	public String getSleeveName() {
		return this.sleeveName;
	}

	public void setSleeveName(String sleeveName) {
		this.sleeveName = sleeveName;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}


}
