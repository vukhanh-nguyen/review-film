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

        // Pagination
        int limit = 5;

        int pagePost = 1;
        int pageUser = 1;

        int totalPagePost = (int) Math.ceil((double) postService.count() / limit);
        int totalPageUser = (int) Math.ceil((double) userService.count() / limit);
        try {
            if (req.getParameter("page_post") != null) {
                pagePost = Integer.parseInt(req.getParameter("page_post"));
            }
        } catch (Exception e) {
        }
        try {
            if (req.getParameter("page_user") != null) {
                pageUser = Integer.parseInt(req.getParameter("page_user"));
            }
        } catch (Exception e) {
        }


        req.setAttribute("posts", postService.findAll(pagePost, limit));
        req.setAttribute("totalPagePost", totalPagePost);
        req.setAttribute("currentPagePost", pagePost);

        req.setAttribute("users", userService.findAll(pageUser, limit));
        req.setAttribute("totalPageUser", totalPageUser);
        req.setAttribute("currentPageUser", pageUser);

        req.getRequestDispatcher("/views/admin/management.jsp").forward(req,resp);
    }
}
