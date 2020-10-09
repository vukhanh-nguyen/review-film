package com.citynow.dao.impl;

import com.citynow.dao.UserDao;
import com.citynow.mapper.impl.UserMapper;
import com.citynow.model.UserModel;
import com.citynow.utils.ConvertUtil;

import java.util.List;

public class UserDaoImpl extends AbstractDao<UserModel> implements UserDao {

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user ");
        sql.append(" INNER JOIN role ON role.id = user.role_id");
        sql.append(" WHERE username = ? AND password = ? AND status = ?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Long save(UserModel userModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO user (username, password,");
        sql.append(" fullname, email, dateofbirth, phone, quantitypost, quantityupvote, status, role_id)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
        return insert(sql.toString(), userModel.getUsername(),
                userModel.getPassword(), userModel.getFullname(), userModel.getEmail(),
                userModel.getDateOfBirth(),
                userModel.getPhone(), userModel.getQuantityPost(), userModel.getQuantityUpvote(), userModel.getStatus(),
                userModel.getRole().getId());
    }

    @Override
    public void update(UserModel userModel) {
        StringBuilder sql = new StringBuilder("UPDATE user SET username = ?, password = ?,");
        sql.append(" fullname = ?, email = ?, avatar = ?,");
        sql.append(" dateofbirth = ?, phone = ?, quantitypost = ? , quantityupvote = ?  , status = ? , role_id = ? WHERE id = ?");
        update(sql.toString(), userModel.getUsername(), userModel.getPassword(), userModel.getFullname(), userModel.getEmail(),
                ConvertUtil.convertStringToBytes(userModel.getAvatar()), userModel.getDateOfBirth(),
                userModel.getPhone(), userModel.getQuantityPost(), userModel.getQuantityUpvote(), userModel.getStatus(), userModel.getId(),
                userModel.getRole().getId());
    }


}
