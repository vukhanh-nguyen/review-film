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

@WebServlet(urlPatterns = {"/admin-manage-post"})
public class AdminManagePost extends HttpServlet {


    IPostService postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Pagination
        int limit = 5;

        int page = 1;

        int totalPagePost = (int) Math.ceil((double) postService.count() / limit);
        try {
            if (req.getParameter("page") != null) {
                page = Integer.parseInt(req.getParameter("page"));
            }
        } catch (Exception e) {
        }

        req.setAttribute("posts", postService.findAll(page, limit));
        req.setAttribute("totalPage", totalPagePost);
        req.setAttribute("currentPage", page);

        req.getRequestDispatcher("/views/admin/managePost.jsp").forward(req,resp);
    }
}
