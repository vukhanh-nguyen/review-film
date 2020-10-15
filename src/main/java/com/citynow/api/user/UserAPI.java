package com.citynow.api.user;

import com.citynow.constant.Constant;
import com.citynow.model.UserModel;
import com.citynow.service.IRoleService;
import com.citynow.service.IUserService;
import com.citynow.service.impl.RoleServiceImpl;
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

@WebServlet(urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet {

    IUserService userService = new UserServiceImpl();

    IRoleService roleService = new RoleServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserModel userModel = mapper.readValue(ConvertUtil.convertJsonToString(req.getReader()), UserModel.class);
        userModel.setRole(roleService.findOne(Constant.ROLE_USER));

        userModel.setAvatar("");
        userModel.setStatus(Constant.USER_ACTIVE_STATUS);
        userModel.setQuantityUpvote(0L);
        userModel.setQuantityPost(0L);
        userModel.setDateOfBirth(new Date(System.currentTimeMillis()));
        userModel.setPhone("");

        userModel = userService.save(userModel);
        mapper.writeValue(resp.getOutputStream(), userModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserModel userModel = mapper.readValue(ConvertUtil.convertJsonToString(req.getReader()), UserModel.class);
        userModel = userService.update(userModel);
        mapper.writeValue(resp.getOutputStream(), userModel);
    }
}
