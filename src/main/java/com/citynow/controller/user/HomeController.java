package com.citynow.controller.user;

import com.citynow.constant.Constant;
import com.citynow.service.IPostService;
import com.citynow.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    IPostService postService = new PostServiceImpl();

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("post", postService.findAllByStatus(Constant.POST_APPROVE_STATUS));
        req.getRequestDispatcher("/views/user/home.jsp").forward(req,resp);
    }
}
