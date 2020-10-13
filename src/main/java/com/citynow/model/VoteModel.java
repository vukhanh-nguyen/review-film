package com.citynow.model;

public class VoteModel {

    private Long id;
    private UserModel user;
    private PostModel post;
    private int actionVote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }

    public int getActionVote() {
        return actionVote;
    }

    public void setActionVote(int actionVote) {
        this.actionVote = actionVote;
    }
}
