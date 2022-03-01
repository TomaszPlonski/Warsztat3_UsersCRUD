package pl.coderslab.workshop3.controlers;

import pl.coderslab.workshop3.domain.dao.UserDao;
import pl.coderslab.workshop3.domain.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class UserListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserDao.readAll();
        req.setAttribute("users",users);
        getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req,resp);
    }
}
