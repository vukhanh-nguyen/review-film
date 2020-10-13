package com.citynow.dao;


import com.citynow.model.RoleModel;

public interface IRoleDao {

    RoleModel findOne(Long id);
}
