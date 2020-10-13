package com.citynow.service;

import com.citynow.model.UserModel;

public interface UserService {

    void save(UserModel userModel);
    UserModel fineOneByUsernameAndPassword(String username, String password);
    UserModel findOne(Long id);
}
