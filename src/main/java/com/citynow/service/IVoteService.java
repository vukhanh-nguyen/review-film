package com.citynow.service;

import com.citynow.model.VoteModel;

import java.util.List;

public interface IVoteService {

    VoteModel save(VoteModel voteModel);
    List<VoteModel> findAllByUserId(Long userId);
}
