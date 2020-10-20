package com.citynow.dao.impl;

import com.citynow.dao.ICommentDao;
import com.citynow.mapper.impl.CommetMapper;
import com.citynow.model.CommentModel;

import java.util.List;

public class CommentDaoImpl extends AbstractDao<CommentModel> implements ICommentDao {

    @Override
    public Long save(CommentModel commentModel) {
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

    @Override
    public List<CommentModel> findAllByPostId(Long postId, int page, int limit) {
        StringBuilder sql = new StringBuilder(" SELECT * ");
        sql.append(" FROM COMMENT, POST, USER ");
        sql.append(" WHERE COMMENT.post_id = POST.id and COMMENT.user_id = USER.id and post_id = ? ");
        sql.append(" ORDER BY comment.id DESC");
        sql.append(" LIMIT ? OFFSET ?");

        // offset = (page -1 ) * limit (MySQL count from 0)
        // limit = limit - 1
        int offset = (page - 1) * limit;
        return query(sql.toString(), new CommetMapper(), postId, limit, offset);
    }

    @Override
    public int countAllByPostId(Long postId) {
        StringBuilder sql = new StringBuilder("SELECT count(*) ");
        sql.append(" FROM comment ");
        sql.append(" WHere comment.post_id = ?");
        int x = count(sql.toString(), postId);
        return count(sql.toString(), postId);
    }
}
