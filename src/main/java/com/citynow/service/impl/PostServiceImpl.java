package com.citynow.service.impl;

import com.citynow.dao.ICommentDao;
import com.citynow.dao.IPostDao;
import com.citynow.dao.impl.CommentDaoImpl;
import com.citynow.dao.impl.PostDaoImpl;
import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.service.IPostService;

import java.util.List;

public class PostServiceImpl implements IPostService {

    IPostDao postDao = new PostDaoImpl();

    ICommentDao commentDao = new CommentDaoImpl();

    @Override
    public List<PostModel> findAll() {
        return postDao.findAll();
    }

    @Override
    public List<PostModel> findAll(int page, int limit) {
        return postDao.findAll(page, limit);
    }

    @Override
    public List<PostModel> findAllByStatus(int status) {
        return postDao.findAllByStatus(status);
    }

    @Override
    public List<PostModel> findAllByStatus(int status, String search, int page, int limit, String sort) {
        return postDao.findAllByStatus(status, search, page, limit, sort);
    }

    @Override
    public List<PostModel> findAllByUserId(Long userId) {
        return postDao.findAllByUserId(userId);
    }

    @Override
    public List<PostModel> findAllByUserId(Long userId, int page, int limit) {
        return postDao.findAllByUserId(userId, page, limit);
    }

    @Override
    public List<PostModel> findAllByUserIdAndStatus(Long userId, int postStatus) {
        return postDao.findAllByUserIdAndStatus(userId, postStatus);
    }

    @Override
    public List<PostModel> findAllTopByStatus(int top, int postStatus) {
        return postDao.findAllTopByStatus(top, postStatus);
    }

    @Override
    public PostModel findOne(Long id) {
        return postDao.findOne(id);
    }

    @Override
    public PostModel save(PostModel postModel) {
        if (postModel.getFilmName().equals("") || postModel.getPostReview().equals("") || postModel.getTitle().equals("")) {
            throw new NullPointerException("Value is null");
        }
        return postDao.findOne(postDao.save(postModel));
    }

    @Override
    public PostModel update(PostModel postModel) {
        if (postModel.getFilmName().equals("") || postModel.getPostReview().equals("") || postModel.getTitle().equals("")) {
            throw new NullPointerException("Value is null");
        }


        postDao.update(postModel);
        return postDao.findOne(postModel.getId());
    }

    @Override
    public int count() {
        return postDao.count();
    }

    @Override
    public int countByStatus(int status) {
        return postDao.countByStatus(status);
    }

    @Override
    public int countByStatusAndSearch(int status, String search) {
        return postDao.countByStatusAndSearch(status, search);
    }

    @Override
    public int countByUserId(Long userId) {
        return postDao.countByUserId(userId);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:
             ids) {
            commentDao.delete(id);
            postDao.delete(id);
        }
    }
}
