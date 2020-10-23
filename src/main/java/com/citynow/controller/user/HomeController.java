package com.citynow.controller.user;

import com.citynow.constant.Constant;
import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.service.IPostService;
import com.citynow.service.IUserService;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.UserServiceImpl;

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

    IUserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        String message = req.getParameter("message");
        if (message != null) {
            req.setAttribute("message", message);
        }

        // Pagination
        int page = 1;
        int limit = 5;
        String search = "";
        try {
            if (req.getParameter("page") != null) {
                page = Integer.parseInt(req.getParameter("page"));
            }
            if (req.getParameter("limit") != null) {
                limit = Integer.parseInt(req.getParameter("limit"));
            }
        } catch (Exception e) {
        }
        try {
            if (req.getParameter("search") != null) {
                search = req.getParameter("search");
            }

        } catch (Exception e) {
        }
        int totalPage;
        String sort = req.getParameter("sort");
        if (sort == null) {
            sort = "date-desc";
        }

        List<PostModel> listResult = postService.findAllByStatus(Constant.POST_APPROVE_STATUS, search, page, limit, sort);
        List<UserModel> TopReviewers = userService.findTopByQuantityLike(3);
        List<PostModel> TopPosts = postService.findAllTopByStatus(3, Constant.POST_APPROVE_STATUS);
        totalPage = (int) Math.ceil((double) postService.countByStatusAndSearch(Constant.POST_APPROVE_STATUS, search) / limit);

        req.setAttribute("post", listResult);
        req.setAttribute("topReviewers", TopReviewers);
        req.setAttribute("topPosts", TopPosts);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("currentPage", page);
        req.setAttribute("sort", sort);
        req.setAttribute("search", search);

        req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
    }
}
