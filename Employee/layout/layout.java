package layout;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Logout")
public class layout  extends HttpServlet{
	 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 Cookie[] cookies = request.getCookies();
		 if (cookies==null) {
			 request.setAttribute("msg", "Seasion Expried...");
					
		} else {
         cookies[0].setMaxAge(0);
         response.addCookie(cookies[0]);
         request.setAttribute("Msg","UserLogout");
		}
		 request.getRequestDispatcher("loginfail.jsp").forward(request, response);
			
	 }

}
