package com.citynow.mapper.impl;

import com.citynow.mapper.Mapper;
import com.citynow.model.CommentModel;
import com.citynow.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommetMapper implements Mapper<CommentModel> {

    public CommentModel map(ResultSet rs) {
        CommentModel commentModel = new CommentModel();
        try {
            commentModel.setId(rs.getLong("id"));
            commentModel.setContent(rs.getString("content"));
            commentModel.setDateCreated(rs.getDate("datecreated"));

            try {
                UserModel user = new UserModel();
                user.setId(rs.getLong("user_id"));
                user.setFullname(rs.getString("fullname"));
                commentModel.setUser(user);
            } catch (Exception e) {
            }
            return commentModel;
        } catch (SQLException e) {
            return null;
        }
    }
}