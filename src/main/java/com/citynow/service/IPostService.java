package com.citynow.service;

import com.citynow.model.PostModel;

import java.util.List;

public interface IPostService {

    List<PostModel> findAll();
    List<PostModel> findAllByStatus(int status);
    List<PostModel> findAllByUserId(Long userId);
    List<PostModel> findAllByUserIdAndStatus(Long userId, int postStatus);
    PostModel findOne(Long id);
    PostModel save(PostModel postModel);
    PostModel update(PostModel postModel);
}
