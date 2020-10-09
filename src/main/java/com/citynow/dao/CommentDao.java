package com.citynow.dao;

import com.citynow.model.CommentModel;

public interface CommentDao extends Dao<CommentModel> {

    Long save(CommentModel commentModel);
}
