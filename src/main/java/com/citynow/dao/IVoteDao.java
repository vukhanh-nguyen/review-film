package com.citynow.dao;

import com.citynow.model.VoteModel;

import java.util.List;

public interface IVoteDao {

    Long save(VoteModel voteModel);
    void update(VoteModel voteModel);
    List<VoteModel> findAllByUserId(Long userId);
    List<VoteModel> findAllByUserId(Long userId, int page, int limit);
    VoteModel findOne(Long id);
    VoteModel findOneByUserIdAndPostId(Long userId, Long postId);
    Long countTotalVoteByPostIdAndAction(Long postId, int action);
    void delete(Long id);
    int countByUserId(Long userId);
}
