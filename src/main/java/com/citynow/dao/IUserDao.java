package com.citynow.dao;

import com.citynow.model.UserModel;

import java.util.List;

public interface IUserDao {

    UserModel findByUserNameAndPassword(String userName, String password);
    UserModel findOne(Long id);
    Long save(UserModel userModel);
    void update(UserModel userModel);
    List<UserModel> findAll();
}
