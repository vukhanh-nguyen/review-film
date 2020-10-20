package com.citynow.service;

import com.citynow.model.VoteModel;

import java.util.List;

public interface IVoteService {

    VoteModel save(VoteModel voteModel);
    VoteModel update(VoteModel voteModel);
    List<VoteModel> findAllByUserId(Long userId);
    List<VoteModel> findAllByUserId(Long userId, int page, int limit);
    VoteModel findOneByUserIdAndPostId(Long userId, Long postId);
    Long countTotalVoteByPostIdAndAction(Long postId, int action);
    void delete(Long id);
    int countByUserId(Long userId);
}
