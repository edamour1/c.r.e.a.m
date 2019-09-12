package cream.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import cream.model.User;

public class GetServletJSON extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		//loginServletHelper.process(req, res);
		System.out.println("inside LoginServletJSON");

		GetServletJSONHelper getServletJSONHelper = new GetServletJSONHelper();
		
		String response;
		try {
			response = getServletJSONHelper.process(req, res);
			
			res.setContentType("application/json;charset=UTF-8");
			
			PrintWriter out = res.getWriter();
		
			out.print(response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
