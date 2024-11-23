package Register;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
            UserBean bean = new UserBean();
            bean.setUsername(request.getParameter("username"));
            bean.setPassword(request.getParameter("password"));
            bean.setRole(request.getParameter("role")); 
            bean.setStatus("pending");
            
            int result = new UserBeanDAO().register(bean);
            
            if (result > 0) {
                request.setAttribute("completed", "Registration is successful. Your registration is pending approval from the manager.");
                request.getRequestDispatcher("Register.jsp").forward(request, response); 
                
              
            } else {
                request.setAttribute("msg", "Registration failed. Please try again. ");
                request.getRequestDispatcher("Registerfail.jsp").forward(request, response);
            }
        
              
    }
}
