package com.lzz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzz.dao.IDeptDao;
import com.lzz.domain.Dept;
import com.lzz.utils.BeanHandler;
import com.lzz.utils.BeanListHandler;
import com.lzz.utils.IntegerHandler;
import com.lzz.utils.JdbcUtils;

public class DeptDaoImpl implements IDeptDao {

	@Override
	public void save(Dept dept) {
		String sql="insert into dept values(null,?)";
		Object[] objs= {dept.getDname()};
		JdbcUtils.update(sql, objs);
	}

	@Override
	public void delete(Integer did) {
		String sql="delete from dept where did=?";
		Object[] objs= {did};
		JdbcUtils.update(sql, objs);
	}

	@Override
	public void update(Dept dept) {
		String sql="update dept set dname=? where did=?";
		Object[] objs= {dept.getDname(),dept.getDid()};
		JdbcUtils.update(sql, objs);
	}

	@Override
	public List<Dept> find() {
		String sql="select * from dept";
		List<Dept> list=(List<Dept>) JdbcUtils.query(sql, null, new BeanListHandler(Dept.class)); 
		return list;
	}

	@Override
	public Dept find(Integer did) {
		String sql="select * from dept where did=?";
		Dept d=(Dept) JdbcUtils.query(sql, new Object[] {did}, new BeanHandler(Dept.class));
		return d;
	}

	@Override
	public int getRowCount() {
		String sql="select count(*) from dept";
		Integer rowCount=(Integer) JdbcUtils.query(sql, null, new IntegerHandler());
		return rowCount;
	}

	@Override
	public List<Dept> find(int startLine, int size) {
		String sql="select * from dept limit ?,?";
		List<Dept> list=(List<Dept>) JdbcUtils.query(sql, new Object[] {startLine,size}, new BeanListHandler(Dept.class)); 
		return list;
	}

}
