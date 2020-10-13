package com.citynow.mapper.impl;

import com.citynow.mapper.Mapper;
import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.model.VoteModel;
import com.citynow.utils.ConvertUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteMapper implements Mapper<VoteModel> {

    @Override
    public VoteModel map(ResultSet rs) {
        VoteModel voteModel = new VoteModel();
        try {
            voteModel.setId(rs.getLong("vote.id"));
            voteModel.setActionVote(rs.getInt("actionvote"));
            try {
                UserModel user = new UserModel();
                user.setId(rs.getLong("user_id"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                voteModel.setUser(user);
            } catch (Exception e) {
            }
            try {
                PostModel post = new PostModel();
                post.setId(rs.getLong("post_id"));
                post.setTitle(rs.getString("title"));
                voteModel.setPost(post);
            } catch (Exception e) {
            }
            return voteModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
