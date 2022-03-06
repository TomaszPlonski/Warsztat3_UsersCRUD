package pl.coderslab.workshop3.controlers;

import pl.coderslab.workshop3.domain.dao.UserDao;
import pl.coderslab.workshop3.domain.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class UserEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null){
            resp.sendRedirect("/list");
        } else {
            User user = UserDao.read(Integer.parseInt(id));
            if (user == null){
                resp.sendRedirect("/list");
            } else {
                req.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User newUser = new User(userName,email,password);
        newUser.setId(Integer.parseInt(req.getParameter("id")));

        UserDao.updateUser(newUser);

        resp.sendRedirect("/list");
    }
}
