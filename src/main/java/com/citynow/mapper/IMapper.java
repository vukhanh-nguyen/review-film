package com.citynow.mapper;

import java.sql.ResultSet;

public interface IMapper<T> {
    T map(ResultSet rs);
}
