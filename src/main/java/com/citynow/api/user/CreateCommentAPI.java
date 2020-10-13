package com.citynow.api.user;

import com.citynow.model.CommentModel;
import com.citynow.service.ICommentService;
import com.citynow.service.IPostService;
import com.citynow.service.IUserService;
import com.citynow.service.impl.CommentServiceImpl;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.ConvertUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = {"/api-comment"})
public class CreateCommentAPI extends HttpServlet {

    ICommentService commentService = new CommentServiceImpl();

    IUserService userService = new UserServiceImpl();

    IPostService postService = new PostServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        CommentModel commentModel = mapper.readValue(ConvertUtil.convertJsonToString(req.getReader()), CommentModel.class);
        commentModel.setDateCreated(new Date(System.currentTimeMillis()));
        commentModel.setUser(userService.findOne(commentModel.getUser_id()));
        commentModel.setPost(postService.findOne(commentModel.getPost_id()));
        commentModel = commentService.save(commentModel);
        mapper.writeValue(resp.getOutputStream(), commentModel);
    }
}
