package com.citynow.mapper;

import java.sql.ResultSet;

public interface Mapper<T> {
    T map(ResultSet rs);
}
