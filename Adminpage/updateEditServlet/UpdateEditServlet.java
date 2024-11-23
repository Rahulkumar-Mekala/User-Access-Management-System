package updateEditServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Manager.ManagerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateedit")
public class UpdateEditServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        if (httpSession == null) {
            request.setAttribute("msg", "Session Expired<br>");
            request.getRequestDispatcher("AdminMsg.jsp").forward(request, response);
        } else {
            String email = request.getParameter("Email");
            ArrayList<ManagerBean> arrayList = (ArrayList<ManagerBean>) httpSession.getAttribute("alist");
            Iterator<ManagerBean> it = arrayList.iterator();
            while (it.hasNext()) {
                ManagerBean bean = it.next();
                if (email.equals(bean.getUsername())) {
                    request.setAttribute("ubean", bean);
                    request.getRequestDispatcher("updateEditDetails.jsp").forward(request, response);
                    break;
                }
            }
        }
    }
}
