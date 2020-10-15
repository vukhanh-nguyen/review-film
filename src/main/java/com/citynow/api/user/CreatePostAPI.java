package com.citynow.api.user;

import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.service.IPostService;
import com.citynow.service.IUserService;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.ConvertUtil;
import com.citynow.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = {"/api-create-post"})
public class CreatePostAPI extends HttpServlet {

    IPostService postService = new PostServiceImpl();

    IUserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PostModel postModel = mapper.readValue(ConvertUtil.convertJsonToString(req.getReader()), PostModel.class);
        postModel.setStatus(0);
        postModel.setDownvote(0L);
        postModel.setUpvote(0L);
        postModel.setDateModified(new Date(System.currentTimeMillis()));
        try {
            postModel.setUser((UserModel) SessionUtil.getInstance().getValue(req, "LOGIN"));
        } catch (Exception e) {
            return;
        }
        postModel = postService.save(postModel);

        /*UserModel userModel = userService.findOne(postModel.getUser().getId());
        Long quantityPost = userModel.getQuantityPost() + 1L;
        userModel.setQuantityPost(quantityPost);
        userService.update(userModel);*/
        mapper.writeValue(resp.getOutputStream(), postModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PostModel postModel = mapper.readValue(ConvertUtil.convertJsonToString(req.getReader()), PostModel.class);
        postModel.setDateModified(new Date(System.currentTimeMillis()));

        PostModel oldPost = postService.findOne(postModel.getId());
        postModel.setUpvote(oldPost.getUpvote());
        postModel.setDownvote(oldPost.getDownvote());
        postModel.setStatus(oldPost.getStatus());
        postModel.setUser(oldPost.getUser());

        postModel = postService.update(postModel);
        mapper.writeValue(resp.getOutputStream(), postModel);
    }
}
