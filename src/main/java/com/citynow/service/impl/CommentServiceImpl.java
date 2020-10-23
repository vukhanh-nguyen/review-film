package com.citynow.service.impl;

import com.citynow.dao.ICommentDao;
import com.citynow.dao.impl.CommentDaoImpl;
import com.citynow.model.CommentModel;
import com.citynow.service.ICommentService;

import java.util.List;

public class CommentServiceImpl implements ICommentService {

    ICommentDao commentDao = new CommentDaoImpl();

    @Override
    public List<CommentModel> findAll() {
        return commentDao.findAll();
    }

    @Override
    public List<CommentModel> findAllByUserId(Long userId) {
        return commentDao.findAllByUserId(userId);
    }

    @Override
    public List<CommentModel> findAllByPostId(Long postId) {
        return commentDao.findAllByPostId(postId);
    }

    @Override
    public List<CommentModel> findAllByPostId(Long postId, int page, int limit) {
        return commentDao.findAllByPostId(postId, page, limit);
    }

    @Override
    public CommentModel save(CommentModel commentModel) {
        if (commentModel.getContent() == null || commentModel.getContent().trim().equals("")) {
            throw new NullPointerException("Value is null");
        }
        return commentDao.findOne(commentDao.save(commentModel));
    }

    @Override
    public int countAllByPostId(Long postId) {
        return commentDao.countAllByPostId(postId);
    }

    @Override
    public void delete(Long id) {
        commentDao.delete(id);
    }
}
