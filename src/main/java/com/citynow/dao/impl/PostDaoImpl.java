package com.citynow.dao.impl;

import com.citynow.dao.PostDao;
import com.citynow.mapper.impl.PostMapper;
import com.citynow.model.PostModel;

import java.util.List;

public class PostDaoImpl extends AbstractDao<PostModel> implements PostDao {

    @Override
    public PostModel findOne(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id AND post.id = ?");
        List<PostModel> postModels = query(sql.toString(), new PostMapper(), id);
        return postModels.isEmpty() ? null : postModels.get(0);
    }

    @Override
    public Long save(PostModel postModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO post (user_id, datemodified,");
        sql.append(" upvote, downvote, title, filmname, postrate, postreview, status)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), postModel.getUser().getId(),
                postModel.getDateModified(), postModel.getUpvote(), postModel.getDownvote(),
                postModel.getTitle(), postModel.getFilmName(), postModel.getPostRate(), postModel.getPostReview(), postModel.getStatus());
    }

    @Override
    public void update(PostModel postModel) {
        StringBuilder sql = new StringBuilder("UPDATE post SET user_id =?, datemodified = ?, upvote = ?,");
        sql.append(" downvote = ?, title = ?, filmname = ?,");
        sql.append(" postrate = ?, postreview = ?, status = ? WHERE id = ?");
        update(sql.toString(), postModel.getUser().getId(), postModel.getDateModified(), postModel.getUpvote(), postModel.getDownvote(),
                postModel.getTitle(), postModel.getFilmName(), postModel.getPostRate(), postModel.getPostReview(),
                postModel.getStatus(),postModel.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM post WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<PostModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id");
        return query(sql.toString(), new PostMapper());
    }

    @Override
    public List<PostModel> findAllByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id AND user.id = ?");
        return query(sql.toString(), new PostMapper(), userId);
    }
}
