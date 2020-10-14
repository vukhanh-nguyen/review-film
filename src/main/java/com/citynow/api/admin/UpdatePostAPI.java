package com.citynow.api.admin;

import com.citynow.model.CommentModel;
import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.service.IPostService;
import com.citynow.service.IUserService;
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

@WebServlet(urlPatterns = {"/admin-api-post"})
public class UpdatePostAPI extends HttpServlet {

    IPostService postService = new PostServiceImpl();

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        int status = Integer.parseInt(req.getParameter("status"));
        PostModel postModel = postService.findOne(id);
        postModel.setStatus(status);
        postService.update(postModel);

        Long userId = postModel.getUser().getId();
        UserModel userModel = userService.findOne(userId);
        Long quantityPostPlus = userModel.getQuantityPost() + 1L;
        userModel.setQuantityPost(quantityPostPlus);
        userService.update(userModel);
    }
}
