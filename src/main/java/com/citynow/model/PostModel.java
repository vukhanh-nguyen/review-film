package com.citynow.model;

import java.util.Date;

public class Post {

    private Long id;
    private User user;
    private Date dateModified;
    private Long upvote;
    private Long downvote;
    private String title;
    private String filmName;
    private int postRate;
    private String postReview;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Long getUpvote() {
        return upvote;
    }

    public void setUpvote(Long upvote) {
        this.upvote = upvote;
    }

    public Long getDownvote() {
        return downvote;
    }

    public void setDownvote(Long downvote) {
        this.downvote = downvote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getPostRate() {
        return postRate;
    }

    public void setPostRate(int postRate) {
        this.postRate = postRate;
    }

    public String getPostReview() {
        return postReview;
    }

    public void setPostReview(String postReview) {
        this.postReview = postReview;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
