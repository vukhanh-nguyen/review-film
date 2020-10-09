package com.citynow.dao;


import com.citynow.model.RoleModel;

public interface RoleDao  extends Dao<RoleModel> {

    RoleModel findOne(Long id);
}
