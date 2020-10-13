package com.citynow.controller.admin;

import com.citynow.service.IPostService;
import com.citynow.service.IUserService;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-management"})
public class AdminManagement extends HttpServlet {

    IUserService userService = new UserServiceImpl();

    IPostService postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("posts", postService.findAll());
        req.setAttribute("users", userService.findAll());
        req.getRequestDispatcher("/views/admin/management.jsp").forward(req,resp);
    }
}
