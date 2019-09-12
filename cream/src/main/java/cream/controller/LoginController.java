package cream.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import cream.model.User;
import cream.repository.UserDao;

public class LoginController {
	
	public String authenticate(HttpServletRequest request) {
		System.out.println("in authenticate method");
		if(!request.getMethod().equals("POST")) {
			return "resources/html/cream_login_page.html";
		}
		
		boolean isNull;
		
		try {
			UserDao userDao = new UserDao();
			User user = userDao.login(request.getParameter("usrname"), request.getParameter("psw"));
			
			isNull = user.getUserName() == null ? true : false; 
			
			if(!isNull) {
				request.getSession().setAttribute("user", user);
				System.out.println(!isNull);
				
				return "/home.login";
			}else {
				return "/invalid.login";
			}//end of else block
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of catch block
		
		return null;
	}

}
