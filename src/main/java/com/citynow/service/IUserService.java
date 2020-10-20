package com.citynow.service;

import com.citynow.model.UserModel;

import java.util.List;

public interface IUserService {

    UserModel save(UserModel userModel);
    UserModel update(UserModel userModel);
    UserModel fineOneByUsername(String username);
    UserModel findOne(Long id);
    List<UserModel> findAll();
    List<UserModel> findAll(int page, int limit);
    List<UserModel> findTopByQuantityLike(int top);
    Long countTotalLikedByUserId(Long userId);
    int count();
}
