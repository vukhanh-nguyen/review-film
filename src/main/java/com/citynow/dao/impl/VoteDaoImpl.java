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
    public List<VoteModel> findAllByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT * ");
        sql.append(" FROM VOTE, USER, POST ");
        sql.append("  WHERE vote.post_id = post.id and vote.user_id = user.id and user_id = ?");
        return query(sql.toString(), new VoteMapper(), userId);
    }

    @Override
    public VoteModel findOne(Long id) {
        String sql = "SELECT * FROM role WHERE id = ?";
        List<VoteModel> votes = query(sql, new VoteMapper(), id);
        return votes.isEmpty() ? null : votes.get(0);
    }
}
