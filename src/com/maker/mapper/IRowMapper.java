package com.maker.mapper;

import java.sql.ResultSet;
import java.util.List;

public interface IRowMapper<T> {
	T rowMapper(ResultSet rs);
}
