package com.citynow.dao;

import com.citynow.model.PostModel;

import java.util.List;

public interface IPostDao {

    PostModel findOne(Long id);
    Long save(PostModel postModel);
    void update(PostModel postModel);
    void delete(Long id);
    List<PostModel> findAll();
    List<PostModel> findAllByStatus(int status);
    List<PostModel> findAllByStatus(int status, int page, int limit, String sort);
    List<PostModel> findAllByUserId(Long userId);
    List<PostModel> findAllByUserIdAndStatus(Long userId, int postStatus);
    int countByStatus(int status);
}
