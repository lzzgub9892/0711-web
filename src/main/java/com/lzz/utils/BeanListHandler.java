package com.lzz.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler implements ResultSetHandler {
	private Class clazz;
	
	public BeanListHandler(Class clazz) {
		super();
		this.clazz = clazz;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public Object handler(ResultSet rs) {
		try {
			List list= new ArrayList();
			while(rs.next()) {
				Object obj=JdbcUtils.resultSet2Bean(clazz, rs);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
