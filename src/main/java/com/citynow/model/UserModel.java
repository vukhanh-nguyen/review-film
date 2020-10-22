package com.citynow.model;

import com.citynow.utils.ValidateUtil;
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
        boolean matchFound = ValidateUtil.validate("^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$", phone);
        if (matchFound) {
            this.phone = phone;
        } else {
            this.phone = "";
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

    public void setValue(UserModel userModel) {
        if (this.id == null) {
            this.id = userModel.getId();
        }
        if (this.username == null) {
            this.username = userModel.getUsername();
        }
        if (this.password == null) {
            this.password = userModel.getPassword();
        }
        if (this.fullname == null) {
            this.fullname = userModel.getFullname();
        }
        if (this.email == null) {
            this.email = userModel.getEmail();
        }
        if (this.avatar == null) {
            this.avatar = userModel.getAvatar();
        }
        if (this.dateOfBirth == null) {
            this.dateOfBirth = userModel.getDateOfBirth();
        }
        if (this.phone == null) {
            this.phone = userModel.getPhone();
        }
        if (this.quantityPost == null) {
            this.quantityPost = userModel.getQuantityPost();
        }
        if (this.quantityUpvote == null) {
            this.quantityUpvote = userModel.getQuantityUpvote();
        }
        if (this.role.getId() == null) {
            this.role = userModel.getRole();
        }
        if (this.status == 0) {
            this.status = userModel.getStatus();
        }
    }
}
