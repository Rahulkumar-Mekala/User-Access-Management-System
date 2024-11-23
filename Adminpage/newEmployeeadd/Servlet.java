package newEmployeeadd;

import java.io.IOException;

import Register.UserBean;
import Register.UserBeanDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newregister")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            UserBean bean = new UserBean();
            bean.setUsername(request.getParameter("username"));
            bean.setPassword(request.getParameter("password"));
            bean.setRole(request.getParameter("role")); 
            
            int result = new UserBeanDAO().register(bean);
            
            if (result > 0) {
                request.setAttribute("completed", "Registration is successful. Your registration is pending approval from the manager.");
                request.getRequestDispatcher("newaddRegister.jsp").forward(request, response); 
            } else {
                request.setAttribute("msg", "Registration failed. Please try again.");
                request.getRequestDispatcher("Registerfail.jsp").forward(request, response);
            }
       
            
            request.setAttribute("msg", "An error occurred during registration. Please contact support.");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        
    }
}
