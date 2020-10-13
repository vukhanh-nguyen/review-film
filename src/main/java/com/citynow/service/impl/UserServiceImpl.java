package com.citynow.service.impl;

import com.citynow.dao.RoleDao;
import com.citynow.dao.UserDao;
import com.citynow.dao.impl.RoleDaoImpl;
import com.citynow.dao.impl.UserDaoImpl;
import com.citynow.model.UserModel;
import com.citynow.service.UserService;
import com.citynow.utils.ConvertUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    RoleDao roleDao = new RoleDaoImpl();

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
}
