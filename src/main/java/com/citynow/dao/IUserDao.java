package com.citynow.dao;

import com.citynow.model.UserModel;

import java.util.List;

public interface IUserDao {

    UserModel findByUserName(String userName);
    UserModel findOne(Long id);
    Long save(UserModel userModel);
    void update(UserModel userModel);
    List<UserModel> findAll();
    List<UserModel> findAll(int page, int limit);
    List<UserModel> findTopByQuantityLike(int top);
    Long countTotalLikedByUserId(Long userId);
    int count();
}
