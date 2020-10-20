package com.citynow.dao;

import com.citynow.model.CommentModel;

import java.util.List;

public interface ICommentDao {

    Long save(CommentModel commentModel);
    CommentModel findOne(Long id);
    List<CommentModel> findAll();
    List<CommentModel> findAllByUserId(Long userId);
    List<CommentModel> findAllByPostId(Long postId);
    List<CommentModel> findAllByPostId(Long postId, int page, int limit);
    int countAllByPostId(Long postId);
}
