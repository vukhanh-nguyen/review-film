package com.citynow.controller.user;

import com.citynow.model.UserModel;
import com.citynow.service.IUserService;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.SessionUtil;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null) {
            req.setAttribute("message", message);
        }

        //resp.sendRedirect(req.getContextPath() + "/home");
        req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserModel model = userService.fineOneByUsername(username);
        if (model != null && !BCrypt.checkpw(password,model.getPassword())){
            model = null;
        }
        if (model != null) {
            SessionUtil.getInstance().putValue(req, "LOGIN", model);
            if (model.getRole().getCode().equals("USER")) {
                resp.sendRedirect(req.getContextPath() + "/home");
            } else if (model.getRole().getCode().equals("ADMIN")) {
                resp.sendRedirect(req.getContextPath() + "/admin-management");
            }
        } else {
            //resp.sendRedirect(req.getContextPath() + "/login");
            req.setAttribute("message", "wrong-account");
            req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
        }
    }
}
