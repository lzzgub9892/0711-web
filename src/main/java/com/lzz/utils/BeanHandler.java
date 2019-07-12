package com.lzz.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanHandler implements ResultSetHandler {
	
	private Class clazz;
	
	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	

	public BeanHandler(Class clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public Object handler(ResultSet rs) {
		try {
			Object obj=null;
			if(rs.next()) {
				obj=JdbcUtils.resultSet2Bean(clazz, rs);
			}
			return obj;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
