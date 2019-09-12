package cream.controller;

import com.google.gson.Gson;

public class factoryJSON <T>{
	
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	T obj;
	
	public String convertToJSON() {
		Gson json = new Gson();
		
		
		return json.toJson(getObj());
	}
	

}
