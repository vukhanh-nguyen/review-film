package com.citynow.service.impl;

import com.citynow.dao.IRoleDao;
import com.citynow.dao.impl.RoleDaoImpl;
import com.citynow.model.RoleModel;
import com.citynow.service.IRoleService;

public class RoleServiceImpl implements IRoleService {

    IRoleDao roleDao = new RoleDaoImpl();

    @Override
    public RoleModel findOne(Long id) {
        return roleDao.findOne(id);
    }
}
