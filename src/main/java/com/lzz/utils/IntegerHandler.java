package com.lzz.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerHandler implements ResultSetHandler {

	@Override
	public Object handler(ResultSet rs) {
		try {
			Integer rowCount=0;
			if(rs.next()) {
				rowCount=rs.getInt(1);
			}
			return rowCount;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
