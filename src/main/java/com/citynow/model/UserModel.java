package com.citynow.model;

import java.util.Date;

public class User {

    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private byte[] avatar;
    private Date dateOfBirth;
    private String phone;
    private Long quantityPost;
    private Long quantityUpvote;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getQuantityPost() {
        return quantityPost;
    }

    public void setQuantityPost(Long quantityPost) {
        this.quantityPost = quantityPost;
    }

    public Long getQuantityUpvote() {
        return quantityUpvote;
    }

    public void setQuantityUpvote(Long quantityUpvote) {
        this.quantityUpvote = quantityUpvote;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
