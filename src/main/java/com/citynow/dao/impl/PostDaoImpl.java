package com.citynow.dao.impl;

import com.citynow.dao.IPostDao;
import com.citynow.mapper.impl.PostMapper;
import com.citynow.model.PostModel;

import java.util.List;

public class PostDaoImpl extends AbstractDao<PostModel> implements IPostDao {

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
                postModel.getStatus(), postModel.getId());
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
    public List<PostModel> findAll(int page, int limit) {
        StringBuilder sql = new StringBuilder(" SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id");
        sql.append(" ORDER BY post.datemodified asc, post.id asc");
        sql.append(" LIMIT ? OFFSET ?");

        // offset = (page -1 ) * limit (MySQL count from 0)
        // limit = limit - 1
        int offset = (page - 1) * limit;
        return query(sql.toString(), new PostMapper(), limit, offset);
    }

    @Override
    public List<PostModel> findAllByStatus(int status) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id AND post.status = ?");
        return query(sql.toString(), new PostMapper(), status);
    }

    @Override
    public List<PostModel> findAllByStatus(int status, String search, int page, int limit, String sort) {

        StringBuilder sql = new StringBuilder(" ");

        if (sort.equals("date-asc")) {
            sql.append(" SELECT * ");
            sql.append(" FROM POST, USER ");
            sql.append(" WHERE POST.user_id = USER.id AND post.status = ?");
            sql.append(" and (LOWER(post.title) LIKE CONCAT(\"%\",  LOWER(?), \"%\") or  ");
            sql.append(" LOWER(post.postreview) LIKE CONCAT(\"%\",  LOWER(?), \"%\")) ");
            sql.append(" ORDER BY post.datemodified asc, post.id asc");
            sql.append(" LIMIT ? OFFSET ?");
        } else if (sort.equals("like-asc")) {
            sql.append(" SELECT * ");
            sql.append(" FROM POST, USER ");
            sql.append(" WHERE POST.user_id = USER.id AND post.status = ?");
            sql.append(" and (LOWER(post.title) LIKE CONCAT(\"%\",  LOWER(?), \"%\") or  ");
            sql.append(" LOWER(post.postreview) LIKE CONCAT(\"%\",  LOWER(?), \"%\")) ");
            sql.append(" ORDER BY post.upvote asc, post.id desc");
            sql.append(" LIMIT ? OFFSET ?");
        } else if (sort.equals("like-desc")) {
            sql.append(" SELECT * ");
            sql.append(" FROM POST, USER ");
            sql.append(" WHERE POST.user_id = USER.id AND post.status = ?");
            sql.append(" and (LOWER(post.title) LIKE CONCAT(\"%\",  LOWER(?), \"%\") or  ");
            sql.append(" LOWER(post.postreview) LIKE CONCAT(\"%\",  LOWER(?), \"%\")) ");
            sql.append(" ORDER BY post.upvote desc, post.id desc");
            sql.append(" LIMIT ? OFFSET ?");
        } else if (sort.equals("dislike-asc")) {
            sql.append(" SELECT * ");
            sql.append(" FROM POST, USER ");
            sql.append(" WHERE POST.user_id = USER.id AND post.status = ?");
            sql.append(" and (LOWER(post.title) LIKE CONCAT(\"%\",  LOWER(?), \"%\") or  ");
            sql.append(" LOWER(post.postreview) LIKE CONCAT(\"%\",  LOWER(?), \"%\")) ");
            sql.append(" ORDER BY post.downvote asc, post.id desc");
            sql.append(" LIMIT ? OFFSET ?");
        } else if (sort.equals("dislike-desc")) {
            sql.append(" SELECT * ");
            sql.append(" FROM POST, USER ");
            sql.append(" WHERE POST.user_id = USER.id AND post.status = ?");
            sql.append(" and (LOWER(post.title) LIKE CONCAT(\"%\",  LOWER(?), \"%\") or  ");
            sql.append(" LOWER(post.postreview) LIKE CONCAT(\"%\",  LOWER(?), \"%\")) ");
            sql.append(" ORDER BY post.downvote desc, post.id desc");
            sql.append(" LIMIT ? OFFSET ?");
        } else {
            // date- desc (Post new)
            sql.append(" SELECT * ");
            sql.append(" FROM POST, USER ");
            sql.append(" WHERE POST.user_id = USER.id AND post.status = ?");
            sql.append(" and (LOWER(post.title) LIKE CONCAT(\"%\",  LOWER(?), \"%\") or  ");
            sql.append(" LOWER(post.postreview) LIKE CONCAT(\"%\",  LOWER(?), \"%\")) ");
            sql.append(" ORDER BY post.datemodified desc, post.id desc");
            sql.append(" LIMIT ? OFFSET ?");
        }

        // offset = (page -1 ) * limit (MySQL count from 0)
        // limit = limit - 1
        int offset = (page - 1) * limit;
        return query(sql.toString(), new PostMapper(), status, search, search, limit, offset);
    }

    @Override
    public List<PostModel> findAllByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id AND user.id = ?");
        return query(sql.toString(), new PostMapper(), userId);
    }

    @Override
    public List<PostModel> findAllByUserId(Long userId, int page, int limit) {
        StringBuilder sql = new StringBuilder(" SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id AND user.id = ? ");
        sql.append(" LIMIT ? OFFSET ?");

        // offset = (page -1 ) * limit (MySQL count from 0)
        // limit = limit - 1
        int offset = (page - 1) * limit;
        return query(sql.toString(), new PostMapper(), userId, limit, offset);
    }

    @Override
    public List<PostModel> findAllByUserIdAndStatus(Long userId, int postStatus) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id AND user.id = ? AND post.status = ?");
        return query(sql.toString(), new PostMapper(), userId, postStatus);
    }

    @Override
    public List<PostModel> findAllTopByStatus(int top, int status) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM POST, USER ");
        sql.append(" WHERE POST.user_id = USER.id AND post.status = ? ");
        sql.append(" order by post.upvote desc, post.id desc ");
        sql.append(" limit ? ");
        return query(sql.toString(), new PostMapper(), status, top);
    }

    @Override
    public int countByStatus(int status) {
        StringBuilder sql = new StringBuilder("SELECT count(*) ");
        sql.append(" FROM POST ");
        sql.append(" WHERE post.status= ? ");
        return count(sql.toString(), status);
    }

    @Override
    public int countByStatusAndSearch(int status, String search) {
        StringBuilder sql = new StringBuilder("SELECT count(*) ");
        sql.append(" FROM POST ");
        sql.append(" WHERE post.status= ? ");
        sql.append(" and (LOWER(post.title) LIKE CONCAT(\"%\",  LOWER(?), \"%\") or  ");
        sql.append(" LOWER(post.postreview) LIKE CONCAT(\"%\",  LOWER(?), \"%\")) ");
        return count(sql.toString(), status, search, search);
    }

    @Override
    public int countByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT count(*) ");
        sql.append(" FROM POST ");
        sql.append(" WHERE post.user_id = ? ");
        return count(sql.toString(), userId);
    }

    @Override
    public int count() {
        StringBuilder sql = new StringBuilder("SELECT count(*) ");
        sql.append(" FROM POST ");
        return count(sql.toString());
    }
}
