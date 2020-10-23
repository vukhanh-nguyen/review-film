package com.citynow.api.user;

import com.citynow.constant.Constant;
import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.service.IPostService;
import com.citynow.service.IUserService;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.ConvertUtil;
import com.citynow.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = {"/api-post"})
public class PostAPI extends HttpServlet {

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
        if (postModel.getUser().getStatus() != Constant.USER_BLOCK_STATUS){
            postModel = postService.save(postModel);
            mapper.writeValue(resp.getOutputStream(), postModel);
        }
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String json = ConvertUtil.convertJsonToString(req.getReader());
        JSONObject dataJson = new JSONObject(json);
        JSONArray idsJson = dataJson.getJSONArray("ids");
        Long[] ids = new Long[idsJson.length()];
        for (int i = 0; i <idsJson.length(); i++) {
            ids[i] = idsJson.getLong(i);
        }
        try{
            postService.delete(ids);
            mapper.writeValue(resp.getOutputStream(), "{}");
        }catch (Exception e){}

    }
}
