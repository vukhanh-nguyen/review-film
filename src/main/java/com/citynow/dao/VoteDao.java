package com.citynow.dao;

import com.citynow.model.VoteModel;

import java.util.List;

public interface VoteDao {

    Long save(VoteModel voteModel);
    List<VoteModel> findAllByUserId(Long userId);
    VoteModel findOne(Long id);
}
