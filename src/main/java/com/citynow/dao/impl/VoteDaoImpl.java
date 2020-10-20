package com.citynow.dao.impl;

import com.citynow.dao.IVoteDao;
import com.citynow.mapper.impl.VoteMapper;
import com.citynow.model.VoteModel;

import java.util.List;

public class VoteDaoImpl extends AbstractDao<VoteModel> implements IVoteDao {

    @Override
    public Long save(VoteModel voteModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO vote (user_id, post_id , actionvote) ");
        sql.append(" VALUES(?, ?, ?)");
        return insert(sql.toString(), voteModel.getUser().getId(), voteModel.getPost().getId(),
                voteModel.getActionVote());
    }

    @Override
    public void update(VoteModel voteModel) {
        StringBuilder sql = new StringBuilder("UPDATE vote SET user_id =?, post_id = ?, actionvote = ? ");
        sql.append(" WHERE id = ?");
        update(sql.toString(), voteModel.getUser().getId(), voteModel.getPost().getId(), voteModel.getActionVote(),
                voteModel.getId());
    }

    @Override
    public List<VoteModel> findAllByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM VOTE, USER, POST ");
        sql.append("  WHERE vote.post_id = post.id and vote.user_id = user.id and user.id = ?");
        return query(sql.toString(), new VoteMapper(), userId);
    }

    @Override
    public List<VoteModel> findAllByUserId(Long userId, int page, int limit) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM VOTE, USER, POST ");
        sql.append("  WHERE vote.post_id = post.id and vote.user_id = user.id and user.id = ?");
        sql.append(" LIMIT ? OFFSET ?");

        // offset = (page -1 ) * limit (MySQL count from 0)
        // limit = limit - 1
        int offset = (page - 1) * limit;
        return query(sql.toString(), new VoteMapper(), userId, limit, offset);
    }

    @Override
    public VoteModel findOne(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM VOTE, USER, POST ");
        sql.append("  WHERE vote.post_id = post.id and vote.user_id = user.id and vote.id = ?");
        List<VoteModel> votes = query(sql.toString(), new VoteMapper(), id);
        return votes.isEmpty() ? null : votes.get(0);
    }

    @Override
    public VoteModel findOneByUserIdAndPostId(Long userId, Long postId) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM VOTE, USER, POST ");
        sql.append("  WHERE vote.post_id = post.id and vote.user_id = user.id and user.id = ? and post.id = ? ");
        List<VoteModel> votes = query(sql.toString(), new VoteMapper(), userId, postId);
        return votes.isEmpty() ? null : votes.get(0);
    }

    @Override
    public Long countTotalVoteByPostIdAndAction(Long postId, int action) {
        StringBuilder sql = new StringBuilder("SELECT count(*) ");
        sql.append(" FROM VOTE ");
        sql.append("  WHERE vote.post_id = ? and actionvote = ? ");
        return Long.valueOf(count(sql.toString(), postId, action));
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM VOTE WHERE id = ?";
        update(sql, id);
    }

    @Override
    public int countByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT count(*) ");
        sql.append(" FROM vote ");
        sql.append(" WHERE vote.user_id = ? ");
        return count(sql.toString(), userId);
    }
}
