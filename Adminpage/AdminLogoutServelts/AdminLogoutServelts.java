package AdminLogoutServelts;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/AdminLogout")
public class AdminLogoutServelts extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		 
		HttpSession httpSession = request.getSession(false);
		if (httpSession==null) {
			request.setAttribute("msg","Session Expires..<br>");
			
		} else {
        httpSession.removeAttribute("abean");
        httpSession.invalidate();
        request.setAttribute("msg", "LoggedOut Successfully ...<br>");
		}
		request.getRequestDispatcher("AdminMsg.jsp").forward(request, response);
	}
 
}
