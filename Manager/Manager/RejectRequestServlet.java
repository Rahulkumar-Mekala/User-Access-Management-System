package Manager;

import Register.UserBeanDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/rejectRequest")
public class RejectRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserBeanDAO userBeanDAO = new UserBeanDAO();

        int result = userBeanDAO.updateUserStatus(userId, "Rejected");

        if (result > 0) {
            response.sendRedirect("managerDashboard");
        } else {
            response.sendRedirect("managerDashboard?error=failed");
        }
    }
}
