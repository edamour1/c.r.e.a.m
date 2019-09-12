package cream.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cream.model.Product;
import cream.repository.ProductDao;

public class ProductController {
	
	public Product process(int pageNumber) throws SQLException {
		
		ProductDao productDao = new ProductDao(); 
		Product product = productDao.findById(33);
		
		return product;
	}
	

}
