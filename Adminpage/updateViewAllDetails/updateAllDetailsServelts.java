package updateViewAllDetails;

import java.io.IOException;
import java.util.ArrayList;

import Manager.ManagerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/AllViewDetails")
public class updateAllDetailsServelts  extends HttpServlet{
	@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	HttpSession httpSession = request.getSession(false);
	 if (httpSession ==null) {
		 request.setAttribute("msg", "Session Expired");
		 request.getRequestDispatcher("AdminroyalMsg.jsp").forward(request, response);
		
	} else {
		 ArrayList<ManagerBean> managerBeans = new updateviewAllDetails().retrieve();
		 httpSession.setAttribute("alist", managerBeans);
		 request.getRequestDispatcher("updateAllViewDetails.jsp").forward(request, response);

	}
}
	
	
}
