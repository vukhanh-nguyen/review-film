package com.citynow.dao;

import com.citynow.model.UserModel;

public interface UserDao {

    UserModel findByUserNameAndPassword(String userName, String password);
    UserModel findOne(Long id);
    Long save(UserModel userModel);
    void update(UserModel userModel);
}
