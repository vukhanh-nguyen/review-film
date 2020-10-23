package com.citynow.controller.user;

import com.citynow.model.UserModel;
import com.citynow.service.IPostService;
import com.citynow.service.IVoteService;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.VoteServiceImpl;
import com.citynow.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/list-posts"})
public class ListPostController extends HttpServlet {

    IPostService postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null) {
            req.setAttribute("message", message);
        }
        UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "LOGIN");

        // Pagination
        int limit = 5;

        int page = 1;

        int totalPageUrPost = (int) Math.ceil((double) postService.countByUserId(model.getId()) / limit);
        try {
            if (req.getParameter("page") != null) {
                page = Integer.parseInt(req.getParameter("page"));
            }
        } catch (Exception e) {
        }

        req.setAttribute("yourposts", postService.findAllByUserId(model.getId(), page, limit));
        req.setAttribute("totalPage", totalPageUrPost);
        req.setAttribute("currentPage", page);

        req.getRequestDispatcher("/views/user/listPost.jsp").forward(req, resp);
    }
}
