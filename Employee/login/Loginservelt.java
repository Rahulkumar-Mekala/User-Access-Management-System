package login;

import java.io.IOException;

import Register.UserBean;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class Loginservelt extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginDao loginDao = new LoginDao();
        UserBean userBean = loginDao.Login(username, password);

        if (userBean == null) {
            request.setAttribute("Msg", "Invalid username or password.");
            request.getRequestDispatcher("loginfail.jsp").forward(request, response);
        } else if (!"Approved".equalsIgnoreCase(userBean.getStatus())) { // Fixed null check
            request.setAttribute("Msg", "Login not allowed. Manager approval pending.");
            request.getRequestDispatcher("loginfail.jsp").forward(request, response);
        } else {
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("ubean", userBean);
            Cookie cookie = new Cookie("name", userBean.getUsername());
            response.addCookie(cookie);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
