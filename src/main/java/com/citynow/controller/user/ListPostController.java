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

    IVoteService voteService = new VoteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null) {
            req.setAttribute("message", message);
        }
        UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "LOGIN");
        req.setAttribute("yourposts", postService.findAllByUserId(model.getId()));
        req.setAttribute("postsinteract", voteService.findAllByUserId(model.getId()));
        req.getRequestDispatcher("/views/user/listPost.jsp").forward(req,resp);
    }
}
