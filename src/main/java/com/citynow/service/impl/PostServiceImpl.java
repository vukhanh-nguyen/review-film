package com.citynow.service.impl;

import com.citynow.dao.PostDao;
import com.citynow.dao.impl.PostDaoImpl;
import com.citynow.model.PostModel;
import com.citynow.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    PostDao postDao = new PostDaoImpl();

    @Override
    public List<PostModel> findAll() {
        return postDao.findAll();
    }
}
