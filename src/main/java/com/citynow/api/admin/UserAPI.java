package com.citynow.api.admin;

import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.service.IUserService;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.ConvertUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-api-user"})
public class UserAPI extends HttpServlet {

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json = ConvertUtil.convertJsonToString(req.getReader());
        JSONObject dataJson = new JSONObject(json);

        Long idUser = dataJson.getLong("user_id");
        int status = dataJson.getInt("status");

        UserModel userModel = userService.findOne(idUser);
        userModel.setStatus(status);

        mapper.writeValue(resp.getOutputStream(), userService.update(userModel));

    }
}
