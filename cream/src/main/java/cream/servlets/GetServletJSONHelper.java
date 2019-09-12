package cream.servlets;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cream.controller.LoginController;
import cream.controller.ProductController;
import cream.controller.factoryJSON;
import cream.model.Product;
import cream.model.User;

public class GetServletJSONHelper {
	
		public String process(HttpServletRequest req, HttpServletResponse res) throws SQLException {
			System.out.println("in GetServletJSONHelper");
			String response;
			
			switch(req.getRequestURI()) {
				case "/cream/user.get":
					System.out.println("/cream/user.get");
					
					factoryJSON <User> fju = new <User> 	factoryJSON();
					User user = (User) req.getSession().getAttribute("user");
					fju.setObj(user);
					
					response = fju.convertToJSON();
					return response;
				
				case "/cream/product.get":
					System.out.println("/cream/product.get");
					
					ProductController pc = new ProductController();
					
					Product product = pc.process(1);
					
					factoryJSON <Product> fjp = new <Product> factoryJSON();
					
					fjp.setObj(product);
					
					response = fjp.convertToJSON();
					
					return response;
					
				default:
					System.out.println("in default case");
					return "No  Object";

				}
		}
}
