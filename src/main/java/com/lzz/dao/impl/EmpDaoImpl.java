package com.lzz.dao.impl;

import java.util.List;

import com.lzz.dao.IEmpDao;
import com.lzz.domain.Emp;
import com.lzz.utils.BeanHandler;
import com.lzz.utils.BeanListHandler;
import com.lzz.utils.IntegerHandler;
import com.lzz.utils.JdbcUtils;

public class EmpDaoImpl implements IEmpDao {

	@Override
	public void save(Emp emp) {
		String sql="insert into emp values(null,?,?,?,?)";
		Object[] objs= {emp.getEname(),emp.getHiredate(),emp.getSal(),emp.getDid()};
		JdbcUtils.update(sql, objs);
	}

	@Override
	public void delete(Integer eid) {
		String sql="delete from emp where eid=?";
		Object[] objs= {eid};
		JdbcUtils.update(sql, objs);
	}

	@Override
	public void update(Emp emp) {
		String sql="update emp set ename=?,hiredate=?,sal=?,did=? where eid=?";
		Object[] objs= {emp.getEname(),emp.getHiredate(),emp.getSal(),emp.getDid(),emp.getEid()};
		JdbcUtils.update(sql, objs);
	}

	@Override
	public Emp find(Integer eid) {
		String sql="select * from emp where eid=?";
		Object[] objs= {eid};
		Emp emp=(Emp) JdbcUtils.query(sql, objs, new BeanHandler(Emp.class));
		return emp;
	}

	@Override
	public List<Emp> find() {
		String sql="select * from emp where eid=?";
		List<Emp> list=(List<Emp>) JdbcUtils.query(sql, null, new BeanListHandler(Emp.class));
		return null;
	}

	@Override
	public int getRowCount() {
		String sql="select count(*) from emp";
		Integer rowCount=(Integer) JdbcUtils.query(sql, null, new IntegerHandler());
		return rowCount;
	}

	@Override
	public List<Emp> find(int startLine, int size) {
		String sql="select * from emp limit ?,?";
		List<Emp> list=(List<Emp>) JdbcUtils.query(sql, new Object[] {startLine,size}, new BeanListHandler(Emp.class)); 
		return list;
	}

}
