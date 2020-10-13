package com.citynow.api.user;

import com.citynow.model.UserModel;
import com.citynow.service.UserService;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.utils.ConvertUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-register"})
public class RegisterAccountAPI extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserModel userModel = mapper.readValue(ConvertUtil.convertJsonToString(req.getReader()), UserModel.class);
        userService.save(userModel);
        req.getRequestDispatcher("/views/user/home.jsp");
    }
}
