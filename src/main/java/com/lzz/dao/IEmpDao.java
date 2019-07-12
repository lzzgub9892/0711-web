package com.lzz.dao;

import java.util.List;

import com.lzz.domain.Emp;

public interface IEmpDao {
	void save(Emp emp);
	void delete(Integer eid);
	void update(Emp emp);
	Emp find(Integer eid);
	List<Emp> find();

}
