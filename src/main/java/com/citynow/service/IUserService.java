package com.citynow.service;

import com.citynow.model.UserModel;

import java.util.List;

public interface IUserService {

    UserModel save(UserModel userModel);
    UserModel update(UserModel userModel);
    UserModel fineOneByUsernameAndPassword(String username, String password);
    UserModel findOne(Long id);
    List<UserModel> findAll();
    Long countTotalLikedByUserId(Long userId);
}
