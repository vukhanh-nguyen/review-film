package com.citynow.service.impl;

import com.citynow.dao.IPostDao;
import com.citynow.dao.impl.PostDaoImpl;
import com.citynow.model.PostModel;
import com.citynow.model.UserModel;
import com.citynow.service.IPostService;

import java.util.List;

public class PostServiceImpl implements IPostService {

    IPostDao postDao = new PostDaoImpl();

    @Override
    public List<PostModel> findAll() {
        return postDao.findAll();
    }

    @Override
    public List<PostModel> findAllByStatus(int status) {
        return postDao.findAllByStatus(status);
    }

    @Override
    public List<PostModel> findAllByUserId(Long userId) {
        return postDao.findAllByUserId(userId);
    }

    @Override
    public List<PostModel> findAllByUserIdAndStatus(Long userId, int postStatus) {
        return postDao.findAllByUserIdAndStatus(userId, postStatus);
    }

    @Override
    public PostModel findOne(Long id) {
        return postDao.findOne(id);
    }

    @Override
    public PostModel save(PostModel postModel) {
        if (postModel.getFilmName().equals("") || postModel.getPostReview().equals("") || postModel.getTitle().equals("")){
            throw new NullPointerException("Value is null");
        }
        return postDao.findOne(postDao.save(postModel));
    }

    @Override
    public PostModel update(PostModel postModel) {
        if (postModel.getFilmName().equals("") || postModel.getPostReview().equals("") || postModel.getTitle().equals("")){
            throw new NullPointerException("Value is null");
        }


        postDao.update(postModel);
        return postDao.findOne(postModel.getId());
    }
}
