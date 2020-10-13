package com.citynow.controller.user;

import com.citynow.model.UserModel;
import com.citynow.service.IUserService;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.SessionUtil;

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
        req.getRequestDispatcher("/views/user/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserModel model = userService.fineOneByUsernameAndPassword(username, password);
        if (model != null) {
            SessionUtil.getInstance().putValue(request, "LOGIN", model);
            if (model.getRole().getCode().equals("USER")) {
                response.sendRedirect(request.getContextPath()+"/home");
            } else if (model.getRole().getCode().equals("ADMIN")) {
                response.sendRedirect(request.getContextPath()+"/admin-management");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
}
