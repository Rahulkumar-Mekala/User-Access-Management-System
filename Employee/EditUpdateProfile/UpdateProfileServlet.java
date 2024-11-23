package EditUpdateProfile;

import java.io.IOException;

import Register.UserBean;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Cookie[] cookies = request.getCookies();

      
        if (cookies == null) {
            request.setAttribute("msg", "Session Expired...");
            request.getRequestDispatcher("msg.jsp").forward(request, response);
        } else {
           
            String value = cookies[0].getValue();
            request.setAttribute("fname", value); 

            
            ServletContext servletContext = request.getServletContext();
            UserBean bean = (UserBean) servletContext.getAttribute("ubean");
 
            bean.setPassword(request.getParameter("password"));
           
                int k = new UpdateProfileDAO().update(bean);

                 
                    if (k > 0) {
                        request.setAttribute("msg", "Profile updated successfully.");
                        request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
                    }
        }
    }
}
