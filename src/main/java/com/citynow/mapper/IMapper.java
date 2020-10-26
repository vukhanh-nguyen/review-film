package com.citynow.mapper;

import java.sql.ResultSet;

/**
 * Interface Mapper
 * @author VuKhanh
 * @param <T>
 */
public interface IMapper<T> {
    T map(ResultSet rs);
}
