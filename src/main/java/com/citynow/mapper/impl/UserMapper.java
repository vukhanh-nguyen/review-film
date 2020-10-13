package com.citynow.mapper.impl;

import com.citynow.mapper.Mapper;
import com.citynow.model.RoleModel;
import com.citynow.model.UserModel;
import com.citynow.utils.ConvertUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<UserModel> {

    public UserModel map(ResultSet rs) {

        UserModel user = new UserModel();
        try {
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullname(rs.getString("fullname"));
            user.setEmail(rs.getString("email"));
            if(rs.getBytes("avatar") == null){

            }else{
                user.setAvatar(ConvertUtil.convertBytesToString(rs.getBytes("avatar")));
            }
            user.setDateOfBirth(rs.getDate("dateofbirth"));
            user.setPhone(rs.getString("phone"));
            user.setQuantityPost(rs.getLong("quantitypost"));
            user.setQuantityUpvote(rs.getLong("quantityupvote"));
            user.setStatus(rs.getInt("status"));
            try {
                RoleModel role = new RoleModel();
                role.setId(rs.getLong("role_id"));
                role.setCode(rs.getString("code"));
                user.setRole(role);
            } catch (Exception e) {
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
