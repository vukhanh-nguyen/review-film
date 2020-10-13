package com.citynow.service.impl;

import com.citynow.dao.IRoleDao;
import com.citynow.dao.IUserDao;
import com.citynow.dao.impl.RoleDaoImpl;
import com.citynow.dao.impl.UserDaoImpl;
import com.citynow.model.UserModel;
import com.citynow.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    IUserDao userDao = new UserDaoImpl();
    IRoleDao roleDao = new RoleDaoImpl();

    @Override
    public void save(UserModel userModel) {
        userModel.setRole(roleDao.findOne(2L));

        // 1 = Active
        // 0 = Block
        // -1 = Ban
        userModel.setStatus(1);
        userModel.setAvatar(null);
        userModel.setQuantityUpvote(0L);
        userModel.setQuantityPost(0L);


        userDao.save(userModel);

        return;
    }

    @Override
    public UserModel fineOneByUsernameAndPassword(String username, String password) {
        return userDao.findByUserNameAndPassword(username, password);
    }

    @Override
    public UserModel findOne(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public List<UserModel> findAll() {
        return userDao.findAll();
    }
}
