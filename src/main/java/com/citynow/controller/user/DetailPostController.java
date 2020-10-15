package com.citynow.controller.user;

import com.citynow.service.ICommentService;
import com.citynow.service.IPostService;
import com.citynow.service.impl.CommentServiceImpl;
import com.citynow.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/detail-post"})
public class DetailPostController extends HttpServlet {

    IPostService postService = new PostServiceImpl();

    ICommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idPost = Long.parseLong(req.getParameter("id"));
        req.setAttribute("post", postService.findOne(idPost));
        req.setAttribute("comments", commentService.findAllByPostId(idPost));
        req.getRequestDispatcher("/views/user/detailPost.jsp").forward(req,resp);
    }
}
