package com.citynow.model;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserModel {

    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String avatar;
    private Date dateOfBirth;
    private String phone;
    private Long quantityPost;
    private Long quantityUpvote;
    private int status;
    private RoleModel role = new RoleModel();

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

        String regex = "^[a-z0-9]+([_-]?[a-z0-9]?)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        boolean matchFound = matcher.matches();
        if(matchFound) {
            this.username = username;
        } else {
            this.username = null;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[!@#$&*]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.matches();
        if(matchFound) {
            this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        } else {
            this.password = null;
        }
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
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.matches();
        if(matchFound) {
            this.email = email;
        } else {
            this.email = null;
        }
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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
        String regex = "^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        boolean matchFound = matcher.matches();
        if(matchFound) {
            this.phone = phone;
        } else {
            this.phone = null;
        }
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

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public void setValue(UserModel userModel){
        if (this.id == null){
            this.id = userModel.getId();
        }
        if (this.username == null){
            this.username = userModel.getUsername();
        }
        if (this.password == null){
            this.password = userModel.getPassword();
        }
        if (this.fullname == null){
            this.fullname = userModel.getFullname();
        }
        if (this.email == null){
            this.email = userModel.getEmail();
        }
        if (this.avatar == null){
            this.avatar = userModel.getAvatar();
        }
        if (this.dateOfBirth == null){
            this.dateOfBirth = userModel.getDateOfBirth();
        }
        if (this.phone == null){
            this.phone = userModel.getPhone();
        }
        if (this.quantityPost == null){
            this.quantityPost = userModel.getQuantityPost();
        }
        if (this.quantityUpvote == null){
            this.quantityUpvote = userModel.getQuantityUpvote();
        }
        if (this.role.getId() == null){
            this.role = userModel.getRole();
        }
        if (this.status == 0){
            this.status = userModel.getStatus();
        }
    }
}
