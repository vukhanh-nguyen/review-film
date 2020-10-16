package com.citynow.service.impl;

import com.citynow.dao.IRoleDao;
import com.citynow.dao.IUserDao;
import com.citynow.dao.impl.RoleDaoImpl;
import com.citynow.dao.impl.UserDaoImpl;
import com.citynow.model.UserModel;
import com.citynow.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Date;
import java.util.List;

public class UserServiceImpl implements IUserService {

    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel save(UserModel userModel) {

        return userDao.findOne(userDao.save(userModel));
    }

    @Override
    public UserModel update(UserModel userModel) {
        //UserModel oldUser = userDao.findOne(userModel.getId());
        //userModel.setPassword(BCrypt.hashpw(userModel.getPassword(),BCrypt.gensalt()));

        userDao.update(userModel);
        return userDao.findOne(userModel.getId());
    }

    @Override
    public UserModel fineOneByUsername(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public UserModel findOne(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public List<UserModel> findAll() {
        return userDao.findAll();
    }

    @Override
    public Long countTotalLikedByUserId(Long userId) {
        return userDao.countTotalLikedByUserId(userId);
    }
}
