package com.citynow.service.impl;

import com.citynow.dao.CommentDao;
import com.citynow.dao.impl.CommentDaoImpl;
import com.citynow.model.CommentModel;
import com.citynow.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public List<CommentModel> findAll() {
        return commentDao.findAll();
    }

    @Override
    public List<CommentModel> findAllByUserId(Long userId) {
        return commentDao.findAllByUserId(userId);
    }

    @Override
    public List<CommentModel> findALlByPostId(Long postId) {
        return commentDao.findAllByPostId(postId);
    }

    @Override
    public CommentModel save(CommentModel commentModel) {
        return commentDao.findOne(commentDao.save(commentModel));
    }
}
