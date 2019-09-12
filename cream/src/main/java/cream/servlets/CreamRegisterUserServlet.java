package cream.servlets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cream.repository.UserDao;
import cream.util.DataConnectionManager;
import cream.model.User;
import oracle.net.aso.l;

public class CreamRegisterUserServlet extends HttpServlet{
	private String path = "/home/developer/revature workspace/cream/c.r.e.a.m/cream/src/main/webapp/html/user_register_page.html";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName, lastName, email, phoneNumber, justNumbers = "", userName, password, verifyPassword, htmlResponse = "";
		firstName = req.getParameter("first_name");
		lastName = req.getParameter("last_name");
		email = req.getParameter("email");
		phoneNumber = req.getParameter("phone");
		userName = req.getParameter("usrname");
		password = req.getParameter("psw");
		
		
		for(int i = 0; i < phoneNumber.length(); i++){
            if(phoneNumber.charAt(i) != '-') {
            	justNumbers += phoneNumber.charAt(i);
            		}
        	}
			
			User user = new User();
			
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPhoneNumber(Long.parseLong(justNumbers));
			user.setUserName(userName);
			user.setPassword(password);
			user.setIsAdmin(0L);
			
			System.out.println("Made it");
			
			System.out.println("first = "+user.getFirstName());
			System.out.println("last = "+user.getLastName());
			System.out.println("email = "+user.getEmail());
			System.out.println("phoneNumber = "+user.getPhoneNumber());
			System.out.println("userName = "+user.getUserName());
			System.out.println("password = "+user.getPassword());
			
			try {
				UserDao userDao = new UserDao();
				
				if(false == userDao.usernameExist(user.getUserName())) {
					System.out.println("Does username exist "+userDao.usernameExist(user.getUserName()));
					userDao.create(user);
					htmlResponse = getHTMLString(path,"User Registered.");
				}else {
					htmlResponse = getHTMLString(path,"The Username is not available.");
				}//end of else statement
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
		
				PrintWriter writer = resp.getWriter();
				writer.write(htmlResponse);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String htmlResponse = getHTMLString(path,"Fill out the and submit the form below.");
		
		PrintWriter writer = resp.getWriter();
		
		writer.write(htmlResponse);
	}
	
	public String getHTMLString(String filePath, String replace) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "", page;
		StringBuffer buffer = new StringBuffer();
		
		while((line=reader.readLine()) != null){
			buffer.append(line);
			}
		
		reader.close();
		page = buffer.toString();
		
		page = MessageFormat.format(page, replace);
		System.out.println(page);
		return page;
		}//end of getHTMLString method

}
