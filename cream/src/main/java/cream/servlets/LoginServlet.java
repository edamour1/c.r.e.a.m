package cream.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cream.model.User;

public class LoginServlet extends HttpServlet{
	private LoginServletHelper loginServletHelper = new LoginServletHelper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		System.out.println("in  doGet");
		
		switch(req.getRequestURI()) {
		case "/cream/home.login":
				
		default:
			req.getRequestDispatcher(loginServletHelper.process(req, res)).forward(req, res);
		}
		
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		System.out.println("in  doPost");
		
		req.getRequestDispatcher(loginServletHelper.process(req, res)).forward(req, res);
	}

}
