package pl.coderslab.workshop3.controlers;

import pl.coderslab.workshop3.domain.dao.UserDao;
import pl.coderslab.workshop3.domain.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show")
public class UserDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null){
            resp.sendRedirect("/WEB-INF/views/list.jsp");
        } else {
            User user = UserDao.read(Integer.parseInt(id));
            req.setAttribute("user",user);
            getServletContext().getRequestDispatcher("/WEB-INF/views/show.jsp").forward(req,resp);
        }
    }
}