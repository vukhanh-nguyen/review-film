package com.citynow.service;

import com.citynow.model.CommentModel;

import java.util.List;

public interface ICommentService {

    List<CommentModel> findAll();
    List<CommentModel> findAllByUserId(Long userId);
    List<CommentModel> findAllByPostId(Long postId);
    CommentModel save(CommentModel commentModel);
}
