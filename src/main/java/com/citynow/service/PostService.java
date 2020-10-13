package com.citynow.service;

import com.citynow.model.PostModel;

import java.util.List;

public interface PostService {

    List<PostModel> findAll();
    PostModel findOne(Long id);
    PostModel save(PostModel postModel);
}
