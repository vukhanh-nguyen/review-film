package com.citynow.dao;

import com.citynow.model.UserModel;

public interface UserDao extends Dao<UserModel> {

    UserModel findByUserNameAndPassword(String userName, String password);
    UserModel findOne(Long id);
    Long save(UserModel userModel);
    void update(UserModel userModel);
}
