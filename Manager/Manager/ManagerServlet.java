package Manager;

import java.io.IOException;
import java.util.List;
import Register.UserBean;
import Register.UserBeanDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserBean> pendingUsers = new UserBeanDAO().getPendingRequests();
        request.setAttribute("pendingUsers", pendingUsers);
        request.getRequestDispatcher("ManagerDashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String status = request.getParameter("status");

        int result = new UserBeanDAO().updateUserStatus(userId, status);

        if (result > 0) {
            response.sendRedirect("manager");
        } else {
            request.setAttribute("msg", "Error updating user status.");
            request.getRequestDispatcher("ManagerDashboard.jsp").forward(request, response);
        }
    }
}
