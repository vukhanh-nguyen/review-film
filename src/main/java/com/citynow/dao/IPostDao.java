package com.citynow.dao;

import com.citynow.model.PostModel;

import java.util.List;

public interface IPostDao {

    PostModel findOne(Long id);
    Long save(PostModel postModel);
    void update(PostModel postModel);
    void delete(Long id);
    List<PostModel> findAll();
    List<PostModel> findAll(int page, int limit);
    List<PostModel> findAllByStatus(int status);
    List<PostModel> findAllByStatus(int status,String search, int page, int limit, String sort);
    List<PostModel> findAllByUserId(Long userId);
    List<PostModel> findAllByUserId(Long userId, int page, int limit);
    List<PostModel> findAllByUserIdAndStatus(Long userId, int postStatus);
    List<PostModel> findAllTopByStatus(int top, int status);
    int countByStatus(int status);
    int countByStatusAndSearch(int status,String search);
    int countByUserId(Long userId);
    int count();
}
