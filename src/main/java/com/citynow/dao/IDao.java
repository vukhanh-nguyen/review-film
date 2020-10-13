package com.citynow.dao;

import com.citynow.mapper.IMapper;

import java.util.List;

public interface IDao<T> {

    <T> List<T> query(String sql, IMapper<T> mapper, Object... parameters);
    void update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
