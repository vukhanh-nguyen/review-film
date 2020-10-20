package com.citynow.service.impl;

import com.citynow.dao.IVoteDao;
import com.citynow.dao.impl.VoteDaoImpl;
import com.citynow.model.VoteModel;
import com.citynow.service.IVoteService;

import java.util.List;

public class VoteServiceImpl implements IVoteService {

    IVoteDao voteDao = new VoteDaoImpl();

    @Override
    public VoteModel save(VoteModel voteModel) {
        return voteDao.findOne(voteDao.save(voteModel));
    }

    @Override
    public VoteModel update(VoteModel voteModel) {
        voteDao.update(voteModel);
        return voteDao.findOne(voteModel.getId());
    }

    @Override
    public List<VoteModel> findAllByUserId(Long userId) {
        return voteDao.findAllByUserId(userId);
    }

    @Override
    public List<VoteModel> findAllByUserId(Long userId, int page, int limit) {
        return voteDao.findAllByUserId(userId, page,limit);
    }

    @Override
    public VoteModel findOneByUserIdAndPostId(Long userId, Long postId) {
        return voteDao.findOneByUserIdAndPostId(userId, postId);
    }

    @Override
    public Long countTotalVoteByPostIdAndAction(Long postId, int action) {
        return voteDao.countTotalVoteByPostIdAndAction(postId, action);
    }

    @Override
    public void delete(Long id) {
        voteDao.delete(id);
    }

    @Override
    public int countByUserId(Long userId) {
        return voteDao.countByUserId(userId);
    }
}
