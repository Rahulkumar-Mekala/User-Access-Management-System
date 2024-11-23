package EditUpdateProfile;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditProfile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            request.setAttribute("Msg", "Session Expired...");
            request.getRequestDispatcher("loginfail.jsp").forward(request, response);
        } else {
            String value = cookies[0].getValue();
            request.setAttribute("fname", value);
            request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
        }
    }
}
