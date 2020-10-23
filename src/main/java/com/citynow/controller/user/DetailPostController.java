package com.citynow.controller.user;

import com.citynow.model.UserModel;
import com.citynow.service.ICommentService;
import com.citynow.service.IPostService;
import com.citynow.service.IVoteService;
import com.citynow.service.impl.CommentServiceImpl;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.VoteServiceImpl;
import com.citynow.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/detail-post"})
public class DetailPostController extends HttpServlet {

    IPostService postService = new PostServiceImpl();

    ICommentService commentService = new CommentServiceImpl();

    IVoteService voteService = new VoteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null) {
            req.setAttribute("message", message);
        }


        Long idPost = Long.parseLong(req.getParameter("id"));

        UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "LOGIN");
        if (model != null) {
            req.setAttribute("vote", voteService.findOneByUserIdAndPostId(model.getId(), idPost));
        }

        int limit = 5;
        int page = 1;
        int totalPage;
        try {
            if (req.getParameter("page") != null) {
                page = Integer.parseInt(req.getParameter("page"));
            }
        }catch (Exception e){}
        totalPage = (int) Math.ceil((double) commentService.countAllByPostId(idPost) / limit);

        req.setAttribute("totalPage", totalPage);
        req.setAttribute("currentPage", page);

        req.setAttribute("post", postService.findOne(idPost));
        req.setAttribute("comments", commentService.findAllByPostId(idPost, page, limit));

        req.getRequestDispatcher("/views/user/detailPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/detailPost.jsp").forward(req, resp);
    }
}
