package com.citynow.dao.impl;

import com.citynow.dao.CommentDao;
import com.citynow.dao.Dao;
import com.citynow.model.CommentModel;

public class CommentDaoImpl extends AbstractDao<CommentModel> implements CommentDao {

    @Override
    public Long save(CommentModel commentModel){
        StringBuilder sql = new StringBuilder("INSERT INTO comment (user_id, content, datecreated");
        sql.append(" VALUES(?, ?, ?)");
        return insert(sql.toString(), commentModel.getUser().getId(),
                commentModel.getContent(), commentModel.getDateCreated());
    }
}
