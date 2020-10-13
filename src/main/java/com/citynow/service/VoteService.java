package com.citynow.service;

import com.citynow.model.VoteModel;

import java.util.List;

public interface VoteService {

    VoteModel save(VoteModel voteModel);
    List<VoteModel> findAllByUserId(Long userId);
}
