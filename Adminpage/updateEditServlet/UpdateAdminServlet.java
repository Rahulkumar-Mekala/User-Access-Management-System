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
@WebServlet("/adminupdateprofile")
public class UpdateAdminServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        if (httpSession == null) {
            request.setAttribute("msg", "Session Expired<br>");
            request.getRequestDispatcher("AdminMsg.jsp").forward(request, response);
        } else {
            ArrayList<ManagerBean> arrayList = (ArrayList<ManagerBean>) httpSession.getAttribute("alist");

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            Iterator<ManagerBean> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                ManagerBean managerBean = iterator.next();
                if (username.equals(managerBean.getUsername())) {
                    managerBean.setUsername(username);
                    managerBean.setPassword(password);
                    managerBean.setRole(role);

                    // Update the database using the DAO method
                    int k = new AdminUpdateDao().update(managerBean);
                    if (k > 0) {
                        request.setAttribute("msg", "Update Successfully completed.<br>");
                        request.getRequestDispatcher("AdminUpdate.jsp").forward(request, response);
                    }
                    break;
                }
            }
        }
    }
}
