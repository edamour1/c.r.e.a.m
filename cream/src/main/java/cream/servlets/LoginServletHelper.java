package cream.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import cream.controller.LoginController;

public class LoginServletHelper {
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
			case "/cream/login.login":
				System.out.println("in login.change rhelper");
				return "resources/html/cream_login_page.html";
				
			case "/cream/authenticate.login":
				System.out.println("in authenticate.login rhelper");
				LoginController loginController = new LoginController();
				
				return loginController.authenticate(request);
				
			case "/cream/home.login":
				System.out.println("in home.login rhelper");
				return "resources/html/cream_home_page.html";
				
			case "/cream/invalid.login":
				System.out.println("in invalid.login rhelper");
				return "resources/html/cream_login_invalid_username_page.html";
				
			case "/cream/get.user.login":
				System.out.println("in get.user.login rhelper");
				//GetUserController getUserController = new GetUserController();
				//getUserController.getUser(request, response);
				System.out.println("in get.user.login rhelper");
				
				
			default:
				System.out.println("in default case");
			return "";
			
		}

		
	}

}
