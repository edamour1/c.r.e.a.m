package cream.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreamHomePageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String joe = req.getParameter("name");
		
		System.out.println(joe);
		String htmlResponse = "<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"  <title>Bootstrap Example</title>\n" + 
				"  <meta charset=\"utf-8\">\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n" + 
				"  <style>\n" + 
				"    /* Remove the navbar's default rounded borders and increase the bottom margin */ \n" + 
				"    .navbar {\n" + 
				"      margin-bottom: 50px;\n" + 
				"      border-radius: 0;\n" + 
				"    }\n" + 
				"\n" + 
				"    /*Christ rules everything around me settings*/\n" + 
				"    #signature {\n" + 
				" 	position: relative;\n" + 
				"  	top: -26px;\n" + 
				"  	left: 30px;\n" + 
				"	font-size:30px; \n" + 
				"	color:Chocolate;\n" + 
				"    }\n" + 
				"    \n" + 
				"    #h1_cream{\n" + 
				"	position: relative;\n" + 
				"	left: 30px;\n" + 
				"	color:Chocolate;\n" + 
				"    }\n" + 
				"\n" + 
				"    #mission{\n" + 
				"	color:Chocolate;\n" + 
				"	}\n" + 
				"    \n" + 
				"\n" + 
				"    /* Remove the jumbotron's default bottom margin */ \n" + 
				"     .jumbotron {\n" + 
				"      margin-bottom: 0;\n" + 
				"      background-color: #000000;\n" + 
				"    }\n" + 
				"\n" + 
				"    .page_navigation{\n" + 
				"      margin-bottom: 0;\n" + 
				"      background-color: #ffffff;\n" + 
				"    }\n" + 
				"\n" + 
				"     #page_nav{\n" + 
				"	position: relative;\n" + 
				"  	left: 650px;\n" + 
				"	}\n" + 
				"   \n" + 
				"    /* Add a gray background color and some padding to the footer */\n" + 
				"    footer {\n" + 
				"      background-color: #f2f2f2;\n" + 
				"      padding: 25px;\n" + 
				"    }\n" + 
				"  </style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"\n" + 
				"<div class=\"jumbotron\">\n" + 
				"  <div class=\"container text-center\">\n" + 
				"    <h1 id =\"h1_cream\">C.R.E.A.M.</h1>\n" + 
				"    <p id=\"signature\">Christ Rules Everything Around Me</p>  \n" + 
				"    <p id=\"mission\">Mission, Vission & Values</p>\n" + 
				"  </div>\n" + 
				"</div>\n" + 
				"\n" + 
				"<nav class=\"navbar navbar-inverse\">\n" + 
				"  <div class=\"container-fluid\">\n" + 
				"    <div class=\"navbar-header\">\n" + 
				"      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n" + 
				"        <span class=\"icon-bar\"></span>\n" + 
				"        <span class=\"icon-bar\"></span>\n" + 
				"        <span class=\"icon-bar\"></span>                        \n" + 
				"      </button>\n" + 
				"      <a class=\"navbar-brand\" href=\"#\">Logo</a>\n" + 
				"    </div>\n" + 
				"    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n" + 
				"      <ul class=\"nav navbar-nav\">\n" + 
				"        <li class=\"active\"><a href=\"#\">Home</a></li>\n" + 
				"        <li><a href=\"/home/developer/revature workspace/c.r.e.a.m/cream_accessories_page.html\">Accessories</a></li>\n" + 
				"        <li><a href=\"/home/developer/revature workspace/c.r.e.a.m/cream_shirt_page.html\">Shirts</a></li>\n" + 
				"        <li><a href=\"/home/developer/revature workspace/c.r.e.a.m/cream_pants_page.html\">Pants</a></li>\n" + 
				"	<li><a href=\"/home/developer/revature workspace/c.r.e.a.m/cream_about_us_page.html\">About Us</a></li>\n" + 
				"      </ul>\n" + 
				"      <ul class=\"nav navbar-nav navbar-right\">\n" + 
				"        <li><a href=\"/home/developer/revature workspace/c.r.e.a.m//cream_login_page.html\"><span class=\"glyphicon glyphicon-user\"></span> Your Account</a></li>\n" + 
				"        <li><a href=\"/home/developer/revature workspace/c.r.e.a.m/cream_new_customer_billing_information_form.html\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> Cart</a></li>\n" + 
				"      </ul>\n" + 
				"    </div>\n" + 
				"  </div>\n" + 
				"</nav>\n" + 
				"\n" + 
				"<!-- Row -->\n" + 
				"<div class=\"container\">    \n" + 
				"  <div class=\"row\">\n" + 
				"\n" + 
				"  <div class=\"col-sm-4\">\n" + 
				"      <div class=\"panel panel-primary\">\n" + 
				"        <div class=\"panel-heading\">HOODIES</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"/home/developer/Downloads/FullSizeR.jpg\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"   </div>\n" + 
				"\n" + 
				"    <div class=\"col-sm-4\">   \n" + 
				"      <div class=\"panel panel-primary\">\n" + 
				"        <div class=\"panel-heading\">SHIRTS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"/home/developer/Downloads/FullSizeR.jpg\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"   \n" + 
				"   <div class=\"col-sm-4\"> \n" + 
				"      <div class=\"panel panel-danger\">\n" + 
				"        <div class=\"panel-heading\">SHIRTS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"https://placehold.it/150x80?text=IMAGE\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"\n" + 
				"    <div class=\"col-sm-4\"> \n" + 
				"      <div class=\"panel panel-success\">\n" + 
				"        <div class=\"panel-heading\">HATS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"https://placehold.it/150x80?text=IMAGE\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"\n" + 
				"    <div class=\"col-sm-4\"> \n" + 
				"      <div class=\"panel panel-success\">\n" + 
				"        <div class=\"panel-heading\">HATS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"https://placehold.it/150x80?text=IMAGE\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"\n" + 
				"   <div class=\"col-sm-4\"> \n" + 
				"      <div class=\"panel panel-success\">\n" + 
				"        <div class=\"panel-heading\">HATS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"https://placehold.it/150x80?text=IMAGE\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"   </div>\n" + 
				"\n" + 
				"\n" + 
				"    <div class=\"col-sm-4\"> \n" + 
				"      <div class=\"panel panel-success\">\n" + 
				"        <div class=\"panel-heading\">HATS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"https://placehold.it/150x80?text=IMAGE\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"\n" + 
				"    <div class=\"col-sm-4\"> \n" + 
				"      <div class=\"panel panel-success\">\n" + 
				"        <div class=\"panel-heading\">HATS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"https://placehold.it/150x80?text=IMAGE\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"\n" + 
				"   <div class=\"col-sm-4\"> \n" + 
				"      <div class=\"panel panel-success\">\n" + 
				"        <div class=\"panel-heading\">HATS</div>\n" + 
				"        <div class=\"panel-body\"><img src=\"https://placehold.it/150x80?text=IMAGE\" class=\"img-responsive\" style=\"width:100%\" alt=\"Image\"></div>\n" + 
				"        <div class=\"panel-footer\">Buy 50 mobiles and get a gift card</div>\n" + 
				"      </div>\n" + 
				"   </div>\n" + 
				"\n" + 
				"\n" + 
				"  </div>\n" + 
				"</div><br>\n" + 
				"\n" + 
				"<!--Page navigation-->\n" + 
				"\n" + 
				"<nav>\n" + 
				"	\n" + 
				"    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n" + 
				"	<ul class=\"nav navbar-nav\" id=\"page_nav\">\n" + 
				"	        <li class=\"active\"><a href=\"#\">1</a></li>\n" + 
				"	        <li><a href=\"#\">2</a></li>\n" + 
				"	        <li><a href=\"#\">3</a></li>\n" + 
				"	        <li><a href=\"#\">4</a></li>\n" + 
				"		<li><a href=\"#\">5</a></li>\n" + 
				"	</ul>\n" + 
				"	</div>\n" + 
				"</nav><br>\n" + 
				"\n" + 
				"<!-- Footer -->\n" + 
				"\n" + 
				"<footer class=\"container-fluid text-center\">\n" + 
				"  <p>Online Store Copyright</p>  \n" + 
				"  <form class=\"form-inline\">Get deals:\n" + 
				"    <input type=\"email\" class=\"form-control\" size=\"50\" placeholder=\"Email Address\">\n" + 
				"    <button type=\"button\" class=\"btn btn-danger\">Sign Up</button>\n" + 
				"  </form>\n" + 
				"</footer>\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>\n" + 
				"";
		
		PrintWriter writer = resp.getWriter();
		writer.write(htmlResponse);
		
	}

}
