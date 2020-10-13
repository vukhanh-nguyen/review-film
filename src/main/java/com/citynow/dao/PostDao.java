package com.citynow.dao;

import com.citynow.model.PostModel;

import java.util.List;

public interface PostDao{

    PostModel findOne(Long id);
    Long save(PostModel postModel);
    void update(PostModel postModel);
    void delete(Long id);
    List<PostModel> findAll();
    List<PostModel> findAllByUserId(Long userId);
}
