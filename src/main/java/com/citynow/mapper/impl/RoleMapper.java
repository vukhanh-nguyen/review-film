package com.citynow.mapper.impl;

import com.citynow.mapper.IMapper;
import com.citynow.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements IMapper<RoleModel> {

    @Override
    public RoleModel map(ResultSet rs) {
        RoleModel roleModel = new RoleModel();
        try {
            roleModel.setId(rs.getLong("id"));
            roleModel.setCode(rs.getString("code"));
            return roleModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
