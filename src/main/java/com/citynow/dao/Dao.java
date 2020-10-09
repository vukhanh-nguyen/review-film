package com.citynow.dao;

import com.citynow.mapper.Mapper;

import java.util.List;

public interface Dao<T> {

    <T> List<T> query(String sql, Mapper<T> mapper, Object... parameters);
    void update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
