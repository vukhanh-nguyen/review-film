package com.citynow.controller.user;

import com.citynow.service.PostService;
import com.citynow.service.impl.PostServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

    PostService postService = new PostServiceImpl();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("post", postService.findAll());
        request.getRequestDispatcher("/views/user/home.jsp").forward(request,response);
    }
}
