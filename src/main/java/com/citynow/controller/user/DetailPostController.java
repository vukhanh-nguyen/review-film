package com.citynow.controller.user;

import com.citynow.model.CommentModel;
import com.citynow.service.CommentService;
import com.citynow.service.PostService;
import com.citynow.service.impl.CommentServiceImpl;
import com.citynow.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = {"/detail-post"})
public class DetailPostController extends HttpServlet {

    PostService postService = new PostServiceImpl();

    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idPost = Long.parseLong(req.getParameter("id"));
        req.setAttribute("post", postService.findOne(idPost));
        req.setAttribute("comments", commentService.findALlByPostId(idPost));
        req.getRequestDispatcher("/views/user/detailPost.jsp").forward(req,resp);
    }
}
