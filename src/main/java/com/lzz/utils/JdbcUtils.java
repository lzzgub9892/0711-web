package com.lzz.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

	
	public static void update(String sql,Object[] objs) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			
			if (objs!=null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject((i + 1), objs[i]);
				} 
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, ps, null);
		}
	}
	
	public static Object query(String sql,Object[] objs,ResultSetHandler rsh) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			if (objs!=null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject((i + 1), objs[i]);
				} 
			}
			rs=ps.executeQuery();
			Object obj=rsh.handler(rs);
			return obj;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
	}
	public static <T>T resultSet2Bean(Class clazz,ResultSet rs){
		try {
			Object obj=clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				String fieldName=f.getName();
				if(f.getType()==Integer.class||f.getType()==int.class) {
					f.set(obj,rs.getInt(fieldName));
				}else if(f.getType()==Double.class||f.getType()==double.class) {
					f.set(obj,rs.getDouble(fieldName));
				}else if(f.getType()==Boolean.class||f.getType()==boolean.class) {
					f.set(obj,rs.getBoolean(fieldName));
				}else if(f.getType()==Byte.class||f.getType()==byte.class) {
					f.set(obj, rs.getByte(fieldName));
				}else if(f.getType()==Character.class||f.getType()==char.class) {
					f.set(obj, rs.getString(fieldName).toCharArray()[0]);
				}else if(f.getType()==Long.class||f.getType()==long.class) {
					f.set(obj, rs.getLong(fieldName));
				}else if(f.getType()==Short.class||f.getType()==short.class) {
					f.set(obj, rs.getShort(fieldName));
				}else if(f.getType()==Float.class||f.getType()==float.class) {
					f.set(obj, rs.getFloat(fieldName));
				}else if(f.getType()==String.class) {
					f.set(obj, rs.getString(fieldName));
				}else if(f.getType()==Date.class) {
					f.set(obj, rs.getDate(fieldName));
				}
			}
			return (T) obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
		
}		

