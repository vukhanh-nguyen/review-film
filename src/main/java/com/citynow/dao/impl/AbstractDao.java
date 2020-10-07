package com.citynow.dao.impl;

import com.citynow.dao.Dao;

public class AbstractDao<T> implements Dao<T> {

    public void update(String sql, Object... parameters) {

    }

    public Long insert(String sql, Object... parameters) {
        return null;
    }

    public int count(String sql, Object... parameters) {
        return 0;
    }
}
