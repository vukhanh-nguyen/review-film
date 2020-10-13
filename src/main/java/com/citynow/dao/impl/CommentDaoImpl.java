package com.citynow.dao.impl;

import com.citynow.dao.CommentDao;
import com.citynow.dao.Dao;
import com.citynow.mapper.impl.CommetMapper;
import com.citynow.model.CommentModel;

import java.util.List;

public class CommentDaoImpl extends AbstractDao<CommentModel> implements CommentDao {

    @Override
    public Long save(CommentModel commentModel){
        StringBuilder sql = new StringBuilder("INSERT INTO comment (user_id, post_id , content, datecreated) ");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), commentModel.getUser_id(), commentModel.getPost_id(),
                commentModel.getContent(), commentModel.getDateCreated());
    }

    @Override
    public CommentModel findOne(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM COMMENT WHERE id = ?");
        List<CommentModel> commentModels = query(sql.toString(), new CommetMapper(), id);
        return commentModels.isEmpty() ? null : commentModels.get(0);
    }

    @Override
    public List<CommentModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM COMMENT");
        return query(sql.toString(), new CommetMapper());
    }

    @Override
    public List<CommentModel> findAllByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM COMMENT, POST, USER ");
        sql.append("  WHERE COMMENT.post_id = POST.id and COMMENT.user_id = USER.id and user_id = ?");
        return query(sql.toString(), new CommetMapper(), userId);
    }

    @Override
    public List<CommentModel> findAllByPostId(Long postId) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM COMMENT, POST, USER ");
        sql.append(" WHERE COMMENT.post_id = POST.id and COMMENT.user_id = USER.id and post_id = ? ");
        sql.append(" ORDER BY comment.id DESC");
        return query(sql.toString(), new CommetMapper(), postId);
    }
}
