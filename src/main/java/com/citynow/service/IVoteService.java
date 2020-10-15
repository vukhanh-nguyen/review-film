package com.citynow.service;

import com.citynow.model.VoteModel;

import java.util.List;

public interface IVoteService {

    VoteModel save(VoteModel voteModel);
    VoteModel update(VoteModel voteModel);
    List<VoteModel> findAllByUserId(Long userId);
    VoteModel findOneByUserIdAndPostId(Long userId, Long postId);
    Long countTotalVoteByPostIdAndAction(Long postId, int action);
}
