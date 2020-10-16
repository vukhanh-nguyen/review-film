package com.citynow.api.user;

import com.citynow.constant.Constant;
import com.citynow.model.UserModel;
import com.citynow.service.IRoleService;
import com.citynow.service.IUserService;
import com.citynow.service.impl.RoleServiceImpl;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.ConvertUtil;
import com.citynow.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

@WebServlet(urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet {

    IUserService userService = new UserServiceImpl();

    IRoleService roleService = new RoleServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String oldPassword = req.getParameter("oldpassword");
        /*ObjectMapper mapper = new ObjectMapper();
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
        userModel.setPassword(BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt()));

        userModel = userService.save(userModel);
        mapper.writeValue(resp.getOutputStream(), userModel);*/
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        JSONObject  dataJson = new JSONObject(ConvertUtil.convertJsonToString(new BufferedReader(new InputStreamReader(req.getInputStream()))));
        String oldPassword = dataJson.getString("oldpassword");
        UserModel userModel;
        if (oldPassword != null) {
            // Change password
            userModel = (UserModel) SessionUtil.getInstance().getValue(req, "LOGIN");
            if (userModel != null && BCrypt.checkpw(oldPassword,userModel.getPassword())){
                String newPassword = dataJson.getString("newpassword");
                userModel.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                userModel = userService.update(userModel);
                mapper.writeValue(resp.getOutputStream(), userModel);
            }
        } else {
            //update profile
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            userModel = mapper.readValue(ConvertUtil.convertJsonToString(req.getReader()), UserModel.class);
            UserModel oldUser = userService.findOne(userModel.getId());
            userModel.setValue(oldUser);
            userModel = userService.update(userModel);
            mapper.writeValue(resp.getOutputStream(), userModel);
        }

    }
}
