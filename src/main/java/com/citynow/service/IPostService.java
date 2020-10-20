package com.citynow.service;

import com.citynow.model.PostModel;

import java.util.List;

public interface IPostService {

    List<PostModel> findAll();

    List<PostModel> findAll(int page, int limit);

    List<PostModel> findAllByStatus(int status);

    List<PostModel> findAllByStatus(int status, String search, int page, int limit, String sort);

    List<PostModel> findAllByUserId(Long userId);

    List<PostModel> findAllByUserId(Long userId, int page, int limit);

    List<PostModel> findAllByUserIdAndStatus(Long userId, int postStatus);

    List<PostModel> findAllTopByStatus(int top, int postStatus);

    PostModel findOne(Long id);

    PostModel save(PostModel postModel);

    PostModel update(PostModel postModel);

    int count();

    int countByStatus(int status);

    int countByStatusAndSearch(int status, String search);

    int countByUserId(Long userId);
}
