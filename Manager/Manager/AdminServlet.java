package Manager;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/managerlogin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String emailAddress = request.getParameter("username");
        String password = request.getParameter("password");

        ManagerBean managerBean = new AdminLoginDAO().Login(emailAddress, password);
        if (managerBean == null) {
            request.setAttribute("msg", "Invalid Login Process.");
            request.getRequestDispatcher("Manager_login.html").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("abean", managerBean);
            request.getRequestDispatcher("ManagerDashboard.jsp").forward(request, response);
        }
    }
}
