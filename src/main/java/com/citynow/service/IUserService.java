package com.citynow.service;

import com.citynow.model.UserModel;

import java.util.List;

public interface IUserService {

    void save(UserModel userModel);
    UserModel fineOneByUsernameAndPassword(String username, String password);
    UserModel findOne(Long id);
    List<UserModel> findAll();
}
