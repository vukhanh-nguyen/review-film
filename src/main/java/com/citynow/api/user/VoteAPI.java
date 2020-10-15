package com.citynow.api.user;

import com.citynow.constant.Constant;
import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.model.VoteModel;
import com.citynow.service.IPostService;
import com.citynow.service.IUserService;
import com.citynow.service.IVoteService;
import com.citynow.service.impl.PostServiceImpl;
import com.citynow.service.impl.UserServiceImpl;
import com.citynow.service.impl.VoteServiceImpl;
import com.citynow.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-vote"})
public class VoteAPI extends HttpServlet {

    IVoteService voteService = new VoteServiceImpl();

    IPostService postService = new PostServiceImpl();

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "LOGIN");
        Long idPost = Long.parseLong(req.getParameter("idPost"));
        PostModel postModel = postService.findOne(idPost);
        int statusVote = Integer.parseInt(req.getParameter("statusVote"));


        // Change vote
        VoteModel voteModel = voteService.findOneByUserIdAndPostId(model.getId(), idPost);
        if (voteModel == null) {
            voteModel = new VoteModel();
            voteModel.setPost(postModel);
            voteModel.setUser(model);
            voteModel.setActionVote(statusVote);
            voteService.save(voteModel);
        } else {
            voteModel.setActionVote(statusVote);
            voteService.update(voteModel);
        }

        // Change post (total vote)
        Long totalVoteLike = voteService.countTotalVoteByPostIdAndAction(idPost, Constant.VOTE_LIKE);
        Long totalVoteDislike = voteService.countTotalVoteByPostIdAndAction(idPost, Constant.VOTE_DISLIKE);
        postModel.setUpvote(totalVoteLike);
        postModel.setDownvote(totalVoteDislike);
        postService.update(postModel);

        // Change user vote (total vote of user write this post)
        UserModel author = userService.findOne(postModel.getUser().getId());
        author.setQuantityUpvote(userService.countTotalLikedByUserId(author.getId()));
        userService.update(author);
    }
}