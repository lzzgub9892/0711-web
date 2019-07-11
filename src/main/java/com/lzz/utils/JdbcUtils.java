package com.lzz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
	private static String user="root";
	private static String pwd="123456";
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn=tl.get();
		if(conn==null){
			conn=DriverManager.getConnection(url, user, pwd);
			tl.set(conn);
		}
		return conn;
	}
	
	public static void free(ResultSet rs,Statement stat,Connection conn) {
		try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				if(stat!=null) stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} finally {
				try {
					if(conn!=null) {
						conn.close();
						tl.remove(); 
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
