package com.citynow.service.impl;

import com.citynow.dao.VoteDao;
import com.citynow.dao.impl.VoteDaoImpl;
import com.citynow.model.VoteModel;
import com.citynow.service.VoteService;

import java.util.List;

public class VoteServiceImpl implements VoteService {

    VoteDao voteDao = new VoteDaoImpl();

    @Override
    public VoteModel save(VoteModel voteModel) {
        return voteDao.findOne(voteDao.save(voteModel));
    }

    @Override
    public List<VoteModel> findAllByUserId(Long userId) {
        return voteDao.findAllByUserId(userId);
    }
}
