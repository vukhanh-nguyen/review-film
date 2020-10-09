package com.citynow.dao;

import com.citynow.model.UserModel;

public interface UserDao extends Dao<UserModel> {

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    Long save(UserModel userModel);
    void update(UserModel userModel);
}
