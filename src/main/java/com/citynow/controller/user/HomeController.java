package com.citynow.controller.user;

import com.citynow.constant.Constant;
import com.citynow.model.PostModel;
import com.citynow.service.IPostService;
import com.citynow.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    IPostService postService = new PostServiceImpl();

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        // Pagination
        int page;
        int limit;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        } else {
            page = 1;
        }
        if (req.getParameter("limit") != null) {
            limit = Integer.parseInt(req.getParameter("limit"));
        } else {
            limit = 5;
        }
        int totalPage;
        String sort = req.getParameter("sort");
        if (sort == null) {
            sort = " ";
        }

        List<PostModel> listResult = postService.findAllByStatus(Constant.POST_APPROVE_STATUS, page, limit, sort);
        totalPage = (int) Math.ceil((double) postService.countByStatus(Constant.POST_APPROVE_STATUS) / limit);

        req.setAttribute("post", listResult);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("currentPage", page);
        req.setAttribute("sort", sort);

        req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
    }
}
